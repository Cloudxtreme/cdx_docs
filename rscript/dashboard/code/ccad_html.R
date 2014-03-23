
source("./utils.R")
source("./html.R")

cas_compare_html <- function(ret_group     = NULL,
                          mat_info         = NULL,
                          title            = "",
                          f_out            = NULL,
                          f_out_suffix     = "", # not the file extension!
                          f_out_ext        = "html",
                          d_out            = NULL, 
#                         dir_plot         = NULL, # only if plots are moved
                          ccad_score_output= F,
                          output_cp_values = F,
                          f_css            = "/home/jblanchard/hdrive/svn/biostats/jblanchard/projects/code/style.css",
                          js_include= c(), # anything to include in the head section
                          browse           = F) {
  if(browse) browser()

  if(is.null(title) || title=="") {
    title <- "CCAD group comparison report"
  }
  if(!is.null(mat_info)) {
    if("Report ID" %in% mat_info[,1]) {            # Ugh!
      idx   <- which(mat_info[,1] %in% "Report ID")[1]
      rid_  <- mat_info[idx,2]
      title <- paste(title, rid_, sep="_")
    }
  }
  if(is.null(ret_group))
    stop("Must specify ret_group\n")
  if(!"df_groups" %in% names(ret_group))
    stop("ret_group isn't an ccad group comparison object\n")
  if(is.null(d_out) || d_out=="")
    stop("Must specify output directory\n")
  if(is.null(f_out) || f_out=="")
    f_out <- paste("ccad_group_comparison_", Sys.Date(), sep="")
  else
    f_out <- paste(f_out, Sys.Date(), sep="_")
  if(f_out_suffix != "")
    f_out <- paste(f_out, f_out_suffix, sep="")
  f_out <- paste(f_out, f_out_ext, sep=".")
  if(is.null(f_css) || f_css=="")
    stop("Must specify CSS file\n")

  # strip off .html extension if there
#  f_out_no_ext <- gsub("\\.html$", "", f_out, perl=TRUE)
  fp_out <- file.path(d_out, f_out)
            # paste(d_out, paste(f_out_no_ext, ".html", sep=""), sep="/")
  cat("Writing to target html file:\n\t", fp_out, "\n")
  target <- html_init_file(filepath  =fp_out,
                           CSSFile   =f_css,
                           Title     =title,
                           js_include=js_include,
                           doctype   ="html 4.01 transitional", #"html 4.01 strict", #"xhtml 1.0 strict", #
                           charset   ="utf-8", #"windows-1252", "ISO-8859-1"
                           useLaTeX  =FALSE, browse=F)

  ########
  html_cat("\n\n<div id='pageHeader'>\n") #, file=target) # include target file
  s_ <- c("<h2 id='title'>", title,"</h2>\n",
          "<span id='subtitle'>CCAD score comparison by ",ret_group$group_variable," </span>\n")
  html_cat(s_)
  html_cat("</div>\n")

  ########
  html_cat("\n<div id='intro'>\n")
  html_cat("</div>\n")

  if(!is.null(mat_info)) {
    html_cat("<h2>Equivalency PQ information</h2>\n")
    tbl_lst <- list(name       = "equiv_info",
                    description= "", #"Machine PQ pass requirements",
                    df_table   = mat_info)
    table_html(tbl_lst, browse=F)
  }

  # table of contents
  toc_html(ret_group, ccad_score_output=ccad_score_output,
           output_cp_values=output_cp_values, browse=F)
  
  # simple counts of batches, plates, samples, ...
#  counts_html(ret_diag, browse=F)

  # sections
  cat("Sections\n")
  html_cat("\n<div id='sections'>\n")
  
  for(ret_ in ret_group) {
    if(!any(c("plots","tables") %in% names(ret_))) # only if there are plots or tables
      next

    cat("\t", ret_$id,"\n", sep="")
    html_cat("\n<div id='",ret_$id,"'>\n")
    html_cat("<h2 class='break'><a name='",ret_$id,"' href='#toc_",ret_$id,"'>",ret_$section,"</a></h2>\n")
    
    if("tables" %in% names(ret_)) {
      for(tbl_ in ret_$tables) {
        html_cat("<h3 class='break'></h3>\n")
        table_html(tbl_, browse=F)
      }
    }
    if("plots" %in% names(ret_)) {
      for(plot_ in ret_$plots) {
        html_cat("<h3 class='break'></h3>\n")
        plot_html(plot_, caption_top=TRUE, browse=F)
      }
    }
    html_cat("</div>\n")
  }

  # data tables
  html_cat("\n<div id='data'>\n",
           "<h2><a name='data' href='#toc_data'>Data</a></h2>\n")

  if(ccad_score_output) {
    cat("\tCCAD scores & diagnostics table\n")
    html_cat("<h3 class='break'></h3>\n")
    output_score_html(list(name="tbl_ccad_scores", description="CCAD scores and diagnostics table",
                            df_table=ret_group$ret_cas$df_all), browse=F)
#    names(df_all) <- gsub("_", " ", names(df_all))
#    table_html(list(name="tbl_ccad_scores", description="CCAD scores and diagnostics table",
#                    df_table=df_all), browse=F)
#    html_cat("</div>\n")
  }
  
  if(output_cp_values) {
    if(is.null(df_cp))
      cat("Must specify df_cp data.frame to output Cp data.\n")
    cat("\tCp data\n")
    html_cat("<h3 class='break'></h3>\n")
    table_html(list(name="tbl_cp_data", description="Cp data table",
                    df_table=df_cp), browse=F)
#    html_cat("</div>\n")
  }
  html_cat("\n</div>\n") # data

  html_cat("\n</div>\n") # sections
  html_cat("</body>\n</html>\n")

  return(fp_out)
}

# compares CCAD scores according to a grouping variable
# can be all pairwise comparisons or against a reference level
# ret_cas           output from calc_alg_score_d2
# df_groups         data.frame with Cp.run.id and grouping variable (in group_variable)
# group_variable    specify the grouping variable name
# reference         the reference level
#                   or NULL if no reference level
cas_comparison <- function(ret_cas         = NULL,
                           df_groups       = NULL,
                           group_variable  = "group",
                           reference       = NULL,
                           elim_sample_type= "Water",
                           max_groups      = 12,
                           params          = NULL,
                           d_out           = NULL,
                           browse          = F) {
  if(browse) browser()

  if(is.null(ret_cas))
    stop("Must specify ret_cas\n")
  if(!"df_all" %in% names(ret_cas))
    stop("df_all isn't contained in ret_cas\n")
  if(!"Cp.run.id" %in% names(ret_cas$df_all))
    stop("Failed to find Cp.run.id field in df_all\n")

  if(is.null(params)) # use default unless overridden
    params <- ret_cas$params
  #
  if(is.null(df_groups) || !is.data.frame(df_groups))
    stop("Must specify groupings data.frame with Cp.run.id and grouping variable for comparison\n")
  if(!"Cp.run.id" %in% names(df_groups))
    stop("Failed to find Cp.run.id field in df_groups\n")
  if(!group_variable %in% names(df_groups))
    stop("Failed to find grouping variable (",group_variable,") field in df_groups\n",sep="")
  if(any(is.na(df_groups$Cp.run.id)))
    stop("Cp.run.id has missing values in df_groups ... not allowed\n")
  if(any(duplicated(df_groups$Cp.run.id)))
    stop("Cp.run.id must be unique in df_groups\n")
  if(any(is.na(df_groups[[group_variable]])))
    stop("grouping variable (",group_variable,") has missing values in df_groups ... not allowed\n")

  df_groups$Group <- df_groups[[group_variable]]
  df_groups <- df_groups[c("Cp.run.id", "Group")]
  if(!is.null(reference) && !reference %in% df_groups$Group)
    stop("reference level (",reference,") is missing from the grouping field\n")

  #
  if(!is.null(d_out) && (d_out==""))
    d_out <- NULL
  if(!is.null(d_out)) { # create dir
    if(file_test("-d", d_out))
      cat("Output dir already exists:",d_out,"\n")
    else {
      if(!dir.create(d_out, recursive=F, mode="0755"))
        stop("Failed to create output dir:", d_out,"\n")
    }
  }

  # eliminate sample types (like water)
  b_     <- ret_cas$df_all$Sample_type %in% elim_sample_type
  df_all <- ret_cas$df_all[!b_,]

  # merge with grouping variable
  df_all <- merge(df_all, df_groups, by="Cp.run.id")
  
  if(!is.null(reference) && !reference %in% df_all$Group)
    stop("reference level (",reference,") is missing from the grouping field in df_all\n")

  if(!is.factor(df_all$Group))
    df_all$Group <- factor(df_all$Group)
  if(!is.null(reference))
    df_all$Group <- relevel(df_all$Group, reference)
  if(length(unique(df_all$Group)) > max_groups)
    stop("Number of groups (",length(unique(df_all$Group)),
         ") exceeds the max allowable ", max_groups,"\n", sep="")

  gene_lst <- c("S100A8", "RPL28",   "TNFRSF10C","IL8RB",  "S100A12","AQP9", "NCF4",
                "CLEC4E", "TMC8",    "TLR4",     "IL18RAP","HNRPF",  "CD3D", "KCNE3", 
                "CD79B",  "SLAMF7",  "TNFAIP6",  "KLRC4",  "TFCP2",  "CASP5","SPIB", 
                "TSPAN16","AF289562","RPS4Y1",   "GTFCP2")

  # scores by group
  ret_s <- compare_scores_by_groups  (df_all, reference, params, group_variable, browse=F)
  ret_c <- compare_clinical_by_groups(df_all, reference, params, group_variable, browse=F)
  ret_g <- compare_genes_by_groups   (df_all, reference, params, gene_lst, group_variable, browse=F)
  ret_x <- compare_pax_by_groups     (df_all, reference, params, ret_cas$score_ranges, group_variable, browse=F)
  
  ret_s$plots <- plot_compare_scores_by_groups  (ret_s, d_out, browse=F)
  ret_c$plots <- plot_compare_clinical_by_groups(ret_c, d_out, browse=F)
  ret_g$plots <- plot_compare_genes_by_groups   (ret_g, d_out, browse=F)
  ret_x$plots <- plot_compare_pax_by_groups     (ret_x, d_out, browse=F)
 
  return(list(ret_cas        = ret_cas,
              ret_s          = ret_s, 
              ret_c          = ret_c, 
              ret_g          = ret_g, 
              ret_x          = ret_x,
              df_groups      = df_groups,
              group_variable = group_variable,
              reference      = reference,
              d_out          = d_out))
}

compare_scores_by_groups <- function(df_s, reference=NULL, params=NULL,
                                     group_variable="group", browse = F) {
  if(browse) browser()

  fields_ <- c("Group", "Batch", "Plate", "Accession", "Cp.run.id", "Is_pax_ctrl",
               "Gender", "Age",  "Sample_type","Score", "Overall_flag")
  df_s <- df_s[fields_]
#  params$well_missing_fail <- params$well_missing_pct*params$data_cnt_well_missing
#  df_s <- cbind(df_s, params)

  # group stats
  lst_ <- by(df_s, df_s["Group"],
                 function(df_) {
                   b_       <- df_$Overall_flag=="Pass"
                   npass_   <- sum(b_)
                   mean_    <- mean(df_$Score[b_], na.rm=T)
                   sd_      <- sd(df_$Score[b_], na.rm=T)
                   ci_width <- ifelse(npass_>0,qt(.975, npass_)*sd_/sqrt(max(npass_,1)),NA) # conf interval width
                   return(data.frame(Group          = df_$Group[1],
                                     Count          = nrow(df_),
                                     Passed         = npass_,
                                     Median         = median(df_$Score[b_], na.rm=T),
                                     Mean           = mean_,
                                     Sd             = sd_,
                                     sqm_machine_sd = params$sqm_machine_sd,
                                     Ci_width       = ci_width,
                                     Ci_lo          = mean_ - ci_width,
                                     Ci_hi          = mean_ + ci_width,
                                     stringsAsFactors=F))}, simplify=F)
  df_stats <- do.call(rbind, lst_)
  if(!is.null(reference)) { # conf int for the difference with the reference
    npass_     <- df_stats$Passed
    sd_        <- df_stats$Sd
    delta_mean <- df_stats$Mean - df_stats$Mean[1]
    ci_width   <- ifelse(npass_ + npass_[1] >0,
                         qt(.975, npass_ + npass_[1])*sqrt(sd_^2/max(npass_,1) + sd_[1]^2/max(npass_[1],1)), # conf interval width
                         NA)
    df_stats$Delta             <- df_stats$Median - df_stats$Median[1]
    df_stats$Delta_mean        <- delta_mean
    df_stats$Delta_ci_width    <- ci_width
    df_stats$Delta_ci_lo       <- delta_mean - ci_width
    df_stats$Delta_ci_hi       <- delta_mean + ci_width
    df_stats$Delta_mean[1]     <- NA
    df_stats$Delta_ci_width[1] <- NA
    df_stats$Delta_ci_lo[1]    <- NA
    df_stats$Delta_ci_hi[1]    <- NA
  }
  df_stats$sqm_xc_conf_int   <- params$sqm_xc_conf_int

  df_table <- df_stats
  df_table$sd_pass <- ifelse(!is.na(df_table$Sd) & (df_table$Sd <= df_table$sqm_machine_sd), "Pass","Fail")
  mean_ <- mean(df_table$Mean)
  df_table$Ci_lo_bnd <- mean_ - df_table$sqm_xc_conf_int[1]
  df_table$Ci_hi_bnd <- mean_ + df_table$sqm_xc_conf_int[1]
  b_                 <- (df_table$Ci_lo_bnd <= df_table$Ci_lo) &
                        (df_table$Ci_hi     <= df_table$Ci_hi_bnd)
  df_table$Ci_pass   <- ifelse(!is.na(b_) & b_, "Pass","Fail")
  df_table$Delta_ci_lo_bnd <- 0 - df_table$sqm_xc_conf_int[1]
  df_table$Delta_ci_hi_bnd <- 0 + df_table$sqm_xc_conf_int[1]
  b_                 <- (df_table$Delta_ci_lo_bnd <= df_table$Delta_ci_lo) &
                        (df_table$Delta_ci_hi     <= df_table$Delta_ci_hi_bnd)
  df_table$Delta_ci_pass   <- ifelse(!is.na(b_) & b_, "Pass","Fail")
  
  field_pairs <- matrix(
  c("Group",		group_variable,
    "Count",		"Count",
    "Passed",		"Passed",
    "Median",		"Median score",
    "Mean",		"Mean score",
    "Sd",		"Std Dev",
    "sqm_machine_sd",	"Std Dev bound",
    "sd_pass",	        "Std Dev pass"), ncol=2, byrow=T)
  if(is.null(reference)) {
    mat_ <- matrix(c(
    "Ci_lo",		"Lower CI",
    "Ci_hi",		"Upper CI",
    "Ci_lo_bnd",	"Lower CI bound",
    "Ci_hi_bnd",	"Upper CI bound",
    "Ci_pass",   	"CI pass"), ncol=2, byrow=T)
    field_pairs <- rbind(field_pairs, mat_)
  } else {
    mat_ <- matrix(c(
    "Delta",		"Delta median scores",
    "Delta_mean",	"Delta mean scores",
    "Delta_ci_lo",	"Delta lower CI bound",
    "Delta_ci_hi",	"Delta upper CI bound",
    "Delta_ci_pass",   	"Delta CI pass"), ncol=2, byrow=T)
    field_pairs <- rbind(field_pairs, mat_)
  }
  df_table <- df_table[field_pairs[,1]]
  names(df_table) <- field_pairs[,2]

  b_ <- sapply(df_table, is.numeric)
  df_table[b_] <- lapply(df_table[b_], function(x) signif(x, digits=3))
  tbl_ <- list(name="tbl_score", description=paste("Score stats by",group_variable),
               df_table=df_table)

  ret_ <- list(df_s=df_s, df_score_stats=df_stats, tables=list(tbl_),
               reference=reference, group_variable=group_variable,
               id="score_group", section="Scores by group")
  return(ret_)
}

plot_compare_scores_by_groups <- function(ret_, d_out=NULL, col_c1=c("grey","tan"),
                                          png_width=600, png_height=NULL, browse=F) {
  if(browse) browser()
  
  df_s     <- ret_$df_s
  df_stats <- ret_$df_score_stats
#  
  plots_ <- list()
  p_idx  <- 1
  f_     <- ""
  # 
  desc_ <- paste("CCAD scores by", ret_$group_variable)
  fn_   <- "group_score.png"
  cat("\t", fn_,"\n")
  f_  <- paste(d_out, fn_, sep="/")
  if(is.null(d_out))
    f_ <- ""
  plots_[[p_idx]] <- list(fname=fn_, fpath=f_, description=desc_); p_idx <- p_idx + 1

  field_ <- "Score"
  v_     <- df_s[[field_]]
  col <- ifelse(df_s$Overall_flag=="Fail","red",
                ifelse(df_s$Sample_type=="Clinical", "blue", "green"))
  pch <- substr(df_s$Sample_type,1,1)
  pch[!is.na(df_s$Gender) & df_s$Gender=="Male"]   <- "M"
  pch[!is.na(df_s$Gender) & df_s$Gender=="Female"] <- "F"
  batch_idx <- c1_index(df_s[c("Group")])
  col_c1_ <- col_c1[1+batch_idx%%length(col_c1)]
  plot_v_by_cat(df_s, field_, "Group", c2="Group",
                xlab="Corus CAD score", xaxis_counts=F,
                f_out =f_, png_width=png_width, png_height=png_height,
                col   =col, pch=pch, cex=.8, col_c1=col_c1_,
                main  =desc_, 
                c2_vlines=list(0,2,"green"), # just the medians
                args.legend=list("topleft",c("Male","Female","Pooled"),
                                 pch=c("M","F","P"),col=c(4,4,3), bty="n"),
                browse=F)

#
  desc_ <- paste("CCAD score medians by", ret_$group_variable)
  fn_   <- "group_score_med.png"
  cat("\t", fn_,"\n")
  f_  <- paste(d_out, fn_, sep="/")
  if(is.null(d_out))
    f_ <- ""
  plots_[[p_idx]] <- list(fname=fn_, fpath=f_, description=desc_); p_idx <- p_idx + 1

  field_ <- "Median"
  df_ <- df_stats
  v_  <- df_[[field_]]
  if(!is.null(ret_$reference)) {
    col <- ifelse(as.numeric(df_$Group)==1, 1,4)
    center_ <- v_[1] # use reference as center
  } else {
    col <- 4
    center_ <- mean(v_)
  }
  x_ <- c(v_, center_ - (v_-center_))
  xlim <- range(c(x_-.1,x_+.1)) # , na.rm=T
  if(all(is.na(xlim)))
     xlim <- c(0,1)
  
  pch <- 1 # substr(df_$Group,1,1)
  batch_idx <- c1_index(df_[c("Group")])
  col_c1_ <- col_c1[1+batch_idx%%length(col_c1)]
  plot_v_by_cat(df_, field_, "Group", # c2="Group",
                xlab="Corus CAD median score", xaxis_counts=F, xlim=xlim,
                f_out =f_, png_width=png_width, png_height=png_height,
                col   =col, pch=pch, cex=1, col_c1=col_c1_,
                main  =desc_, jit_size=0,
                vlines=c(center_, 2, 3), 
                browse=F)

#
  desc_ <- paste("CCAD score std dev by", ret_$group_variable)
  fn_   <- "group_score_sd.png"
  cat("\t", fn_,"\n")
  f_  <- paste(d_out, fn_, sep="/")
  if(is.null(d_out))
    f_ <- ""
  plots_[[p_idx]] <- list(fname=fn_, fpath=f_, description=desc_); p_idx <- p_idx + 1

  field_ <- "Sd"
  df_ <- df_stats
  v_  <- df_[[field_]]
  xlim <- range(c(0, v_+.2, 1, df_$sqm_machine_sd[1]+.1))
  if(all(is.na(xlim)))
     xlim <- c(0,1)

  col <- ifelse(df_$Sd > df_$sqm_machine_sd[1], 2, 4)
  pch <- 1 # substr(df_$Group,1,1)
  batch_idx <- c1_index(df_[c("Group")])
  col_c1_ <- col_c1[1+batch_idx%%length(col_c1)]
  plot_v_by_cat(df_, field_, "Group", # c2="Group",
                xlab="Corus CAD score std dev", xaxis_counts=F, xlim=xlim,
                f_out =f_, png_width=png_width, png_height=png_height,
                col   =col, pch=pch, cex=1, col_c1=col_c1_,
                main  =desc_, jit_size=0,
                vlines=c(df_$sqm_machine_sd[1], 2, 2), # need the limit here
                browse=F)

#
  desc_ <- paste("95% confidence intervals of CCAD score means by", ret_$group_variable)
  fn_   <- "group_score_ci.png"
  cat("\t", fn_,"\n")
  f_  <- paste(d_out, fn_, sep="/")
  if(is.null(d_out))
    f_ <- ""
  plots_[[p_idx]] <- list(fname=fn_, fpath=f_, description=desc_); p_idx <- p_idx + 1

  df_l <- df_stats[c("Group","Ci_lo")]
  df_m <- df_stats[c("Group","Mean" )]
  df_h <- df_stats[c("Group","Ci_hi")]
  names(df_l)[2] <- "value"
  names(df_m)[2] <- "value"
  names(df_h)[2] <- "value"
  df_  <- rbind(df_l, df_m, df_h)
  v_   <- df_$value
  xlim <- range(c(v_-.1, v_+.1))
  if(all(is.na(xlim)))
     xlim <- c(0,1)
  col  <- 1
  pch  <- rep(c("(","+",")"), each=nrow(df_l))
#  batch_idx <- c1_index(df_[c("Group")])
#  col_c1_ <- col_c1[1+batch_idx%%length(col_c1)]
  if(is.null(ret_$reference))
    ci_limits <- mean(df_stats$Mean) + df_stats$sqm_xc_conf_int[1]*c(-1,0,1)
  else
    ci_limits <- df_stats$Mean[1] + df_stats$sqm_xc_conf_int[1]*c(-1,0,1)
  plot_v_by_cat(df_, "value", "Group", # c2="Group",
                xlab="Corus CAD score", xaxis_counts=F, xlim=xlim,
                f_out =f_, png_width=png_width, png_height=png_height,
                col   =col, pch=pch, cex=1, col_c1=col_c1_,
                main  =desc_, jit_size=0,
                vlines=list(ci_limits, 2, col=c(2,3,2)),
                args.segments=list(df_stats$Ci_lo, as.numeric(df_stats$Group),
                  df_stats$Ci_hi, as.numeric(df_stats$Group), col=1, lty=1),
                browse=F)

# mean deltas from reference
  if(!is.null(ret_$reference)) {
    desc_ <- paste("95% confidence intervals of the CCAD score ",ret_$group_variable,
                   " mean deltas\n",ret_$group_variable," mean - reference (",ret_$reference,") mean",sep="")
    fn_   <- "group_score_ci_delta.png"
    cat("\t", fn_,"\n")
    f_  <- paste(d_out, fn_, sep="/")
    if(is.null(d_out))
      f_ <- ""
    plots_[[p_idx]] <- list(fname=fn_, fpath=f_, description=desc_); p_idx <- p_idx + 1

    df_ <- df_stats[-1,]
    df_$Group <- factor(df_$Group) # delete missing categories
    df_l <- df_[c("Group","Delta_ci_lo")]
    df_m <- df_[c("Group","Delta_mean" )]
    df_h <- df_[c("Group","Delta_ci_hi")]
    names(df_l)[2] <- "value"
    names(df_m)[2] <- "value"
    names(df_h)[2] <- "value"
    df_  <- rbind(df_l, df_m, df_h)
    v_   <- df_$value
    xlim <- range(c(v_-.1, v_+.1))
    if(all(is.na(xlim)))
      xlim <- c(0,1)
    col  <- 1
    pch  <- rep(c("(","+",")"), each=nrow(df_l))
    ci_limits <- df_stats$sqm_xc_conf_int[1]*c(-1,0,1)
    col_c1_ <- rep(col_c1, nrow(df_l))[1:nrow(df_l)]
    plot_v_by_cat(df_, "value", "Group", # c2="Group",
                  xlab="Corus CAD score", xaxis_counts=F, xlim=xlim,
                  f_out =f_, png_width=png_width, png_height=png_height,
                  col   =col, pch=pch, cex=1, col_c1=col_c1_,
                  main  =desc_, jit_size=0,
                  vlines=list(ci_limits, 2, col=c(2,3,2)),
                  args.segments=list(df_l$value, as.numeric(df_l$Group),
                    df_h$value, as.numeric(df_l$Group), col=1, lty=1),
                  browse=F)
  }

  invisible(plots_)
}

compare_clinical_by_groups <- function(df_s, reference=NULL, params=NULL,
                                       group_variable="group", browse = F) {
  if(browse) browser()

  fields_ <- c("Group", "Batch", "Plate", "Accession", "Cp.run.id", "Is_pax_ctrl",
               "Sex", "Age",  "Sample_type","Score", "Overall_flag")
  df_s$Sex <- df_s$Gender
  df_s <- df_s[df_s$Sample_type=="Clinical", fields_]
  if(nrow(df_s)==0)
    return(NULL)
#  params$well_missing_fail <- params$well_missing_pct*params$data_cnt_well_missing
#  df_s <- cbind(df_s, params)

  # group stats
  lst_ <- by(df_s, df_s[c("Group", "Sex")],
                 function(df_) {
                   return(data.frame(Group = df_$Group[1],
                                     Sex   = df_$Sex[1],
                                     Count = nrow(df_),
                                     Median= median(df_$Age, na.rm=T),
                                     Sd    = sd(df_$Age, na.rm=T),
                                     stringsAsFactors=F))}, simplify=F)
  df_age <- do.call(rbind, lst_)
  tbl_gs <- table(df_s[c("Group","Sex")])

  # table
  df_table <- df_age[order(df_age$Group, df_age$Sex),]
  field_pairs <- matrix(
  c("Group",  group_variable,
    "Sex",    "Sex",
    "Count",  "Count",
    "Median", "Median age",
    "Sd",     "Std Dev"), ncol=2, byrow=T)
  df_table <- df_table[field_pairs[,1]]
  names(df_table) <- field_pairs[,2]

  b_ <- sapply(df_table, is.numeric)
  df_table[b_] <- lapply(df_table[b_], function(x) signif(x, digits=3))
  tbl_ <- list(name="tbl_clinical", description=paste("Clinical stats by",group_variable),
               df_table=df_table)
  
  ret_ <- list(df_s=df_s, df_age_stats=df_age, tbl_group_by_sex=tbl_gs, tables=list(tbl_),
               reference=reference, group_variable=group_variable,
               id="clinical_group", section="Clinical samples by group")
  return(ret_)
}

plot_compare_clinical_by_groups <- function(ret_, d_out=NULL, col_c1=c("grey","tan"),
                                          png_width=600, png_height=NULL, browse=F) {
  if(browse) browser()
  
  png_height_ <- ifelse(is.null(png_height), png_width, png_height)
  plots_ <- list()
  if(is.null(ret_))
    return(plots_)
  
  p_idx  <- 1
  f_     <- ""
#
  df_    <- ret_$df_s #df_age_stats
  desc_ <- paste("Age and sex by", ret_$group_variable)
  fn_   <- "group_sex_age.png"
  cat("\t", fn_,"\n")
  f_  <- paste(d_out, fn_, sep="/")
  if(is.null(d_out))
    f_ <- ""
  plots_[[p_idx]] <- list(fname=fn_, fpath=f_, description=desc_); p_idx <- p_idx + 1

  field_ <- "Age"
  v_     <- df_[[field_]]
  col <- ifelse(df_$Overall_flag=="Fail","red",
                ifelse(df_$Sample_type=="Clinical", "blue", "green"))
  pch <- substr(df_$Sample_type,1,1)
  pch[!is.na(df_$Sex) & df_$Sex=="Male"]   <- "M"
  pch[!is.na(df_$Sex) & df_$Sex=="Female"] <- "F"
  batch_idx <- c1_index(df_[c("Group")])
  col_c1_ <- col_c1[1+batch_idx%%length(col_c1)]
  plot_v_by_cat(df_, field_, "Group", c2="Group",
                xlab="Age", xaxis_counts=F,
                f_out =f_, png_width=png_width, png_height=png_height,
                col   =col, pch=pch, cex=.8, col_c1=col_c1_,
                main  =desc_, 
                c2_vlines=list(0,2,"green"), # just the medians
                browse=F)

  # Sex counts
  desc_ <- paste("Sample counts sex by", ret_$group_variable)
  fn_   <- "group_sex.png"
  cat("\t", fn_,"\n")
  if(!is.null(d_out)) {
    f_  <- paste(d_out, fn_, sep="/")
    png(filename=f_, width=png_width, height=png_height_)
  }
  plots_[[p_idx]] <- list(fname=fn_, fpath=f_, description=desc_); p_idx <- p_idx + 1

  mat_ <- t(as.matrix(ret_$tbl_group_by_sex))[2:1,]
  max_ <- max(mat_,na.rm=T)
  ylim <- c(0, max(mat_+1, 1.25*max_, 3))
  col  <- c("skyblue2","pink1")
  xlim <- c(1,(ncol(mat_)+1)*max(nrow(mat_),2))
  barplot(mat_, col=col, beside=T, ylim=ylim, xlim=xlim,
          main=desc_, ylab="Samples",
          legend.text=T, args.legend=list(bty="n"))
  if(!is.null(d_out)) {
    dev.off()
  }

  invisible(plots_)
}

compare_genes_by_groups <- function(df_s, reference=NULL, params=NULL, gene_lst=NULL,
                                       group_variable="group", browse = F) {
  if(browse) browser()

  if(is.null(gene_lst))
    stop("Must specify gene list in compare_genes_by_groups\n")
  fields_0 <- c("Group", "Batch", "Plate", "Accession", "Cp.run.id", "Is_pax_ctrl",
               "Gender", "Age",  "Sample_type","Score", "Overall_flag")
  fields_ <- c(fields_0, gene_lst)
  df_s <- df_s[fields_]
  if(nrow(df_s)==0)
    return(NULL)
#  params$well_missing_fail <- params$well_missing_pct*params$data_cnt_well_missing
#  df_s <- cbind(df_s, params)
  
  # group stats
  b_  <- df_s$Overall_flag=="Pass"
  if(sum(b_) > 0)
    df_group_cps <- aggregate(df_s[b_, gene_lst], df_s[b_,]["Group"], median, na.rm=T)
  else
    return(NULL)
#  lst_ <- as.list(gene_lst)
#  for(ii in 1:length(lst_)) {
#    gene_ <- gene_lst[[ii]]
#    df_ <- cbind(df_s[fields_0], Gene=gene_, Cp=df_s[[gene_]], stringsAsFactors=F)
#    lst_genes[[ii]] <- df_
#  }
##  df_gene_cp <- do.call(rbind, lst_)
  
#  lst_ <- lapply(lst_genes, 
#                 function(df_) {
#                   b_ <- df_$Overall_flag=="Pass"
#                   return(data.frame(Group  = df_$Group[1],
#                                     Gene   = df_$Gene[1],
#                                     Count  = nrow(df_),
#                                     Passed = sum(b_),
#                                     Median = median(df_$Cp[b_], na.rm=T),
#                                     Sd     = sd(df_$Cp[b_], na.rm=T),
#                                     stringsAsFactors=F))})
#  df_stats <- do.call(rbind, lst_)
  
  ret_ <- list(df_s=df_s, df_group_cps=df_group_cps, genes=gene_lst,
               reference=reference, group_variable=group_variable,
               id="gene_group", section="Gene Cps by group")
  return(ret_)
}

plot_compare_genes_by_groups <- function(ret_, d_out=NULL, col_c1=c("grey","tan"),
                                         png_width=600, png_height=NULL, browse=F) {
  if(browse) browser()
  
  png_height_ <- ifelse(is.null(png_height), png_width, png_height)
  plots_ <- list()
  p_idx  <- 1
  f_     <- ""

  if(is.null(ret_) || (nrow(ret_$df_group_cps) == 0))
    return(plots_)
  #######################
  desc_ <- paste("Gene median Cp values by", ret_$group_variable)
  fn_   <- "group_gene_cps.png"
  cat("\t", fn_,"\n")
  if(!is.null(d_out)) {
    f_  <- paste(d_out, fn_, sep="/")
    png(filename=f_, width=png_width, height=png_height_)
  }
  plots_[[p_idx]] <- list(fname=fn_, fpath=f_, description=desc_); p_idx <- p_idx + 1

  opar   <- par(mar=c(6,4,4,2)+.1, mfrow=c(1,1), las=1)
  df_    <- ret_$df_group_cps
  b_f    <- factor(df_$Group)
#  s_f   <- factor(df_$Sample_type)
  col    <- as.numeric(b_f)
#  pch   <- substr(levels(s_f),1,1)[as.numeric(s_f)]
  pch    <- as.numeric(b_f)
  ngenes <- length(ret_$genes)
  mat_   <- as.matrix(df_[ret_$genes])
  rownames(mat_) <- df_$Group
  mat_   <- t(mat_)
  ylim   <- range(c(20,40, mat_), na.rm=T)
  matplot(mat_, ylim=ylim, xaxt="n", pch=pch, col=col,
          main=desc_, ylab="Cp value")
  abline(h=0,lty=2,col=8)
  abline(v=1:ngenes,lty=2,col=8)
  matlines(mat_, pch=pch, col=col)
  axis(1, at=1:ngenes,labels=rownames(mat_), las=2)
  legend("topleft", levels(b_f), text.col=1:nlevels(b_f),
         col=1:nlevels(b_f), pch=1:nlevels(b_f), bty="n")
#  legend("bottomright", levels(s_f), #col=1:nlevels(b_f),
#         pch=substr(levels(s_f),1,1), bty="n")

  par(opar) #par(mar=c(5,4,4,2)+.1, mfrow=c(1,1), las=1)
  if(!is.null(d_out)) {
    dev.off()
  }

  #######################
  if(!is.null(ret_$reference) &&
     (nrow(ret_$df_group_cps)>1)) { # delta Cps from reference
    desc_ <- paste("Gene median Cp deltas from reference ", ret_$reference,
                   " by ", ret_$group_variable, sep="")
    fn_   <- "group_gene_cps_ref.png"
    cat("\t", fn_,"\n")
    if(!is.null(d_out)) {
      f_  <- paste(d_out, fn_, sep="/")
      png(filename=f_, width=png_width, height=png_height_)
    }
    plots_[[p_idx]] <- list(fname=fn_, fpath=f_, description=desc_); p_idx <- p_idx + 1

    opar   <- par(mar=c(6,4,4,2)+.1, mfrow=c(1,1), las=1)
    df_    <- ret_$df_group_cps
    b_f    <- factor(df_$Group)
    col    <- as.numeric(b_f)[-1]
    pch    <- as.numeric(b_f)[-1]
    ngenes <- length(ret_$genes)
    mat_   <- as.matrix(df_[ret_$genes])
    rownames(mat_) <- paste(df_$Group, "-", df_$Group[1])
    mat_   <- t(mat_)
    mat_ <- mat_[,-1] - mat_[,1]
    ylim   <- range(c(-.5,.5, mat_, -mat_), na.rm=T)
    matplot(mat_, ylim=ylim, xaxt="n", pch=pch, col=col,
            main=desc_, ylab="Cp delta")
    abline(h=0,lty=2,col=8)
    abline(v=1:ngenes,lty=2,col=8)
    matlines(mat_, pch=pch, col=col)
    axis(1, at=1:ngenes,labels=rownames(mat_), las=2)
    legend("topleft", paste(levels(b_f)[-1],"-",levels(b_f)[1]), text.col=2:nlevels(b_f),
           col=2:nlevels(b_f), pch=2:nlevels(b_f), bty="n")

    par(opar) #par(mar=c(5,4,4,2)+.1, mfrow=c(1,1), las=1)
    if(!is.null(d_out)) {
      dev.off()
    }
  }
  
  invisible(plots_)
}

compare_pax_by_groups <- function(df_s, reference=NULL, params=NULL, score_ranges, 
                                       group_variable="group", browse = F) {
  if(browse) browser()

  fields_ <- c("Group", "Batch", "Plate", "Accession", "Cp.run.id", "Is_pax_ctrl",
               "Gender", "Age",  "Sample_type","Score", "Overall_flag")
  df_s <- df_s[df_s$Is_pax_ctrl==1, fields_]
  if(nrow(df_s)==0)
    return(NULL)
  df_s$pax_batch_max_dev <- params$pax_batch_max_dev
  df_s$pax_score_range_lo <- score_ranges$PAX[1]
  df_s$pax_score_range_hi <- score_ranges$PAX[2]
#  params$well_missing_fail <- params$well_missing_pct*params$data_cnt_well_missing
#  df_s <- cbind(df_s, params)

  # group stats
  lst_ <- by(df_s, df_s["Group"],
                 function(df_) {
                   b_ <- df_$Overall_flag=="Pass"
                   return(data.frame(Group  = df_$Group[1],
                                     Count  = nrow(df_),
                                     Passed = sum(b_),
                                     Median = median(df_$Score[b_], na.rm=T),
                                     Sd     = sd(df_$Score[b_], na.rm=T),
                                     stringsAsFactors=F))}, simplify=F)
  df_stats <- do.call(rbind, lst_)
  ret_ <- list(df_s=df_s, df_stats=df_stats,
               reference=reference, group_variable=group_variable,
               id="pax_group", section="Pax scores by group")
  return(ret_)
}

plot_compare_pax_by_groups      <- function(ret_, d_out=NULL, col_c1=c("grey","tan"),
                                          png_width=600, png_height=NULL, browse=F) {
  if(browse) browser()
  
  plots_ <- list()
  if(is.null(ret_))
    return(plots_)
  df_s    <- ret_$df_s
  if(nrow(df_s)==0)
    return(plots_)
  
  p_idx  <- 1
  f_     <- ""
  # 
  desc_ <- paste("PAX CCAD scores by", ret_$group_variable)
  fn_   <- "group_pax_score.png"
  cat("\t", fn_,"\n")
  f_  <- paste(d_out, fn_, sep="/")
  if(is.null(d_out))
    f_ <- ""
  plots_[[p_idx]] <- list(fname=fn_, fpath=f_, description=desc_); p_idx <- p_idx + 1

  pax_score_region <- c(-1.2,-.2)

  field_ <- "Score"
  v_     <- df_s[[field_]]
  col <- ifelse(df_s$Overall_flag=="Fail","red", "blue")
  pch <- substr(df_s$Sample_type,1,1)
  batch_idx <- c1_index(df_s[c("Group")])
  col_c1_ <- col_c1[1+batch_idx%%length(col_c1)]
  pr_m_ <- (df_s$pax_score_range_lo[1] + df_s$pax_score_range_hi[1])/2
  xlim_min_range <- median(df_s[[field_]], na.rm=T) + df_s$pax_batch_max_dev[1]*c(-1,1)
  plot_v_by_cat(df_s, field_, "Group", c2="Group",xlim_min_range=xlim_min_range,
                xlab="PAX Corus CAD score", xaxis_counts=F,
                f_out =f_, png_width=png_width, png_height=png_height,
                col   =col, pch=pch, cex=.8, col_c1=col_c1_,
                main  =desc_, 
                vlines=list(c(df_s$pax_score_range_lo[1],pr_m_,df_s$pax_score_range_hi[1]),2,c(2,8,2)),
                c2_vlines=list(0,2,3), #list(0,2,"green"),
#                c2_vlines=list(df_s$pax_batch_max_dev[1]*c(-1,0,1),2,c(2,3,2)), #list(0,2,"green"), # just the medians # 
                browse=F)

  invisible(plots_)
}

############################
############################
# diagnostics

cas_d2_diag_html <- function(ret_diag,
                             df_cp            = NULL, # cp data to output
                             mat_info         = NULL,
                             title            = "",
                             f_out            = NULL,
                             f_out_suffix     = "", # not the file extension!
                             f_out_ext        = "html",
                             d_out            = NULL, 
                             dir_plot         = NULL, # only if plots are moved
                             ccad_score_output = F,
                             output_cp_values = F,
                             f_css            = "/home/jblanchard/hdrive/svn/biostats/jblanchard/projects/code/style.css",
                             js_include = c(), # anything to include in the head section
                             browse=F) {
  if(browse) browser()

  if(is.null(title) || title=="") {
    title <- "CCAD diagnostics report"
  }
  if(!is.null(mat_info)) {
    if("Report ID" %in% mat_info[,1]) {            # Ugh!
      idx   <- which(mat_info[,1] %in% "Report ID")[1]
      rid_  <- mat_info[idx,2]
      title <- paste(title, rid_, sep="_")
    }
  }
  if(is.null(ret_diag))
    stop("Must specify ret_diag\n")
  if(!"ret_cas" %in% names(ret_diag))
    stop("ret_diag isn't an ccad diagnostics object\n")
  if(is.null(d_out) || d_out=="")
    stop("Must specify output directory\n")
  if(is.null(f_out) || f_out=="")
    f_out <- paste("ccad_group_comparison_", Sys.Date(), sep="")
    f_out <- paste("ccad_diagnostics_", Sys.Date(), sep="")
  if(f_out_suffix != "")
    f_out <- paste(f_out, f_out_suffix, sep="")
  f_out <- paste(f_out, f_out_ext, sep=".")
  if(is.null(f_css) || f_css=="")
    stop("Must specify CSS file\n")

  if(is.null(dir_plot))
    dir_plot <- ret_diag$d_out

  # strip off .html extension if there
#  f_out_no_ext <- gsub("\\.html$", "", f_out, perl=TRUE)
  fp_out <- file.path(d_out, f_out)
            # paste(d_out, paste(f_out_no_ext, ".html", sep=""), sep="/")
  cat("Writing to target html file:\n\t", fp_out, "\n")
  target <- html_init_file(filepath  =fp_out,
                           CSSFile   =f_css,
                           Title     =title,
                           js_include=js_include, 
                           doctype   ="html 4.01 transitional", #"html 4.01 strict", #"xhtml 1.0 strict", #
                           charset   ="utf-8", #"windows-1252", "ISO-8859-1"
                           useLaTeX  =FALSE, browse=F)

  ########
  html_cat("\n\n<div id='pageHeader'>\n") #, file=target) # include target file
  s_ <- c("<h2 id='title'>", title,"</h2>\n",
          "<span id='subtitle'>Score and QC metrics for batches of 8 sample CCAD plates</span>\n")
  html_cat(s_)
  html_cat("</div>\n")

  ########
  html_cat("\n<div id='intro'>\n")
  html_cat("</div>\n")

  if(!is.null(mat_info)) {
    html_cat("<h2>Equivalency PQ information</h2>\n")
    tbl_lst <- list(name       = "equiv_info",
                    description= "", #"Machine PQ pass requirements",
                    df_table   = mat_info)
    table_html(tbl_lst, browse=F)
  }

  # table of contents
  toc_html(ret_diag, ccad_score_output=ccad_score_output,
           output_cp_values=output_cp_values, browse=F)
  
  # simple counts of batches, plates, samples, ...
#  counts_html(ret_diag, browse=F)

  # sections
  cat("Sections\n")
  html_cat("\n<div id='sections'>\n")
  
  for(ret_ in ret_diag) {
    if(!any(c("plots","tables") %in% names(ret_))) # only if there are plots or tables
      next

    cat("\t", ret_$id,"\n", sep="")
    html_cat("\n<div id='",ret_$id,"'>\n")
    html_cat("<h2 class='break'><a name='",ret_$id,"' href='#toc_",ret_$id,"'>",ret_$section,"</a></h2>\n")
    
    if("tables" %in% names(ret_)) {
      for(tbl_ in ret_$tables) {
        html_cat("<h3 class='break'></h3>\n")
        table_html(tbl_, browse=F)
      }
    }
    if("plots" %in% names(ret_)) {
      for(plot_ in ret_$plots) {
        html_cat("<h3 class='break'></h3>\n")
        plot_html(plot_, caption_top=TRUE, browse=F)
      }
    }
    html_cat("</div>\n")
  }

  # data tables
  html_cat("\n<div id='data'>\n",
           "<h2><a name='data' href='#toc_data'>Data</a></h2>\n")

  if(ccad_score_output) {
    cat("\tCCAD scores & diagnostics table\n")
    html_cat("<h3 class='break'></h3>\n")
    output_score_html(list(name="tbl_ccad_scores", description="CCAD scores and diagnostics table",
                            df_table=ret_diag$ret_cas$df_all), browse=F)
#    names(df_all) <- gsub("_", " ", names(df_all))
#    table_html(list(name="tbl_ccad_scores", description="CCAD scores and diagnostics table",
#                    df_table=df_all), browse=F)
#    html_cat("</div>\n")
  }
  
  if(output_cp_values) {
    if(is.null(df_cp))
      cat("Must specify df_cp data.frame to output Cp data.\n")
    cat("\tCp data\n")
    html_cat("<h3 class='break'></h3>\n")
    table_html(list(name="tbl_cp_data", description="Cp data table",
                    df_table=df_cp), browse=F)
#    html_cat("</div>\n")
  }
  html_cat("\n</div>\n") # data

  html_cat("\n</div>\n") # sections
  html_cat("</body>\n</html>\n")

  return(fp_out)
}

output_score_html <- function(tbl_list, return_df=F, browse=F) {
  if(browse) browser()

  df_all <- tbl_list$df_table
#  names(df_all) <- gsub("_", " ", names(df_all))
  mat_ <- matrix(
      c("Plate",			"Plate",
        "Batch",			"Batch",
        "Cp.run.id",			"Cp.run.id",
        "Accession",			"Accession",
        "Sample_type",			"Sample type",
        "Gender",			"Gender",
        "Age",			        "Age",
        "Score",			"Score",
        "Trans_score",			"Trans score",
        "Score_nt",			"Score nt",
        "Trans_score_nt",		"Trans score nt",
        "AF289562",			"AF289562",
        "AQP9",			        "AQP9",
        "CASP5",			"CASP5",
        "CD3D",			        "CD3D",
        "CD79B",			"CD79B",
        "CLEC4E",			"CLEC4E",
        "HNRPF",			"HNRPF",
        "IL18RAP",			"IL18RAP",
        "IL8RB",			"IL8RB",
        "KCNE3",			"KCNE3",
        "KLRC4",			"KLRC4",
        "NCF4",			        "NCF4",
        "RPL28",			"RPL28",
        "S100A12",			"S100A12",
        "S100A8",			"S100A8",
        "SLAMF7",			"SLAMF7",
        "SPIB",			        "SPIB",
        "TFCP2",			"TFCP2",
        "TLR4",		 	        "TLR4",
        "TMC8",			        "TMC8",
        "TNFAIP6",			"TNFAIP6",
        "TNFRSF10C",			"TNFRSF10C",
        "TSPAN16",			"TSPAN16",
        "RPS4Y1",			"RPS4Y1",
#        "Sex_fail",			"Sex fail",
        "Sex_flag",			"Sex flag",
        "GTFCP2",			"GTFCP2",
        "Gdna_delta_cp",		"Gdna delta Cp",
#        "Gdna_warn",			"Gdna warn",
#        "Gdna_fail",			"Gdna fail",
        "Gdna_flag",			"Gdna flag",
        "Data_cnt",			"Data count",
        "Data_incomplete",		"Data incomplete",
        "Sample_well_total",		"Well total",
#        "Sample_well_missing",		"Sample well missing",
#        "Sample_well_warn",		"Sample well warnings",
#        "Sample_well_fail",		"Sample well failures",
        "Well_na_cnt",			"Well NAs count",
        "Well_na_flag",			"Well NA flag",
        "Sample_missing_1well_cnt",	"Sample 1well NAs count",
        "Sample_missing_2well_cnt",	"Sample 2well NAs count",
        "Sample_missing_3well_cnt",	"Sample 3well NAs count",
#        "Sample_gene_na_cnt",		"Sample gene NAs count",
#        "Sample_gene_fail",		"Sample gene fail",
        "Gene_na_cnt",			"Gene NAs count",
        "Gene_na_flag",			"Gene NA flag",
#        "Expr_mean",			"Expr mean",
#        "Expr_mean_warn",		"Expr mean warn",
#        "Expr_mean_fail",		"Expr mean fail",
        "Exp_mean",			"Exp mean",
        "Exp_mean_flag",		"Exp mean flag",
#        "Expr_profile",	        "Expr profile",
#        "Ep_warn",			"Ep warn",
#        "Ep_fail",			"Ep fail",
        "Exp_profile",			"Expression profile",
        "Exp_flag",			"Expression flag",
#        "Med_sd",			"Med sd",
#        "Med_sd_warn",			"Med sd warn",
#        "Med_sd_fail",			"Med sd fail",
        "Sd",			        "SD 50",
        "Sd_flag",			"SD 50 flag",
        "Sd_90",			"SD 90",
#        "Sd_90_warn",			"Sd 90 warn",
#        "Sd_90_fail",			"Sd 90 fail",
        "Sd_90_flag",			"SD 90 flag",
#        "Sd_max",			"Sd max",
#        "Sd_max_fail",			"Sd max fail",
        "Sd_100",			"SD 100",
        "Sd_100_flag",			"SD 100 flag",
        "Trunc_cnt",			"Truncation counts",
#        "Trunc_warn",			"Trunc warn",
#        "Trunc_fail",			"Trunc fail",
        "Trunc_flag",			"Truncation flag",
        "Warning_cnt",			"Warnings",
        "Warning_cnt_ng",		"Warnings ng",
        "Warning_fail",			"Warning failures",
        #
        "Is_water",			"Is water",
        "Water_cp_min",			"Water cp min",
        "Water_cp_low_cnt",	        "Water cp low cnt",
        "Water_fail",			"Water fail",
        "Is_pax_ctrl",			"Is PAX ctrl",
        "Pax_batch_med",		"Pax batch med",
        "Pax_batch_mdev",		"Pax batch mdev",
        "Pax_batch_sd",			"Pax batch sd",
        "Pax_fail",			"Pax fail",
        "Pax_batch_fail",	        "Pax batch fail",
        "Negctrl_cp_min",		"Negctrl Cp min",
        "Negctrl_total",		"Negctrl total",
#        "Negctrl_fail",		"Negctrl fail",
        "Negctrl_flag",			"Negctrl flag",
        "fail_ngt",			"fail ngt",
#        "Sample_pass",			"Sample pass",
        "Plate_well_total",		"Plate well total",
#        "Plate_well_missing_cnt",	"Plate well NAs count",
        "Plate_well_na_cnt",		"Plate well NAs count",
        "Plate_sample_fail_cnt",	"Plate sample failures",
        "Plate_sample_warn_cnt",	"Plate sample warnings",
#        "Plate_pass",			"Plate pass",
        "Batch_samp_fail_cnt",		"Batch sample failures",
        "Batch_samp_warn_cnt",		"Batch sample warnings",
        "Batch_plate_fail_cnt",		"Batch plate failures",
        "Sample_flag",			"Sample flag",
        "Plate_flag",			"Plate flag",
        "Overall_flag",			"Overall flag"
        ), ncol=2, byrow=T)

  b_ <- mat_[,1] %in% names(df_all)
  if(any(!b_)) {
    cat(sum(!b_)," variables not found in df_all\n")
    print(table(b_))
    cat(paste(mat_[!b_,1], collapse=", "),"\n")
    stop("\n")
  }
  
  df_all <- df_all[mat_[,1]] # subset
  names(df_all) <- mat_[,2]  # rename

  if(return_df) {
    return(df_all)
  } else {
  # print out score data
    table_html(list(name=tbl_list$name, description=tbl_list$description,
                    df_table=df_all), browse=F)
  }
}

toc_html <- function(ret_diag, ccad_score_output=F, output_cp_values=F, browse=F) {
  if(browse) browser()

  cat("TOC\n")
  html_cat("\n<div id='toc'>\n",
           "<h2><a name='toc'>Contents</a></h2>")
  
  # counts?

  # sections
  for(ret_ in ret_diag) {
    if(!any(c("plots","tables") %in% names(ret_)))
      next

    cat("\t", ret_$id,"\n", sep="")
    html_cat("<h3><a name='toc_",ret_$id,"' href='#",ret_$id,"'>&emsp;",ret_$section,"</a></h3>\n")
    
    for(tbl_ in ret_$tables) {
      html_cat("<a class='table' name='toc_",tbl_$name,"' href='#",tbl_$name,"'>&emsp;&emsp;",tbl_$description,"</a><br>\n")
    }
    if("tables" %in% names(ret_))
      html_cat("<br>\n")

    for(plot_ in ret_$plots) {
      html_cat("<a class='plot' name='toc_",plot_$fname,"' href='#",plot_$fname,"'>&emsp;&emsp;",plot_$description,"</a><br>\n")
    }
  }

  # data tables
  html_cat("<h3><a name='toc_data' href='#data'>&emsp;Data</a></h3>\n")

  if(ccad_score_output) {
    cat("\tscores\n")
    html_cat("<a class='table' name='toc_tbl_ccad_scores' href='#tbl_ccad_scores'>&emsp;&emsp;",
             "CCAD scores and diagnostics table","</a><br>\n")
  }
  
  if(output_cp_values) {
    cat("\tcp data\n")
    html_cat("<a class='table' name='toc_tbl_cp_data' href='#tbl_cp_data'>&emsp;&emsp;",
             "Cp data table","</a><br>\n")
  }
  
  html_cat("</div>\n")
}

table_html <- function(tbl_lst, output_string=F, browse=F) {
  if(browse) browser()

  str_ <- c("\n<div id='", tbl_lst$name,"'>\n",
            "<a name='", tbl_lst$name,"' href='#toc_", tbl_lst$name,"'>",
            paste("<span class=\"table_caption\">",tbl_lst$description,"</span></a>\n", sep=""),
            "<p></p>\n<table>\n",
            "<col span='1'></col>\n",
            data2html_table(tbl_lst$df_table, use.rownames=F, browse=F),
            "</table>\n",
            "</div>\n")
  if(output_string)
    return(str_)
  html_cat(str_)
}

# creates the interior of an html table from data
# data can be data.frame, table, matrix, list of scalars, or vector
# doesn't output the <table> tag
# ncol, byrow  are used only when data is a list or vector
# list and vector data are filled by column by default (as with matrices)
# the output contains a header when for a table, data.frame
#    and for a matrix when colnames is not null
# when use.rownames=T then row names are used when they exist and 1:nrow otherwise
data2html_table <- function(data, ncol=NULL, byrow=F, use.rownames=F,
                            hi_light_col_cnts=c("failures","NAs", "warnings"), # column names
                            hi_light_tags    =c("fail","NA", "warn"),          # columns entries
                            hi_light_words=c("Fail", "Warn"), browse=F) { # in any column
  if(browse) browser()

  if(is.data.frame(data) || is.table(data) || is.matrix(data))
    mat_ <- as.matrix(data) # a data.frame will convert to char here if mixed types
  if(is.list(data))
    data <- as.vector(data)
  if(is.vector(data)) {
    if(length(data)<= 0)
      return("")
    if(is.null(ncol))
      stop("Must specify the number of columns (ncol) for scalar data\n")
    if((ncol <= 0) || (length(data)%% ncol))
      stop("data length is not a multiple of the column number\n")
    mat_ <- matrix(data, ncol=ncol, byrow=byrow)
  }
  if(ncol(mat_)<= 0)
    return("")

  b_rownames <- F
  b_colnames <- !is.null(colnames(mat_))
  if(b_colnames)
    mat_ <- rbind(colnames(mat_), mat_)
  if(use.rownames) {
    if(is.null(rownames(mat_)))        # don't hav'em?
      rownames(mat_) <- 1:nrow(mat_)   # mak'em
    mat_ <- cbind(rownames=rownames(mat_), mat_) # got'em
    b_rownames <- T
  }
#  return(mat_)
  if(b_colnames) { # col names in the first row
    for(ii in 1:length(hi_light_col_cnts)) {
      pattern_ <- hi_light_col_cnts[ii] # paste(hi_light_col_cnts,collapse="|")
      tag_     <- hi_light_tags[ii]
      idx_     <- grep(pattern_, mat_[1,]) # columns with 'failure' in the name
      for(jj in idx_) {
        v_ <- suppressWarnings(as.numeric(mat_[,jj]))
        b_ <- !is.na(v_) & v_ > 0  # positive values
        mat_[b_,jj] <- paste("<span class='",tag_,"'>",v_[b_],"</span>", sep="")
      }
    }
#    b_ <- mat_ %in% hi_light_words
#    mat_[b_] <- paste("<span class='fail'>",mat_[b_],"</span>", sep="")
  }
  for(ii in 1:length(hi_light_words)) {
    b_ <- mat_ %in% hi_light_words[ii] # hilight this word everywhere found
    mat_[b_] <- paste("<span class='",hi_light_words[ii],"'>",mat_[b_],"</span>", sep="")
  }
  
  tmat_ <- t(mat_) # need for indexing
  v_ <- character(length(mat_))
  col <- 1
  item_tag <- "td"
  if(b_colnames) # header
    item_tag <- "th"

  for(ii in 1:length(mat_)) {
    s_ <- ""
    if(col==1) {
      if(item_tag == "th") # in the header
        s_ <- "<thead>\n<tr>"
      else
        s_ <- "<tr>"
    } 
    s_ <- paste(s_, "<",item_tag,">", tmat_[[ii]],"</",item_tag,">", sep="")
    if(col==ncol(mat_)) {
      if(item_tag == "th") # in the header
        s_ <- paste(s_, "</tr>\n</thead>\n</tbody>\n", sep="")
      else
        s_ <- paste(s_, "</tr>\n", sep="")
      item_tag <- "td" # set back after header
      col <- 0
    }
    if(ii == length(mat_)) # last element
      v_[ii] <- paste(s_, "</tbody>\n", sep="")
    else
      v_[ii] <- s_
    col <- col + 1
  }

  s_ <- paste(v_, collapse="")
  return(s_);
}

plot_html <- function(plot_lst, caption_top=FALSE, browse=F) {
  if(browse) browser()

  html_cat("\n<div id='", plot_lst$fname,"'>\n",
           "<a name='",plot_lst$fname,"'></a>", sep="") # "' href='#toc_",plot_lst$fname,
  caption_ <- paste("<a  href='#toc_",plot_lst$fname,"'>",
                    plot_lst$description,"</a>", sep="")
  html_insert_plot(plot_lst$fpath, caption=caption_,
                   caption_top=caption_top, return_str=FALSE, browse=F)
  
  html_cat("</div>\n")
}

##############################################

cas_d2_diagnostics <- function(df_cp,
                               df_age,
                               d_out       = NULL,
                               df_delta2   = NULL,
                               df_cp_delta = NULL,
                               pax_prefix  = "PAX_ctrl",
                               acc_nc      = c("(-) Ctrl"),
                               acc_ex      = c("(+) Ctrl"),
                               acc_w       = c("Water", "WATER"),
                               ret_cas     = NULL, 
                               samples_per_plate=8, #c(8,4),
                               gb_         = gene_cp_bounds(), 
                               params      = alg_qc_metric_params(),
                               score_ranges= NULL, 
                               browse      = F) {
  if(browse) browser()

  if(!is.null(d_out) && (d_out==""))
    d_out <- NULL
  if(!is.null(d_out)) { # create dir
    if(file_test("-d", d_out))
      cat("Output dir already exists:",d_out,"\n")
    else {
      if(!dir.create(d_out, recursive=F, mode="0755"))
        stop("Failed to create output dir:", d_out,"\n")
    }
  }
  
  fields <- c("Batch","Plate","Accession","Cp.run.id","Cp","Well","Gene")
  if(!all(fields %in% names(df_cp)))
    stop("df_cp missing required fields:",
         paste(fields[!fields %in% names(df_cp)], collapse=", "),"\n")

  # regularize NAs
  b_ <- !is.na(df_cp$Cp) & ((df_cp$Cp <= 0) | (df_cp$Cp >= 40))
  df_cp$Cp[b_] <- NA
  b_ <- is.na(df_cp$Cp) & (df_cp$Gene == "TSPAN16")
  df_cp$Cp[b_] <- 38
  
  b_ <- !is.na(df_cp$Gene) & (df_cp$Gene == "gTFCP2")
  df_cp$Gene[b_] <- "GTFCP2"

  #
  if(is.null(ret_cas)) { # need to calc
    cat("Calc scores\n")
    ret_cas <- calc_alg_score_d2(df_cp,
                                 df_age,
                                 df_delta2   = df_delta2,
                                 df_cp_delta = df_cp_delta,
                                 acc_prefix  = pax_prefix,
                                 acc_nc      = acc_nc,
                                 acc_ex      = acc_ex,
                                 acc_w       = acc_w,
                                 samples_per_plate=samples_per_plate,
                                 gb_         = gb_,
                                 params      = params,
                                 score_ranges= score_ranges,
                                 browse      = F)
  }
  # use current values
  df_s              <- ret_cas$df_all # scores and QC metrics
  params            <- ret_cas$params # takes precedence
  samples_per_plate <- ret_cas$samples_per_plate # takes precedence
  df_delta2         <- ret_cas$df_delta2
  df_cp_delta       <- ret_cas$df_cp_delta
  acc_prefix        <- ret_cas$acc_prefix
  acc_nc            <- ret_cas$acc_nc
  acc_ex            <- ret_cas$acc_ex
  acc_w             <- ret_cas$acc_w
  score_ranges      <- ret_cas$score_ranges
  
  cat("New variables\n")
  df_s <- score_new_variables(df_s)
  ret_cas$df_all <- df_s

# gene_lst <- c("AF289562","AQP9",    "CASP5",  "CD3D",      "CD79B",
#               "CLEC4E",  "GTFCP2",  "HNRPF",  "IL18RAP",   "IL8RB",  
#               "KCNE3",   "KLRC4",   "NCF4",   "RPL28",     "RPS4Y1",
#               "S100A12", "S100A8",  "SLAMF7", "SPIB",      "TFCP2",
#               "TLR4",    "TMC8",    "TNFAIP6","TNFRSF10C", "TSPAN16")
  # ordered by PAX standard expression levels
  gene_lst <- c("S100A8", "RPL28",   "TNFRSF10C","IL8RB",  "S100A12","AQP9", "NCF4",
                "CLEC4E", "TMC8",    "TLR4",     "IL18RAP","HNRPF",  "CD3D", "KCNE3", 
                "CD79B",  "SLAMF7",  "TNFAIP6",  "KLRC4",  "TFCP2",  "CASP5","SPIB", 
                "TSPAN16","AF289562","RPS4Y1",   "GTFCP2")
  sex_gene_lst <- c("RPS4Y1")
  
  cat("Batch\n")
  ret_b <- cas_d2_batch(  df_s, params, browse=F)
  cat("Plate\n")
  ret_p <- cas_d2_plate(  df_s, params, browse=F)
  cat("Sample\n")
  ret_s <- cas_d2_sample( df_s, params, browse=F)
  cat("Gene\n")
  ret_g <- cas_d2_gene(   df_s, gene_lst, sex_gene_lst, browse=F)
  cat("Neg ctrls\n")
  ret_n <- cas_d2_negctrl(df_cp, acc_nc, params, browse=F)
  cat("PAX ctrls\n")
  ret_x <- cas_d2_paxctrl(df_s, # df_delta2=df_delta2,
                          ret_cas$df_batch_delta,
                          gene_lst, params, score_ranges, browse=F)
  cat("Water\n")
  ret_w <- cas_d2_water(df_s, gene_lst, params, browse=F)

  cat("Batch plots\n")
  ret_b$plots <- plot_cas_d2_batch  (ret_b, d_out, browse=F)
  cat("Plate plots\n")
  ret_p$plots <- plot_cas_d2_plate  (ret_p, d_out, browse=F)
  cat("Sample plots\n")
  ret_s$plots <- plot_cas_d2_sample (ret_s, d_out, browse=F)
  cat("Gene plots\n")
  ret_g$plots <- plot_cas_d2_gene   (ret_g, d_out, browse=F)
  cat("Neg ctrl plots\n")
  ret_n$plots <- plot_cas_d2_negctrl(ret_n, d_out, browse=F)
  cat("PAX ctrl plots\n")
  ret_x$plots <- plot_cas_d2_paxctrl(ret_x, d_out, browse=F)
  cat("Water plots\n")
  ret_w$plots <- plot_cas_d2_water  (ret_w, d_out, browse=F)
  
  return(list(ret_cas = ret_cas,
              ret_b   = ret_b, 
              ret_p   = ret_p, 
              ret_s   = ret_s, 
              ret_g   = ret_g, 
              ret_n   = ret_n,
              ret_x   = ret_x,
              ret_w   = ret_w,
              d_out   = d_out))
}

score_new_variables <- function(df_s, browse = F) {
  if(browse) browser()
  
  df_s$Plate_well_na_cnt <- df_s$Plate_well_missing_cnt
  df_s$Well_na_cnt       <- df_s$Sample_well_missing
  df_s$Well_na_flag      <- metric_flag(df_s$Sample_well_fail, df_s$Sample_well_warn)
  df_s$Gene_na_cnt       <- df_s$Sample_gene_na_cnt
  df_s$Gene_na_flag      <- metric_flag(df_s$Sample_gene_fail)
  df_s$Gdna_flag         <- metric_flag(df_s$Gdna_fail,        df_s$Gdna_warn)
  df_s$Exp_mean          <- df_s$Expr_mean
  df_s$Exp_mean_flag     <- metric_flag(df_s$Expr_mean_fail,   df_s$Expr_mean_warn)
  df_s$Sd                <- df_s$Med_sd
  df_s$Sd_100            <- df_s$Sd_max
  df_s$Sd_flag           <- metric_flag(df_s$Med_sd_fail,      df_s$Med_sd_warn)
  df_s$Sd_90_flag        <- metric_flag(df_s$Sd_90_fail,       df_s$Sd_90_warn)
  df_s$Sd_100_flag       <- metric_flag(df_s$Sd_max_fail)
  df_s$Exp_profile       <- df_s$Expr_profile
  df_s$Exp_flag          <- metric_flag(df_s$Ep_fail,          df_s$Ep_warn)
  df_s$Trunc_flag        <- metric_flag(df_s$Trunc_fail,       df_s$Trunc_warn)
  df_s$Sex_flag          <- metric_flag(df_s$Sex_fail)
  df_s$Negctrl_flag      <- metric_flag(df_s$Negctrl_fail)
  df_s$Sample_flag       <- metric_flag(1-df_s$Sample_pass)
  df_s$Plate_flag        <- metric_flag(1-df_s$Plate_pass)
  df_s$Overall_flag      <- metric_flag(!(df_s$Sample_pass & df_s$Plate_pass))

  return(df_s)
}

metric_flag <- function(fail, warn=NULL, browse=F) {
  if(browse) browser()
  if(is.numeric(fail))
     fail <- fail>0 #==1
  if(is.null(warn))
    warn <- rep(0, length(fail))
  if(is.numeric(warn))
    warn <- warn>0 #==1
  return(ifelse(fail, "Fail", ifelse(warn, "Warn", "Pass")))
}

cas_d2_gene <- function(df_s, gene_lst, sex_gene_lst, browse = F) {
  if(browse) browser()

  df_s <- df_s[df_s$Sample_type != "Water",]
  if(nrow(df_s) == 0)
    return(list(id="gene", section="Gene Cps",
               genes=gene_lst, sex_genes=sex_gene_lst,
               df_plate=NULL, df_plate_na=NULL,
               df_sex=NULL, df_batch=NULL))
    
  gene_lst <- gene_lst[!gene_lst %in% sex_gene_lst]
  # so gene_lst and sex_gene_lst are disjoint
  
  df_s$Sex <- df_s$Gender
  df_s$Sex[is.na(df_s$Sex)] <- ""
  fields_ <- c("Batch","Plate","Accession","Cp.run.id",
               "Sample_type", "Sex", gene_lst, sex_gene_lst)
  # sample_type is 'Clinical', 'PAX', 'IRP', 'ICP' or 'Water'
  df_ <- df_s[fields_]
  st_ <- table(df_$Sample_type[df_$Sample_type %in% c('PAX', 'IRP', 'ICP')])
  b_ <- df_$Sample_type %in% c('PAX', 'IRP', 'ICP', 'Pooled')
  if(length(st_)>1) # combine pooled if more than one type
    df_$Sample_type[b_] <- "Pooled"
  df_$Sex[b_] <- df_$Sample_type[b_] # need this for the sex gene plot
  
#  if(nrow(df_)==0)
#    return(list(id="gene", section="Gene"))

  # plate level
  df_plate   <- aggregate(df_[gene_lst], df_[c("Batch","Plate","Sample_type")],
                    median, na.rm=T)

  # missing alg genes at plate level
  genes_23 <- gene_lst[gene_lst != "GTFCP2"]
  df_plate_na <- aggregate(df_[genes_23], df_[c("Batch","Plate")],
                    function(x) {sum(is.na(x))})
  df_plate_na <- df_plate_na[order(df_plate_na$Batch, df_plate_na$Plate),]

  df_sex      <- aggregate(df_[sex_gene_lst], df_[c("Batch","Plate","Sample_type", "Sex")],
                    median, na.rm=T)

  # batch level
  df_batch   <- aggregate(df_[gene_lst], df_[c("Batch","Sample_type")],
                    median, na.rm=T)
  
  ret_ <- list(id="gene", section="Gene Cps",
               genes=gene_lst, sex_genes=sex_gene_lst,
               df_plate=df_plate, df_plate_na=df_plate_na,
               df_sex=df_sex, df_batch=df_batch)
  return(ret_)
}

plot_cas_d2_gene <- function(ret_, d_out, col_c1=c("grey","tan"),
                             png_width=600, png_height=NULL, browse = F) {
  if(browse) browser()

  png_height_ <- ifelse(is.null(png_height), png_width, png_height)
  plots_ <- list()
  p_idx  <- 1
  f_     <- ""
  if(is.null(ret_$df_plate_na))
    return(plots_)
#  opar <- par() #par(mar=c(5,4,4,2)+.1, mfrow=c(1,1), las=1)

  #######################
  desc_ <- "Missing gene Cp counts plate by gene"
  fn_   <- "gene_nas.png"
  cat("\t", fn_,"\n")
  f_  <- paste(d_out, fn_, sep="/")
  if(d_out=="")
    f_ <- ""
  plots_[[p_idx]] <- list(fname=fn_, fpath=f_, description=desc_); p_idx <- p_idx + 1

  genes_23 <- ret_$genes[ret_$genes != "GTFCP2"]
  df_  <- ret_$df_plate_na
  mat_ <- as.matrix(df_[genes_23])
  rownames(mat_) <- df_$Plate
  colnames(mat_) <- genes_23
  plot_tbl(mat_,c1=NULL, c2=NULL, row_blocks=df_$Batch,
           main  =desc_, xlab  ="", ylab="",
           breaks=c(-1,0,1000),
           labels=c("Pass","Warn"),    # ,"Fail" # this is not a requirement
           colors=c("blue", "orange"), # ,"red"  # it is required in the machine PQs
           f_out =f_, browse=F)

  #######################
  desc_ <- "Gene median Cp values by batch"
  fn_   <- "gene_cps_batch.png"
  cat("\t", fn_,"\n")
  if(d_out!="") {
    f_  <- paste(d_out, fn_, sep="/")
    png(filename=f_, width=png_width, height=png_height_)
  }
  plots_[[p_idx]] <- list(fname=fn_, fpath=f_, description=desc_); p_idx <- p_idx + 1

  opar <- par(mar=c(6,4,4,2)+.1, mfrow=c(1,1), las=1)
  df_   <- ret_$df_batch
  b_f   <- factor(df_$Batch)
  s_f   <- factor(df_$Sample_type)
  col   <- as.numeric(b_f)
  pch   <- substr(levels(s_f),1,1)[as.numeric(s_f)]
  ngenes <- length(ret_$genes)
  mat_   <- t(as.matrix(df_[ret_$genes]))
  ylim   <- range(c(20,40, mat_), na.rm=T)
  matplot(mat_, ylim=ylim, xaxt="n", pch=pch, col=col,
          main=desc_, ylab="Cp value")
  abline(h=0,lty=2,col=8)
  abline(v=1:ngenes,lty=2,col=8)
  matlines(mat_, pch=pch, col=col)
  axis(1, at=1:ngenes,labels=rownames(mat_), las=2)
  legend("topleft", levels(b_f), text.col=1:nlevels(b_f), bty="n")
  legend("bottomright", levels(s_f), #col=1:nlevels(b_f),
         pch=substr(levels(s_f),1,1), bty="n")

  par(opar) #par(mar=c(5,4,4,2)+.1, mfrow=c(1,1), las=1)
  if(d_out != "") {
    dev.off()
  }

  #######################
  desc_ <- "Sex gene median Cp values by batch and plate"
  fn_   <- "gene_cps_sex.png"
  cat("\t", fn_,"\n")
  f_  <- paste(d_out, fn_, sep="/")
  if(d_out=="")
    f_ <- ""
  plots_[[p_idx]] <- list(fname=fn_, fpath=f_, description=desc_); p_idx <- p_idx + 1

  df_s   <- ret_$df_sex
  field_ <- "RPS4Y1"
  v_ <- df_s[[field_]]
  bound_ <- NA # df_s$Bound[1]
  lev_ <- unique(df_s$Sex[!df_s$Sex %in% c("Female","Male")])
  levels_ <- c("Female","Male")
  if(length(lev_)>0)
    levels_ <- c("Female","Male", lev_)
  s_f <- factor(df_s$Sex, levels=levels_)
  pch <- substr(s_f, 1,1)
  col <- c(2,4,1)[as.numeric(s_f)] # should indicate errors
  batch_idx <- c1_index(df_s[c("Batch","Plate")])
  col_c1_ <- col_c1[1+batch_idx%%length(col_c1)]
  xlim <- range(c(v_, bound_, 20, 40), na.rm=T) #  
  plot_v_by_cat(df_s, field_, "Plate", c2="Batch", xlim=xlim, xlab="RPS4Y1 Cp value",
                f_out =f_, png_width=png_width, png_height=png_height,
                col   =col, pch=pch, cex=1, col_c1=col_c1_,
                main  =desc_,
#                vlines=list(bound_,2,c("red")),
                browse=F)
  
  invisible(plots_)
}

cas_d2_water <- function(df_s, gene_lst, params, browse = F) {
  if(browse) browser()
  
  fields_ <- c("Batch","Plate","Accession","Cp.run.id","Sample_well_total",
               "Is_water", "Water_cp_min","Water_cp_low_cnt","Water_fail",
               gene_lst)

  df_ <- df_s[df_s$Is_water==1, fields_]
  if(nrow(df_)==0)
    return(list(id="water", section="Water", df_water=NULL))
  df_$Bound <- params$water_cp_min

  ord <- order(df_$Batch, df_$Plate, df_$Cp.run.id)
  df_ <- df_[ord,]
  df_water <- df_

  df_ <- df_water[c("Batch","Plate", "Is_water", "Water_fail")]
  df_$Fail <- df_$Water_fail
  df_$Pass <- df_$Is_water - df_$Water_fail
  # aggregate by plate
  df_p <- aggregate(df_[-(1:2)], df_[c("Batch","Plate")], sum)

  # aggregate by batch
  df_b <- aggregate(df_[-(1:2)], df_[c("Batch")], sum)

  ret_ <- list(id="water", section="Water", df_water=df_water,
               df_p=df_p, df_b=df_b, gene_lst=gene_lst)
  return(ret_)
}

plot_cas_d2_water <- function(ret_, d_out, col_c1=c("grey","tan"),
                                png_width=600, png_height=NULL, browse = F) {
  if(browse) browser()

  png_height_ <- ifelse(is.null(png_height), png_width, png_height)
  plots_ <- list()
  p_idx  <- 1
  f_     <- ""
  opar <- par() #par(mar=c(5,4,4,2)+.1, mfrow=c(1,1), las=1)

  if(is.null(ret_$df_water))
    return(plots_)

  #####################
  desc_ <- "Water failures by batch"
  fn_   <- "water_fail_batch.png"
  cat("\t", fn_,"\n")
  if(d_out!="") {
    f_  <- paste(d_out, fn_, sep="/")
    png(filename=f_, width=png_width, height=png_height_)
  }
  plots_[[p_idx]] <- list(fname=fn_, fpath=f_, description=desc_); p_idx <- p_idx + 1

  df_ <- ret_$df_b
  mat_ <- as.matrix(df_[c("Pass", "Fail")])
  rownames(mat_) <- df_$Batch
  ylim <- range(0, 2, mat_+1, na.rm=T)
  col  <- c("blue","red")
  xlim <- c(1,(ncol(mat_)+1)*max(nrow(mat_),2))
  barplot(t(mat_), col=col, beside=T, ylim=ylim, xlim=xlim,
          main=desc_, ylab="Water samples",
          legend.text=T, args.legend=list(bty="n"))
  if(d_out != "") {
    dev.off()
  }

  #####################
  desc_ <- "Water failures by plate"
  fn_   <- "water_fail_plate.png"
  cat("\t", fn_,"\n")
  if(d_out!="") {
    f_  <- paste(d_out, fn_, sep="/")
    png(filename=f_, width=png_width, height=png_height_)
  }
  plots_[[p_idx]] <- list(fname=fn_, fpath=f_, description=desc_); p_idx <- p_idx + 1

#  df_ <- ret_$df_p
#  mat_ <- as.matrix(df_[c("Pass", "Fail")])
#  rownames(mat_) <- df_$Plate
#  ylim <- range(0, 2, mat_+1, na.rm=T)
#  col  <- c("blue","red")
#  barplot(t(mat_), col=col, beside=T, ylim=ylim, 
#          main=desc_, ylab="Water samples",
#          legend.text=T, args.legend=list(bty="n"))
#  if(d_out != "") {
#    dev.off()
#  }
  df_ <- ret_$df_p
  field_ <- "Fail"    #
  v_ <- df_[[field_]]
  bound_ <- 0.5 #df_$Bound[1]
  col <- ifelse(v_ > bound_,"red","blue")
  pch <- 1
  batch_idx <- c1_index(df_[c("Batch","Plate")])
  col_c1_ <- col_c1[1+batch_idx%%length(col_c1)]
  xlim <- range(c(v_, bound_, 3), na.rm=T)
  plot_v_by_cat(df_, field_, "Plate", c2="Batch", xlim=xlim, xlab="Count of water failures",
                f_out =f_, png_width=png_width, png_height=png_height,
                col   =col, pch=pch, cex=1, col_c1=col_c1_,
                main  =desc_, xaxis_counts=T,
                vlines=list(bound_,2,c("red")),
                browse=F)


  #####################
  desc_ <- "Water Cp min by sample"  #
  fn_   <- "water_cp_min.png"       #
  cat("\t", fn_,"\n")
  f_  <- paste(d_out, fn_, sep="/")
  if(d_out=="")
    f_ <- ""
  plots_[[p_idx]] <- list(fname=fn_, fpath=f_, description=desc_); p_idx <- p_idx + 1

  df_s <- ret_$df_water
  field_ <- "Water_cp_min"    #
  v_ <- df_s[[field_]]
  bound_ <- df_s$Bound[1]
  col <- ifelse(v_ < bound_,"red","blue") # low is bad
  pch <- 1
  batch_idx <- c1_index(df_s[c("Batch","Plate")])
  col_c1_ <- col_c1[1+batch_idx%%length(col_c1)]
  xlim <- range(c(df_s$Water_cp_min-1, bound_, 40), na.rm=T)
  plot_v_by_cat(df_s, field_, "Plate", c2="Batch", xlim=xlim, xlab="Water Cp minimum",
                f_out =f_, png_width=png_width, png_height=png_height,
                col   =col, pch=pch, cex=1, col_c1=col_c1_,
                main  =desc_,
                vlines=list(bound_,2,c("red")),
                browse=F)

  #####################
  desc_ <- "Water Cp low counts by sample"
  fn_   <- "water_cp_low.png"     
  cat("\t", fn_,"\n")
  f_  <- paste(d_out, fn_, sep="/")
  if(d_out=="")
    f_ <- ""
  plots_[[p_idx]] <- list(fname=fn_, fpath=f_, description=desc_); p_idx <- p_idx + 1

  df_s <- ret_$df_water
  field_ <- "Water_cp_low_cnt"
  v_ <- df_s[[field_]]
  bound_ <- 0
  total_ <- df_s$Sample_well_total[1]
  col <- ifelse(v_ > bound_,"red","blue")
  pch <- 1
  batch_idx <- c1_index(df_s[c("Batch","Plate")])
  col_c1_ <- col_c1[1+batch_idx%%length(col_c1)]
  xlim <- range(c(0,2, df_s$Water_cp_low_cnt), na.rm=T)
  plot_v_by_cat(df_s, field_, "Plate", c2="Batch", xlim=xlim, xaxis_counts=T,
                f_out =f_, png_width=png_width, png_height=png_height, xlab="Low water Cp count",
                col   =col, pch=pch, cex=1, col_c1=col_c1_,
                main  =desc_,
                vlines=list(c(bound_+.5, total_),2,c("red", "grey")),
                browse=F)
  
  # water Cp values by sample
  desc_ <- "Water minimum Cp values by gene"
  fn_   <- "water_cps.png"
  cat("\t", fn_,"\n")
  if(d_out!="") {
    f_  <- paste(d_out, fn_, sep="/")
    png(filename=f_, width=png_width, height=png_height_)
  }
  plots_[[p_idx]] <- list(fname=fn_, fpath=f_, description=desc_); p_idx <- p_idx + 1

  opar <- par(mar=c(6,4,4,2)+.1, mfrow=c(1,1), las=1)
  df_s   <- ret_$df_water
  genes_ <- ret_$gene_lst
  ngenes <- length(genes_)
  bound_ <- df_s$Bound[1]
  mat_   <- t(as.matrix(df_s[genes_]))
  ylim <- range(c(30,40, mat_), na.rm=T)
  matplot(mat_, ylim=ylim, xaxt="n",
          main=desc_, ylab="Cp value")
  abline(h=0,lty=2,col=8)
  abline(v=1:ngenes,lty=2,col=8)
  matlines(mat_)
  axis(1, at=1:ngenes,labels=rownames(mat_), las=2)
  abline(h=bound_, lty=2, col=2)
#  legend("topleft", colnames(mat_), col=1:ncol(mat_),
#         pch=as.character(1:ncol(mat_)), bty="n")
  par(opar) # par(mar=c(5,4,4,2)+.1, mfrow=c(1,1), las=1)
  if(d_out != "") {
    dev.off()
  }
  
  if(d_out == "")
    par(opar) #par(mar=c(5,4,4,2)+.1, mfrow=c(1,1), las=1)

  invisible(plots_)
}

cas_d2_paxctrl <- function(df_s, # df_delta2=NULL,
                           df_batch_delta=NULL,
                           gene_lst, params, score_ranges, browse = F) {
  if(browse) browser()

#  if(is.null(df_delta2))
#    return(list(id="paxctrl", section="PAX controls", df_sample=NULL))
#  if(is.null(df_batch_delta))
#    stop("df_batch_delta is NULL, this shouldn't happen\n")

  # individual scores
  df_s_orig <- df_s
#  b_  <- substr(df_s$Accession, 1, length(pax_prefix)) == pax_prefix
  b_   <- df_s$Is_pax_ctrl > 0
  df_s <- df_s[b_, c("Batch","Plate", "Score", "Is_pax_ctrl", "Pax_fail",
                     "Pax_batch_med","Pax_batch_mdev",
                     "Pax_batch_sd","Pax_batch_fail")]

  if(nrow(df_s)==0) # no PAX ctrls, (eg, single assay plates, or machine PQ)
    return(list(id="paxctrl", section="PAX controls", df_sample=NULL))
  
  df_s$pax_batch_max_dev <- params$pax_batch_max_dev
  df_s$pax_batch_max_sd  <- params$pax_batch_max_sd

  df_s$pax_score_range_lo <- NA
  df_s$pax_score_range_hi <- NA
  if(!is.null(score_ranges) && !is.null(score_ranges$PAX)) {
    df_s$pax_score_range_lo <- score_ranges$PAX[1]
    df_s$pax_score_range_hi <- score_ranges$PAX[2]
  }

  # batch level pass, median, max dev, SD
  # aggregate over samples to batch level
  df_b1 <- aggregate(df_s[c("Is_pax_ctrl", "Pax_fail")], df_s[c("Batch")], sum)
  df_b1$pax_batch_fail_max <- 4*params$pax_batch_fail_pct+.5

  # already aggregated at the batch level
  b_    <- duplicated(df_s[c("Batch")]) 
  df_b2 <- df_s[!b_, c("Batch", "Pax_batch_med","Pax_batch_mdev",
                       "Pax_batch_sd","Pax_batch_fail",
                       "pax_batch_max_dev","pax_batch_max_sd",
                       "pax_score_range_lo","pax_score_range_hi")]

  df_b <- merge(df_b1, df_b2, by="Batch")
#  df_b$pax_batch_max_dev <- params$pax_batch_max_dev
#  df_b$pax_batch_max_sd  <- params$pax_batch_max_sd

  # batch profile deltas
  mat_pd <- NULL
  if(!is.null(df_batch_delta)) {
    df_cpd    <- df_batch_delta # assumed sorted by Batch, Gene
    df_cpd$Gene <- as.factor(df_cpd$Gene)
    genes_    <- levels(df_cpd$Gene)
    b_ <- !genes_ %in% gene_lst
    if(any(b_)) {
      cat("Some genes in df_batch_delta not in gene_lst (this shouldn't happen)\n")
      print(paste(genes_[b_], collapse=", "), "\n")
      stop("\n")
    }
    ngenes_   <- length(genes_)
    nbatch_   <- length(df_cpd$Batch)/ngenes_
    batch_idx <- ngenes_*((1:nbatch_)-1) + 1 # first entry for each batch
    mat_pd    <- matrix(df_cpd$Cp_delta, nrow=ngenes_)
    rownames(mat_pd) <- genes_
    colnames(mat_pd) <- df_cpd$Batch[batch_idx] # each batch profile in one column
    # order genes by gene_lst (the Cp level of the PAX std)
    gene_lst_ <- gene_lst[gene_lst %in% genes_]
    ord       <- order_a2b(genes_, gene_lst_)
    mat_pd    <- mat_pd[ord,,drop=F]
  }
  
  ret_ <- list(df_sample=df_s, df_batch_cnt=df_b, mat_profile_delta=mat_pd,
               id="paxctrl", section="PAX controls")
  return(ret_)
}

plot_cas_d2_paxctrl <- function(ret_, d_out, 
                                  col_c1=c("grey","tan"),
                                  png_width=600, png_height=NULL,browse = F) {
  if(browse) browser()

  plots_ <- list()
  p_idx  <- 1
  f_     <- ""
  png_height_ <- ifelse(is.null(png_height), png_width, png_height)

  if(is.null(ret_$df_sample))
    return(plots_)

  pax_score_region <- c(-1.6,-.3)
  #####################
  # PAX ctrl fail count
  desc_ <- "PAX controls by batch"
  fn_   <- "pax_batch.png"
  cat("\t", fn_,"\n")
  if(d_out!="") {
    f_  <- paste(d_out, fn_, sep="/")
    png(filename=f_, width=png_width, height=png_height_)
  }
  plots_[[p_idx]] <- list(fname=fn_, fpath=f_, description=desc_); p_idx <- p_idx + 1

  df_ <- ret_$df_batch_cnt
#  df_ <- df_[c("Batch","Is_pax_ctrl", "Pax_fail","pax_batch_fail_max")]
  df_$Pass <- df_$Is_pax_ctrl - df_$Pax_fail
  df_$Fail <- df_$Pax_fail
  fields <- c("Pass", "Fail")
  mat_ <- as.matrix(df_[fields])
  rownames(mat_) <- df_$Batch
  max_ <- max(mat_,na.rm=T)
  ylim <- c(0, max(mat_+1, 1.20*max_, df_$pax_batch_fail_max[1]+.5))
  col  <- c("blue","red")
  xlim <- c(1,(ncol(mat_)+1)*max(nrow(mat_),2))
  barplot(t(mat_), col=col, beside=T, ylim=ylim, xlim=xlim,
          main=desc_, ylab="PAX controls",
          legend.text=ifelse(length(fields)>1,T,F), args.legend=list(bty="n"))
  abline(h=df_$pax_batch_fail_max[1],lty=2,col=2)
  if(d_out != "") {
    dev.off()
  }

  #############
  # PAX scores by batch
  desc_ <- "PAX scores by sample"
  fn_   <- "pax_score.png"
  cat("\t", fn_,"\n")
  f_   <- paste(d_out, fn_, sep="/")
  if( d_out=="")
    f_ <- ""
  plots_[[p_idx]] <- list(fname=fn_, fpath=f_, description=desc_); p_idx <- p_idx + 1

  df_s <- ret_$df_sample
  adev <- abs(df_s$Score - df_s$Pax_batch_med)
#  col  <- ifelse(adev > df_s$pax_batch_max_dev,"red",
#                ifelse(adev > 3*df_s$pax_batch_max_sd, "goldenrod", "blue"))
  col  <- ifelse(df_s$Pax_fail==1, 2,4)
  pch  <- 1
  batch_idx <- c1_index(df_s[c("Batch","Plate")])
  col_c1_ <- c("grey70","grey90")
  col_c1_ <- col_c1_[1+batch_idx%%length(col_c1_)]
  xlim  <- range(c(pax_score_region, df_s$Score), na.rm=T)
  plot_v_by_cat(df_s, "Score", "Plate", c2="Batch", xlim=xlim,
                f_out =f_, png_width=png_width, png_height=png_height,
                col   =col, pch=pch, cex=1, col_c1=col_c1_,
                main  =desc_, jit_size=0,
                col_medians = NULL, #"green",
#                vlines=list(df_s$Pax_batch_med+c(-df_s$pax_batch_max_dev,0,df_s$pax_batch_max_dev),2,c(2,8,2)),
                c2_vlines=list(df_s$pax_batch_max_dev[1]*c(-1,0,1),2,c(2,3,2)),
                browse=F)

  #############
  # PAX score range by batch
  desc_ <- "PAX score range by sample"
  fn_   <- "pax_score_range.png"
  cat("\t", fn_,"\n")
  f_   <- paste(d_out, fn_, sep="/")
  if( d_out=="")
    f_ <- ""
  plots_[[p_idx]] <- list(fname=fn_, fpath=f_, description=desc_); p_idx <- p_idx + 1

  df_s <- ret_$df_sample
  adev <- abs(df_s$Score - df_s$Pax_batch_med)
#  col  <- ifelse(adev > df_s$pax_batch_max_dev,"red",
#                ifelse(adev > 3*df_s$pax_batch_max_sd, "goldenrod", "blue"))
  col  <- ifelse(df_s$Pax_fail==1, 2,4)
  pch  <- 1
  batch_idx <- c1_index(df_s[c("Batch","Plate")])
  col_c1_ <- c("grey70","grey90")
  col_c1_ <- col_c1_[1+batch_idx%%length(col_c1_)]
  xlim  <- range(c(pax_score_region, df_s$Score), na.rm=T)
  pr_m_ <- (df_s$pax_score_range_lo[1] + df_s$pax_score_range_hi[1])/2
  plot_v_by_cat(df_s, "Score", "Plate", c2="Batch", xlim=xlim,
                f_out =f_, png_width=png_width, png_height=png_height,
                col   =col, pch=pch, cex=1, col_c1=col_c1_,
                main  =desc_, jit_size=0,
                col_medians = NULL, #"green",
                vlines=list(c(df_s$pax_score_range_lo[1],pr_m_,df_s$pax_score_range_hi[1]),2,c(2,8,2)),
                c2_vlines=list(0,2,3),
#                c2_vlines=list(df_s$pax_batch_max_dev[1]*c(-1,0,1),2,c(2,3,2)),
                browse=F)

  #############
  # PAX median by batch
  desc_ <- "PAX median score by batch"
  fn_   <- "pax_median.png"
  cat("\t", fn_,"\n")
  f_   <- paste(d_out, fn_, sep="/")
  if(d_out=="")
    f_ <- ""
  plots_[[p_idx]] <- list(fname=fn_, fpath=f_, description=desc_); p_idx <- p_idx + 1

  df_s <- ret_$df_batch_cnt
  col  <- ifelse(df_s$Pax_fail > df_s$pax_batch_fail_max, "red", "blue")
  pch  <- 1
  batch_idx <- c1_index(df_s[c("Batch")])
  col_c1_ <- c("grey70","grey90")
  col_c1_ <- col_c1_[1+batch_idx%%length(col_c1_)]
  xlim <- range(c(pax_score_region, df_s$Pax_batch_med), na.rm=T)
  plot_v_by_cat(df_s, "Pax_batch_med", "Batch", xlim=xlim, xlab="Median score",
                f_out =f_, png_width=png_width, png_height=png_height,
                col   =col, pch=pch, cex=1, col_c1=col_c1_,
                main  =desc_,
                vlines=list(median(df_s$Pax_batch_med,na.rm=T),2,3), jit_size=0,
                browse=F)

  #############
  # PAX SD by batch
  desc_ <- "PAX score SD by batch"
  fn_   <- "pax_sd.png"
  cat("\t", fn_,"\n")
  f_  <- paste(d_out, fn_, sep="/")
  if(d_out=="")
    f_ <- ""
  plots_[[p_idx]] <- list(fname=fn_, fpath=f_, description=desc_); p_idx <- p_idx + 1

  df_s <- ret_$df_batch_cnt
  col  <- ifelse(df_s$Pax_batch_sd > df_s$pax_batch_max_sd, "red", "blue")
  pch  <- 1
  bounds_ <- c(0, df_s$pax_batch_max_sd[1])
  batch_idx <- c1_index(df_s[c("Batch")])
  col_c1_ <- c("grey70","grey90")
  col_c1_ <- col_c1_[1+batch_idx%%length(col_c1_)]
  xlim <- range(c(0, df_s$Pax_batch_sd, df_s$pax_batch_max_sd[1]*1.3), na.rm=T)
  plot_v_by_cat(df_s, "Pax_batch_sd", "Batch", xlim=xlim, xlab="Score SD",
                f_out =f_, png_width=png_width, png_height=png_height,
                col   =col, pch=pch, cex=1, col_c1=col_c1_,
                main  =desc_, jit_size=0,
                vlines=list(bounds_,2,c(8,2)),
                browse=F)

  #############
  # PAX max dev by batch
  desc_ <- "PAX score max deviation by batch"
  fn_   <- "pax_mdev.png"
  cat("\t", fn_,"\n")
  f_  <- paste(d_out, fn_, sep="/")
  if(d_out=="")
    f_ <- ""
  plots_[[p_idx]] <- list(fname=fn_, fpath=f_, description=desc_); p_idx <- p_idx + 1

  df_s   <- ret_$df_batch_cnt
  col <- ifelse(df_s$Pax_batch_mdev > df_s$pax_batch_max_dev,"red", "blue")
  pch <- 1
  bounds_ <- c(0, df_s$pax_batch_max_dev[1])
  batch_idx <- c1_index(df_s[c("Batch")])
  col_c1_ <- c("grey70","grey90")
  col_c1_ <- col_c1_[1+batch_idx%%length(col_c1_)]
  xlim <- range(c(0, df_s$Pax_batch_mdev, df_s$pax_batch_max_dev[1]*1.3), na.rm=T)
  plot_v_by_cat(df_s, "Pax_batch_mdev", "Batch", xlim=xlim, xlab="Score max deviation",
                f_out =f_, png_width=png_width, png_height=png_height,
                col   =col, pch=pch, cex=1, col_c1=col_c1_,
                main  =desc_, jit_size=0,
                vlines=list(bounds_,2,c(8,2)),
                browse=F)


  #############
  # gene deltas by batch
  if(!is.null(ret_$mat_profile_delta)) {
    desc_ <- "PAX profile gene Cp deltas by batch"
    fn_   <- "pax_delta.png"
    cat("\t", fn_,"\n")
    if(d_out!="") {
      f_  <- paste(d_out, fn_, sep="/")
      png(filename=f_, width=png_width, height=png_height_)
    }
    plots_[[p_idx]] <- list(fname=fn_, fpath=f_, description=desc_); p_idx <- p_idx + 1

    opar <- par(mar=c(7,4,4,2)+.1, mfrow=c(1,1), las=1)
    mat_ <- ret_$mat_profile_delta
    ylim <- range(c(-1,1, mat_, -mat_), na.rm=T)
    matplot(mat_, ylim=ylim, xaxt="n",
            main=desc_, ylab="PAX profile Cp delta correction")
    abline(h=0,lty=2,col=8)
    abline(v=1:23,lty=2,col=8)
    matlines(mat_)
    axis(1, at=1:23,labels=rownames(mat_), las=2)
    legend("topleft", colnames(mat_), col=1:ncol(mat_),
           pch=as.character(1:ncol(mat_)), bty="n")
    par(opar) # par(mar=c(5,4,4,2)+.1, mfrow=c(1,1), las=1)
    if(d_out != "") {
      dev.off()
    }
  }

  invisible(plots_)
}

cas_d2_negctrl <- function(df_cp, acc_nc, params, browse = F) {
  if(browse) browser()

#  fields_ <- c("Batch","Plate","Negctrl_total","Negctrl_cp_min","Negctrl_fail")
  b_ <- df_cp$Accession %in% grep_strings(acc_nc, df_cp$Accession, fixed=T, browse=F)
  df_cp <- df_cp[b_,]

  df_cp$Cp[is.na(df_cp$Cp)] <- 40

  ord   <- order(df_cp$Batch, df_cp$Plate, df_cp$Cp)
  df_cp <- df_cp[ord,]
  df_cp$Bound <- params$plate_nc_RPL28_min
  df_cp$Fail  <- df_cp$Cp < params$plate_nc_RPL28_min
  
  ret_ <- list(df_cp=df_cp, id="negctrl", section="Negative controls")
  return(ret_)
}

c1_index <- function(df_, browse=F) {
  if(browse) browser()

  df_ <- unique(df_)
  df_ <- df_[order(df_[[1]]),,drop=F]
  idx <- as.numeric(factor(df_[[1]]))
  return(idx)
}

plot_cas_d2_negctrl <- function(ret_, d_out="", col_c1=c("grey70","grey90"),
                                png_width=600, png_height=NULL, browse=F) {
  if(browse) browser()

  plots_ <- list()
  p_idx  <- 1
  
  #####################
  # batch level
  desc_ <- "Negative control RPL28 Cps by batch"
  fn_   <- "neg_ctrl_batch.png"
  cat("\t", fn_,"\n")
  f_  <- paste(d_out, fn_, sep="/")
  if(d_out=="")
    f_ <- ""
  plots_[[p_idx]] <- list(fname=fn_, fpath=f_, description=desc_); p_idx <- p_idx + 1
  df_ <- ret_$df_cp

  col <- ifelse(df_$Fail,2,ifelse(df_$Cp >=40, 1,4))
  pch <- 1
  batch_idx <- c1_index(df_[c("Batch")])
#  col_c1 <- 8 #col_c1[1+batch_idx%%length(col_c1)]
  plot_v_by_cat(df_, "Cp", "Batch", f_out=f_, png_width=png_width, png_height=png_height,
                col=col, pch=pch, cex=1, col_c1=8, xlim_min_range=c(35, 40),
                main=desc_, xlab="RPL28 Cp",
                vlines=c(df_$Bound[1],2,2),
                browse=F)

  #####################
  # plate level
  desc_ <- "Negative control RPL28 Cps by plate"
  fn_   <- "neg_ctrl_plate.png"
  cat("\t", fn_,"\n")
  f_  <- paste(d_out, fn_, sep="/")
  if(d_out=="")
    f_  <- ""
  plots_[[p_idx]] <- list(fname=fn_, fpath=f_, description=desc_); p_idx <- p_idx + 1
  df_ <- ret_$df_cp

  col <- ifelse(df_$Fail,2,ifelse(df_$Cp >=40, 1,4))
  pch <- 1
  batch_idx <- c1_index(df_[c("Batch","Plate")])
  col_c1_ <- col_c1[1+batch_idx%%length(col_c1)]
  plot_v_by_cat(df_, "Cp", "Plate", c2="Batch", xlim_min_range=c(35, 40),
                f_out=f_, png_width=png_width, png_height=png_height,
                col=col, pch=pch, cex=1, col_c1=col_c1_,
                main=desc_, xlab="RPL28 Cp",
                vlines=c(df_$Bound[1],2,2),
                browse=F)
  
  invisible(plots_)
}

cas_d2_batch <- function(df_s, params, browse = F) {
  if(browse) browser()

  df_s$Gene_na_fail  <- df_s$Sample_gene_fail
  df_s$Sample_fail  <- 1 - df_s$Sample_pass
  df_s$Plate_fail   <- 1 - df_s$Plate_pass # switch to failure count
  df_s$sample_plate_fail <- ifelse(df_s$Is_water==1, 0,
                                   1 - (df_s$Sample_pass & df_s$Plate_pass))
  # sample level stuff
  df_bp1 <- df_s[c("Batch", "Plate", "Accession",
                   "Gender","Gender",
                   "Sample_type", "Sample_type", # extra for counts
                   "Is_pax_ctrl", "Pax_fail",
                   "Is_water","Water_fail",
                   "Sample_fail","sample_plate_fail","Gene_na_fail", "Gdna_fail")]

  names(df_bp1)[3:7] <- c("Sample","Male","Female","Clinical","Pooled")
  df_bp1$Sample   <- 1 # sample count
  df_bp1$Male     <- ifelse(!is.na(df_bp1$Male) &
                            df_bp1$Male    =="Male",    1,0)
  df_bp1$Female   <- ifelse(!is.na(df_bp1$Female) &
                            df_bp1$Female  =="Female",  1,0)
  df_bp1$Clinical <- ifelse(df_bp1$Clinical=="Clinical",1,0)
  df_bp1$Water    <- df_bp1$Is_water
  df_bp1$Pooled   <- 1 - df_bp1$Clinical - df_bp1$Water

  # aggregate to plate level
  df_bp1_a <- aggregate(df_bp1[-(1:2)], df_bp1[1:2], sum, na.rm=T)

  # already aggregated at the plate level
  b_ <- duplicated(df_s[c("Batch","Plate")]) 
  df_bp2 <- df_s[!b_, c("Batch", "Plate", "Plate", # extra for plate count
                        "Negctrl_total", "Negctrl_fail",
                        "Plate_well_na_cnt",
                        "Plate_sample_fail_cnt", # exclude gender/trunc failures
                        "Plate_sample_warn_cnt", # exclude gender warnings
                        "Plate_fail")]
  names(df_bp2)[3] <- "pnum"
  df_bp2$pnum <- 1 # plate count
  names(df_bp2)[6:8] <- c("Well_na", "Sample_fail_ngt",
                          "Sample_warn_ng")
  
  df_bp_m <- merge(df_bp1_a, df_bp2, by=c("Batch","Plate"))
  
  # aggregate over plates to batch level
  df_batch_cnt <- aggregate(df_bp_m[-(1:2)], df_bp_m["Batch"], sum)
  names(df_batch_cnt)[names(df_batch_cnt)=="pnum"] <- "Plate"

  # should fail if more than 50% of 4 PAX ctrls fail
  df_batch_cnt$pax_batch_fail_max <- 4*params$pax_batch_fail_pct+.5

  df_batch_cnt <- df_batch_cnt[order(df_batch_cnt$Batch),]

  field_pairs <-matrix(
    c("Batch",            "Batch",           
      "Plate",            "Plates",           
      "Plate_fail",       "Plate failures",      
      "Sample",           "Samples",          
      "Sample_fail",      "Sample failures",     
      "sample_plate_fail","sample-plate failures",
      "Male",             "Males",         
      "Female",           "Females",       
      "Clinical",         "Clinical",     
      "Pooled",           "Pooled",       
      "Is_pax_ctrl",      "PAX ctrls",  
      "Pax_fail",         "Pax failures",     
      "Water",            "Waters",        
      "Water_fail",       "Water failures",   
      "Negctrl_total",    "Neg ctrls",
      "Negctrl_fail",     "Neg ctrl failures",
      "Gdna_fail",        "GDNA failures",
      "Well_na",          "Well NAs",
      "Gene_na_fail",     "Gene NA failures"), ncol=2, byrow=T)
      #"Sample_fail_ngt"   "Sample_warn_ng"           
  df_batch_table <- df_batch_cnt[field_pairs[,1]]
  names(df_batch_table) <- field_pairs[,2]
#  b_ <- sapply(df_batch_table, is.numeric)
#  df_batch_table[b_] <- lapply(df_batch_table[b_], function(x) signif(x, digits=3))
  tbl_ <- list(name="tbl_batch", description="Batch level counts", df_table=df_batch_table)
  
  ret_ <- list(df_batch_cnt=df_batch_cnt, id="batch", section="Batch",
               tables=list(tbl_))
  return(ret_)
}

cas_d2_plate <- function(df_s, params, browse = F) {
  if(browse) browser()

  df_s$Well_na_warn  <- df_s$Sample_well_warn
  df_s$Well_na_fail  <- df_s$Sample_well_fail
  df_s$Gene_na_fail  <- df_s$Sample_gene_fail
  df_s$Exp_mean_warn <- df_s$Expr_mean_warn
  df_s$Exp_mean_fail <- df_s$Expr_mean_fail
  df_s$Sd_warn       <- df_s$Med_sd_warn
  df_s$Sd_fail       <- df_s$Med_sd_fail
  df_s$Sd_90_warn    <- df_s$Sd_90_warn
  df_s$Sd_90_fail    <- df_s$Sd_90_fail
  df_s$Sd_100_fail   <- df_s$Sd_max_fail
  df_s$Exp_warn      <- df_s$Ep_warn
  df_s$Exp_fail      <- df_s$Ep_fail
  df_s$Sample_fail   <- !df_s$Sample_pass
  df_s$sample_plate_fail <- ifelse(df_s$Is_water==1, 0,
                                   1 - (df_s$Sample_pass & df_s$Plate_pass))

  # sample level
  df_p <- df_s[c("Batch","Plate", "Accession",
                 "Gender",        "Gender",
                 "Sample_type",   "Sample_type", # extra
                 "Is_pax_ctrl",   "Pax_fail",
                 "Is_water",      "Water_fail",  
                 "Well_na_warn",  "Well_na_fail",
                 "Gene_na_fail",
                 "Gdna_warn",     "Gdna_fail",
                 "Exp_mean_warn", "Exp_mean_fail",
                 "Sd_warn",       "Sd_fail",
                 "Sd_90_warn",    "Sd_90_fail",
                 "Sd_100_fail",
                 "Trunc_warn",    "Trunc_fail",
                 "Exp_warn",      "Exp_fail",
                 "Sex_fail",
                 "Warning_fail",
                 "Sample_fail",   "sample_plate_fail"
                 )]
  names(df_p)[3:7] <- c("Sample", "Male","Female","Clinical","Pooled")
  df_p$Sample   <- 1 # sample count
  df_p$Male     <- ifelse(!is.na(df_p$Male) &
                          df_p$Male    =="Male",    1,0)
  df_p$Female   <- ifelse(!is.na(df_p$Female) &
                          df_p$Female  =="Female",  1,0)
  df_p$Clinical <- ifelse(df_p$Clinical=="Clinical",1,0)
  df_p$Pooled   <- 1*(df_p$Clinical==0)*(df_p$Is_water==0)

  # aggregate over samples
  df_p1 <- aggregate(df_p[-(1:2)], df_p[c("Batch","Plate")], sum)

  b_ <- duplicated(df_s[c("Batch","Plate")]) 
  df_p2 <- df_s[!b_, c("Batch", "Plate",
                       "Negctrl_total", "Negctrl_fail",
                       "Plate_well_na_cnt",
                       "Plate_sample_fail_cnt", # exclude gender/trunc failures
                       "Plate_sample_warn_cnt", # exclude gender warnings
                       "Plate_flag")]
  names(df_p2)[5:7] <- c("Well_na", "Sample_fail_ngt","Sample_warn_ng")
  
  df_plate_cnt <- merge(df_p1, df_p2, by=c("Batch","Plate"))

  df_plate_cnt$plate_samp_fail_pct <- params$plate_samp_fail_pct
  df_plate_cnt$plate_samp_warn_pct <- params$plate_samp_warn_pct

  df_plate_cnt <- df_plate_cnt[order(df_plate_cnt$Batch, df_plate_cnt$Plate),]

  # table
  field_pairs <- matrix(
    c("Batch",             "Batch",             
      "Plate",             "Plate",             
      "Sample",            "Samples",            
      "Male",              "Males",              
      "Female",            "Females",            
      "Clinical",          "Clinical",          
      "Pooled",            "Pooled",            
      "Sample_fail",       "Sample failures",       
      "sample_plate_fail", "Sample plate failures", 
#      "Sample_fail_ngt",   "Sample failures ngt",   
#      "Sample_warn_ng",    "Sample warnings ng",    
      "Plate_flag",        "Plate status",         
      "Is_pax_ctrl",       "PAX ctrls",       
      "Pax_fail",          "PAX failures",          
      "Negctrl_total",     "Negctrl count",     
      "Negctrl_fail",      "Negctrl failures",      
      "Is_water",          "Waters",          
      "Water_fail",        "Water failures",
      "Sex_fail",          "Sex failures",          
      "Well_na",           "Well NAs",           
      "Well_na_warn",      "Well NA warnings",      
      "Well_na_fail",      "Well NA failures",      
      "Gdna_warn",         "Gdna warnings",         
      "Gdna_fail",         "Gdna failures",         
      "Gene_na_fail",      "Gene NA failures",      
      "Exp_mean_warn",     "Expression mean warnings",     
      "Exp_mean_fail",     "Expression mean failures",     
      "Sd_warn",           "Sd warnings",           
      "Sd_fail",           "Sd failures",           
      "Sd_90_warn",        "Sd 90 warnings",        
      "Sd_90_fail",        "Sd 90 failures",        
      "Sd_100_fail",       "Sd 100 failures",       
      "Trunc_warn",        "Truncation warnings",        
      "Trunc_fail",        "Truncation failures",        
      "Exp_warn",          "Expression warnings",          
      "Exp_fail",          "Expression failures",          
      "Warning_fail",      "Warning failures"), ncol=2, byrow=T)

  df_plate_table <- df_plate_cnt[field_pairs[,1]]
  names(df_plate_table) <- field_pairs[,2]
#  b_ <- sapply(df_plate_table, is.numeric)
#  df_plate_table[b_] <- lapply(df_plate_table[b_], function(x) signif(x, digits=3))
  tbl_ <- list(name="tbl_plate", description="Plate level counts", df_table=df_plate_table)

  ret_ <- list(df_plate_cnt=df_plate_cnt, id="plate", section="Plate",
               tables=list(tbl_))
  return(ret_)
}

cas_d2_sample <- function(df_s, params, browse = F) {
  if(browse) browser()

  params$well_missing_fail <- params$well_missing_pct*params$data_cnt_well_missing
  df_s <- cbind(df_s, params)
  df_s$Trans_score_delta <- df_s$Score - df_s$Score_nt
  # sample level
  df_sample <- df_s[c(
      "Batch","Plate",  "Accession","Cp.run.id",
      "Gender", "Age",  "Sample_type",
      "Score",
      "Well_na_cnt",    "Well_na_flag", "well_missing_fail","well_missing_warn",
      "Gene_na_cnt",    "Gene_na_flag","gene_missing_max",
      "Is_pax_ctrl",    #"Pax_fail",
      "Is_water", "Water_fail",  
      "Gdna_delta_cp",  "Gdna_flag", "gdna_min","gdna_warn",
      "Exp_mean",       "Exp_mean_flag","expr_mean_max","expr_mean_warn",
      "Sd",             "Sd_flag", "med_sd_max","med_sd_warn",
      "Sd_90",          "Sd_90_flag", "sd_90_max","sd_90_warn",
      "Sd_100",         "Sd_100_flag", "sd_max_max",
      "Exp_profile",    "Exp_flag",
      "ep_max","ep_warn","ep_pool_max","ep_pool_warn",
      "Trunc_cnt",      "Trunc_flag", "trunc_max","trunc_warn",
      "Trans_score_delta", "trans_score_delta_max",
      "RPS4Y1",         "Sex_flag",
      "rps4y1_female_min","rps4y1_male_max","rps4y1_pool_max",
#     "Negctrl_cp_min", "Negctrl_total", "Negctrl_flag","plate_nc_RPL28_min",
      "Warning_cnt",    "Warning_fail","warning_max",
#     "Plate_well_na_cnt",
      "Sample_flag",
#     "Plate_flag",
      "Overall_flag"
                     )]
  
  df_sample$sample_plate_fail <- ifelse(df_s$Is_water==1, 0,
                                        1-(df_s$Sample_pass & df_s$Plate_pass))
  df_sample <- df_sample[order(df_sample$Batch,df_sample$Plate,df_sample$Cp.run.id),]
  ret_ <- list(df_sample=df_sample, id="sample", section="Sample")
  return(ret_)
}

#
plot_cas_d2_batch <- function(ret_, d_out, png_width=600, png_height=png_width, browse = F) {
  if(browse) browser()
  
  df_    <- ret_$df_batch_cnt
  plots_ <- list()
  p_idx  <- 1
  f_     <- ""

  #####################
  # sample count
  desc_ <- "Sample failures by batch\nincluding plate failures"
  fn_   <- "batch_sample.png"
  cat("\t", fn_,"\n")
  if(d_out!="") {
    f_  <- paste(d_out, fn_, sep="/")
    png(filename=f_, width=png_width, height=png_height)
  }
  plots_[[p_idx]] <- list(fname=fn_, fpath=f_, description=desc_); p_idx <- p_idx + 1

  fields <- c("Batch","Sample", "sample_plate_fail","Is_water")
  df_f <- df_[fields]
  df_f$Fail <- df_f[[3]]
  df_f$Pass <- df_f[[2]] - df_f$Fail
  df_f$Water <- df_f$Is_water
  mat_ <- as.matrix(df_f[c("Pass", "Fail", "Water")])
  rownames(mat_) <- df_f$Batch
  max_ <- max(mat_,na.rm=T)
  ylim <- c(0, max(mat_+1, 1.20*max_, 3))
  col  <- c("green3","orange","grey20")
  xlim <- c(1,(ncol(mat_)+1)*max(nrow(mat_),2))
  barplot(t(mat_), col=col, beside=T, ylim=ylim, xlim=xlim,
          main=desc_, ylab="Samples",
          legend.text=ifelse(length(fields)>1,T,F), args.legend=list(bty="n"))
  if(d_out != "") {
    dev.off()
  }
  
  #####################
  # Sex counts
  desc_ <- "Sample count by sex and batch"
  fn_   <- "batch_sex.png"
  cat("\t", fn_,"\n")
  if(d_out!="") {
    f_  <- paste(d_out, fn_, sep="/")
    png(filename=f_, width=png_width, height=png_height)
  }
  plots_[[p_idx]] <- list(fname=fn_, fpath=f_, description=desc_); p_idx <- p_idx + 1

  fields <- c("Male","Female","Pooled","Is_water")
  mat_ <- as.matrix(df_[fields])
  rownames(mat_) <- df_$Batch
  max_ <- max(mat_,na.rm=T)
  ylim <- c(0, max(mat_+1, 1.25*max_, 3))
  col  <- c("skyblue2","pink1","grey50","grey20")
  xlim <- c(1,(ncol(mat_)+1)*max(nrow(mat_),2))
  barplot(t(mat_), col=col, beside=T, ylim=ylim, xlim=xlim,
          main=desc_, ylab="Samples",
          legend.text=ifelse(length(fields)>1,T,F), args.legend=list(bty="n"))
  if(d_out != "") {
    dev.off()
  }

  #####################
  # gDNA failures
  desc_ <- "GDNA failures by batch"
  fn_   <- "batch_gdna.png"
  cat("\t", fn_,"\n")
  if(d_out!="") {
    f_  <- paste(d_out, fn_, sep="/")
    png(filename=f_, width=png_width, height=png_height)
  }
  plots_[[p_idx]] <- list(fname=fn_, fpath=f_, description=desc_); p_idx <- p_idx + 1

  fields <- c("Gdna_fail")
  mat_ <- as.matrix(df_[fields], drop=F)
  colnames(mat_) <- "Fail" # c("Pass","Fail")
  rownames(mat_) <- df_$Batch
  max_ <- max(mat_, na.rm=T)
  ylim <- c(0, max(mat_+1, 1.20*max_, 8))
  col  <- 2 #c("blue","red")
  xlim <- c(1,(ncol(mat_)+1)*max(nrow(mat_),2))
  barplot(t(mat_), col=col, beside=T, ylim=ylim, xlim=xlim,
          main=desc_, ylab="gDNA failures",
          legend.text=ifelse(length(fields)>1,T,F), args.legend=list(bty="n"))
  if(d_out != "") {
    dev.off()
  }

  #####################
  # missing wells
  desc_ <- "Well NA counts by batch"
  fn_   <- "batch_well_na.png"
  cat("\t", fn_,"\n")
  if(d_out!="") {
    f_  <- paste(d_out, fn_, sep="/")
    png(filename=f_, width=png_width, height=png_height)
  }
  plots_[[p_idx]] <- list(fname=fn_, fpath=f_, description=desc_); p_idx <- p_idx + 1

  fields <- c("Well_na")
  mat_ <- as.matrix(df_[fields], drop=F)
  colnames(mat_) <- "Fail" # c("Pass","Fail")
  rownames(mat_) <- df_$Batch
  max_ <- max(mat_, na.rm=T)
  ylim <- c(0, max(mat_+1, 1.20*max_, 8))
  col  <- 2 #c("blue","red")
  xlim <- c(1,(ncol(mat_)+1)*max(nrow(mat_),2))
  barplot(t(mat_), col=col, beside=T, ylim=ylim, xlim=xlim,
          main=desc_, ylab="Well NAs",
          legend.text=ifelse(length(fields)>1,T,F), args.legend=list(bty="n"))
  if(d_out != "") {
    dev.off()
  }

  #####################
  # missing gene Cps
  desc_ <- "Samples with gene NA failures by batch"
  fn_   <- "batch_gene_na.png"
  cat("\t", fn_,"\n")
  if(d_out!="") {
    f_  <- paste(d_out, fn_, sep="/")
    png(filename=f_, width=png_width, height=png_height)
  }
  plots_[[p_idx]] <- list(fname=fn_, fpath=f_, description=desc_); p_idx <- p_idx + 1

  fields <- c("Gene_na_fail")
  mat_ <- as.matrix(df_[fields], drop=F)
  colnames(mat_) <- "Fail" # c("Pass","Fail")
  rownames(mat_) <- df_$Batch
  max_ <- max(mat_, na.rm=T)
  ylim <- c(0, max(mat_+1, 1.20*max_, 8))
  col  <- 2 #c("blue","red")
  xlim <- c(1,(ncol(mat_)+1)*max(nrow(mat_),2))
  barplot(t(mat_), col=col, beside=T, ylim=ylim, xlim=xlim,
          main=desc_, ylab="Samples with gene NA failures",
          legend.text=ifelse(length(fields)>1,T,F), args.legend=list(bty="n"))
  if(d_out != "") {
    dev.off()
  }

  #####################
  # neg ctrl fail count
  desc_ <- "Neg ctrl counts by batch"
  fn_   <- "batch_negctrl.png"
  cat("\t", fn_,"\n")
  if(d_out!="") {
    f_  <- paste(d_out, fn_, sep="/")
    png(filename=f_, width=png_width, height=png_height)
  }
  plots_[[p_idx]] <- list(fname=fn_, fpath=f_, description=desc_); p_idx <- p_idx + 1

  df_f <- df_[c("Batch","Negctrl_total","Negctrl_fail")]
  df_f$Pass <- df_f[[2]] - df_f[[3]]
  df_f$Fail <- df_f[[3]]

  fields <- c("Pass", "Fail")
  mat_ <- as.matrix(df_f[fields])
  rownames(mat_) <- df_f$Batch
  max_ <- max(mat_,na.rm=T)
  ylim <- c(0, max(mat_+1, 1.20*max_, 8))
  col  <- c("blue","red")
  xlim <- c(1,(ncol(mat_)+1)*max(nrow(mat_),2))
  barplot(t(mat_), col=col, beside=T, ylim=ylim, xlim=xlim,
          main=desc_, ylab="Wells",
          legend.text=ifelse(length(fields)>1,T,F), args.legend=list(bty="n"))
  if(d_out != "") {
    dev.off()
  }

  #####################
  # plate fail count
  desc_ <- "Plate counts by batch"
  fn_   <- "batch_plate.png"
  cat("\t", fn_,"\n")
  if(d_out!="") {
    f_  <- paste(d_out, fn_, sep="/")
    png(filename=f_, width=png_width, height=png_height)
  }
  plots_[[p_idx]] <- list(fname=fn_, fpath=f_, description=desc_); p_idx <- p_idx + 1

  df_f <- df_[c("Batch","Plate", "Plate_fail")]
  df_f$Pass <- df_f[[2]] - df_f[[3]]
  df_f$Fail <- df_f[[3]]

  fields <- c("Pass", "Fail")
  mat_ <- as.matrix(df_f[fields])
  rownames(mat_) <- df_f$Batch
  max_ <- max(mat_,na.rm=T)
  ylim <- c(0, max(mat_+1, 1.20*max_, 8))
  col  <- c("purple","pink")
  xlim <- c(1,(ncol(mat_)+1)*max(nrow(mat_),2))
  barplot(t(mat_), col=col, beside=T, ylim=ylim, xlim=xlim,
          main=desc_, ylab="Plates",
          legend.text=ifelse(length(fields)>1,T,F), args.legend=list(bty="n"))
  if(d_out != "") {
    dev.off()
  }

#  #####################
#  # PAX ctrl fail count
#  desc_ <- "PAX controls by batch"
#  f_    <- "batch_pax.png"
#  cat("\t", f_,"\n")
#  if(d_out!="") {
#    f_  <- paste(d_out, f_, sep="/")
#    png(filename=f_, width=png_width, height=png_height)
#  }
#  plots_[[p_idx]] <- c(f_, desc_); p_idx <- p_idx + 1
#
#  fields <- c("Batch","Is_pax_ctrl", "Pax_fail","pax_batch_fail_max")
#  df_f <- df_[fields]
#  df_f$Pass <- df_f[[2]] - df_f[[3]]
#  df_f$Fail <- df_f[[3]]      
#  mat_ <- as.matrix(df_f[c("Pass", "Fail")])
#  rownames(mat_) <- df_f$Batch
#  max_ <- max(mat_,na.rm=T)
#  ylim <- c(0, max(mat_+1, 1.20*max_, df_f$pax_batch_fail_max[1]+.5))
#  col  <- c("blue","red")
#  xlim <- c(1,(ncol(mat_)+1)*max(nrow(mat_),2))
#  barplot(t(mat_), col=col, beside=T, ylim=ylim, xlim=xlim,
#          main=desc_, ylab="PAX controls",
#          legend.text=ifelse(length(fields)>1,T,F), args.legend=list(bty="n"))
#  abline(h=df_f$pax_batch_fail_max[1],lty=2,col=2)
#  if(d_out != "") {
#    dev.off()
#  }
  
  invisible(plots_)
}

plot_cas_d2_plate <- function(ret_, d_out, png_width=600, png_height=png_width, aa=NULL,browse = F) {
  if(browse) browser()

  df_p   <- ret_$df_plate_cnt
  plots_ <- list()
  p_idx  <- 1

  if(!(is.null(aa) || (aa =="")))
    df_p$Plate[1] <- aa #"Abcdefghijkl"
  opar <- par(no.readonly = T) #par(mar=c(5,4,4,2)+.1, mfrow=c(1,1), las=1)
  
  #####################
  # sex count
  desc_ <- "Sample sex by plate"
  fn_   <- "plate_sex.png"
  cat("\t", fn_,"\n")
  f_   <- paste(d_out, fn_, sep="/")
#  if(d_out=="")
#    f_ <- ""
  plots_[[p_idx]] <- list(fname=fn_, fpath=f_, description=desc_); p_idx <- p_idx + 1
  df_p$Water <- df_p$Is_water
  df_ <- df_p[c("Batch", "Plate", "Water", "Pooled", "Male", "Female")]
  do_barplot(d_out, fn_, desc_, xlab="Samples", xaxis_counts=T,
             df_, c1="Plate", c2="Batch", c("Water","Pooled","Male", "Female"),
             col=c("black","grey","skyblue","pink"), browse=F)

  #####################
  # sex fail count
  desc_ <- "Sex failures by plate"
  fn_   <- "plate_sex_fail.png"
  cat("\t", fn_,"\n")
  f_   <- paste(d_out, fn_, sep="/")
  plots_[[p_idx]] <- list(fname=fn_, fpath=f_, description=desc_); p_idx <- p_idx + 1
  df_ <- df_p[c("Batch", "Plate", "Sex_fail")]
  do_barplot(d_out, fn_, desc_, xlab="Samples", xaxis_counts=T,
             df_, c1="Plate", c2="Batch", c("Sex_fail"),
             col=c("red"), browse=F)

  #####################
  # PAX failures
  desc_ <- "PAX status by plate"
  fn_   <- "plate_pax.png"
  cat("\t", fn_,"\n")
  f_   <- paste(d_out, fn_, sep="/")
  plots_[[p_idx]] <- list(fname=fn_, fpath=f_, description=desc_); p_idx <- p_idx + 1
  df_ <- df_p[c("Batch","Plate","Is_pax_ctrl","Pax_fail")]
  df_$Fail <- df_$Pax_fail
  df_$Pass <- df_$Is_pax_ctrl - df_$Fail
  fields_ <- c("Pass","Fail")
  do_barplot(d_out, fn_, desc_, xlab="PAX samples", xaxis_counts=T,
             df_, c1="Plate", c2="Batch", fields_, vlines=2.5,
             col=c("green","red"), browse=F)

  #####################
  # Well NA counts, there are no failures here
  desc_ <- "Well NA counts by plate"
  fn_   <- "plate_well_na.png"
  cat("\t", fn_,"\n")
  f_   <- paste(d_out, fn_, sep="/")
  plots_[[p_idx]] <- list(fname=fn_, fpath=f_, description=desc_); p_idx <- p_idx + 1
  fields_ <- c("Well_na")
  df_ <- df_p[c("Batch","Plate", fields_)]
  do_barplot(d_out, fn_, desc_, xlab="Well NA count", xaxis_counts=T,
             df_, c1="Plate", c2="Batch", fields_, vlines=c(),
             col=c("thistle"), browse=F) # no red

  #####################
  # well NA failures
  desc_ <- "Sample well NA failures/warnings by plate"
  fn_   <- "plate_well_na_fail.png"
  cat("\t", fn_,"\n")
  f_   <- paste(d_out, fn_, sep="/")
  plots_[[p_idx]] <- list(fname=fn_, fpath=f_, description=desc_); p_idx <- p_idx + 1
  fields_ <- c("Well_na_fail", "Well_na_warn")
  df_ <- df_p[c("Batch","Plate", fields_)]
  df_$Fail <- df_$Well_na_fail
  df_$Warn <- df_$Well_na_warn - df_$Fail
  fields_ <- c("Fail", "Warn")
  do_barplot(d_out, fn_, desc_, xlab="Sample well NA failure/warning count", xaxis_counts=T,
             df_, c1="Plate", c2="Batch", fields_, vlines=c(),
             col=c("red","orchid1"), browse=F)

  #####################
  # gDNA failures
  desc_ <- "Sample gDNA failures/warnings by plate"
  fn_   <- "plate_gdna.png"
  cat("\t", fn_,"\n")
  f_   <- paste(d_out, fn_, sep="/")
  plots_[[p_idx]] <- list(fname=fn_, fpath=f_, description=desc_); p_idx <- p_idx + 1
  fields_ <- c("Gdna_fail", "Gdna_warn")
  df_ <- df_p[c("Batch","Plate", fields_)]
  df_$Fail <- df_$Gdna_fail
  df_$Warn <- df_$Gdna_warn - df_$Fail
  fields_  <- c("Fail", "Warn")
  do_barplot(d_out, fn_, desc_, xlab="Sample gDNA failure/warning count", xaxis_counts=T,
             df_, c1="Plate", c2="Batch", fields_, vlines=c(),
             col=c("red","turquoise"), browse=F)

  #####################
  # gene NA failures
  desc_ <- "Sample gene NAs by plate"
  fn_   <- "plate_gene_na.png"
  cat("\t", fn_,"\n")
  f_   <- paste(d_out, fn_, sep="/")
  plots_[[p_idx]] <- list(fname=fn_, fpath=f_, description=desc_); p_idx <- p_idx + 1
  df_ <- df_p[c("Batch","Plate","Gene_na_fail")]
  do_barplot(d_out, fn_, desc_, xlab="Sample gene NA failures", xaxis_counts=T,
             df_, c1="Plate", c2="Batch", c("Gene_na_fail"), vlines=c(),
             col=c("red","wheat"), browse=F)

  #####################
  # exp mean
  desc_ <- "Sample expression mean failures/warnings by plate"
  fn_   <- "plate_exp_mean.png"
  cat("\t", fn_,"\n")
  f_   <- paste(d_out, fn_, sep="/")
  plots_[[p_idx]] <- list(fname=fn_, fpath=f_, description=desc_); p_idx <- p_idx + 1
  fields_ <- c("Exp_mean_fail", "Exp_mean_warn")
  df_ <- df_p[c("Batch","Plate", fields_)]
  df_$Fail <- df_$Exp_mean_fail
  df_$Warn <- df_$Exp_mean_warn - df_$Fail
  fields_  <- c("Fail", "Warn")
  do_barplot(d_out, fn_, desc_, xlab="Sample expression mean failure/warning count", xaxis_counts=T,
             df_, c1="Plate", c2="Batch", fields_, vlines=c(),
             col=c("red","thistle"), browse=F)

  #####################
  # Sd
  desc_ <- "Sample std dev failures/warnings by plate"
  fn_   <- "plate_sd.png"
  cat("\t", fn_,"\n")
  f_   <- paste(d_out, fn_, sep="/")
  plots_[[p_idx]] <- list(fname=fn_, fpath=f_, description=desc_); p_idx <- p_idx + 1
  fields_ <- c("Sd_fail","Sd_warn")
  df_ <- df_p[c("Batch","Plate", fields_)]
  df_$Fail <- df_$Sd_fail
  df_$Warn <- df_$Sd_warn - df_$Fail
  fields_  <- c("Fail", "Warn")
  do_barplot(d_out, fn_, desc_, xlab="Sample std dev failure/warning count", xaxis_counts=T,
             df_, c1="Plate", c2="Batch", fields_, vlines=c(),
             col=c("red","thistle"), browse=F)

  #####################
  # Sd 90
  desc_ <- "Sample std dev 90 failures/warnings by plate"
  fn_   <- "plate_sd90.png"
  cat("\t", fn_,"\n")
  f_   <- paste(d_out, fn_, sep="/")
  plots_[[p_idx]] <- list(fname=fn_, fpath=f_, description=desc_); p_idx <- p_idx + 1
  fields_ <- c("Sd_90_fail","Sd_90_warn")
  df_ <- df_p[c("Batch","Plate", fields_)]
  df_$Fail <- df_$Sd_90_fail
  df_$Warn <- df_$Sd_90_warn - df_$Fail
  fields_  <- c("Fail", "Warn")
  do_barplot(d_out, fn_, desc_, xlab="Sample std dev 90 failure/warning count", xaxis_counts=T,
             df_, c1="Plate", c2="Batch", fields_, vlines=c(),
             col=c("red","thistle"), browse=F)

  #####################
  # Sd 100
  desc_ <- "Sample std dev 100 failures by plate"
  fn_   <- "plate_sd100.png"
  cat("\t", fn_,"\n")
  f_   <- paste(d_out, fn_, sep="/")
  plots_[[p_idx]] <- list(fname=fn_, fpath=f_, description=desc_); p_idx <- p_idx + 1
  fields_ <- c("Sd_100_fail")
  df_ <- df_p[c("Batch","Plate", fields_)]
  do_barplot(d_out, fn_, desc_, xlab="Sample std dev 100 failures", xaxis_counts=T,
             df_, c1="Plate", c2="Batch", fields_, vlines=c(),
             col=c("red","thistle"), browse=F)

  #####################
  # truncations
  desc_ <- "Sample truncation failures/warnings by plate"
  fn_   <- "plate_trunc.png"
  cat("\t", fn_,"\n")
  f_   <- paste(d_out, fn_, sep="/")
  plots_[[p_idx]] <- list(fname=fn_, fpath=f_, description=desc_); p_idx <- p_idx + 1
  fields_ <- c("Trunc_fail","Trunc_warn")
  df_ <- df_p[c("Batch","Plate", fields_)]
  df_$Fail <- df_$Trunc_fail
  df_$Warn <- df_$Trunc_warn - df_$Fail
  fields_  <- c("Fail", "Warn")
  do_barplot(d_out, fn_, desc_, xlab="Sample truncation failure/warning count", xaxis_counts=T,
             df_, c1="Plate", c2="Batch", fields_, vlines=c(),
             col=c("red","thistle"), browse=F)

  #####################
  # exp profile
  desc_ <- "Sample expression profile failures/warnings by plate"
  fn_   <- "plate_exp.png"
  cat("\t", fn_,"\n")
  f_   <- paste(d_out, fn_, sep="/")
  plots_[[p_idx]] <- list(fname=fn_, fpath=f_, description=desc_); p_idx <- p_idx + 1
  fields_ <- c("Exp_fail","Exp_warn")
  df_ <- df_p[c("Batch","Plate", fields_)]
  df_$Fail <- df_$Exp_fail
  df_$Warn <- df_$Exp_warn - df_$Fail
  fields_  <- c("Fail", "Warn")
  do_barplot(d_out, fn_, desc_, xlab="Sample expression profile failure/warning count",
             df_, c1="Plate", c2="Batch", fields_, vlines=c(), xaxis_counts=T,
             col=c("red","thistle"), browse=F)

  #####################
  # warning counts
  desc_ <- "Sample warning count failures by plate"
  fn_   <- "plate_warn.png"
  cat("\t", fn_,"\n")
  f_   <- paste(d_out, fn_, sep="/")
  plots_[[p_idx]] <- list(fname=fn_, fpath=f_, description=desc_); p_idx <- p_idx + 1
  fields_ <- c("Warning_fail")
  df_ <- df_p[c("Batch","Plate", fields_)]
  do_barplot(d_out, fn_, desc_, xlab="Sample warning count failures", xaxis_counts=T,
             df_, c1="Plate", c2="Batch", fields_, vlines=c(),
             col=c("red","thistle"), browse=F)

  #####################
  # sample fails
  desc_ <- "Sample failures by plate\nincludes plate failures"
  fn_   <- "plate_sample_fail.png"
  cat("\t", fn_,"\n")
  f_   <- paste(d_out, fn_, sep="/")
  plots_[[p_idx]] <- list(fname=fn_, fpath=f_, description=desc_); p_idx <- p_idx + 1
  df_ <- df_p[c("Batch","Plate", "Sample","sample_plate_fail")]
  df_$Pass <- df_$Sample - df_$sample_plate_fail # includes plate failures
  df_$Fail <- df_$sample_plate_fail
  fields_ <- c("Pass","Fail")
  do_barplot(d_out, fn_, desc_, xlab="Samples", xaxis_counts=T,
             df_, c1="Plate", c2="Batch", fields_, vlines=c(),
             col=c("blue","red"), browse=F)

  #####################
  # neg ctrl fail
  desc_ <- "Negative control failures by plate"
  fn_   <- "plate_neg_ctrl.png"
  cat("\t", fn_,"\n")
  f_   <- paste(d_out, fn_, sep="/")
  plots_[[p_idx]] <- list(fname=fn_, fpath=f_, description=desc_); p_idx <- p_idx + 1
  fields_ <- c("Negctrl_fail")
  df_ <- df_p[c("Batch","Plate", fields_)]
  do_barplot(d_out, fn_, desc_, xlab="Neg ctrl failures", xaxis_counts=T,
             df_, c1="Plate", c2="Batch", fields_, vlines=c(),
             col=c("red","thistle"), browse=F)

  #####################
  # 
  desc_ <- "Plate failures"
  fn_   <- "plate_fail.png"
  cat("\t", fn_,"\n")
  f_   <- paste(d_out, fn_, sep="/")
  plots_[[p_idx]] <- list(fname=fn_, fpath=f_, description=desc_); p_idx <- p_idx + 1
  df_ <- df_p[c("Batch","Plate", "Plate_flag")]
  df_$Fail <- df_$Plate_flag != "Pass"
  fields_ <- c("Fail")
  do_barplot(d_out, fn_, desc_, xlab="Plate failures", xaxis_counts=T,
             df_, c1="Plate", c2="Batch", fields_, vlines=c(),
             col=c("red","thistle"), browse=F)

  if(d_out == "")
    par(opar) #par(mar=c(5,4,4,2)+.1, mfrow=c(1,1), las=1)

  invisible(plots_)
}

do_barplot <- function(d_out, f_, desc_, xlab, df_, xaxis_counts=F,
                       c1="Plate", c2="Batch", fields=c(), vlines=c(), vcol=2,
                       col=c(4,2),  xlim=NULL, png_width=600, png_height=NULL,
                       mar=NULL, nrow_min=36, browse = F) {
  if(browse) browser()
  
  if(!c1 %in% names(df_))
    stop("Can't find c1=(",c1,") in df_\n", sep="")
  if(!c2 %in% names(df_))
    stop("Can't find c2=(",c2,") in df_\n", sep="")
  b_ <- fields %in% names(df_)
  if(any(!b_))
    stop("Can't find fields: ",paste(fields[!b_],collapse=", "),") in df_\n", sep="")

  space <- .5*barplot_space(df_[[c2]])
  mat_  <- as.matrix(df_[fields], drop=F)
  rownames(mat_) <- df_[[c1]]

  max_ <- max(apply(mat_, 1, sum, na.rm=T))
  if(is.null(xlim)) {
    xlim <- c(0, max(max_+1, 1.25*max_, 3))
    if(length(vlines)>0)
      xlim <- range(c(xlim, ceiling(vlines)))
  }

  if(is.null(png_height)) {
    yfactor <- nrow(df_)/nrow_min
    yfactor <- max(1, yfactor)
    png_height <- ceiling(yfactor*png_width)
  }
  
  if(d_out!="") {
    f_  <- paste(d_out, f_, sep="/")
    png(filename=f_, width=png_width, height=png_height)
  }
  plot.new() # erases the canvas, squawks otherwise
  width_factor <- max(strwidth(df_[[c1]]))/strwidth("B1_P01")
  width_factor <- max(1, min(3, width_factor))
  if(is.null(mar))
    mar <- c(5, 2+3*width_factor, 4, 2)+.1
  opar <- par(mar = mar, las=2)
#  par(mar=c(5, 2+3*width_factor, 4, 2)+.1, las=2)
  barplot(t(mat_), col=col, beside=F, xlim=xlim, horiz=T, space=space,
          main=desc_, xlab=xlab, xaxt="n",
          legend.text=ifelse(length(fields)>1,T,F), # show lend if more than one field
          args.legend=list(bty="n"), las=2)
  if(xaxis_counts)
    axis(1, at=0:ceiling(max(xlim)), las=1)
  else
    axis(1, las=1)
  if(length(vlines)>0)
    abline(v=vlines, lty=2,col=vcol)
  par(opar) #par(mar=c(5,4,4,2)+.1, mfrow=c(1,1))
  if(d_out != "")
    dev.off()
}

barplot_space <- function(v, browse = F) {
  if(browse) browser()

  s_ <- rep(0, length(v))
  ii <- 2
  while(ii <= length(v)) {
    if(v[[ii-1]] != v[[ii]])
      s_[[ii]] <- 1
    ii <- ii + 1
  }
  return(s_)
}

plot_cas_d2_sample <- function(ret_, d_out, col_c1=c("grey","tan"),
                               png_width=600, png_height=NULL, aa="", browse = F) {
  if(browse) browser()

  df_s   <- ret_$df_sample
  plots_ <- list()
  p_idx  <- 1
  
  if(!(is.null(aa) || (aa =="")))
    df_s$Plate[1] <- aa #"Abcdefghijkl"
  opar <- par(no.readonly = TRUE) #par(mar=c(5,4,4,2)+.1, mfrow=c(1,1), las=1)

  #####################
  # 
  desc_ <- "CCAD scores by sample"
  fn_   <- "sample_score.png"
  cat("\t", fn_,"\n")
  f_  <- paste(d_out, fn_, sep="/")
  if(d_out=="")
    f_ <- ""
  plots_[[p_idx]] <- list(fname=fn_, fpath=f_, description=desc_); p_idx <- p_idx + 1

  field_ <- "Score"
  v_     <- df_s[[field_]]
#  bounds_ <- c(df_s$well_missing_fail[1],df_s$well_missing_warn[1])+.5
  b_pax_ctrl <- df_s$Is_pax_ctrl==1
  col <- ifelse(df_s$Overall_flag=="Fail","red",
                ifelse(df_s$Sample_type=="Clinical", "blue",
                       ifelse(b_pax_ctrl, "cyan","green")))
  pch <- substr(df_s$Sample_type,1,1)
  pch[!is.na(df_s$Gender) & df_s$Gender=="Male"]   <- "M"
  pch[!is.na(df_s$Gender) & df_s$Gender=="Female"] <- "F"
  pch[b_pax_ctrl] <- "C"
  batch_idx <- c1_index(df_s[c("Batch","Plate")])
  col_c1_ <- col_c1[1+batch_idx%%length(col_c1)]
  plot_v_by_cat(df_s, field_, "Plate", c2="Batch", xlab="Corus CAD score",
                xaxis_counts=F,
                f_out =f_, png_width=png_width, png_height=png_height,
                col   =col, pch=pch, cex=.8, col_c1=col_c1_,
                main  =desc_, 
            #   vlines=list(bounds_,2,c("red","goldenrod")),
                browse=F)

  #####################
  # 
  desc_ <- "Well NA counts by sample"
  fn_   <- "sample_well_na.png"
  cat("\t", fn_,"\n")
  f_  <- paste(d_out, fn_, sep="/")
  if(d_out=="")
    f_ <- ""
  plots_[[p_idx]] <- list(fname=fn_, fpath=f_, description=desc_); p_idx <- p_idx + 1

  field_ <- "Well_na_cnt"
  v_     <- df_s[[field_]]
  bounds_ <- c(df_s$well_missing_fail[1],df_s$well_missing_warn[1])+.5
  col <- ifelse(v_ > bounds_[1],"red", ifelse(v_ > bounds_[2], "goldenrod","black"))
  pch <- 1
  batch_idx <- c1_index(df_s[c("Batch","Plate")])
  col_c1_ <- col_c1[1+batch_idx%%length(col_c1)]
  plot_v_by_cat(df_s, field_, "Plate", c2="Batch", xlab="Well NA count",
                xlim_min_range=range(0, ceiling(bounds_)), xaxis_counts=T,
                f_out =f_, png_width=png_width, png_height=png_height,
                col   =col, pch=pch, cex=1, col_c1=col_c1_,
                main  =desc_, 
                vlines=list(bounds_,2,c("red","goldenrod")),
                browse=F)

  #####################
  desc_ <- "Gene NA count by sample" #
  fn_   <- "sample_gene_na.png"  #
  cat("\t", fn_,"\n")
  f_  <- paste(d_out, fn_, sep="/")
  if(d_out=="")
    f_ <- ""
  plots_[[p_idx]] <- list(fname=fn_, fpath=f_, description=desc_); p_idx <- p_idx + 1

  field_ <- "Gene_na_cnt"  #
  v_ <- df_s[[field_]]
  bounds_ <- c(df_s$gene_missing_max[1])+.5 #
  col <- ifelse(v_ > bounds_[1],"red","black")
  pch <- 1
  batch_idx <- c1_index(df_s[c("Batch","Plate")])
  col_c1_ <- col_c1[1+batch_idx%%length(col_c1)]
  plot_v_by_cat(df_s, field_, "Plate", c2="Batch", xlab="Gene NA count",
                xlim_min_range=range(0, ceiling(bounds_),2), xaxis_counts=T,
                f_out =f_, png_width=png_width, png_height=png_height,
                col   =col, pch=pch, cex=1, col_c1=col_c1_,
                main  =desc_,
                vlines=list(bounds_,2,c("red","goldenrod")),
                browse=F)

  #####################
  desc_ <- "gDNA delta by sample"  #
  fn_   <- "sample_gdna_delta.png" #
  cat("\t", fn_,"\n")
  f_  <- paste(d_out, fn_, sep="/")
  if(d_out=="")
    f_ <- ""
  plots_[[p_idx]] <- list(fname=fn_, fpath=f_, description=desc_); p_idx <- p_idx + 1

  field_ <- "Gdna_delta_cp"        #
  v_ <- df_s[[field_]]
  bounds_ <- c(df_s$gdna_min[1],df_s$gdna_warn[1]) #
  col <- ifelse(v_ < bounds_[2],"red", ifelse(v_ < bounds_[1], "goldenrod","black"))
  pch <- 1
  batch_idx <- c1_index(df_s[c("Batch","Plate")])
  col_c1_ <- col_c1[1+batch_idx%%length(col_c1)]
  plot_v_by_cat(df_s, field_, "Plate", c2="Batch", xlim_min_range=range(3, bounds_,7),
                f_out =f_, png_width=png_width, png_height=png_height, xlab="gDNA delta Cp",
                col   =col, pch=pch, cex=1, col_c1=col_c1_,
                main  =desc_,
                vlines=list(bounds_,2,c("red","goldenrod")),
                browse=F)

  #####################
  desc_ <- "Expression mean by sample"  #
  fn_   <- "sample_exp_mean.png"  #
  cat("\t", fn_,"\n")
  f_  <- paste(d_out, fn_, sep="/")
  if(d_out=="")
    f_ <- ""
  plots_[[p_idx]] <- list(fname=fn_, fpath=f_, description=desc_); p_idx <- p_idx + 1

  field_ <- "Exp_mean"    #
  v_ <- df_s[[field_]]
  bounds_ <- c(df_s$expr_mean_max[1],df_s$expr_mean_warn[1]) #
  col <- ifelse(v_ > bounds_[1],"red", ifelse(v_ > bounds_[2], "goldenrod","black"))
  pch <- 1
  batch_idx <- c1_index(df_s[c("Batch","Plate")])
  col_c1_ <- col_c1[1+batch_idx%%length(col_c1)]
  plot_v_by_cat(df_s, field_, "Plate", c2="Batch", xlim_min_range=range(28, bounds_,30),
                f_out =f_, png_width=png_width, png_height=png_height, xlab="Expression mean",
                col   =col, pch=pch, cex=1, col_c1=col_c1_,
                main  =desc_,
                vlines=list(bounds_,2,c("red","goldenrod")),
                browse=F)

  #####################
  desc_ <- "Std dev median by sample" #
  fn_   <- "sample_sd.png"  #
  cat("\t", fn_,"\n")
  f_  <- paste(d_out, fn_, sep="/")
  if(d_out=="")
    f_ <- ""
  plots_[[p_idx]] <- list(fname=fn_, fpath=f_, description=desc_); p_idx <- p_idx + 1

  field_ <- "Sd"  #
  v_ <- df_s[[field_]]
  bounds_ <- c(df_s$med_sd_max[1],df_s$med_sd_warn[1]) #
  col <- ifelse(v_ > bounds_[1],"red", ifelse(v_ > bounds_[2], "goldenrod","black"))
  pch <- 1
  batch_idx <- c1_index(df_s[c("Batch","Plate")])
  col_c1_ <- col_c1[1+batch_idx%%length(col_c1)]
  plot_v_by_cat(df_s, field_, "Plate", c2="Batch", xlim_min_range=range(0, bounds_,.2),
                f_out =f_, png_width=png_width, png_height=png_height, xlab="Std dev",
                col   =col, pch=pch, cex=1, col_c1=col_c1_,
                main  =desc_,
                vlines=list(bounds_,2,c("red","goldenrod")),
                browse=F)

  #####################
  desc_ <- "Std dev 90th percentile by sample" #
  fn_   <- "sample_sd90.png"  #
  cat("\t", fn_,"\n")
  f_  <- paste(d_out, fn_, sep="/")
  if(d_out=="")
    f_ <- ""
  plots_[[p_idx]] <- list(fname=fn_, fpath=f_, description=desc_); p_idx <- p_idx + 1

  field_ <- "Sd_90"  #
  v_ <- df_s[[field_]]
  bounds_ <- c(df_s$sd_90_max[1],df_s$sd_90_warn[1]) #
  col <- ifelse(v_ > bounds_[1],"red", ifelse(v_ > bounds_[2], "goldenrod","black"))
  pch <- 1
  batch_idx <- c1_index(df_s[c("Batch","Plate")])
  col_c1_ <- col_c1[1+batch_idx%%length(col_c1)]
  plot_v_by_cat(df_s, field_, "Plate", c2="Batch", xlim_min_range=range(0, bounds_,.7),
                f_out =f_, png_width=png_width, png_height=png_height, xlab="Std dev 90th percentile",
                col   =col, pch=pch, cex=1, col_c1=col_c1_,
                main  =desc_,
                vlines=list(bounds_,2,c("red","goldenrod")),
                browse=F)

  #####################
  desc_ <- "Std dev max by sample" #
  fn_   <- "sample_sd_max.png"  #
  cat("\t", fn_,"\n")
  f_  <- paste(d_out, fn_, sep="/")
  if(d_out=="")
    f_ <- ""
  plots_[[p_idx]] <- list(fname=fn_, fpath=f_, description=desc_); p_idx <- p_idx + 1

  field_ <- "Sd_100"  #
  v_ <- df_s[[field_]]
  bounds_ <- c(df_s$sd_max_max[1]) #
  col <- ifelse(v_ > bounds_[1],"red", "black")
  pch <- 1
  batch_idx <- c1_index(df_s[c("Batch","Plate")])
  col_c1_ <- col_c1[1+batch_idx%%length(col_c1)]
  plot_v_by_cat(df_s, field_, "Plate", c2="Batch", xlim_min_range=range(0, bounds_,2.4),
                f_out =f_, png_width=png_width, png_height=png_height, xlab="Std dev max",
                col   =col, pch=pch, cex=1, col_c1=col_c1_,
                main  =desc_,
                vlines=list(bounds_,2,c("red","goldenrod")),
                browse=F)

  #####################
  desc_ <- "Expression profile by sample" #
  fn_   <- "sample_exp_profile.png"  #
  cat("\t", fn_,"\n")
  f_  <- paste(d_out, fn_, sep="/")
  if(d_out=="")
    f_ <- ""
  plots_[[p_idx]] <- list(fname=fn_, fpath=f_, description=desc_); p_idx <- p_idx + 1

  field_ <- "Exp_profile"  #
  v_ <- df_s[[field_]]
  bounds_ <- c(df_s$ep_max[1],df_s$ep_warn[1],df_s$ep_pool_max[1],df_s$ep_pool_warn[1]) #
  col <- rep("black", nrow(df_s))
  b_ <- df_s$Sample_type=="Clinical"
  col[b_]  <- ifelse(v_[b_ ] > bounds_[1],"red", ifelse(v_[b_ ] > bounds_[2], "goldenrod","black"))
  col[!b_] <- ifelse(v_[!b_] > bounds_[3],"magenta", ifelse(v_[!b_] > bounds_[4], "cyan","blue"))
  pch <- 1 + !b_ # 1 is clinical, 2 pooled
  batch_idx <- c1_index(df_s[c("Batch","Plate")])
  col_c1_ <- col_c1[1+batch_idx%%length(col_c1)]
  plot_v_by_cat(df_s, field_, "Plate", c2="Batch", xlim_min_range=range(bounds_, 30),
                f_out =f_, png_width=png_width, png_height=png_height, xlab="Expression profile",
                col   =col, pch=pch, cex=1, col_c1=col_c1_,
                main  =desc_,
                vlines=list(bounds_,c(1,1,2,2),c("red","goldenrod","magenta","cyan")),
                browse=F)

  #####################
  desc_ <- "Truncations by sample" #
  fn_   <- "sample_trunc.png"  #
  cat("\t", fn_,"\n")
  f_  <- paste(d_out, fn_, sep="/")
  if(d_out=="")
    f_ <- ""
  plots_[[p_idx]] <- list(fname=fn_, fpath=f_, description=desc_); p_idx <- p_idx + 1

  field_ <- "Trunc_cnt"  #
  v_ <- df_s[[field_]]
  bounds_ <- c(df_s$trunc_max[1],df_s$trunc_warn[1]) #
  col <- ifelse(v_ > bounds_[1],"red", ifelse(v_ > bounds_[2], "goldenrod","black"))
  pch <- 1
  batch_idx <- c1_index(df_s[c("Batch","Plate")])
  col_c1_ <- col_c1[1+batch_idx%%length(col_c1)]
  plot_v_by_cat(df_s, field_, "Plate", c2="Batch", xlab="Truncation count",
                xlim_min_range=range(0, bounds_+1), xaxis_counts=T,
                f_out =f_, png_width=png_width, png_height=png_height,
                col   =col, pch=pch, cex=1, col_c1=col_c1_,
                main  =desc_,
                vlines=list(bounds_,2,c("red","goldenrod")),
                browse=F)

  #####################
  desc_ <- "Sex by sample" #
  fn_   <- "sample_sex.png"  #
  cat("\t", fn_,"\n")
  f_  <- paste(d_out, fn_, sep="/")
  if(d_out=="")
    f_ <- ""
  plots_[[p_idx]] <- list(fname=fn_, fpath=f_, description=desc_); p_idx <- p_idx + 1

  field_ <- "RPS4Y1"  #
  v_ <- df_s[[field_]]
  bounds_ <- c(df_s$rps4y1_female_min[1],df_s$rps4y1_male_max[1],df_s$rps4y1_pool_max[1]) #
  col <- ifelse(v_ > bounds_[3],"green","grey") # pooled
  pch <- rep(1, length(col))
  b_ <- !is.na(df_s$Gender) & df_s$Gender == "Female"
  col[b_] <- ifelse(v_[b_] < bounds_[1],"red","black")
  pch[b_] <- 70 # 3  'F'
  b_ <- !is.na(df_s$Gender) & df_s$Gender == "Male"
  col[b_] <- ifelse(v_[b_] > bounds_[2],"blue","black")
  pch[b_] <- 77 #6   'M'
  batch_idx <- c1_index(df_s[c("Batch","Plate")])
  col_c1_ <- col_c1[1+batch_idx%%length(col_c1)]
  plot_v_by_cat(df_s, field_, "Plate", c2="Batch", xlim_min_range=range(bounds_-1, bounds_+1),
                f_out =f_, png_width=png_width, png_height=png_height, xlab="RPS4Y1 Cp value",
                col   =col, pch=pch, cex=1, col_c1=col_c1_,
                main  =desc_,
                vlines=list(bounds_,2,c("red","blue","black","green","grey")),
                args.legend=list("top",c("Female","Female error","Male","Male error",
                                         "Pooled", "Pooled error"),
                                 col=c(1,2,1,4,8,3), pch=c(70,70,77,77,1,1), bty="n"),
                browse=F)

  #####################
  desc_ <- "Warning counts by sample" #
  fn_   <- "sample_warnings.png"  #
  cat("\t", fn_,"\n")
  f_  <- paste(d_out, fn_, sep="/")
  if(d_out=="")
    f_ <- ""
  plots_[[p_idx]] <- list(fname=fn_, fpath=f_, description=desc_); p_idx <- p_idx + 1

  field_ <- "Warning_cnt"  #
  v_ <- df_s[[field_]]
  bounds_ <- c(df_s$warning_max[1]) + .5
  col <- ifelse(v_ > bounds_[1],"red","black")
  pch <- 1
  batch_idx <- c1_index(df_s[c("Batch","Plate")])
  col_c1_ <- col_c1[1+batch_idx%%length(col_c1)]
  plot_v_by_cat(df_s, field_, "Plate", c2="Batch",
                xlim_min_range=range(0, ceiling(bounds_), 3), xaxis_counts=T,
                f_out =f_, png_width=png_width, png_height=png_height, xlab="Warning count",
                col   =col, pch=pch, cex=1, col_c1=col_c1_,
                main  =desc_,
                vlines=list(bounds_,2,c("red")),
                browse=F)

#
  if(d_out == "")
    par(opar) #par(mar=c(5,4,4,2)+.1, mfrow=c(1,1), las=1)

  invisible(plots_)
}

# df_     data.frame with fields v1 and c1 (and maybe c2)
# v1      field with numeric values
# c1      field with categories
# c2      field with categories, can be NULL
#         order by c2, c1 (must be nested: each c1 in only one c2)
# col     colors the points, length(col) = nrows(df_) or 1
# pch     point symbols, length(pch) = nrows(df_) or 1
# col_c1  colors the categories, length(col_c1) divisor of length(unique(c1))
plot_v_by_cat <- function(df_, v1, c1, c2=NULL,
                          xlim=NULL, ylim=NULL,
                          xlim_min_range=NULL, xaxis_counts=F,
                          main        =paste(v1,"by",c1), xlab=v1, ylab="",
                          col=1, pch=1, cex=1, col_c1=8,
                          mar         = NULL, #c(5, 7, 4, 2)+.1,
                          jit_size    =.2,
                          col_medians = NULL, # color for median lines
                          vlines      = NULL,
                          c2_vlines   = NULL,
                          args.legend = NULL,
                          args.segments = NULL,
                          f_out="", png_width=600, png_height=NULL, nrow_min=36, 
                          browse=F) {
  if(browse) browser()
  
  if(!v1 %in% names(df_))
    stop("Can't find v1=(",v1,") in df_\n", sep="")
  if(!c1 %in% names(df_))
    stop("Can't find c1=(",c1,") in df_\n", sep="")
  if(!is.null(c2) && !(c2 %in% names(df_)))
    stop("Can't find c2=(",c2,") in df_\n", sep="")

  if(!is.null(c2))
    ord <- order(df_[[c2]], df_[[c1]])
  else
    ord <- order(df_[[c1]])
  df_ <- df_[ord,]
  if(length(col)>1)
    col <- col[ord]
  if(length(pch)>1)
    pch <- pch[ord]

  space_cum_points <- 0
  space_cum_cats   <- 0
  if(!is.null(c2)) {
    space_ <- .5*barplot_space(df_[[c2]])
    space_cum_points <- cumsum(space_)

    dups_   <- duplicated(df_[[c1]])
    c2_cats <- df_[!dups_, c2] # one c2 for each unique c1 in order
    space_  <- .5*barplot_space(c2_cats)
    space_cum_cats <- cumsum(space_)
    g_   <- factor(df_[[c1]], levels=df_[!dups_,c1])

    med_c2  <- tapply(df_[[v1]], df_[c2], median, na.rm=T)
    med_rng <- matrix(unlist(tapply(as.numeric(g_) + space_cum_points, df_[[c2]], range)), nrow=2)
  } else {
    g_   <- as.factor(df_[[c1]])
    med_c2  <- median(df_[[v1]], na.rm=T)
    med_rng <- matrix(range(as.numeric(g_) + space_cum_points), nrow=2)
  }
  ncat <- nlevels(g_)
  idx  <- as.numeric(g_)
  rem_ <- ncat %% length(col_c1)
  if(rem_ != 0)
    stop("Length of col_c1 not a divisor of the number of categories (",ncat,")\n")

  med_idx <- 1:length(med_c2)
  if(is.null(col_medians))
    med_idx <- c()

  na_cnt <- tapply(is.na(df_[[v1]]), g_, sum)
  na_cnt_any <- any(na_cnt>0)
  na_cnt_space <- 1*na_cnt_any
  na_cnt_char <- ifelse(na_cnt>0, na_cnt, "")
  y_labels <- (1:ncat)+space_cum_cats
  x_   <- df_[[v1]]
  y_   <- idx + space_cum_points
  jit_ <- jit_size*(runif(length(y_)) - .5)

  if(is.null(xlim)) {
    if(any(!is.na(x_)))
      xlim <- range(x_, na.rm=T)
    else
      xlim <- c(0,1)
    if(!is.null(vlines))
      xlim <- range(c(xlim, vlines[[1]]), na.rm=T)
    if(!is.null(xlim_min_range))
      xlim <- range(c(xlim, xlim_min_range))      
  }
  if(is.null(ylim))
    ylim <- range(c(y_, y_+jit_, y_+.5, y_-.5))

  if(is.null(png_height)) {
    yfactor <- ncat/nrow_min
    yfactor <- max(1, yfactor)
    png_height <- ceiling(yfactor*png_width)
  }

  if(f_out != "") {
#    cat("\nOpening png graphics device:\t", f_out,"\n")
    png(filename=f_out, width=png_width, height=png_height)
#    cat("\t", f_out,"\n")
  }
  plot.new() # erases the canvas, squawks otherwise
  width_factor <- max(strwidth(levels(g_)))/strwidth("B1_P01")
  width_factor <- max(1, min(3, width_factor))
  if(is.null(mar))
    mar <- c(5, 2+3*width_factor, 4, 2+na_cnt_space)+.1
  opar <- par(mar = mar)
  plot(x_, y_+jit_, xlim=xlim, ylim=ylim, type="n", yaxt="n", xaxt="n",
       main=main, xlab=xlab, ylab=ylab)
  if(xaxis_counts)
    axis(1, at=0:ceiling(max(xlim))) # forces integers at axis labels
  else
    axis(1)
  axis(2, at=y_labels, labels=levels(g_), las=2) #, col=col_c1, col.ticks=col_c1)
  abline(h=y_labels, lty=2, col=col_c1)
#  for(ii in med_idx)
#    segments(med_c2[ii], med_rng[1, ii]-.5, med_c2[ii], med_rng[2, ii]+.5,
#             lty=2, col=col_medians)
  if(length(med_idx)>0)
    segments(med_c2, med_rng[1,]-.5, med_c2, med_rng[2,]+.5,
             lty=2, col=col_medians)
  points(x_, y_+jit_, col=col, pch=pch, cex=cex)
  if(!is.null(vlines))
    abline(v=vlines[[1]],lty=vlines[[2]], col=vlines[[3]])
  if(!is.null(c2_vlines)) {
    x_val <- rep(med_c2, each=length(c2_vlines[[1]])) + rep(c2_vlines[[1]], length(med_c2))
    y_lo  <- rep(med_rng[1,], each=length(c2_vlines[[1]]))
    y_hi  <- rep(med_rng[2,], each=length(c2_vlines[[1]]))
    segments(x_val, y_lo-.5, x_val, y_hi+.5,
             lty=c2_vlines[[2]], col=c2_vlines[[3]])
  }
  if(na_cnt_any)
    mtext(na_cnt_char, side=4, line=1, at=y_labels, las=2)

  if(!is.null(args.segments))
    do.call(segments, args.segments)

  if(!is.null(args.legend))
    do.call(legend, args.legend)

  par(opar) #par(mar=c(5,4,4,2)+.1, mfrow=c(1,1))

  if(f_out != "")
    dev.off()
}

########################

# tbl_    2-dim table, matrix, or data.frame with categorical fields c1 and c1
# c1      field with categories (only for df_ a data.frame) or specify row name
# c2      field with categories (only for df_ a data.frame) or specify col name
plot_tbl <- function(tbl_,c1=NULL, c2=NULL, row_blocks=NULL, col_blocks=NULL,
                     xlim=NULL, ylim=NULL,
                     main        = NULL, xlab=NULL, ylab=NULL,
                     breaks=NULL, labels=NULL, colors=NULL,
                     mar         = NULL, #c(5, 7, 4, 2)+.1,
                     args.legend = NULL,
                     line_axis   = -1,
                     f_out="", png_width=600, png_height=NULL, nrow_min=25, 
                     browse=F) {
  if(browse) browser()

  if(is.null(breaks))
    stop("Must specify breaks argument\n")
  if(is.null(labels))
    stop("Must specify labels argument\n")
  if(is.null(colors))
    stop("Must specify colors argument\n")
  if(length(breaks) != length(labels)+1)
    stop("Breaks/labels length conflict must have length(breaks) == length(labels)+1\n")
  if(length(labels) != length(colors))
    stop("Labels and colors must have the same length\n")
  if(is.data.frame(tbl_)) {
    if(is.null(c1))
      stop("Must specify c1 field when using a data.frame\n")
    if(is.null(c2))
      stop("Must specify c2 field when using a data.frame\n")
    if(c1 %in% names(tbl_))
      stop("Can't find field c1 (",c1,") in data.frame tbl_\n", sep="")
    if(c2 %in% names(tbl_))
      stop("Can't find field c2 (",c2,") in data.frame tbl_\n", sep="")
    tbl_ <- table(tbl_[c(c1,c2)])
  }
  if(is.matrix(tbl_))
    tbl_ <- as.table(tbl_)

  if(nrow(tbl_)>0 && is.null(rownames(tbl_)))
    rownames(tbl_) <- 1:nrow(tbl_)
  if(ncol(tbl_)>0 && is.null(colnames(tbl_)))
    colnames(tbl_) <- 1:ncol(tbl_)

  if(!is.null(row_blocks)) {
    if(length(row_blocks)!= nrow(tbl_))
      stop("Length of row_blocks not matching the row number of table\n")
  }
  if(!is.null(col_blocks)) {
    if(length(col_blocks)!= ncol(tbl_))
      stop("Length of col_blocks not matching the column number of table\n")
  }
  if(!is.null(row_blocks) || !is.null(col_blocks))
    tbl_ <- as.table(matrix_blocks(tbl_, row_blocks, col_blocks, browse=F))

  if(is.null(names(dimnames(tbl_))))
    names(dimnames(tbl_)) <- c(NA,NA)

  if(is.null(c1))
    c1 <- "c1"
  if(is.null(c2))
    c2 <- "c2"
  
  if(is.na(names(dimnames(tbl_))[1]))
    names(dimnames(tbl_))[1] <- c1
  if(is.na(names(dimnames(tbl_))[2]))
    names(dimnames(tbl_))[2] <- c2

  if(is.null(xlab))
    xlab <- names(dimnames(tbl_))[2] # cols
  if(is.null(ylab))
    ylab <- names(dimnames(tbl_))[1] # rows

  nlabels <- ifelse(is.null(labels),0,length(labels))
  if(is.null(xlim))
    xlim <- range(c(0, c(ncol(tbl_), nrow_min)+1))
  if(is.null(ylim))
    ylim <- range(c(-.5, c(nrow(tbl_), nrow_min)+.5+nlabels))
  
  if(is.null(png_height)) {
    yfactor <- nrow(tbl_)/nrow_min
    yfactor <- max(1, yfactor)
    png_height <- ceiling(yfactor*png_width)
  }

  xfactor <- max(1, ncol(tbl_)/nrow_min)
  if(xfactor > 1)
    png_width <- ceiling(xfactor*png_width)

  if(f_out != "") {
#    cat("\nOpening png graphics device:\t", f_out,"\n")
    png(filename=f_out, width=png_width, height=png_height)
#    cat("\t", f_out,"\n")
  }
  plot.new() # erases the canvas, squawks otherwise
  width_factor  <- max(strwidth(rownames(tbl_)))/strwidth("B1_P01")
  height_factor <- max(strwidth(colnames(tbl_)))/strwidth("B1_P01")
  width_factor  <- max(1, min(3, width_factor))
  height_factor <- max(1, min(3, height_factor))
  if(is.null(mar))
    mar <- c( 2+3*height_factor+line_axis, 2+3*width_factor+line_axis, 4, 2)+.1
#  cat("mar",mar,"\n")
#  cat("xlim",xlim,"\n")
#  cat("ylim",ylim,"\n")
  opar <- par(mar = mar)
#  zlim <- c(0, max_)
  z_ <- matrix(as.numeric(cut(tbl_, breaks=breaks, labels=labels)), nrow=nrow(tbl_))
  plot(0, 0, xlim=xlim, ylim=ylim, type="n",
       xaxs="i", yaxs="i", yaxt="n", xaxt="n", bty="n",
       main=main, xlab=xlab, ylab=ylab)
#  axis(1, at=1:ncol(tbl_))
#  axis(2, at=1:nrow(tbl_))
  axis(1, at=1:ncol(tbl_), labels=colnames(tbl_), tick=F, las=2, cex.axis=1, line=line_axis)
  axis(2, at=1:nrow(tbl_), labels=rownames(tbl_), tick=F, las=2, cex.axis=1, line=line_axis)
  image(x=1:ncol(tbl_), y=1:nrow(tbl_), z=t(z_), #pmin(mat_, max_), # zlim=zlim,
        col=colors, add=T)
  x_ <- (2:ncol(tbl_))-.5
  y_ <- (2:nrow(tbl_))-.5
  segments(x_, .5, x_, nrow(tbl_)+.5, lty=1, col=1, lwd=.5) #"grey40")
  segments(.5, y_, ncol(tbl_)+.5, y_, lty=1, col=1, lwd=.5) #"grey40")
  text(x=col(tbl_), y=row(tbl_), labels=tbl_)
  
  if(!is.null(args.legend))
    do.call(legend, args.legend)
  legend("topleft",labels, fill=colors, bty="n")

  par(opar) #par(mar=c(5,4,4,2)+.1, mfrow=c(1,1))

  if(f_out != "")
    dev.off()
}

matrix_blocks <- function(mat_, g_row=NULL, g_col=NULL, browse=F) {
  if(browse) browser()

  if(!is.matrix(mat_))
    stop("mat_ is not a matrix\n")
  if(is.null(g_row))
    g_row <- rep(1, nrow(mat_))
  if(is.null(g_col))
    g_col <- rep(1, ncol(mat_))
  if(nrow(mat_) != length(g_row))
    stop("nrow(mat_) != length(g_row)\n")
  if(ncol(mat_) != length(g_col))
    stop("ncol(mat_) != length(g_col)\n")
  if(any(is.na(g_row)))
     stop("g_row has NA entries, not allowed\n")
  if(any(is.na(g_col)))
     stop("g_col has NA entries, not allowed\n")
  r_idx <- block_index(g_row)
  c_idx <- block_index(g_col)
  
  mat_b <- matrix(NA, nrow=max(r_idx), ncol=max(c_idx))
  mat_b[r_idx, c_idx] <- mat_
  if(!is.null(rownames(mat_))) {
    rn_ <- rep(NA, nrow(mat_b))
    rn_[r_idx] <- rownames(mat_)
    rownames(mat_b) <- rn_
  }
  if(!is.null(colnames(mat_))) {
    cn_ <- rep(NA, ncol(mat_b))
    cn_[c_idx] <- colnames(mat_)
    colnames(mat_b) <- cn_
  }
  
  return(mat_b)
}

# inserts a blank at each change of g_
# returns an index
block_index <- function(g_, browse=F) {
  if(browse) browser()
  n_ <- length(g_)
  if(n_==0)
    return(c())
  if(any(is.na(g_)))
     stop("g_ has NA entries, not allowed\n")
  if(n_ == 1)
    return(1)
  b_ <- c(FALSE, g_[-1] != g_[-n_])
  s_ <- cumsum(b_)
  idx <- (1:n_) + s_
  return(idx)
}










