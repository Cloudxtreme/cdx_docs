#!/usr/bin/Rscript

args <- commandArgs(TRUE)
print (args)

clid = args[1]

cat("Running CDx QC Script......\n")

source("./code/ccad_dash.R", chdir=T)

f_ <- paste("./data/",clid,".csv",sep="")
df_d <- read.csv(f_, as.is=T, strip.white=T)

str(df_d)

d_out <- paste("./result/","32924",sep="")
f_out_suffix <- ""

system(paste("mkdir -p", d_out), intern=TRUE)

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


