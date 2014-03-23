
install.packages("multicore")


$ R

source("./code/ccad_dash.R", chdir=T)
f_ <- "./data/32924.csv"
df_d <- read.csv(f_, as.is=T, strip.white=T)

str(df_d)

d_out <- "."
f_out_suffix <- ""
ret_ <- cas_dashboard(df_d,
               d_out        = d_out,
               f_out_suffix = f_out_suffix,
               acc_pc       = "POS",
               acc_nc       = "NEG",
               acc_ex       = c(),
               acc_w        = c("Water", "WATER", "_W"),
               html_out     = F,
               d_html       = "../html",
               browse       = F)


Output dir:
  ./plots_1 
  ./ccad_diagnostics_2012-06-15_1.html 

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
getwd()
"/home/cchou/QCScript/dashboard"

