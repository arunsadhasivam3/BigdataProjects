library(devtools)
library(rmongodb)
library(plyr)
library(dplyr)
library(gdata) 
library(RJSONIO)


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

dbSelect <- function(export,collection){
 
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



trainData<-function(){
  export = data.frame(stringsAsFactors =false )
  export = data.frame()
  train<-dbSelect(export,'analytics.loan_prediction_train')
  
  return (train)
}

testData<-function(){
  export = data.frame(stringsAsFactors =false )
  export = data.frame()
  test<-dbSelect(export,'analytics.loan_prediction_test')
  test$Loan_Status<-'N'
  
  return (test)
}


predictOutput <- function (){
  print('predictOutput:begin')
  train<-trainData()
  test<-testData()
  #test$Loan_ID<-test$"_id"
  combined<-rbind(test,train)
  
  train<-combined[368:981,]
  test<-combined[1:367,]
  
  
  library(dplyr)
  train<-imputeMissingValue(train)
  train$Loan_id <- train$"_id"
  train<-dplyr::select(train, 1:Loan_Status)
  
  
  test<-imputeMissingValue(test)
  test$Loan_id = test$"_id"
  test<-dplyr::select(test,1:13)
  
  library(randomForest)
  
  str(train)
  str(test)
  set.seed(615)
  
  formula <- Loan_Status ~ ApplicantIncome +CoapplicantIncome+Credit_History+Loan_Amount_Term+LoanAmount+Self_Employed+
    Property_Area+Married
  colSums(is.na(train))
  fit <- randomForest(formula, data=train,importance=TRUE, ntree=38)
  
  pred=predict(fit,test)
  test$Loan_Status=pred
  print(test$Loan_Status)
  print('predictOutput:end')
  persistData(test)
  return (test) ## important to return then only in ui it can get and return in rshiny
}



persistData<-function(test){
  print('persistData:begin')
 
 
  for( i in 1:nrow(test)){  
    row<-test[i,]
    print(colnames(row))
    qryvalue<- levels(drop.levels(row$"_id"))
    print(qryvalue)
    #where condition
    buf <- mongo.bson.buffer.create()
    mongo.bson.buffer.append(buf, "_id", qryvalue)
    selQry <- mongo.bson.from.buffer(buf)
    
    rowLength<-length(row)
    buf1 <- mongo.bson.buffer.create()
    for( j in 1:rowLength){
      key=colnames(test)[j]
      cellvalue<-levels(drop.levels(test[i,j]) )
      print(cellvalue)
      
      mongo.bson.buffer.append(buf1, key, cellvalue)
      
    }
    
    
    tableResult <- mongo.bson.from.buffer(buf1)
    mongo.update(mongo,'analytics.loan_prediction_test',
                 selQry
                 ,tableResult)
    print(mongo.get.err(mongo))
    
    
    
  }
  
}



### main ###



mongo <- mongo.create()
print(mongo.get.err(mongo))
if(mongo.is.connected(mongo) == TRUE) {
  print('connected') 
}else{
  print('No connection Available...') 
}

train<-trainData() 
names(train)
test<-testData()
names(test)
 



