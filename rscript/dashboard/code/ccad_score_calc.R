
source("./utils.R")

# this occurs in the calc_alg_score_single
expr_range_profile <- function(df_, gb_= gene_cp_bounds(), browse=F) {
  if(browse) browser()

  gb_ <- gb_[gb_$Gene != "TSPAN16",]
  b_  <- !df_$Gene %in% "TSPAN16"
  df_ <- df_[b_,] # normal samples and assay genes
  df_$Cp[df_$Cp >= 40] <- NA
  # median Cp values
  med_   <- tapply(df_$Cp, df_$Gene, median, na.rm=TRUE)

  ##################
  # normalize values
  ord    <- order_a2b(gb_$Gene, names(med_))
  gb_    <- gb_[ord,]
  gb_$med <- med_
  norm_  <- with(as.list(med_), (1/2 * HNRPF   + 1/2 * TFCP2))
  gb_$med_n   <- gb_$med - norm_
  b_norm <- !gb_$Gene %in% c("HNRPF","TFCP2")
  gb_$med_n[b_norm] <- pmax(gb_$med_n, gb_$GL)[b_norm] # trim to lower bound
  gb_$med_n[b_norm] <- pmin(gb_$med_n, gb_$GU)[b_norm] # trim to upper bound
  sum_abs_dev <- sum( abs(gb_$med_n - gb_$GM) )

  return(sum_abs_dev)
}

ct_truncations <- function(df_, gb_= gene_cp_bounds(), browse=F) {
  if(browse) browser()

  gb_  <- gb_[gb_$Gene != "TSPAN16",]
  b_   <- !df_$Gene %in% "TSPAN16"
  df_  <- df_[b_,] # normal samples and assay genes
  df_$Cp[df_$Cp >= 40] <- NA
  # median Cp values
  med_ <- tapply(df_$Cp, df_$Gene, median, na.rm=TRUE)

  ##################
  # normalize values
  ord     <- order_a2b(names(med_), gb_$Gene)
  med_    <- med_[ord]
  gb_$med <- med_
  norm_   <- with(as.list(med_), (1/2 * HNRPF   + 1/2 * TFCP2))
  gb_$med_n <- gb_$med - norm_
  gb_$tr_lo <- gb_$med_n < gb_$GL # trim to lower bound
  gb_$tr_hi <- gb_$med_n > gb_$GU # trim to upper bound
  gb_$tr    <- gb_$tr_lo | gb_$tr_hi
  return(gb_$tr)
}

ct_norm_values <- function(df_, gb_= gene_cp_bounds(), browse=F) {
  if(browse) browser()

  gb_  <- gb_[gb_$Gene != "TSPAN16",]
  b_   <- !df_$Gene %in% "TSPAN16"
  df_  <- df_[b_,] # normal samples and assay genes
  df_$Cp[df_$Cp >= 40] <- NA
  # median Cp values
  med_ <- tapply(df_$Cp, df_$Gene, median, na.rm=TRUE)

  ##################
  # normalize values
  ord   <- order_a2b(names(med_), gb_$Gene)
  med_  <- med_[ord]
  norm_ <- with(as.list(med_), (1/2 * HNRPF   + 1/2 * TFCP2))
  med_n <- med_ - norm_

  return(med_n)
}

#gender_RPS4Y1 <- function(df_, male_threshold=34, browse=F) {
#  if(browse) browser()
#
#  cp_  <- df_$Cp[df_$Gene=="RPS4Y1"] # single value
#  if( is.na(cp_)
#     return(NA)
#  gen_ <- ifelse( cp_ > male_threshold, "Female", "Male"))
#  return(gen_)
#}

gene_cp_bounds <- function(browse=F) {
  if(browse) browser()
  #         Gene        GL          GM          GU
  v_ <- c("SLAMF7"   , -0.61292,  0.388559,  1.324676,
          "KLRC4"    , -1.15984,  0.514429,  2.109338,
          "TMC8"     , -2.71014,  -2.20653,  -1.67021,
          "CD3D"     ,  -1.3957,  -0.68308,  0.417505,
          "S100A12"  , -5.74066,  -3.81596,  -2.21403,
          "S100A8"   , -8.21483,  -6.90758,  -5.66543,
          "CLEC4E"   , -3.83992,  -2.18726,  -0.77086,
          "HNRPF"    , -1.32127,  -1.08667,  -0.92033,
          "TFCP2"    , 0.920328,  1.086674,   1.32127,
          "RPL28"    , -6.37254,   -5.9124,  -5.43474,
          "AF289562" , 1.937206,   4.37912,  5.757529,
          "AQP9"     , -4.87667,  -3.41811,  -2.21594,
          "NCF4"     , -4.20325,  -3.26455,  -2.20702,
          "CASP5"    , 0.301614,  2.604186,   4.12436,
          "IL18RAP"  , -3.22638,  -1.22201,  0.908392,
          "TNFAIP6"  , -0.70764,  1.161532,   2.94319,
          "TLR4"     , -2.94473,  -1.52378,  -0.56193,
          "KCNE3"    , -1.18882,  -0.24418,  0.698112,
          "IL8RB"    , -5.61977,  -4.50703,  -3.46853,
          "TNFRSF10C", -5.54215,  -4.44072,  -3.34768,
          "CD79B"    , -1.08847,  0.177718,   1.50448,
          "SPIB"     , 1.171489,  2.616313,  4.441006,
          "TSPAN16"  , 2.361062,  3.954757,  9.357854)
  mat_ <- matrix(v_, ncol=4, byrow=T)
  colnames(mat_) <- c("Gene","GL","GM","GU")
  df_ <- as.data.frame(mat_, stringsAsFactors=F)
  df_$GL <- as.numeric(df_$GL)
  df_$GM <- as.numeric(df_$GM)
  df_$GU <- as.numeric(df_$GU)
  df_ <- df_[order(df_$Gene),]

  return(df_)
}

#    df_cp        data.frame contains Cp.run.id, Accession
#                 and Cp values for all 23 algorithm genes (plus RPS4Y1) in triplicate
#    df_age       contains fields Accession, Age, Gender if not in df_cp,
#                 and possibly pooled
#                 pooled (binary) indicates a pooled sample
#                 this forces Age=60 and averages score for male/female
#    gb_          gene bounds data.frame from call to gene_cp_bounds()
#    af2_scores   the TRUE (the default) calculates the usual score,
#                 when FALSE the AF2 term in the algorithm is omitted
# returns a data.frame:
#    Cp.run.id     unique run ID
#    Accession     unique to the sample
#    Score         CorusCAD I algorithm score
#    Trans_score   transformed score
#    Gender        gender as supplied or calculated
#    Error         error string, "" if no error
#   
calc_alg_score <- function(df_cp, df_age, gb_=gene_cp_bounds(), af2_scores=T, browse=F) {
  if(browse) browser()

#  nm_ <- c("Cp.run.id", "Accession", "Score", "Trans_score", "Gender", "Error")
#  df_e <- df_empty(length(nm_), names=nm_)
  if(!all(c("Cp.run.id", "Accession", "Gene", "Cp") %in% names(df_cp)))
    stop("df_cp missing fields: Cp.run.id, Accession, Gene, or Cp\n")
  if(!all(c("Accession", "Age") %in% names(df_age)))
    stop("df_age missing fields: Accession, or Age\n")

  if(length(unique(df_age$Accession)) < length(df_age$Accession))
    stop("Accession IDs not unique in df_age\n")

  if(!all(df_age$Accession %in% df_cp$Accession))
    stop("Some Accession ID in df_age is not in df_cp\n")

  fields <- c("Accession", "Age")
  if("Gender" %in% names(df_age)) # keep Gender if it's available
    fields <- c(fields, "Gender")
  if("pooled" %in% names(df_age) && !"Pooled" %in% names(df_age)) {
    df_age$Pooled <- df_age$pooled # make sure upper case
    df_age$pooled <- NULL
  }

  # some samples may be pooled
  # first calc score for the non-pooled subset
  df_s <- NULL
  if(any(!df_age$Pooled)) {
    df_age_ <- df_age[!df_age$Pooled,] # not pooled subset
    df_cp_  <- merge(df_cp, df_age_[fields], by="Accession")
    lst_    <- by(df_cp_, df_cp_$Cp.run.id, calc_alg_score_single, gb_=gb_, af2_scores=af2_scores)
    df_s    <- rbind_df_list(lst_)
  }
  
  # now the pooled subset
  if(any(df_age$Pooled)) {
    df_age_ <- df_age[df_age$Pooled,] # pooled subset
    df_age_$Age <- 60

    df_cp_ <- merge(df_cp, df_age_[fields], by="Accession")

    # delete RPS4Y1 data, or an error will be reported when the gender mismatches below
    df_cp_ <- df_cp_[df_cp_$Gene != "RPS4Y1",]
    
    # calc score for male
    df_cp_$Gender <- "Male"
    lst_   <- by(df_cp_, df_cp_$Cp.run.id, calc_alg_score_single, gb_=gb_, af2_scores=af2_scores)
    df_m   <- rbind_df_list(lst_)
    df_m$Trans_score <- NULL
    df_m$Gender      <- NULL
    df_m$Age         <- NULL
    # calc score for female
    df_cp_$Gender <- "Female"
    lst_   <- by(df_cp_, df_cp_$Cp.run.id, calc_alg_score_single, gb_=gb_, af2_scores=af2_scores)
    df_f   <- rbind_df_list(lst_)
    df_f$Trans_score <- NULL
    df_f$Gender      <- NULL
    df_f$Age         <- NULL

    # use average score
    df_p <- merge(df_m, df_f[1:4], by=c("Cp.run.id", "Accession"))
    df_p$Score <- (df_p$Score.x + df_p$Score.y)/2
    df_p$Trans_score <- transformed_score(df_p$Score)
    df_p$Score.x <- NULL
    df_p$Score.y <- NULL
    df_p$Gender  <- NA
    df_p$Age     <- 60
    df_p$Error <- paste(df_p$Error.x, df_p$Error.y, sep=" : ")
    b_ <- df_p$Error == " : "
    df_p$Error[b_] <- "" # no error
#    df_p$Error <- df_p$Error.x # use the error from the Male calc
#    b_ <- df_p$Error == " : "
#    df_p$Error[b_] <- df_p$Error.y[b_] # unless empty
    df_p$Error.x <- NULL
    df_p$Error.y <- NULL
    len_ <- length(df_p)
    ind_ <- c(1:2, 1:5+len_ - 5, 3:(len_-5))
    df_p <- df_p[ind_]
    if(is.null(df_s))
      df_s <- df_p
    else
      df_s <- rbind(df_s, df_p)
  }
  
  return(df_s)
}

#    df_        data.frame contains Cp values for all 23 algorithm genes (plus RPS4Y1) in triplicate
#               must also contain GTFCP2 or (ADORA3 and 'ADORA3 IN') for genomic contamination
#               must contain gene RPS4Y1 or gender field
#               may also contain Age
#    Accession  must be in df_
#    Age        may also be in df_
#    Gender     Male/Female,
#               can also be in df_ as Gender or RPS4Y1
#    gb_        gene bounds data.frame from call to gene_cp_bounds()
#    af2_scores =T fr normal scores, =F for non-AF2 scores
# returns a data.frame:
#    Cp.run.id     unique run ID
#    Accession     unique to the sample
#    Score         CorusCAD I algorithm score
#    Trans_score   transformed score
#    Gender        Gender as supplied or calculated
#    Error         error string, "" if no error
calc_alg_score_single <- function(df_, Age=NULL, Gender=NULL,
                                  gb_=gene_cp_bounds(), af2_scores=T, browse=F) {
  if(browse) browser()

  ###################
  g_ <- rep(NA, length(gb_$Gene))
  names(g_) <- gb_$Gene
  df_err <- data.frame(Cp.run.id=NA, Accession=NA, Score=NA, Trans_score=NA,
                       Gender=NA, Age=NA, Error="", as.list(g_),
                       RPS4Y1=NA, GTFCP2=NA, ADORA3=NA, ADORA3.IN=NA,
                       stringsAsFactors=F)
  
  ###################
  # check fields
  # c("Plate", "Well", "Cp.run.id", "Accession", "Gene", "Cp")
  b_ <- c("Cp.run.id", "Gene", "Cp") %in% names(df_)
  if(!all(b_)) {
    df_err$Error <- "Missing fields (Cp.run.id, Gene, Cp)"
    return(df_err)
  }
  Cp.run.id <- df_$Cp.run.id[1]
  df_err$Cp.run.id <- Cp.run.id
  
  ###################
  # Accession
  if(!"Accession" %in% names(df_)) {
    df_err$Error <- "Accession fields missing"
    return(df_err)
  }
  accession_ <- df_$Accession[1]
  df_err$Accession  <- accession_
  
  ###################
  if(is.null(Gender))
    Gender <- NA # sorry, there are a number of sources for this
  # check Gender fields
  if(is.na(Gender) && ("Gender" %in% names(df_)))
    Gender <- df_$Gender[1]
  
  if(is.na(Gender) && !("RPS4Y1" %in% df_$Gene)) {
    df_err$Error <- "Gender fields missing (Gender and RPS4Y1)"
    return(df_err)
  }

  ####################
  # genomic contam
  if("GTFCP2" %in% df_$Gene)
    gc_gene <- "GTFCP2"
  else if(all(c("ADORA3","ADORA3 IN") %in% df_$Gene))
    gc_gene <- c("ADORA3", "ADORA3 IN")
  else {
    df_err$Error <- "Genes GTFCP2 and ('ADORA3 IN' or ADORA3) missing, can't check for genomic contamination"
    return(df_err)
  }

  ####################
  # gene list
  genes_ <- c(gb_$Gene,
              gc_gene)  # genomic contamination
  if("RPS4Y1" %in% df_$Gene) #is.na(Gender))
    genes_ <- c(genes_, "RPS4Y1") # gender calculation
# genes_ <-  c("AF289562", "AQP9",   "CASP5",   "CD3D",      "CD79B",
#              "CLEC4E",   "HNRPF",  "IL18RAP", "IL8RB",
#              "KCNE3",    "KLRC4",  "NCF4",    "RPL28",     "RPS4Y1",
#              "S100A12",  "S100A8", "SLAMF7",  "SPIB",      "TFCP2",
#              "TLR4",     "TMC8",   "TNFAIP6", "TNFRSF10C", "TSPAN16")

  ####################
  # check Age fields
  if(is.null(Age) && !("Age" %in% names(df_))) {
    df_err$Error <- "Age field missing"
    return(df_err)
  }

  if(is.null(Age) && ("Age" %in% names(df_)))
    Age <- df_$Age[1]
  
  if(is.na(Age)) {
    df_err$Error <- "Missing Age"
    return(df_err)
  }
  df_err$Age <- Age
  
  #####################
  # check data complete
  df_ <- df_[df_$Gene %in% genes_,]
  b_  <- genes_ %in% df_$Gene
  if(!all(b_)) {
    df_err$Error <- paste("Missing genes (should have ",length(genes_)," genes)",sep="")
    return(df_err)
  }

  cnt_   <- tapply(df_$Gene, df_$Gene, length)
  if(!all(cnt_ == 3)) {
    df_err$Error <- "Genes not in triplicate"
    return(df_err)
  }

  ###################
  # NoCalls
#  b_ <- df_$Cp == "NoCall"
#  if(any(b_))
#    df_$Cp[b_] <- NA
  df_$Cp <- as.numeric(df_$Cp) # this auto converts NoCall to NA
  # Cp=0 is actually Cp=40, occurs a lot
  df_$Cp[df_$Cp==0] <- 40 # need this for gender calc and genomic contam
                          # set to NA below, NOT HERE!
  
  ###################
  # Gender from Y chromosome
  RPS4Y1 <- NA
  if("RPS4Y1" %in% df_$Gene) {
    v_ <- df_$Cp[df_$Gene=="RPS4Y1"]
    Gender_y <- ycp2gender(v_)
    RPS4Y1 <- Gender_y[2]
    if(is.na(Gender_y[1])) {
      df_err$Error <- paste("Gender calculation failed (Gender_y[1]=",Gender_y[1],")",sep="")
      return(df_err)
    }
    if(is.na(Gender))
      Gender <- Gender_y[1]
    if(Gender != Gender_y[1]) {
      df_err$Error <- paste("Supplied gender (",Gender,
                          ") mismatch with calculated gender Gender_y=c(",
                          Gender_y[1],",",RPS4Y1,")",sep="")
      return(df_err)
    }
    df_ <- df_[df_$Gene!="RPS4Y1",] # eliminate chrom Y gene (just for Gender determination)
  }

  if(is.na(Gender)) {
    df_err$Error <- "Gender not specified"
    return(df_err)
  }
  df_err$Gender <- Gender
  df_err$RPS4Y1 <- RPS4Y1
  
  ###################
  # gDNA contam
  GTFCP2    <- NA
  ADORA3    <- NA
  ADORA3.IN <- NA
  if(gc_gene[[1]] == "GTFCP2") {
    v_ <- df_$Cp[df_$Gene == "GTFCP2"]
    GTFCP2 <- median(v_, na.rm=TRUE)
    if(is.na(GTFCP2))
      GTFCP2 <- 38
  } else {
    v_ <- df_$Cp[df_$Gene == "ADORA3"]
    ADORA3 <- median(v_, na.rm=TRUE)
    if(is.na(ADORA3))
      ADORA3 <- 38
    v_ <- df_$Cp[df_$Gene == "ADORA3 IN"]
    ADORA3.IN <- median(v_, na.rm=TRUE)
    if(is.na(ADORA3.IN))
      ADORA3.IN <- 38
  }
  df_ <- df_[!df_$Gene %in% gc_gene,] # eliminate, not part of score calculation
  df_err$ADORA3    <- ADORA3
  df_err$ADORA3.IN <- ADORA3.IN
  
  ###################
  # set Cp >= 40   -->   NA
#  df_$Cp[df_$Cp == "NoCall"] <- NA
  df_$Cp[df_$Cp >= 40] <- NA

  ###################
  # median Cp values
  cnt_na <- tapply(df_$Cp, df_$Gene, function(x) sum(is.na(x)))
  med_   <- tapply(df_$Cp, df_$Gene, median, na.rm=TRUE)
  sd_    <- tapply(df_$Cp, df_$Gene, sd,     na.rm=TRUE)
  sd_[cnt_na>1]  <- NA # allow at most one failure
  med_[cnt_na>1] <- NA
  i_tspan <- which(names(cnt_na)=="TSPAN16")
  if(is.na(med_[i_tspan]))
    med_[i_tspan] <- 38
  
  if(any(is.na(med_))) {
    df_err$Error <- "Missing Gene Cp"
    return(df_err)
  }
  if(any(is.na(sd_[-i_tspan]))) {
    df_err$Error <- "Missing Gene SD"
    return(df_err)
  }

  Error <- ""

  if(median(sd_[-i_tspan]) > .15) {
    Error <- paste(Error,"High replicate SD (median sd=",signif(median(sd_[-i_tspan]),4)," > .15)", sep="")
#     return(data.frame(Cp.run.id=Cp.run.id, Accession=accession_, Score=NA, Trans_score=NA, Gender=Gender, Error=Error, stringsAsFactors=F))
   }

  ##################
  # normalize values
  ord    <- order_a2b(gb_$Gene, names(med_))
  gb_    <- gb_[ord,]
  gb_$med <- med_
  norm_  <- with(as.list(med_), (1/2 * HNRPF   + 1/2 * TFCP2))
  gb_$med_n   <- gb_$med - norm_
  b_norm <- !gb_$Gene %in% c("HNRPF","TFCP2")
  gb_$med_n[b_norm] <- pmax(gb_$med_n, gb_$GL)[b_norm] # trim to lower bound
  gb_$med_n[b_norm] <- pmin(gb_$med_n, gb_$GU)[b_norm] # trim to upper bound
  sum_abs_dev <- sum( abs(gb_$med_n - gb_$GM)[gb_$Gene != "TSPAN16"])
  if(sum_abs_dev > 27.17) {
    Error <- paste(Error,"Expression Profile Out of Range (sum_abs_dev=",signif(sum_abs_dev,4)," > 27.17)",sep="")
#    return(data.frame(Cp.run.id=Cp.run.id, Accession=accession_, Score=NA, Trans_score=NA, Gender=Gender, Error=Error, stringsAsFactors=F))
  }
  
  ###################
  # trimmed values
  med_t   <- gb_$med_n + norm_
  names(med_t) <- gb_$Gene

  med_t_lst <- as.list(med_t)
  attach(med_t_lst)
  AF161365 <- TSPAN16 # alias

  ####################
  # gDNA contamination
  if(gc_gene[[1]] == "GTFCP2") {
#    GTFCP2_n <- GTFCP2 - norm_ # don't normalize, TFCP2 isn't (but it is trimmed)
    if(GTFCP2 - TFCP2 < 3.25) {
      Error <- paste(Error,"gDNA Contamination, GTFCP2 (GTFCP2 - TFCP2=",signif(GTFCP2 - TFCP2,4)," < 3.25)", sep="")
#      detach(med_t_lst)
#      return(data.frame(Cp.run.id=Cp.run.id, Accession=accession_, Score=NA, Trans_score=NA, Gender=Gender, Error=Error, stringsAsFactors=F))
    }
  } else {
    ADORA3_n    <- ADORA3    - norm_
    ADORA3.IN_n <- ADORA3.IN - norm_
    if((ADORA3.IN_n - ADORA3 < .75) && (ADORA3.IN_n < 4)) {
      Error <- paste(Error,"gDNA Contamination, ADORA3")
#      detach(med_t_lst)
#      return(data.frame(Cp.run.id=Cp.run.id, Accession=accession_, Score=NA, Trans_score=NA, Gender=Gender, Error=Error, stringsAsFactors=F))
    }
  }

  Norm1 <- RPL28
  Norm2 <- (1/2 * HNRPF   + 1/2 * TFCP2)
  NKup  <- (1/2 * SLAMF7  + 1/2 * KLRC4)
  Tcell <- (1/2 * CD3D    + 1/2 * TMC8)
  Bcell <- (2/3 * CD79B   + 1/3 * SPIB)
  Neut  <- (1/2 * AQP9    + 1/2 * NCF4)
  Nup   <- (1/3 * CASP5   + 1/3 * IL18RAP   + 1/3 * TNFAIP6)
  Ndown <- (1/4 * IL8RB   + 1/4 * TNFRSF10C + 1/4 * TLR4    + 1/4 * KCNE3)
  SCA1  <- (1/3 * S100A12 + 1/3 * CLEC4E    + 1/3 * S100A8)
  AF2   <- ifelse(af2_scores, AF289562, gb_$GM[gb_$Gene == "AF289562"]+Norm2)
  TSPAN <- ifelse( is.na(AF161365) | (AF161365-Norm2 > 6.27), 1, 0)
  SEX   <- ifelse(Gender=="Male", 1, 0)

  Intercept <- ifelse(Gender=="Male",
                      2.67239 + 0.04486831*Age, # Age in years
                      1.8212087 + 0.12328342*max(0,Age-60))
  
  Score <- Intercept -
           0.75514157*( Nup - Ndown)      -
             0.40578722*( NKup - Tcell)     -
               0.30754268*SEX*( SCA1- Norm1)  -
                 0.13717485*( Bcell- Tcell)     -
                   0.54778346*(1-SEX)*(SCA1- Neut) -
                     0.48182308*SEX*(TSPAN)        -   
                        0.24592034*(AF2- Norm2)
  detach(med_t_lst)
  
  ###################
  # transformed Score
  t_score <- transformed_score(Score, browse=F)
  
  ret_ <- cbind(data.frame(Cp.run.id=Cp.run.id, Accession=accession_,
                           Score=Score, Trans_score=t_score,
                           Gender=Gender, Age=Age, Error=Error, stringsAsFactors=F),
                med_t_lst, RPS4Y1=as.numeric(RPS4Y1),
                GTFCP2=GTFCP2, ADORA3=ADORA3, ADORA3.IN=ADORA3.IN,
                stringsAsFactors=F)
# ret_ <- cbind(ret_, med_t_lst, RPS4Y1=as.numeric(RPS4Y1), stringsAsFactors=F)
  return(ret_)
}

transformed_score <- function(score, browse=F) {
  if(browse) browser()

  score <- pmax(score, -2.95)
  score <- pmin(score, 1.57)
  score <- round(.5 + (2.95 + score)*40/4.52)  # round up
  score <- pmin(score, 40)
  score <- pmax(score, 1)
  return(score)
}

# cp_      vector of Cp values
# na_max   number of NAs allowed
ycp2gender <- function(cp_, male_threshold=30, female_threshold=34, na_max=1) {
  #  cp_[is.na(cp_)] <- 40                   # ?????????? 
#  gs_ <- ifelse(is.na(cp_), 0, ifelse(cp_ <= male_threshold,    1,
#                               ifelse(cp_ >= female_threshold, -1, 0)))
#  gs_    <- sum(gs_)
#  gender <- ifelse(gs_ >= 1, "Male", ifelse(gs_ <= -1, "Female", NA))
  # M, M, M  -> M
  # M, M,NA  -> M
  # M,NA,NA  -> NA
  # M, M, F  -> M
  # M, F, F  -> F

  na_cnt <- sum(is.na(cp_))
  cp_m   <- median(cp_, na.rm=T)
  b_na   <- is.na(cp_m) | na_cnt > na_max
  gender <- NA
  if(!b_na && cp_m <= male_threshold)
    gender <- "Male"
  if(!b_na && cp_m >= female_threshold)
    gender <- "Female"

  return(c(Gender=gender, Cp_med=cp_m))
}

# assumes the data frame is from XML files
# or CCAD data from Waban
ccad_format_waban <- function(df_, browse=F) {
  if(browse) browser()
  
  nm_ <- names(df_)
  # need these for Waban, maybe they're already there
  fields_w <- c("Plate", "Well", "Cp.run.id","Accession","Gene", "Cp")
  b_ <- fields_w %in% nm_
  if(all(b_)) # all there, done
    return(df_)
  
  cat("\nConvert to Waban format\n")
  # should be from XML files
  fields_ <- c("Plate_id", "Well", # "Position", 
               "Sample","Cp.run.id","Assay", "Cp")
  b_ <- fields_ %in% nm_
  if(any(!b_)) { # its not an XML file, so time to bail
    cat("Can't find fields required for Waban format\n",
        paste(fields[!b_]), "\n")
    stop("\n")
  }

  df_$Plate <- df_$Plate_id
  df_$Accession <- paste(df_$Plate_id, df_$Sample, sep=".")
  g_ <- df_$Assay
  g_[g_ == "gTFCP2"] <- "GTFCP2"
  df_$Gene <- g_
  df_ <- df_[fields_w] # restrict or not?

  return(df_)
}

# loads the files in the file list
# load all as data.frames
# concats them all in long format
# converts to Waban format
load_ccad_files <- function(f_lst, format_waban=F, browse=F) {
  if(browse) browser()

  df_ <- load_files_rbind(f_lst, browse=F)
  if(format_waban)
    df_ <- ccad_format_waban(df_, browse=F)
  
  return(df_)
}
