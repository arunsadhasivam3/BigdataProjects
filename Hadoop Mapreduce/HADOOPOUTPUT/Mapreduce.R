#! /usr/bin/env Rscript
# map.R

library(stringdist, quietly=TRUE)

input <- file("stdin", "r")

while(length(line <- readLines(input, n=1, warn=FALSE)) > 0) {
   # in case of empty lines
   # more sophisticated defensive code makes sense here
   if(nchar(line) == 0) break
  
   fields <- unlist(strsplit(line, ","))
    
   # extract 2-grams
   d <- qgrams(tolower(fields[4]), q=2)
  
   for(i in 1:ncol(d)) {
     # language / 2-gram / count
     cat(fields[2], "\t", colnames(d)[i], "\t", d[1,i], "\n")
   }
}

close(input)

#! /usr/bin/env Rscript
# reduce.R

input <- file("stdin", "r")

# initialize variables that keep
# track of the state

is_first_line <- TRUE

while(length(line <- readLines(input, n=1, warn=FALSE)) > 0) {
   line <- unlist(strsplit(line, ","))
 
   # current line belongs to previous
   # line's key pair
   if(!is_first_line && 
      prev_lang == line[1] && 
      prev_2gram == line[2]) {
        sum <- sum + as.integer(line[3])
   }
   # current line belongs either to a
   # new key pair or is first line
   else {
     # new key pair - so output the last
     # key pair's result
     if(!is_first_line) {
       # language / 2-gram / count
       cat(prev_lang,"\t",prev_2gram,"\t",sum,"\n")
     } 
 
     # initialize state trackers
     prev_lang <- line[1]
     prev_2gram <- line[2]
     sum <- as.integer(line[3])
     is_first_line <- FALSE
   }
}

# the final record
cat(prev_lang,"\t",prev_2gram, "\t", sum, "\n")

close(input)