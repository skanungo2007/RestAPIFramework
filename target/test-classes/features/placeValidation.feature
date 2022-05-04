Feature: Validating Add Place (Maps) API

	@AddPlace
	Scenario Outline: Verify Maps functionality
		Given Add Place Payload with "<name>" "<address>" and "<phone>"
		When User calls "addPlaceAPI" using "POST" http request
		Then User should get a valid response with response code 200
		And "status" in response body is "OK"
		And "scope" in response body is "APP"
		Then Verify the "<name>" for the placeId using "getPlaceAPI" with "GET" http request
		#And User finally delete the place using "deletePlaceAPI" with "DELETE" http request
		
		Examples:
		|	name				|	address					|	phone			|
		|	Frontline Mobile	|	GC Avenue, Kolkata		|	+91 7845625521	|
		#|	Frontline Desktop	|	Esplandae, Kolkata		|	+91 8455622003	|
		#|	Frontline Laptop	|	Chadni Chowk, Kolkata	|	+91 6258654545	|
		
		
	@DeletePlace
	Scenario: Verify Delete Place functionality
		Given Delete Place Payload
		When User calls "deletePlaceAPI" using "DELETE" http request
		Then User should get a valid response with response code 200
		And "status" in response body is "OK"
		
		
	