Feature: Sale processor
  
  Scenario: Sale details saved for less than 20 messages
    Given Sale api running on "http://localhost:8080/saleprocessor/sale" url
     And Report folder and data in DB cleansed
    When sale is processed with sale below input
   #|Product type| Price	|Quantity|Http Status Code|
    | Orange	|	1.00	|	1		|	|201|
    | Orange	|	1.00	|	1		|	|201|
    | Orange	|	1.00	|	1		|	|201|
    | Orange	|	1.00	|	1		|	|201|
    | Orange	|	1.00	|	1		|	|201|
    | Grapes	|	1.00	|	1		|	|201|
    | Grapes	|	15.00	|			|ADD|201|
    | Orange	|	1.00	|	1		|	|201|
    | Orange	|	1.00	|	1		|	|201|
    | Orange	|	1.00	|	1		|	|201|
    | Orange	|	1.00	|	1		|	|201|
    | Orange	|	1.00	|	1		|	|201|
    | Orange	|	1.00	|	1		|	|201|
    Then show save trade details
    And check "TEN_MESSAGE_REPORT" report is generated   
    |Grapes,1,16.00|
	|Orange,8,8.00|
    
    Scenario: Sale details saved for less than 30 messages
    Given Sale api running on "http://localhost:8080/saleprocessor/sale" url
    And Report folder and data in DB cleansed
     When sale is processed with sale below input
   #|Product type| Price	|Quantity|Http Status Code|
    | Orange	|	10.10	|	1		|	|201|
    | Orange	|	10.10	|	1		|	|201|
    | Orange	|	10.10	|	1		|	|201|
    | Orange	|	10.10	|	1		|	|201|
    | Orange	|	10.10	|	1		|	|201|
    | Orange	|	10.10	|	1		|	|201|
    | Orange	|	10.10	|			|ADD|201|
    | Orange	|	10.10	|	1		|	|201|
    | Orange	|	10.10	|	1		|	|201|
    | Orange	|	10.10	|	1		|	|201|
    | Orange	|	10.10	|	1		|	|201|
    | Orange	|	10.10	|	1		|	|201|
    | Orange	|	10.10	|	1		|	|201|
    | Orange	|	10.10	|	1		|	|201|
    | Orange	|	10.10	|	1		|	|201|
    | Orange	|	10.10	|	1		|	|201|
    | Orange	|	10.10	|	1		|	|201|
    | Orange	|	10.10	|	1		|	|201|
    | Orange	|	10.10	|	1		|	|201|
    | Orange	|	10.10	|			|ADD|201|
    | Orange	|	10.10	|	1		|	|201|
    | Orange	|	10.10	|	1		|	|201|
    | Orange	|	10.10	|	1		|	|201|
    | Orange	|	10.10	|	1		|	|201|
    | Orange	|	10.10	|	1		|	|201|
    | Orange	|	10.10	|	1		|	|201|
    Then show save trade details
     And check "TWENTY_MESSAGE_REPORT" report is generated  
    |Orange,18,424.20|
	    
     Scenario: Sale details saved for less than 40 messages
    Given Sale api running on "http://localhost:8080/saleprocessor/sale" url
     And Report folder and data in DB cleansed
     When sale is processed with sale below input
   #|Product type| Price	|Quantity|Http Status Code|
    | Orange	|	10.10	|	1		|	|201|
    | Orange	|	10.10	|	1		|	|201|
    | Orange	|	10.10	|	1		|	|201|
    | Orange	|	10.10	|	1		|	|201|
    | Orange	|	10.10	|	1		|	|201|
    | Orange	|	10.10	|	1		|	|201|
    | Orange	|	10.10	|			|ADD|201|
    | Orange	|	10.10	|	1		|	|201|
    | Orange	|	10.10	|	1		|	|201|
    | Orange	|	10.10	|	1		|	|201|
    | Orange	|	10.10	|	1		|	|201|
    | Orange	|	10.10	|	1		|	|201|
    | Orange	|	10.10	|	1		|	|201|
     | Orange	|	10.10	|	1		|	|201|
    | Orange	|	10.10	|	1		|	|201|
    | Orange	|	10.10	|	1		|	|201|
    | Orange	|	10.10	|	1		|	|201|
    | Orange	|	10.10	|	1		|	|201|
    | Orange	|	10.10	|	1		|	|201|
    | Orange	|	10.10	|			|ADD|201|
    | Orange	|	10.10	|	1		|	|201|
    | Orange	|	10.10	|	1		|	|201|
    | Orange	|	10.10	|	1		|	|201|
    | Orange	|	10.10	|	1		|	|201|
    | Orange	|	10.10	|	1		|	|201|
    | Orange	|	10.10	|	1		|	|201|
    | Orange	|	10.10	|	1		|	|201|
    | Orange	|	10.10	|	1		|	|201|
    | Orange	|	10.10	|	1		|	|201|
    | Orange	|	10.10	|	1		|	|201|
    | Orange	|	10.10	|	1		|	|201|
    | Orange	|	10.10	|	1		|	|201|
    | Orange	|	10.10	|			|ADD|201|
    | Orange	|	10.10	|	1		|	|201|
    | Orange	|	10.10	|	1		|	|201|
    | Orange	|	10.10	|	1		|	|201|
    | Orange	|	10.10	|	1		|	|201|
    | Orange	|	10.10	|	1		|	|201|
    | Orange	|	10.10	|	1		|	|201|
    Then show save trade details
     And check "THIRTY_MESSAGE_REPORT" report is generated 
    |Orange,28,525.20|
    
     Scenario: Sale details saved for less than 50 messages
    Given Sale api running on "http://localhost:8080/saleprocessor/sale" url
     And Report folder and data in DB cleansed
     When sale is processed with sale below input
   #|Product type| Price	|Quantity|Http Status Code|
    | Orange	|	1.00	|	1		|	|201|
    | Orange	|	1.00	|	1		|	|201|
    | Orange	|	1.00	|	1		|	|201|
    | Orange	|	1.00	|	1		|	|201|
    | Orange	|	1.00	|	1		|	|201|
    | Grapes	|	1.00	|	1		|	|201|
    | Grapes	|	5.00	|			|ADD|201|
    | Orange	|	1.00	|	1		|	|201|
    | Orange	|	1.00	|	1		|	|201|
    | Orange	|	1.00	|	1		|	|201|
    | Orange	|	1.00	|	1		|	|201|
    | Orange	|	1.00	|	1		|	|201|
    | Orange	|	1.00	|	1		|	|201|
    | Orange	|	1.00	|	1		|	|201|
    | Orange	|	1.00	|	1		|	|201|
    | Orange	|	1.00	|	1		|	|201|
    | Orange	|	1.00	|	1		|	|201|
    | Orange	|	1.00	|	1		|	|201|
    | Orange	|	1.00	|	1		|	|201|
    | Orange	|	1.00	|	1		|	|201|
    | Orange	|	1.00	|	1		|	|201|
    | Orange	|	1.00	|	1		|	|201|
    | Orange	|	1.00	|		1	|   |201|
    | Orange	|	1.00	|	1		|	|201|
    | Orange	|	1.00	|	1		|	|201|
    | Orange	|	1.00	|	1		|	|201|
    | Orange	|	1.00	|	1		|	|201|
    | Orange	|	1.00	|	1		|	|201|
    | Orange	|	1.00	|	1		|	|201|
    | Orange	|	1.00	|	1		|	|201|
    | Orange	|	1.00	|	1		|	|201|
    | Orange	|	1.00	|	1		|	|201|
    | Orange	|	1.00	|	1		|	|201|
    | Orange	|	1.00	|	1		|	|201|
    | Orange	|	1.00	|	1		|	|201|
    | Orange	|	1.00	|			|ADD|201|
    | Orange	|	1.00	|	1		|	|201|
    | Orange	|	1.00	|	1		|	|201|
    | Orange	|	1.00	|	1		|	|201|
    | Orange	|	1.00	|	1		|	|201|
    | Orange	|	1.00	|	1		|	|201|
    | Orange	|	1.00	|	1		|	|201|
    | Orange	|	1.00	|	1		|	|201|
    | Orange	|	1.00	|	1		|	|201|
    | Orange	|	1.00	|	1		|	|201|
    | Orange	|	1.00	|	1		|	|201|
    | Orange	|	1.00	|	1		|	|201|
    | Orange	|	1.00	|	1		|	|201|
    | Orange	|	1.00	|			|ADD|201|
    | Orange	|	1.00	|	1		|	|201|
    | Orange	|	1.00	|	1		|	|201|
    | Orange	|	1.00	|	1		|	|406|
    | Orange	|	1.00	|	1		|	|406|
    | Orange	|	1.00	|	1		|	|406|
    | Orange	|	1.00	|	1		|	|406|
    Then show save trade details
     And check "FORTY_MESSAGE_REPORT" report is generated   
   |Grapes,1,6.00|
   |Orange,37,70.00|