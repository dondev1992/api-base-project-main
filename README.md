# Payment Processor Service

  ### Purpose
  This service serves as a mock payment processing service that associates use to simulate calling a
  credit card processing API.  It has some basic validation for required fields and randomly declines
  a percentage of otherwise valid requests so associates can handle declines gracefully.

  ### Getting Started
  By default this service starts up on 8084 but you can override on the commandline by specifying `-Dserver.port=8084`

  Package the jar, then run:
```  
  java -jar payment-processor-service-1.0-SNAPSHOT.jar 
```

  ### Endpoint
  One post endpoint exposed at `/payments`

  #### Request Body
```
{
	"creditCardNumber": "4111111111111111",
	"expirationMonth": 11,
	"expirationYear": 2020,
	"securityCode": 123,
	"chargeAmount": 99.99,
	"correlationGuid": "asdfasdfasdf"
}
```
  #### Response Body
```
{
    "status": "Success",
    "errors": [],
    "processDate": "2020-06-16",
    "correlationGuid": "asdfasdfasdf"
}
```