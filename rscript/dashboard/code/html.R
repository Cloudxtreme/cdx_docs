
# sets an output file
# used by html_cat
# file="" give standard out (the console)
set_output_file <- function(file, browse=F) {
  if(browse) browser()
  assign(".HTML.file", file, env = .GlobalEnv)
}

# just like the 'cat' function
# but it remembers the output file when
# set by 'set_output_file' above
html_cat <- function(..., sep="", file = get(".HTML.file"), append=TRUE, browse=F) {
  if(browse) browser()
  cat(..., sep=sep, file=file, append=append)
}

html_doctype <- function(doctype=c("html 4.01 transitional",
                                   "html 4.01 strict",
                                   "xhtml 1.0 strict"),
                    browse=F) {
  if(browse) browser()

  doctype <- match.arg(doctype)
  if(doctype=="html 4.01 strict") {
    s_doctype <- "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01//EN\"\n\"http://www.w3.org/TR/html4/strict.dtd\">"
  } else if(doctype=="html 4.01 transitional") {
    s_doctype <- "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n\"http://www.w3.org/TR/html4/loose.dtd\">"
  } else if(doctype=="xhtml 1.0 strict") {
    s_doctype <- "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\"\n\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">"
  }
  return(s_doctype)
}

# sets thecharacter encoding
# this is set in an editor when a file is saved
# this can be problematic
html_char_encoding <- function(charset=c("utf-8", "windows-1252", "ISO-8859-1"), is_xhtml=F, browse=F) {
  if(browse) browser()
  charset <- match.arg(charset)
  self_closing_tag <- ifelse(is_xhtml, "/","")
  s_charset <- paste("<meta http-equiv=\"content-type\" content=\"text/html;charset=",
                     charset, "\"", self_closing_tag,">", sep="")
  return(s_charset)
}

# replacement for the similar function in the R2HTML package
# but clears out a lot of junk
# Title        - sets the title, which appears on the tab and the top of the browser
# js_include   - vector of strings to insert into the head section (eg java script)
html_init_file <-
  function (filepath="", #outdir = tempdir(), filename = "index", extension = "html", 
            Title = "Title", CSSFile = "style.css", useLaTeX = FALSE,
            js_include = "",
            doctype=c("html 4.01 transitional", "html 4.01 strict", "xhtml 1.0 strict"),
            charset=c("utf-8", "windows-1252", "ISO-8859-1"),
            browse=F) {
  if(browse) browser()

  doctype   <- match.arg(doctype)
  s_doctype <- html_doctype(doctype)
  is_xhtml  <- tolower(substr(doctype,1,1)) ==  "x"
  self_closing_tag <- ifelse(is_xhtml, "/","")

  if(is_xhtml) {
    s_xml_ns <- " xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\""
  } else {
    s_xml_ns <- ""
  }
  s_lang   <- " lang=\"en\""

  charset   <- match.arg(charset)
  s_meta_charset <- html_char_encoding(charset, is_xhtml=is_xhtml)

  s_css <- paste("<link rel=\"stylesheet\" href=\"", CSSFile, 
                 "\" type=\"text/css\"", self_closing_tag,">", sep = "")
  
  if(useLaTeX) {
    s_latex_ns     <- " xmlns:mml=\"http://www.w3.org/1998/Math/MathML\""
    s_latex_script <- "<object id=\"mathplayer\" classid=\"clsid:32F66A20-7614-11D4-BD11-00104BD3F987\"></object>\n<?import namespace=\"mml\" implementation=\"#mathplayer\"?>\n<script type=\"text/javascript\" src=\"ASCIIMathML.js\"></script>"
    s_latex_body   <- " onload=\"translate()\""
  } else {
    s_latex_ns     <- ""
    s_latex_script <- ""
    s_latex_body   <- ""
  }
  
  if(is.null(filepath))
    stop("filepath is null\n")
  file <- filepath
  #    filepath <- file.path(outdir, paste(filename, ".", extension, sep = ""))
  set_output_file(filepath, browse=F) # assign(".HTML.file", filepath, env = .GlobalEnv)

  # write the doc type
  html_cat(s_doctype, "\n", append=FALSE) # start the file

  # open the html tag
  txt <- c("<html",
           s_xml_ns,
           s_latex_ns,
           s_lang,
           ">\n") 
  html_cat(txt)
  
  txt <- c("<head>\n",
           s_meta_charset, "\n",
           "<title>", Title, "</title>\n",
           s_css, "\n",
           s_latex_script, "\n",
           js_include,
           "</head>\n")
  html_cat(txt)

  # open the body
  txt <- c("<body",
            s_latex_body,
            ">\n")
  html_cat(txt)
}


set2fail <- function(x, b_) {
  x <- as.character(x)
  if(length(x) != length(b_))
    stop("Length of x and b_ not the same\n")
  x[b_] <-paste("<span class='fail'>",x[b_],"</span>", sep="")
  return(x)
}


# x  is a character vector
# replaces occurrences of "fail" with "<span class='fail'>Fail</span>"
# case insensitive
true2pass <- function(x) {
  if(is.logical(x))
    return(ifelse(is.na(x), x, ifelse(x, "Pass", "<span class='fail'>Fail</span>")))
  b_    <- is.na(x) | tolower(x) %in% c("f", "false")
  x[b_] <- "<span class='fail'>Fail</span>"
  b_    <- is.na(x) | tolower(x) %in% c("t", "true")
  x[b_] <- "Pass"
  return(x)
}

# creates the interior of an html table from a vector or list of strings
# doesn't adjoint the table tags
# fills by row by default (not as with matrices)
list2html_table <- function(lst, ncol, byrow=T, browse=F) {
  if(browse) browser()

  if(length(lst)<= 0)
    return("")
  if((ncol <= 0) || (length(lst)%% ncol))
    stop("List length is not a multiple of the column number\n")
  if(!byrow) { # transpose the matrix
    mat_ <- matrix(unlist(lst), nrow=ncol, byrow=T) # fills by column
    lst  <- as.vector(mat_)
  }
  v_ <- character(length(lst))
  col <- 1
  for(ii in 1:length(lst)) {
    s_ <- ""
    if(col==1) {
      s_ <- "<tr>"
    } 
    s_ <- paste(s_, "<td>", lst[[ii]],"</td>", sep="")
    if(col==ncol) {
      s_ <- paste(s_, "</tr>\n", sep="")
      col <- 0
    }
    v_[ii] <- s_
    col <- col + 1
  }

  s_ <- paste(v_, collapse="")
  return(s_);
}

# this inserts a plot with a caption
# the caption can be above or below the plot
# both plot and caption are centered in the window
# return_str=T returns the actual html snippet as a string
html_insert_plot <- function(file, caption=NULL, caption_top=FALSE,
                             is_xml=FALSE, return_str=FALSE, browse=F) {
  if(browse) browser()

  if(!is.null(caption)) {
    s_caption <- c("<span class=\"image_caption\">",caption,"</span>\n")
    title <- caption # use the caption for the title
  } else {
    s_caption <- c("")
    title <- file    # use the filepath if the there's no caption
  }

  s_ <- "<p>\n"
  if(caption_top)
    s_ <- c(s_, s_caption)
  
  s_ <- c(s_, "<img class=\"image\" src=\"",file,"\"\ntitle=\"",title,
              "\" alt=\"",title,"\"", ifelse(is_xml, " />\n", ">\n"))

  if(caption_top)
    s_ <- c(s_, "</p>\n")
  else
    s_ <- c(s_, s_caption, "</p>\n")

  if(return_str)
    return(paste(s_, collapse=""))
  
  html_cat(s_)
}

# this left or right justifies a plot and caption
#
# this is clumsy as you need to set the width of the plot and 
# caption in the style sheet in the .image_left or .image_right entry
#
# to center a plot and caption just use html_insert_plot
# which gives simpler html code
html_insert_plot_justify <- function(file, caption=NULL, caption_top=FALSE,
                                     align=c("center","left","right"), is_xml=FALSE, 
                                     browse=F) {
  if(browse) browser()

  align <- match.arg(align)
  class_ <- paste("image_", align, sep="")
  if(align == "center")
    s_ <- c()
  else
    s_ <- c("<div class=\"",class_,"\">\n")

  s_image <- html_insert_plot(file, caption=caption, caption_top=caption_top,
                              return_str=TRUE, is_xml=is_xml, browse=F)
  s_ <- c(s_, s_image)
  
  if(align != "center")
    s_ <- c(s_, "</div>\n")
          
  html_cat(s_)
}
