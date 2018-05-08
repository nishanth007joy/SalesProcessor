This act as a spring boot restfull API.
This accepts input for two URI
/salesprocessor/sales
{"price":14.2,"quantity":"10","salesName":"Orange"}

/salesprocessor/sales/operation
{"salesName":"Orange","operation":"ADD","operationAmount":100.1}

Output is logged to console and different reports are created at location \src\main\resources\SalesReport

Feature file for BDD is located at \src\main\resources\SalesReport and we can run feature file for acceptance test
