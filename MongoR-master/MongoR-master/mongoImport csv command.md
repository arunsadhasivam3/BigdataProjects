mongoimport --db analytics --collection loan_prediction_train --type csv --headerline  --file D:\WorkSpace\MongoDb\train.csv
mongoimport --db analytics --collection loan_prediction_test --type csv --headerline  --file D:\WorkSpace\MongoDb\test.csv


> db.loan_prediction_test.update( {},{$set:{"Loan_Status":"N"}} )
WriteResult({ "nMatched" : 1, "nUpserted" : 0, "nModified" : 1 })

#only if multi: true is given then only it updates all rows.

> db.loan_prediction_test.update( {},{$set:{"Loan_Status":"N"}},{multi:true} )
WriteResult({ "nMatched" : 367, "nUpserted" : 0, "nModified" : 366 })

To update all records Loan_Status to "N" 

 > db.loan_prediction_test.update({},{$set:{Loan_Status:"Y"}}, {multi:true})
WriteResult({ "nMatched" : 367, "nUpserted" : 0, "nModified" : 367 })



