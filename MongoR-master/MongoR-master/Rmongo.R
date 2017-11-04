 library(RMongo)
  mongo <- mongoDbConnect("analytics","127.0.0.1", 27017)
  dbShowCollections(mongo)
  output <- dbGetQuery(mongo, 'loan_prediction_train', '{}')
  dbSetWriteConcern(mongo,1,0,FALSE,FALSE)
  
