#
# This is a Shiny web application. You can run the application by clicking
# the 'Run App' button above.
#
# Find out more about building applications with Shiny here:
#
#    http://shiny.rstudio.com/
#

library(shiny)

source("loanPrediction.R")
test<-''
# Define UI for application that draws a histogram
ui <- shinyUI(fluidPage(
  
  # Application title
  titlePanel("Loan Prediction in R"),
  actionButton("PredictButton", "PredictButton"),
  actionButton("refreshButton", "Refresh"),
  # Show a plot of the generated distribution
  mainPanel(column(ncol(testData())-1, dataTableOutput('table')))
  
))

# Define server logic required to draw a histogram
server <- shinyServer(function(input, output) {
  output$table <- renderDataTable(testData() )
  #predict
  observeEvent(input$PredictButton , {
    print('Predict event')
    output$table <- renderDataTable(predictOutput())
    
  })
  
  
  observeEvent(input$refreshButton, {
    output$table <- renderDataTable(testData())
    
  }) 
})

# Run the application 
shinyApp(ui = ui, server = server)

