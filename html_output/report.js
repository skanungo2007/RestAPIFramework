$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/features/placeValidation.feature");
formatter.feature({
  "name": "Validating Add Place (Maps) API",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Verify Delete Place functionality",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@DeletePlace"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Delete Place Payload",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinitions.delete_Place_Payload()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User calls \"deletePlaceAPI\" using \"DELETE\" http request",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinitions.user_calls_using_http_request(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should get a valid response with response code 200",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.user_should_get_a_valid_response_with_response_code(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "\"status\" in response body is \"OK\"",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.in_response_body_is(String,String)"
});
formatter.result({
  "status": "passed"
});
});