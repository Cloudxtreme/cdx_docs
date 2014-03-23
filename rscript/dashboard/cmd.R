

#source("/home/jblanchard/hdrive/projects/code/ccad_batch.R")
#source("/home/jblanchard/hdrive/projects/code/ccad_html.R", chdir=T)
#source("/home/jblanchard/hdrive/projects/code/utils.R")

source("./code/ccad_dash.R", chdir=T)

###############
# run diagnostics from dashboard

# dashboard data files
# /pdrive/For_Phil/dashing/


f_ <- "./data/32924.csv"
df_d <- read.csv(f_, as.is=T, strip.white=T)
#'data.frame':	3279 obs. of  18 variables:
# $ rnax_date          : chr  "2012-03-01" "2012-03-01" "2012-03-01" "2012-03-01" ...
# $ batch_id           : chr  " A/32924" " A/32924" " A/32924" " A/32924" ...
# $ container_id       : chr  " AR009501" " AR009501" " AR009501" " AR009501" ...
# $ well               : int  1 2 3 4 5 6 7 8 9 10 ...
# $ oligo              : chr  " GXP-000120-AF289562" " GXP-000120-AF289562" "  ...
# $ trf                : chr  " TRF78326" " TRF78327" " TRF78326" " TRF78327" ...
# $ cp_run_id          : int  50105 50106 50105 50106 50105 50106 50105 50106 ...
# $ cp_value           : num  33.7 34.3 24.8 23.3 35.7 ...
# $ cp_normalized_value: num  33.4 34.3 24.8 23.3 36.3 ...
# $ cp_offset          : logi  NA NA NA NA NA NA ...
# $ cp_sd              : num  0.26071 0.30075 0.00266 0.04467 0.82475 ...
# $ gender             : chr  " Male" " Male" " Male" " Male" ...
# $ dob                : chr  " 1969-12-20" " 1958-08-29" " 1969-12-20" " 1958-08-29" ...
# $ age                : int  42 53 42 53 42 53 42 53 42 53 ...
# $ dst                : chr  " 2012-02-28" " 2012-02-28" " 2012-02-28" " 2012-02-28" ...
# $ rnax_kit_lot       : chr  " CDL001981" " CDL001981" " CDL001981" " CDL001981" ...
# $ rt_kit_lot         : chr  " CDL001991" " CDL001991" " CDL001991" " CDL001991" ...
# $ plate_kit_lot      : chr  " CDL001986" " CDL001986" " CDL001986" " CDL001986" ...

# b_ <- sapply(df_, is.character)
# df_[b_] <- lapply(df_[b_], trim_space)


table(df_d$batch_id)
# A/32924 
#    3279

# break up by Cork

count_corks(df_d)
# 1

lst_ <- data_by_cork(df_d, browse=F)

length(lst_)
# 1

# can process only one cork at a time


table(df_d$batch_id)
# 1 batch

table(df_d$container_id)
# AR009501  AR009503  AR009511  AR009517  AR009521  AR009525  AR009528  AR014952 
#      380       239       380       380       380       380       380       380 
# AR014953 
#      380 

# 9 plates

table(df_d$trf)
#    NEGCONTROL_10FEB2012  POSCONTROL_CDL002029_01                 TRF13271 
#                      36                      188                       47 
#                TRF26836                 TRF26840                 TRF51051 
#                      47                       47                       47 
# ...



data <- reset_names(df_d, browse=F)
data$Gene <- oligo2gene(data$oligo, browse=F)


df_age <- extract_df_age(data, c("NEG"), c("POS"), browse=F)

#
df_offset <- extract_lot_offset(data, browse=F)

is_gene_profile(df_offset, field="Cp_delta", browse=F)


d_out <- "."
f_out_suffix <- "_1"
ret_ <- cas_dashboard(df_d,
              d_out        = d_out,
              f_out_suffix = f_out_suffix,
              acc_pc       = "POS",
              acc_nc       = "NEG",
              acc_ex       = c(),
              acc_w        = c("Water", "WATER", "_W"),
              html_out     = T,
              d_html       = "../html",
              browse       = F)


df_ <- plot_table (ret_, browse=T)

df_ <- data_table (ret_, browse=F)

lst_ <- data_list(ret_)

# need .css, javascript code -> ./html/

ret_b <- cas_d2_batch(ret_$ret_cas$df_all, ret_$ret_cas$params, browse=T)


"<table>\n",
"<col span='1'></col>\n",
data2html_table(tbl_lst$df_table, use.rownames=F, browse=F),
"</table>\n",


data2html_table(lst_[[1]], use.rownames=F, browse=F)

