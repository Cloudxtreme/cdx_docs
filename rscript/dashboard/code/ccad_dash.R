
source("./utils.R")
source("./ccad_batch.R")
source("./ccad_html.R")

cas_dashboard <- function(data,
                          d_out        = NULL,
                          f_out_suffix = NULL,
                          acc_pc       = "POS",
                          acc_nc       = "NEG",
                          acc_ex       = c(),
                          acc_w        = c("Water", "WATER", "_W"),
                          params       = alg_qc_metric_params(),
                          score_ranges = NULL, # impose score ranges
                          html_out     = F,    # output html file
                          d_html       = "../html", # .css, jquery stuff
                          browse       = F) {
  if(browse) browser()

  ncork <- count_corks(data, browse=F)
  if(ncork != 1)
    stop("Found more than one CORK (",ncork,") only one at a time\n")

  df_cp  <- reset_names(data, browse=F)
  df_cp$Gene <- oligo2gene(df_cp$oligo, browse=F)

  df_age      <- extract_df_age(df_cp, c(acc_nc, acc_ex), acc_pc, browse=F)
  df_cp_delta <- extract_lot_offset(df_cp, browse=F)

  fields <- c("Batch","Plate","Accession","Cp.run.id","Well","Gene","Cp")
  ret_cas <- calc_alg_score_d2(df_cp[fields], df_age,
                               df_cp_delta = df_cp_delta,
                               acc_prefix  = acc_pc,
                               acc_ex      = acc_ex,
                               acc_nc      = acc_nc,
                               acc_w       = acc_w,
                               samples_per_plate=8,
                               gb_         = gene_cp_bounds(), 
                               params      = params,
                               score_ranges= score_ranges,
                               browse=F)

  d_plot <- paste(d_out,"/","plots",f_out_suffix,sep="")
  ret_diag <- cas_d2_diagnostics(df_cp[fields],
                                 df_age,
                                 d_out   = d_plot,
                                 ret_cas = ret_cas, 
                                 browse  = F)

#  return(ret_diag)
  #############
  # output

  cat("Output tables\n")
  df_plots <- plot_table(ret_diag)
  df_tbls  <- data_table(ret_diag, d_out, f_out_suffix)

  # plot table
  f_ <- paste(d_out,"/plots_list",f_out_suffix,".csv",sep="")
  write.csv(df_plots, file=f_, row.names=F)

  # data table
  f_ <- paste(d_out,"/data_list",f_out_suffix,".csv",sep="")
  write.csv(df_tbls, file=f_, row.names=F)

  # data
  lst_ <- data_list(ret_diag)
#    output_score_html(list(name="tbl_ccad_scores",
#                           description="CCAD scores and diagnostics table",
#                            df_table=ret_diag$ret_cas$df_all), browse=F)
  for(ii in 1:length(lst_)) {
    df_ <- lst_[[ii]]
    # csv file
    f_  <- df_tbls$fpath[ii]
    write.csv(df_, file=f_, row.names=F)
    # html file

    tbl_html <- c("<table>\n",
#                 "<col span='1'></col>\n",
                  data2html_table(df_, use.rownames=F, browse=F),
                  "</table>\n")
    f_  <- df_tbls$fpath[ii]
    n_ <- nchar(f_)
    f_ <- paste(substr(f_, 1, n_-3), "html_fragment",sep="") # html extension
    writeLines(tbl_html, con=f_, sep="")
  }

  if(html_out) {
      js_include <- c(paste("<script type=\"text/javascript\" src=\"",d_html,
                            "/jquery-latest.js\"></script>\n",sep=""),
                      paste("<script type=\"text/javascript\" src=\"",d_html,
                            "/jquery.tablesorter.js\"></script>\n",sep=""),
                      "<script type=\"text/javascript\">\n", 
                      "$(document).ready(function() { $(\"table\").tablesorter( {widgets: ['zebra']}); } );\n",
                      "</script>\n"
                      )
      f_css <- paste(d_html, "/style.css",sep="")
      cas_d2_diag_html(ret_diag,
                       df_cp            = NULL, # cp data to output
                       mat_info         = NULL,
                       title            = "",
                       f_out            = NULL,
                       f_out_suffix     = f_out_suffix, # not the file extension!
                       f_out_ext        = "html",
                       d_out            = d_out, 
                       dir_plot         = NULL, # only if plots are moved
                       ccad_score_output = F,
                       output_cp_values = F,
                       f_css            = f_css,
                       js_include       = js_include,
                       browse=F)
  }

  return(ret_diag)
}

plot_table <- function(ret_diag, browse=F) {
  if(browse) browser()

  if(!is.list(ret_diag) || length(ret_diag)==0)
    stop("ret_diag is not a list or is empty\n")

  lst_ <- list()
  kk   <- 0
  for(ii in 1:length(ret_diag)) {
    ret_ <- ret_diag[[ii]]
    if("plots" %in% names(ret_)) {
      section_  <-ret_$section
      for(plot_ in ret_$plots) {
        kk <- kk + 1
        lst_[[kk]] <- unlist(c(section_,plot_))
      }
    }
  }
  df_ <- as.data.frame(matrix(unlist(lst_), nrow=kk, byrow=T),
                       stringsAsFactors=F)
  names(df_) <- c("Section","fname","fpath","description")
  return(df_)
}

data_table <- function(ret_diag, d_out=".", f_out_suffix="", browse=F) {
  if(browse) browser()

  if(!is.list(ret_diag) || length(ret_diag)==0)
    stop("ret_diag is not a list or is empty\n")

  lst_ <- list()
  kk   <- 0
  for(ii in 1:length(ret_diag)) {
    ret_ <- ret_diag[[ii]]
    if("tables" %in% names(ret_)) {
      section_  <-ret_$section
      for(tbl_ in ret_$tables) {
        kk <- kk + 1
        lst_[[kk]] <- unlist(c(section_,tbl_[1:2]))
      }
    }
  }
  kk <- kk + 1
  lst_[[kk]] <- c("Sample","tbl_ccad_scores","CCAD scores and diagnostics table")
  df_ <- as.data.frame(matrix(unlist(lst_), nrow=kk, byrow=T),
                       stringsAsFactors=F)
  names(df_) <- c("Section","name","description")

  df_$fpath <- paste(d_out, "/", df_$name, f_out_suffix,".csv",sep="")
  df_ <- df_[c(1,2,4,3)]
  
  return(df_)
}

data_list <- function(ret_diag, browse=F) {
  if(browse) browser()

  if(!is.list(ret_diag) || length(ret_diag)==0)
    stop("ret_diag is not a list or is empty\n")

  lst_ <- list()
  kk   <- 0
  for(ii in 1:length(ret_diag)) {
    ret_ <- ret_diag[[ii]]
    if("tables" %in% names(ret_)) {
      section_  <-ret_$section
      for(tbl_ in ret_$tables) {
        kk <- kk + 1
        lst_[[kk]] <- tbl_$df_table
      }
    }
  }
  kk <- kk + 1
  lst_[[kk]] <- ret_diag$ret_cas$df_all

  return(lst_)
}

# takes Cp offset data from the first Cp.run.id
# a creates a gene profile
# uses NEGATIVE of the offset so that
# Cp_adjusted = Cp_raw + offset
extract_lot_offset <- function(data, browse=F) {
  if(browse) browser()

  if(!is.data.frame(data))
    stop("data argument must be a data.frame\n")

  if(count_corks(data) != 1)
    stop("Only one cork at a time\n")

  if(is.na(data$Cp.run.id[1]))
    stop("Cp.run.id missing (NA)\n")

  genes_ <- c("AF289562","AQP9", "CASP5", "CD3D", "CD79B", "CLEC4E",   
              "HNRPF", "IL18RAP", "IL8RB", "KCNE3", "KLRC4",   
              "NCF4", "RPL28", "S100A12", "S100A8", "SLAMF7", 
              "SPIB", "TFCP2", "TLR4", "TMC8", "TNFAIP6", "TNFRSF10C",
              "TSPAN16" )  # "GTFCP2", "RPS4Y1"
  df_ <- data[data$Cp.run.id == data$Cp.run.id[1],c("Gene", "cp_offset")]
  df_$cp_offset <- - df_$cp_offset # minus out front! their definition is backwards
#  df_ <- df_[!duplicated(df_$Gene),]
  idx <- match(genes_, df_$Gene)
  df_ <- df_[idx,]
  if(nrow(df_) != length(genes_))
    stop("Wrong gene number(nrow(df_)) should be (",length(genes_),")\n")
  names(df_)[2] <- "Cp_delta"
  df_$Cp_delta <- ifelse(is.na(df_$Cp_delta), 0, df_$Cp_delta)

  if(!is_gene_profile(df_, field="Cp_delta", browse=F))
    stop("lot offset is not a valid profile\n")
  
  return(df_)
}

# extracts age, gender info,
# also pos ctrls
# exclude acc_ex
extract_df_age <- function(data, pat_ex, pat_pc, browse=F) {
  if(browse) browser()

  fields <- c("Accession","Age", "Gender")
  acc_ex <- grep_strings(pat_ex, data$Accession, fixed=T)
  data   <- data[!data$Accession %in% acc_ex,]
  acc_pc <- grep_strings(pat_pc, data$Accession, fixed=T)
  df_    <- unique(data[!data$Accession %in% acc_pc, fields])
  df_$Sample_type <- "Clinical"

  if(length(acc_pc) > 0) 
    df_ <- rbind(df_,
                 data.frame(Accession   = acc_pc,
                            Age         = 60,
                            Gender      = NA,
                            Sample_type = "PAX",
                            stringsAsFactors=F
                            ))
  df_ <- df_[order(df_$Accession),]
  return(df_)
}

# converst the oligo field to a Gene field
oligo2gene <- function(oligo, browse=F) {
  if(browse) browser()

  idx <- 11
  sep <- substr(oligo, idx,idx)
  b_ <- !is.na(sep) && (sep != "-")
  if(any(b_))
    stop("Found unexpected separator: (", sep[b_][1], ")\n")

  gene <- substr(oligo, idx+1,60)
  return(gene)
}

reset_names <- function(data, browse=F) {
  if(browse) browser()

  mat_ <- matrix(c(
                   "batch_id"           , "Batch",     
                   "container_id"       , "Plate", 
                   "well"               , "Well",         
                   "trf"                , "Accession",          
                   "cp_run_id"          , "Cp.run.id",    
                   "cp_value"           , "Cp",     
                   "gender"             , "Gender",       
                   "age"                , "Age" ),
                 ncol=2, byrow=T)
#                  "oligo"                 
#                  "cp_offset"             
#                  "rnax_date"          
#                  "cp_normalized_value"
#                  "cp_sd"              
#                  "dob"                
#                  "dst"                
#                  "rnax_kit_lot"       
#                  "rt_kit_lot"         
#                  "plate_kit_lot"      

  # match the names from the first column
  b_ <- mat_[,1] %in% names(data)
  if(any(!b_))
    stop("Missing required fields: ",paste(mat_[!b_,1], collapse=", "), "\n")
  idx <- match(mat_[,1], names(data))

  if(any(is.na(idx)))
    stop("idx = NA for some required fields (this shouldn't happen): ",
         paste(mat_[is.na(idx),1], collapse=", "), "\n")
  
  names(data)[idx] <- mat_[,2]
  return(data)
}

# counts the number of corks using fields:
# rt_kit_lot, plate_kit_lot  # not rnax_kit_lot, 
count_corks <- function(data, browse=F) {
  if(browse) browser()

  if(!is.data.frame(data))
    stop("data argument must be a data.frame\n")

  fields_ <- c("rt_kit_lot", "plate_kit_lot")
  b_ <- fields_ %in% names(data)
  if(any(!b_))
    stop("Missing required fields from data: ",
         paste(fields_[!b_], collapse=", "),"\n")

  if(nrow(data)==0)
    return(0)

  df_corks <- unique(data[c("rt_kit_lot", "plate_kit_lot")])

  return(nrow(df_corks))
}

# splits the data by cork
# returns a list of data.frames
# one for each cork
data_by_cork <- function(data, browse=F) {
  if(browse) browser()

  if(!is.data.frame(data))
    stop("data argument must be a data.frame\n")
  
# [1] "rnax_date"           "batch_id"            "container_id"       
# [4] "well"                "oligo"               "trf"                
# [7] "cp_run_id"           "cp_value"            "cp_normalized_value"
#[10] "cp_offset"           "cp_sd"               "gender"             
#[13] "dob"                 "age"                 "dst"                
#[16] "rnax_kit_lot"        "rt_kit_lot"          "plate_kit_lot"

  fields_ <- c("rnax_kit_lot", "rt_kit_lot", "plate_kit_lot")
  b_ <- fields_ %in% names(data)
  if(any(!b_))
    stop("Missing required fields from data: ",
         paste(fields_[!b_], collapse=", "),"\n")

#  df_cork <- unique(data[c("rnax_kit_lot", "rt_kit_lot", "plate_kit_lot")])

  lst_ <- by(data, data[c("rnax_kit_lot", "rt_kit_lot", "plate_kit_lot")], function(df_) df_)

  return(lst_)
}



