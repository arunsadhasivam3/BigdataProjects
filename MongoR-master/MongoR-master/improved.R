library(devtools)
library(rmongodb)
library(plyr)
library(dplyr)
library(gdata) 
imputeMissingValue<-function(df){
  
  #KNN computes only for the numeric value not for the Char
  #use KNN as such since 2 function similar name is there
  #kNN imputation is correct function name
  #change non-numeric to numeric first and than impute
  library(VIM)
  
  
  df$Dependents<-as.integer(df$Dependents)
  #df[df$Dependents=='','Dependents'] <- 'NA'
  df[df$Dependents=='3+','Dependents'] <- '3'
  df$Dependents<-as.factor(df$Dependents)
  
  df$Gender=as.integer(df$Gender)
  df$Gender=as.factor(df$Gender)
  
  
  df$Self_Employed=as.integer(df$Self_Employed)
  df$Self_Employed=as.factor(df$Self_Employed)
  
  df$Married=as.integer(df$Married)
  #since test does not have '' showing error when
  #predicting ,hence commented 
  #Error when uncommented:"Type of predictors in new data do not match that of the training data"
  #df$Married=as.factor(df$Married)
  
  df$CoapplicantIncome <- as.integer( df$CoapplicantIncome)
  
  #df$Loan_Status   <- as.integer( df$Loan_Status  )
  
  df<- kNN(df,variable=c('Gender','Self_Employed','Married',
                         'Credit_History','Loan_Amount_Term',
                         'LoanAmount','CoapplicantIncome'))
  
  
  ##NOTE:
  ## when reading from db  make sure that data types are correclty mapped.
  # sicne it by default takes char
  # need to manually map to appropriate data type
  
  df$ApplicantIncome   <- as.integer( df$ApplicantIncome  )
  df$CoapplicantIncome   <- as.integer( df$CoapplicantIncome  )
  df$LoanAmount   <- as.integer( df$LoanAmount  )
  df$Loan_Amount_Term   <- as.integer( df$Loan_Amount_Term  )
  df$Credit_History   <- as.integer( df$Credit_History  )
  df$Loan_Status   <- as.factor(( df$Loan_Status  ))
  
  
  return(df)
}

library(data.table)

#combinedTable<-data.table(combined)






dbSelect <- function(export,collection){
  
  print(collection)
  ####1.count of records
  totRec<-mongo.count(mongo, collection)
  totRec
  
  
  ####2.list  of all records in table
  query <- mongo.bson.empty()
  #rec<-mongo.find(mongo,coll,query = query,limit=100L)
  cursor <- mongo.find(mongo, collection, query)
  # Step though the matching records and display them
  while (mongo.cursor.next(cursor)){
    tmp = mongo.bson.to.list(mongo.cursor.value(cursor))
    tmp.df = as.data.frame(t(unlist(tmp)), stringAsFactors = FALSE)
    export = rbind.fill(export, tmp.df)
    
  }
  mongo.cursor.destroy(cursor)
  
  return (export)
}


# create a mongo.bson { _id : (Object ID) id }
#   for searching a collection to find the record with given the id
bson_id <- function(id) {
  buf <- mongo.bson.buffer.create()
  mongo.bson.buffer.append(buf, "_id", id)
  mongo.bson.from.buffer(buf)
}




mongo <- mongo.create()
print(mongo.get.err(mongo))
if(mongo.is.connected(mongo) == TRUE) {
  #export = data.frame(stringsAsFactors =false )
  #
  export = data.frame()
  train<-dbSelect(export,'analytics.loan_prediction_train')
  names(train)
  
  test<-dbSelect(export,'analytics.loan_prediction_test')
  names(test)
  
  #fmt_test<-data.frame(Loan_Status=rep("N" ,nrow(test)),test[,]); 
  test$Loan_Status<-'N'
  test$Loan_ID<-test$"_id"
  combined<-rbind(test,train)
  
  ###train
  
  train<-combined[368:981,]
  test<-combined[1:367,]
  
  
  ###########train data formatting
  
 dfNames <- c("Loan_ID","Gender", "Married" ,"Dependents","Education",
                  "Self_Employed","ApplicantIncome","CoapplicantIncome",
                  "LoanAmount","Loan_Amount_Term","Credit_History",
                  "Property_Area","Loan_Status")
  library(dplyr)
  train<-imputeMissingValue(train)
  train<-dplyr::select(train, 2:14)
  
  #colSums(is.na(train))
  # write.csv(file="fmttrain.csv",train, row.names=F)
   
  #################test
  test<-imputeMissingValue(test)
   test<-dplyr::select(test,2:14)
  #############################4. predict the loan_status
  
   library(randomForest)
   
  str(train)
  str(test)
  set.seed(615)
  
  #ApplicantIncome, CoapplicantIncome, Credit_History, LoanAmount.
  #Rejected 1 attributes: Self_Employed
  formula <- Loan_Status ~ ApplicantIncome +CoapplicantIncome+Credit_History+Loan_Amount_Term+LoanAmount+Self_Employed+
  Property_Area+Married
  colSums(is.na(train))
  fit <- randomForest(formula, data=train,importance=TRUE, ntree=38)
  #colSums(is.na(test))
  pred=predict(fit,test)
  test$Loan_Status=pred
  
  
  
  #check no of Y and N
  
   for( i in 1:5){    
      row<-test[i,]
      rowdata<-''
      for( j in 1: length(row)){
        val<-levels(drop.levels(test[i,j]))
        if(j==1 ){
          rowdata<- paste(val,rowdata, sep="")
        }else{
          rowdata<- paste(rowdata,val, sep="," )
        }
      }
      result = substr(rowdata, 1, nchar(rowdata)-1)
      print(result)
   }
  
  for( i in 1:nrow(test)){  
      row<-test[i,]
      val<- levels(drop.levels(row$Loan_ID))
     # critCmd<-paste("_id="+val,critCmd,sep="=")
      #print(criteria)
      rowdata<-''
     
      for( j in 1: length(row)){
        val<-levels(drop.levels(test[i,j]) )
        cmd<-paste(colnames(test)[j],val,sep="=")
        if(j==1 ){
          rowdata<- paste(cmd,rowdata, sep="")
        }else{
          rowdata<- paste(rowdata,cmd, sep="," )
        }
      }
      result = substr(rowdata, 1, nchar(rowdata)-1)
      
      mongo.update(mongo,'analytics.loan_prediction_test',
                                 list("_id"="LP001015")
                                 ,list(result))
      print(mongo.get.err(mongo))
      print(list(result))
  }
  
  # mongo.update(mongo,'analytics.loan_prediction_test',
  #              list("_id"=val)
  #              ,list(Loan_Status=test[i,j]))
 
  # print(mongo.get.err(mongo))
  
  #11- error means BSON not finished - should not occur with R driver.
  # #############################6. Generate Output
  
 # write.csv(file="output.csv",c(test['Loan_ID'],test['Loan_Status']), row.names=F)
}
