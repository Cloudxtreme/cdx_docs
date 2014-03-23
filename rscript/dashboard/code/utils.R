
`%&%` <- function(x,y) paste(x,y,sep="")

delete_empty_levels <- function(fac) {

  tbl_ <- table(fac)
  fac  <- factor(as.character(fac), levels=names(tbl_)[tbl_>0])
  return(fac)
}

# loads a list of files as data frames
# and rbinds them into long format
# comma separated by default
load_files_rbind <- function(f_lst, sep=",", browse=F) {
  if(browse) browser()
  
  n_files <- length(f_lst)
  lst_ <- list(n_files)
  for(ii in 1:n_files) {
    f_ <- f_lst[[ii]]
    cat("#####\n",ii,":\t", basename(f_), "\n")
    lst_[[ii]] <- read.table(f_, header=T, sep=sep, check.names=F, quote="\"",
                           stringsAsFactors=F)
  }
    
  cat("########\nbinding rows\n")
  # rbind to a single data frame
  df_ <- do.call(rbind, c(lst_, deparse.level=0))
  return(df_)
}

execute_query <- function(conn, query)
{
 res  <- dbSendQuery(conn, query)
 data <- dbGetResult(res)
 return(data)
}

# v_   char vector
# p_   list of strings or regexps
# return:
# vector of matches from v_
grep_strings <- function(p_, v_, value=T, fixed=F, browse=F) {
  if(browse) browser()

  if(is.null(p_))
    return(c())
  l_ <- lapply(as.list(p_), function(pat, v_, value, fixed) { grep(pat, v_, value=value, fixed=fixed) }, v_, value, fixed)
  ret_ <- sort(unique(unlist(l_)))
  
  return(ret_)
}

# get a list of files from a path
# if path doesn't exist then return c()
# if path == directory then gets the files in the dir matching the pattern
# if path == file then returns the file 
get_file_list <- function(path, pattern="", browse=F) {
  if(browse) browser()

  finfo <- file.info(path)
  if(is.na(finfo$isdir)) { # file doesn't exist
    return(c())
  } 
  if(finfo$isdir) {
  #  path   <- dir_trim(path)
    f_lst <- list.files(path, pattern=pattern, full.names=T, ignore.case=T)
  } else {
    f_lst <- path
  }

  return(f_lst)
}

compare_df <- function(df1, df2, eps=1e-10, factors_as_chars=F,
                       types_identical=F, must_be_identical=F, browse=F) {
  if(browse) browser()

  if(!is.list(df1)) {
    cat("df1 is not a list\n")
    return(FALSE)
  }
  if(!is.list(df2)) {
    cat("df2 is not a list\n")
    return(FALSE)
  }
  if(!is.data.frame(df1)) {
    cat("df1 is not a data.frame\n")
    return(FALSE)
  }
  if(!is.data.frame(df2)) {
    cat("df2 is not a data.frame\n")
    return(FALSE)
  }

  if(identical(df1, df2)) { # check first
#    cat("df1 and df2 are 'identical'\n")
    return(TRUE)
  }

  if(length(df1) !=  length(df2)) {
    cat("Lengths are not the same\n")
    return(FALSE)
  }

  if(nrow(df1) !=  nrow(df2)) {
    cat("Number of rows are not the same\n")
    return(FALSE)
  }

  n_ <- names(df1)
  b_ <- n_ == names(df2)
  if(any(!b_)) {
    cat("Column names (",which(!b_)[1],") are not the same\n")
    return(FALSE)
  }

  b_ <- rownames(df1) == rownames(df2)
  if(any(!b_)) {
    cat("Row names (",which(!b_)[1],") are not the same\n")
    return(FALSE)
  }

  if(factors_as_chars) { # convert factors to chars
    # typeof(factor) == "integer"  Ugh!
    b1 <- sapply(df1, is.factor)
    b2 <- sapply(df2, is.factor)
    df1[b1] <- lapply(df1[b1], as.character)
    df2[b2] <- lapply(df2[b2], as.character)
  }

  # should use class() !
  m_ <- sapply(df1, mode)
  t_ <- sapply(df1, typeof)
  b_ <- m_ == sapply(df2, mode)
  if(any(!b_)) {  # a factor and a char will be caught here
    cat("Column modes (",which(!b_)[1],") are not the same\n") # even if factors_as_chars
    return(FALSE)
  }

  b_ <- t_ == sapply(df2, typeof)
  if(types_identical && any(!b_)) {
    cat("Column types (",which(!b_)[1],") are not the same\n")
    return(FALSE)
  }

  for(ii in 1:length(df1)) { # compare the columns
    a_ <- df1[[ii]]
    b_ <- df2[[ii]]
    if(is.factor(a_) || is.factor(b_)) { # factors
      if(factors_as_chars) { # this shouldn't happen
        if(any(as.character(a_) != as.character(b_), na.rm=T)) {
          cat("Column ",ii, " : (factor as char)\tNot the same", "\n", sep="")
          return(FALSE)
        }
      } else { # factors must match
          if(is.factor(a_) && !is.factor(b_)) {
            cat("Column ",ii, "\tdf1 is a factor but df2 is NOT\tNot the same", "\n", sep="")
            return(FALSE)
          }
          if(!is.factor(a_) && is.factor(b_)) {
            cat("Column ",ii, "\tdf1 is NOT a factor but df2 is a factor\tNot the same", "\n", sep="")
            return(FALSE)
          }
          if(any(levels(a_) != levels(b_), na.rm=T)) {
            cat("Column ",ii, " : (factor levels)\tNot the same", "\n", sep="")
            return(FALSE)
          }
          if(any(as.numeric(a_) != as.numeric(b_), na.rm=T)) {
            cat("Column ",ii, " : (factor as numeric)\tNot the same", "\n", sep="")
            return(FALSE)
          }
      }
    } else if(is.numeric(a_)) { # int, floats
      diff_ <- max(abs(a_ - b_), na.rm=T)
      if(diff_ >= eps) {
        cat("Column ",ii, " : (", t_[ii],")\tmax diff=", diff_, "  Not the same", "\n", sep="")
        return(FALSE)
      }
    } else if(is.character(a_) || is.logical(a_)) { # chars, logical
      if(any(a_ != b_, na.rm=T)) {
        cat("Column ",ii, " : (", t_[ii],")\tNot the same", "\n", sep="")
        return(FALSE)
      }
    } else { # 
      cat(t_[ii],"\tunrecognized type\n") # could be an ordered factor?
      return(FALSE)
    }
  }

  if(must_be_identical) { # already checked above and it failed
    cat("df1 and df2 are not 'identical'\n")
    return(FALSE)
  }

  return(TRUE)
}

# reverse strings
# eg: strReverse(c("abc", "Statistics"))
strReverse <- function(x) {
        sapply(lapply(strsplit(x, NULL), rev), paste, collapse="")
}

# return an empty data.frame of length=len
# all numeric
df_empty <- function(len, names_=paste("a",1:len,sep=""), browse=F) {
  if(browse) browser()
  if(!is.numeric(len) || !(as.integer(len)==len) || len<0)
    stop("len must be a non-negative interger\n")
  df_ <- as.data.frame(as.list(numeric(len)))
  df_ <- df_[FALSE,,drop=F] # it drops when length=1
  if(len>0)
    names(df_) <- names_
  return(df_)
}

# df_i   data.frame with two or one columns
#        such as chromosome (character or numeric) and position (numeric)
#        or just position
#        the ordering is order(df_[[1]], df_[[2]]) or order(df_[[1]])
#        that is, column one takes priority when there are two columns
# return: all indicies of pairs of rows from df_1 and df_2 with
#        chromosomes matching and positions within near of each other
near_pairs <- function(df_1, df_2, near, do_sort=T, browse=F) {
  if(browse) browser()

  if(!(is.numeric(near)))
    stop("near must be numeric\n")
  if(!is.data.frame(df_1))
    stop("df_1 must be a data frame\n")
  if(!is.data.frame(df_2))
    stop("df_2 must be a data frame\n")
  len_ <- length(df_1)
  if(!len_ %in% 1:2)
    stop("df_1 must have one or two columns\n")
  if(len_ != length(df_2))
    stop("df_1 and df_2 must have the same number of columns\n")

  if(!(is.numeric(df_1[[len_]]) && is.numeric(df_2[[len_]])))
    stop("Column ",len_," of both df_1 and df_2 must be numeric\n")
  if(len_ == 2) {
    if(mode(df_1[[1]])!=mode(df_2[[1]]))
      stop("The columns of df_1 and df_2 must be comparable\n")
  }
  
  if(len_==1)
    return(near_pairs_single(df_1[[1]], df_2[[1]], near,
                             do_sort=do_sort, browse=F))

  if(do_sort) {
    df_1 <- df_1[order(df_1[[1]], df_1[[2]]),]
    df_2 <- df_2[order(df_2[[1]], df_2[[2]]),]
  }

  chr_all <- sort(unique(c(df_1[[1]], df_2[[1]])))
  ret_ <- lapply(chr_all, near_pairs_chr, df_1, df_2, near)

  # strip out empty ones
  ret_ <- ret_[!sapply(ret_, is.null)]
  if(length(ret_)==0) 
    df_ <- df_empty(3)
  else # combine data.frames
    df_ <- rbind_df_list(ret_)
  ns_ <- c(names(df_1)[1:2], names(df_2)[2])
  if(ns_[2] == ns_[3]) {
    ns_[2] <- paste(ns_[2],"_1",sep="")
    ns_[3] <- paste(ns_[3],"_2",sep="")
  }
  names(df_) <- ns_

  return(df_)
}

near_pairs_chr <- function(chr, df_1, df_2, near, do_sort=F, browse=F) {
  if(browse) browser()
  p1 <- df_1[df_1[[1]] == chr, 2]
  p2 <- df_2[df_2[[1]] == chr, 2]
  np_ <- near_pairs_single(p1, p2, near, do_sort=do_sort)
  if(nrow(np_)==0)
    return(NULL)
  np_[[names(df_1)[1]]] <- chr
  return(np_[c(3,1,2)])
}

# p1, p2, and near all numeric
# returns data.frame of all ordered pairs from p1 and p2
# within distance near
near_pairs_single <- function(p1, p2, near, do_sort=T, browse=F) {
  if(browse) browser()

  len1 <- length(p1)
  if(len1<1 || length(p2)<1)
    return(df_empty(2))
  if(do_sort) {
    p1 <- sort(p1)
    p2 <- sort(p2)
  }

  j_lo <- i2j_low( p1,  p2-near)
  j_hi <- i2j_low(-p1, -p2-near)
  j_hi <- 1 + length(p2) - j_hi[len1:1]

  ret_ <- lapply(1:len1,
                 function(i, j_lo, j_hi) {
                   lo_ <- j_lo[[i]]
                   hi_ <- j_hi[[i]]
                   if(is.na(lo_) || is.na(hi_) || lo_ < hi_)
                     return(data.frame(p1=numeric(0), p2=numeric(0)))
                   return(data.frame(p1=p1[i], p2=p2[hi_:lo_]))
                 }, j_lo, j_hi)

  # strip out empty ones
  ret_ <- ret_[!sapply(ret_, is.null)]
  # combine data.frames
  df_  <- rbind_df_list(ret_)
  names(df_) <- c("p1","p2")
  return(df_)
}

# assumes p1, p2 sorted numeric vectors, and neither empty
# returns:  vector with length(p1)
# ith value = max{j; p2[[j]] <= p1[[i]]}
#             NA if empty  
i2j_low <- function(p1, p2, browse=F) {
  if(browse) browser()

  df_ <- data.frame(x=c(p1,p2),
                    b=c(rep(1:0, c(length(p1),length(p2)))))
  ord <- order(df_$x, df_$b) # order p2 first when a tie
  df_ <- df_[ord,]

  i2j <- integer(length(p1))
  i1 <- 0
  i2 <- 0
  for(k in 1:nrow(df_)) {
    if(df_$b[k]==0) {
      i2 <- i2 + 1
    } else {
      i1 <- i1 + 1
      i2j[[i1]] <- i2
    }
  }
  i2j[i2j==0] <- NA
  return(i2j)
}

plot_pvalues <-  function(pvals, n_bonf=length(pvals),
                          n_max=length(pvals), y_max=4,
                          main="P-values", xlab="SNPs",
                          browse=F) {
  if(browse) browser()

  lp_ <- -sort(log10(pvals))[1:n_max]
  bonf_ <- log10(n_bonf/.05)
  col <- ifelse(lp_>=bonf_, 2, 4)
  ylim=c(0,ceiling(max(c(y_max, bonf_, lp_))))
  plot(lp_, ylim=ylim, col=col,
       main=main, xlab=xlab,
       ylab="-log10 p-value")
  abline(h=bonf_, col=8, lty=2)
  text(.9*n_max, bonf_-.2, "Bonferroni", col=8)

}

plot_pval_df <-  function(df, n_bonf=nrow(df),
                          n_max=nrow(df), y_max=4, fdr_pct=50,
                          main="P-values", xlab="SNPs",
                          browse=F) {
  if(browse) browser()

  if("pvalue" %in% names(df) && !"pval" %in% names(df))
    df$pval <- df$pvalue
  if("p_fdr" %in% names(df) && !"pval_fdr" %in% names(df))
    df$pval_fdr <- df$p_fdr
  if(!"pval" %in% names(df))
    stop("Can't find pval field in data frame df\n")
  
  fdr_level <- 100
  if(!is.null(fdr_pct)) {
    b_ <- 100*df$pval_fdr<=fdr_pct
    if(any(b_))
      fdr_level <- -log10(max(df$pval[b_]))
  }

  lp_ <- -sort(log10(df$pval))[1:n_max]
  bonf_ <- log10(n_bonf/.05)
  col <- ifelse(lp_>=bonf_, 2, ifelse(lp_>=fdr_level, 4, 8))
  ylim=c(0,ceiling(max(c(y_max, bonf_, lp_))))
  plot(lp_, ylim=ylim, col=col,
       main=main, xlab=xlab,
       ylab="-log10 p-value")
  abline(h=bonf_, col=8, lty=2)
  text(.9*n_max, bonf_-.2, "Bonferroni", col=8)
  if(!is.null(fdr_pct)) {
    abline(h=fdr_level, col=8, lty=2)
    text(.9*n_max, fdr_level-.2, paste("FDR = ",fdr_pct,"%",sep=""), col=8)
  }
}

# proportional hazards test plot
# y   survival time
# g   group data
plot_ph_test <- function(y, g, legend_pos="bottomright",
                          eps=1e-6, browse=F, ...) {
  if(browse) browser()

  if(length(y) != length(g))
    stop("data y and group indicator g must have the same length\n")
  if(!is.vector(y) || !is.numeric(y))
    stop("y must be numeric\n")
  b_ <- is.na(y) | is.na(g)
  y <- y[!b_]
  g <- g[!b_]
  if(length(y)==0)
    stop("No data to plot\n")
  if(any(y<0))
    stop("y data must be positive\n")
  g <- as.factor(g)

  # splits the points by group and make plotting points
  ret_ <- tapply(y, g, function(y) { n <- length(y)
                         return(list(y=sort(y), p=((1:n)-.5)/n))})
                 
  xlim <- range(y) #log(pmax(y, eps)))
  ylim <- c(0,1)
  plot(0,0, type="n", xlim=xlim, ylim=ylim,
       main="Proportional hazards test\ndifferent groups should be vertically shifted",
       xlab="Log y[ord]", ylab="Survival probability")
  for(ii in 1:nlevels(g)) {
    pch <- ifelse(ret_[[ii]]$y < eps, 2, 1)
    y_ <- ret_[[ii]]$y
    p_ <- ret_[[ii]]$p
    points(y_, log(-log(1-p_)),
           col=ii, type="s",pch=pch, ...)
  }
  legend(legend_pos, levels(g), lty=1, col=1:nlevels(g), bty="n")
}

# accelerated life test plot
# y   survival time
# g   group data
plot_al_test <- function(y, g, legend_pos="bottomleft",
                          eps=1e-6, browse=F, ...) {
  if(browse) browser()

  if(length(y) != length(g))
    stop("data y and group indicator g must have the same length\n")
  if(!is.vector(y) || !is.numeric(y))
    stop("y must be numeric\n")
  b_ <- is.na(y) | is.na(g)
  y <- y[!b_]
  g <- g[!b_]
  if(length(y)==0)
    stop("No data to plot\n")
  if(any(y<0))
    stop("y data must be positive\n")
  g <- as.factor(g)

  # splits the points by group and make plotting points
  ret_ <- tapply(y, g, function(y) { n <- length(y)
                         return(list(y=sort(y), p=((1:n)-.5)/n))})
                 
  xlim <- range(log(pmax(y, eps)))
  ylim <- c(0,1)
  plot(0,0, type="n", xlim=xlim, ylim=ylim,
       main="Accelerated life test\ndifferent groups should be horizontally shifted",
       xlab="Log y[ord]", ylab="Survival probability")
  for(ii in 1:nlevels(g)) {
    pch <- ifelse(ret_[[ii]]$y < eps, 2, 1)
    points(log(pmax(ret_[[ii]]$y, eps)), 1-ret_[[ii]]$p,
           col=ii, type="s",pch=pch, ...)
  }
  legend(legend_pos, levels(g), lty=1, col=1:nlevels(g), bty="n")
}

plot_survival <- function(y, browse=F, ...) {
  if(browse) browser()

  if(!is.vector(y) || !is.numeric(y))
    stop("y must be numeric\n")
  y <- y[!is.na(y)]
  if(length(y)==0)
    stop("No data to plot\n")
  n_ <- length(y)
  y_  <- sort(y)
  p_ <- ((1:n_) - .5)/n_
  plot(y_, 1-p_,
       main="Survival plot", xlab="Survival time",
       ylab="Probablity of survival",...)
}

plot_weibull_test <- function(y, eps=1e-6, browse=F, ...) {
  if(browse) browser()

  if(!is.vector(y) || !is.numeric(y))
    stop("y must be numeric\n")
  y <- y[!is.na(y)]
  if(length(y)==0)
    stop("No data to plot\n")
  if(any(y<0))
    stop("y data must be positive\n")
  n_ <- length(y)
  y_  <- sort(y)
  p_ <- ((1:n_) - .5)/n_
  pch <- ifelse(y_ < eps, 2, 1)
  plot(log(-log(1-p_)), log(pmax(y_, eps)), # protect from underflow
       main="Weibull test plot\nWeibull data is linear",
       xlab="log(-log(1-p))",
       ylab="log(y[ord])",pch=pch, ...)
}

# 
plot_hazard_test <- function(y,
                             test=c("exponential", "Weibull", "weibull"),
                             browse=F, ...) {
  if(browse) browser()
  test <- match.arg(test)
  
  if(!is.vector(y) || !is.numeric(y))
    stop("y must be numeric\n")
  y <- y[!is.na(y)]
  if(length(y)==0)
    stop("No data to plot\n")
  if(any(y<0))
    stop("y data must be positive\n")
  n_ <- length(y)
  y_  <- sort(y)
  alp_ <- cumsum(1/(n_-(1:n_)+1))
  if(test=="exponential")
     plot(alp_, y_,
       main="Hazard plot\nexponential data is linear",
       xlab="cumsum(1/(n-i+1))",
       ylab="Survival time y[ord]",...)
  else
     plot(log(alp_), log(y_),
       main="Hazard plot\nWeibull data is linear",
       xlab="log cumsum(1/(n-i+1))",
       ylab="Log survival time (log y[ord])",...)
}

# b_outer     boolean
# b_inner     the support is b_outer==TRUE
#
# ret_bool    boolean same length as b_outer
#             with support of b_inner
#             ie, ret_bool[ b_outer] == b_inner
#             and ret_bool[!b_outer] == F
bool_in_bool <- function(b_outer, b_inner) {
  ret_bool <- b_outer
  ret_bool[b_outer] <- b_inner
  return(ret_bool)
}

# lists data.frames
ls_df <- function(pattern=NULL, browse=F) {
  if(browse) browser()
  if (!missing(pattern))
    nm_ <- ls(".GlobalEnv", pattern)
  else
    nm_ <- ls(".GlobalEnv")
  b_  <- sapply(nm_, function(x) is.data.frame(get(x)))
  return(nm_[b_])
}

# lists non-functions
ls_nf <- function(pattern=NULL) {
  if (!missing(pattern))
    nm_ <- ls(".GlobalEnv", pattern)
  else
    nm_ <- ls(".GlobalEnv")
  b_  <- sapply(nm_, function(x) is.function(get(x)))
  return(nm_[!b_])
}

# rbind a list of data frames
# assumes all have the same length (ncol)
# assumes all the columns match
# doesn't attempt to match columns
# uses the names from the first df
rbind_df_list <- function(df_list, browse=F) {
  if(browse) browser()

  if(!is.list(df_list))
    stop("df_list is not a list\n")
  
  if(length(df_list)==0)
    return(df_empty(0)) # df_list)
  
  # check all data frames
  is.df_ <- sapply(df_list, is.data.frame)
  if(!all(is.df_))
    stop("Some list objects are not data.frames\n")
  
  if(length(df_list)==1)
    return(df_list[[1]])
  
  # check all lengths match
  len_ <- sapply(df_list, length)
  if(!all(len_ == len_[1]))
    stop("Data frames don't all have the same length\n")

  is.factor_ <- sapply(df_list[[1]], is.factor)
  len_ <- len_[1]
  ret_ <- list()
  for(ii in 1:len_) {
    ret_[[ii]] <- unlist(lapply(df_list, function(x) x[[ii]]))
    if(is.factor_[ii])
      ret_[[ii]] <- factor(ret_[[ii]])
  }
  names(ret_) <- names(df_list[[1]])
  rownames_   <- unlist(lapply(df_list, row.names))
  if(any(duplicated(rownames_)))
    rownames_ <- 1:length(rownames_)
  df_ <- as.data.frame(ret_, row.names = rownames_, check.rows = FALSE,
                       check.names = FALSE, stringsAsFactors=F)
  names(df_) <- names(df_list[[1]])
  return(df_)
}

get_chrom_ind <- function(chr, browse=F) {
  if(browse) browser()

  if(is.numeric(chr))
    return(chr)
  if(is.factor(chr))
    chr <- as.character(chr)
  if(!is.character(chr))
    stop("chr no numeric, char, or factor...what is it?\n")
  chrom_ind <- as.numeric(chr)
  chrom_ind[chr=="X"]   <- 23
  chrom_ind[chr=="Y"]   <- 24
  chrom_ind[chr %in% c("","UN", "Un","un", "U", "u","Unknown","unknown","---")] <- 25
  chrom_ind[chr %in% c("MT", "Mt", "mt", "M", "m", "Mito", "mito")]             <- 26
  return(chrom_ind)
}

# vals_all    : a vector of character values
# vals        : a character, numeric, or boolean vector
#               if vals=NULL then all values are assumed
#               character:  vals must be a subset of vals_all
#               numeric  :  must be a subset of 1:length(vals_all)
#                           these give the indices of the subset in vals_all
#               boolean  :  must have same length as vals_all
# return:     : a boolean vector same length as vals_all
#               indicating the subset of vals_all given by vals
get_boolean_indicator <- function(vals, vals_all, null_all_true=TRUE, browse=F) {
  if(browse) browser()

  # NULL is NULL
  # c() also NULL, it's also not char, numeric, or logical
  
  if(is.null(vals))
    return(rep(null_all_true==TRUE, length(vals_all)))
  
  if(is.character(vals)) {
    b_ <- vals %in% vals_all
    if(any(!b_)) {
      cat("Some values not found in vals_all:\n")
      print(str(vals[!b_]))
      stop("\n")
    }
    vals <- vals_all %in% vals
  } else if(is.numeric(vals)) {
    b_ <- vals<1 | vals>length(vals_all)
    if(any(b_)) {
      cat("Some vals as row indices out of bounds:\n")
      print(str(vals[b_]))
      stop("\n")
    }
    vals <- (1:length(vals_all)) %in% vals # boolean subset indicator
  }

  if(is.logical(vals)) {
    if(length(vals) != length(vals_all))
      stop("boolean vals length (",length(vals),
           ") doesn't match vals_all length (",length(vals_all), ")\n")
    bool_vals <- vals
  } else
    stop("values must be character, numeric, or boolean\n")

  # so vals_all[bool_vals] is the subset
  return(bool_vals)
}

# read lines from file or connection
# using seek positions in idx
read_line_idx <- function(idx, f_in=NULL, browse=F) {
  if(browse) browser()

  con <- NULL
  we_open <- FALSE
  if(is.character(f_in)) {
    con <- file(f_in, "rt")
    we_open <- TRUE
  } else { # is.connection(f_in)
    con <- f_in
  }
  if(is.null(con))
    stop("f_in must be a file path or a connection\n")

  lines <- character(length(idx))
  jj <- 1
  for(pos in idx) {
    seek(con, where=pos) #, origin = "start", rw = "", ...)
    if(length(line <- readLines(con, 1))>0)
      lines[jj] <- line
    jj <- jj + 1
  }
  if(we_open)
    close(con) # we open we close
  return(lines)
}

# obsolete: strsplit does this exactly
# lines  : a vector or list of strings to be split
# returns a list of vectors.  One vector per line split
split_lines <- function(lines, sep="\t", browse=F) {
  if(browse) browser()

  ret_ <- list()
  ret_[length(lines)] <- "" # init length
  ii <- 1
  for(line in lines) {
    ret_[[ii]] <- strsplit(line, sep)[[1]]
    ii <- ii + 1
  }
  return(ret_)
}

# get the seek positions of each line in a text file
# include_last  : include the position of the last character of the last line
# nrows         : number of lines to try
#                 -1 for all lines (default)
#                 still works when file isn't terminated by a newline
# return: a vector of seek positions
create_seek_index <- function(f_in, include_last=F, nrows=-1,
                              skip_comments=F, browse=F) {
  if(browse) browser()

  if(nrows<0) {
    nrows  <- 1+get_nrows(f_in)
    # add one in case no newline at end of file
    # get_nrows uses 'wc -l' which counts newlines
    if(is.na(nrows))
      stop("Failed to get the number of lines of file:",f_in,"\n")
    cat(nrows-1,"lines found in file\n")
  } 
  
  # open read connection
  con <- file(f_in, "rt")

  idx <- numeric(nrows+1) # add one in case include_last
  idx[1] <- 0 # even for an empty file

  ii <- 1
  while(length(line <- readLines(con, 1))>0) {

    if(skip_comments && substr(line[1],1,1)=="#") {
      idx[ii] <- seek(con)
      next;
    }
    ii <- ii + 1
    idx[ii] <- seek(con) #, where = NA, origin = "start", rw = "", ...)

    if(  ii %%  10000 == 0) {
      cat(".")
      if(ii %% 100000 == 0)
        cat(" ")
      if(ii %% 500000 == 0)
        cat("\n")
#      if(ii %% 200000 == 0)
#        cat("\n")
    }
    if(ii>nrows)
      break
  }
  nrows <- min(ii-1, nrows)
  if(include_last) {
    idx <- idx[1:(nrows+1)]
  } else {
    idx <- idx[1:nrows]
  }
  close(con)
  cat("\nDone.\n")
  return(idx)
}

# get number of rows in a text file
# this counts newlines and so it is one short on
# files not terminated by a newline
# returns NA on failure
get_nrows <- function(f_in, browse=F) {
  if(browse) browser()
  cmd_   <- paste("wc -l '",f_in,"'", sep="")
  ret_   <- try_system(cmd_)
  nrows_ <- as.numeric(strsplit(ret_, "\\s")[[1]][1])
#  if(is.na(nrows_))
#    stop("Failed to get the number of lines of file:",f_in,"\n")
#  cat(nrows_,"lines found in file, including header\n")
#  nrows_ <- nrows_ - 1 # don't include the header

  return(nrows_)
}


# from Phil
all_object_sizes <- function (nmax=10) {
  ls_ <- ls(1)
  if(!is.null(nmax))
    nmax <- min(nmax, length(ls_))
  res <- unlist(lapply( ls_, function (x) { object.size(get(x)) } ))
  names(res) <- ls_
  sort(res, decreasing=TRUE)[1:nmax]

}

# reduce the precision of the points
# return the unique values (of the reduced precision points)
# and their multiplicities
points_density <- function(x, y=NULL, xwidth=NULL, ywidth=xwidth,
                           xpoints=1000, ypoints=xpoints, browse=F) {
  if(browse) browser()

  x_r <- reduce_precision(x, width=xwidth, npoints=xpoints)

  if(is.null(y)) {
#    tbl_ <- table(x_r)mar
#    x_q  <- as.numeric(tbl_)
#    x_m  <- as.vector(tbl_)
    # which is better?
#    ta_ <- tapply(x_r, x_r, length)
#    x_q <- as.numeric(names(ta_))
#    x_m <- unname(as.vector(ta_))
    
    ag_ <- aggregate(x_r, list(x_r=x_r), length)
    return(data.frame(x_q=ag_$x_r, multiple=ag_[[length(ag_)]]))
  } else {
    
    y_r <- reduce_precision(y, width=ywidth, npoints=ypoints)
    ag_ <- aggregate(x_r, list(x_r=x_r, y_r=y_r), length)
    return(data.frame(x_q=ag_$x_r, y_q=ag_$y_r, multiple=ag_[[length(ag_)]]))
  }

}


# round off x so that a range of width is represented by npoints points
reduce_precision <- function(x, width=NULL, npoints=1000, browse=F) {
  if(browse) browser()

  if(!is.numeric(x))
    stop("argument x must be numeric\n")
  if(!is.null(width) && !(is.numeric(width) && width>0))
    stop("argument xwidth must be positive\n")
  if(!is.null(npoints) && !(is.numeric(npoints) && npoints>0))
    stop("argument npoints must be positive\n")
  rng <- range(x, finite = TRUE)
  if(rng[1]==rng[2])
    return(x)
  
  if(is.null(width))
    width <- rng[[2]]-rng[[1]]

  del <- width/npoints
#  diff <- x-del*round(x/del)
#  max_diff <- max(abs(diff))
#  cat("del/2=",del/2,"\tmax_del=",max_diff,"\n")
#  if(max_diff>del)
#    cat("Max_diff > del/2\n")
#  return( data.frame(x=x, r=del*round(x/del),diff=diff))
  return(del*round(x/del))
}

qqhnorm <- function(y,...) {
  n <- length(y)
  x <- c()
  if(n>0)
    x <- qnorm(((1:n)+1)/(2*n+1), lower=F)
  qqplot(x, abs(y), xlab="Half-normal quantiles",...)
}

# altered from Faraway's halfnorm
half_norm <- function (x, nlab = 2, labs = as.character(1:length(x)),
                      ylim=NULL, ylab = "Sorted Data", col=NULL, browse=F, ...) {
    if(browse) browser()
    x <- abs(x)
    if(is.null(ylim))
      ylim <- c(0, max(x)) # JLB, allow adjustment of ylim
    labord <- order(x)
    x <- sort(x)
    i <- order(x)
    n <- length(x)
    nlab <- min(nlab,n)
    if(is.null(col)) {
      col <- rep(4, n)
      col[(n - nlab + 1):n] <- 2
    }
    ui <- qnorm((n + 1:n)/(2 * n + 1))
    plot(ui, x[i], xlab = "Half-normal quantiles", ylab = ylab, 
        ylim = ylim, type = "n", ...)
#    if (nlab < n) {
    points(ui, x[i], col=col,...) # JLB,  pass params
    text(ui[(n - nlab + 1):n], x[i][(n - nlab + 1):n], labs[labord][(n - 
        nlab + 1):n], pos=4, cex=.7) # JLB,  pass params here too?
}

oddsratio <- function(tbl_) {
  mat_ <- as.matrix(tbl_, nrow=2)
  return( mat_[1,1]*mat_[2,2]/(mat_[1,2]*mat_[2,1]) )
}

# transpose a data.frame
# the column 'col1' becomes the new names
# the names become the column 'col1_new'
# entries assumed numeric, except col1
transpose_df <- function(df_, col1, col1_new, browse=F) {
  if(browse) browser()

  if(!col1 %in% names(df_))
    stop("Can't find col1", col1,"\n")
  ind <- which(col1 %in% names(df_))[1]
  df_t <- cbind(col1_new=names(df_)[-ind],
                as.data.frame(t(as.matrix(df_[-ind]))),
                stringsAsFactors=F)
  names(df_t)    <- c(col1_new, df_[[ind]])
  rownames(df_t) <- 1:nrow(df_t)
  return(df_t)
}

# if a is a permutation of b
# returns ord such that
# a[ord] == b
# dies if a not a perm of b
order_a2b <- function(a, b, null_on_fail=F, browse=F) {
  if(browse) browser()
  if(!is.vector(a))
    if(null_on_fail) return(NULL)
    else stop("a is not a vector\n")
  if(!is.vector(b))
    if(null_on_fail) return(NULL)
    else stop("b is not a vector\n")
  if(length(a) != length(b))
    if(null_on_fail) return(NULL)
    else stop("length(a)=",length(a)," != length(b)=",length(b),"\n")
  ord_a <- order(a)
  ord_b <- order(b)
  if(!vsame(a[ord_a], b[ord_b]))
    if(null_on_fail) return(NULL)
    else stop("Entries of a and b don't match\n")
  ord <- ord_a[order(ord_b)]
  if(!vsame(a[ord], b))
    if(null_on_fail) return(NULL)
    else stop("Entries of a[ord] and b don't match (this shouldn't happen)\n")
  return(ord)
}

# check if two vectors are the same
# type conversions are allowed, ie, "2" == 2
vsame <- function(a, b, verbose=T) {
  if(!is.vector(a)) {
    if(verbose) cat("vsame: a is not a vector\n")
    return(FALSE)
  }
  if(!is.vector(b)) {
    if(verbose) cat("vsame: b is not a vector\n")
    return(FALSE)
  }
  if(length(a) != length(b)) {
    if(verbose) cat("vsame: a and b don't have the same length\n")
    return(FALSE)
  }
  na_a <- is.na(a)
  if(any(na_a != is.na(b))) {
    if(verbose) cat("vsame: a and b don't have the same NA pattern\n")
    return(FALSE)
  }
  if(verbose && !all(a[!na_a] == b[!na_a]))
     cat("vsame: a and b have a mismatch\n")
  return(all(a[!na_a] == b[!na_a])) 
}

# regex  - describes reg expressions
# gsub   - describes grep, sub, gsub, regexpr, ...
# trims all leading or trailing white space
trim_space <- function(v_) {
  ls_ <- regexpr('^\\s+', v_, perl=T)
  ts_ <- regexpr('\\s*$', v_, perl=T) # always matches
  a_ <- ifelse(ls_>0, attr(ls_,"match.length")+1, 1)
  b_ <- ifelse(ts_>0, ts_-1, 1)
  return(substr(v_, a_, b_))
}

# trims a leading or trailing double quote (only one leading and one trailing)
trim_quotes <- function(v_) {
  ls_ <- regexpr('^\\"', v_, perl=T)
  ts_ <- regexpr('(\\"?)$', v_, perl=T) # always matches
  a_ <- ifelse(ls_>0, attr(ls_,"match.length")+1, 1)
  b_ <- ifelse(ts_>0, ts_-1, 1)
  return(substr(v_, a_, b_))
}

#p_ <- (0:100)/100
#max(p_ - ilogit(logit(p_)))

# transform [0,1] to [eps, 1-eps]
logit <- function(p, eps=1e-10) {
  p_ <- eps + (1-2*eps)*p
  return( log(p_/(1-p_)) )
}

# inverse logit then inverse transform
ilogit <- function(logit, eps=1e-10) {
  e_  <- exp(logit)
  if(e_>1)
    il_ <- 1/(1+1/e_)
  else
    il_ <- e_/(1+e_)
  return( (il_ - eps)/(1-2*eps) )
}

is_a_char_string <- function(s_, browse=F) {
  if(browse) browser()

  if(!is.character(s_)) # how to recognize a string?
    return(FALSE)
  if(typeof(s_) != "character")
    return(FALSE)
  if(!is.vector(s_, mode="character"))
    return(FALSE)
  if(length(s_) != 1)
    return(FALSE)
  return(TRUE)
}

df_or_file <- function(df, skip=-1, sep="\t", comment.char="",
                       quote = "\"", check.names=T, browse=F) {
  if(browse) browser()

  if(is.data.frame(df))
    return(df)
  # check if a char string
  f_ <- df
  if(!is_a_char_string(f_))
    stop("Must supply a data.frame or a file path")
  if(file.access(f_, mode=0) != 0) # Unix return value
    stop("Can't find file:", f_)
  if(file.access(f_, mode=4) != 0) # Unix return value
    cat("File is not readable ... trying anyway\n")
  df <- read.table(f_, header=T, sep=sep, quote=quote, skip=skip,
                   comment.char=comment.char,
                   check.names =check.names, stringsAsFactors = F)
  return(df)
}

# x  - a character vector
# returns a boolean vector
# is parsible date for each entry
# NAs   - are returned FALSE
# TRUE  - is a date
# FALSE - not parsible
is_date <- function(x, format="%d-%b-%Y") {
#  return(ifelse(is.na(x), NA,
#                ifelse(is.na(as.Date(x, format=format)), F, T)))
  return(ifelse(is.na(as.Date(x, format=format)), F, T))
}

dir_trim <- function(dir) {
#  if(dir == "/")
#    return(dir)
  dir %-~% "/+$"  # trim trailing slash
  return(dir)
}

# input  can be a vector
#        it is piped to STDIN a line at a time
try_system <- function(s_cmd, input=NULL, intern=TRUE, browse=F) {
  if(browse) browser()

  ret_ <- try(system(s_cmd, intern=intern, input=input))
  if(class(ret_) == "try_error")
    stop(paste("try_error cmd: ",s_cmd,"\n"))
  return(ret_)
}

##############################

#### Obsolete #####
# dates imported from read.xls are left in integer format
# the origin seems to be "1899-12-30"!
n2date <- function(x, origin="1899-12-30", fmt='%d-%b-%y', del_0=T) {
    d_ <- format(as.Date(as.numeric(x), origin=origin), fmt)
    if(del_0) # delete leading zero
      d_ <- ifelse(substr(d_,1,1)=="0",substr(d_,2,20), d_)
    d_ <- ifelse(x=="", "", d_)
    return(d_)
}

#n2date(c(10742, "", NA, "10742", "10742", "10742", "10742", "14140", "14140"))

#### Obsolete #####
# years have only two digits (Ugh!)
# shift dates after max_year back a century
# assumes format = "%d-%b-%y"
# returns format = "%d-%b-%Y"
shift_date <- function(d_c, max_year, browse=F) {
  if(browse) browser()

  dt_ <- as.Date(d_c, format="%d-%b-%y")     # data object
  # this shifts years < 1969 forward a century
  y_  <- as.numeric(format(dt_, format="%Y"))# year
  m_  <- format(dt_, format="%b")            # month
  d_  <- as.numeric(format(dt_, format="%d"))# day

  # shift years back a century
  y_c <- ifelse(!is.na(y_) & y_>max_year, y_-100, y_) # year corrected
  d_c <- as.Date(paste(d_, m_, y_c,sep="-"), format="%d-%b-%Y")
  d_f <- format(d_c, format="%d-%b-%Y")
  return(d_f)
}





















