package stepDefinition;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import junit.framework.Assert;
import pojo.LocationPojo;
import pojo.PlacePojo;
import resources.ResourcesAPI;
import testData.TestData;
import utility.Utility;


public class StepDefinitions {

	Response response;

	static String placeId = null;
	
	RequestSpecification req; 
	ResponseSpecification res; 
	
	TestData data = new TestData();
	Utility utils = new Utility();
	
	
	@Given("Add Place Payload with {string} {string} and {string}")
	public void add_Place_Payload_with_and(String name, String address, String phone) throws IOException {
	    
		String uri = Utility.readKey("uri");
		
		/*
		RequestSpecification request = new RequestSpecBuilder().setContentType(ContentType.JSON).setBaseUri(uri).addQueryParam("key", "qaclick123")
				.addHeader("Content-Type", "application/json").setBody(data.addRequest()).build();
		*/
		
		req = given().spec(utils.requestSpecificationBuilder()).body(data.addRequest(name, address, phone));
		
		

		
	}
	
	
	@When("User calls {string} using {string} http request")
	public void user_calls_using_http_request(String resource, String method) {
	    
		res = utils.responseSpecificationBuilder();
		
		ResourcesAPI resourceAPI = ResourcesAPI.valueOf(resource);
		
		
		if(method.equalsIgnoreCase("post")) {
			
			response = req
					.when().post(resourceAPI.getResource())
					.then().assertThat().spec(res).extract().response();
			
			
			System.out.println();
			System.out.println("**********Add Place***********");
			System.out.println("Time: " + response.getTime());
			System.out.println("Status Code: " + response.getStatusCode());
			System.out.println(response.getStatusLine());
			System.out.println(response.getHeader("Content-Type"));
			System.out.println("******************************");
			System.out.println();
			
			
			
			placeId = utils.getJsonPath(response, "place_id");
			
			System.out.println("Place Added. ID: " + placeId);

			System.out.println();
			
			
		} else if(method.equalsIgnoreCase("get")) {
			
			response = req
					.when().get(resourceAPI.getResource())
					.then().assertThat().spec(res).extract().response();
			
			
			System.out.println();
			System.out.println("**********Get Place***********");
			System.out.println("Time: " + response.getTime());
			System.out.println("Status Code: " + response.getStatusCode());
			System.out.println(response.getStatusLine());
			System.out.println(response.getHeader("Content-Type"));
			System.out.println("******************************");
			System.out.println();
			
			
		} else {
			
			response = req
					.when().delete(resourceAPI.getResource())
					.then().assertThat().spec(res).extract().response();
			
			
			System.out.println();
			System.out.println("**********Delete Place***********");
			System.out.println("Time: " + response.getTime());
			System.out.println("Status Code: " + response.getStatusCode());
			System.out.println(response.getStatusLine());
			System.out.println(response.getHeader("Content-Type"));
			System.out.println("******************************");
			System.out.println();
			
			
		}
		
	
	}

	

	@Then("User should get a valid response with response code {int}")
	public void user_should_get_a_valid_response_with_response_code(int int1) {
		
	    Assert.assertEquals(response.getStatusCode(), int1);

		System.out.println();
		
	}

	@And("{string} in response body is {string}")
	public void in_response_body_is(String key, String value) {
		
		Assert.assertEquals(utils.getJsonPath(response, key), value);
		
		
	}
	

	
	@Then("Verify the {string} for the placeId using {string} with {string} http request")
	public void verify_the_for_the_placeId_using_with_http_request(String expectedName, String resource, String method) throws IOException {
	   
		ResourcesAPI resourceAPI = ResourcesAPI.valueOf(resource);
		
		req = given().spec(utils.requestSpecificationBuilder()).queryParam("place_id", placeId);
		
		//Call the method in the previous lines
		user_calls_using_http_request(resource, method);
		
		
		System.out.println();
		
		String actualName = utils.getJsonPath(response, "name");
		
		System.out.println("Name of Place: " + actualName);
		
		Assert.assertEquals(expectedName, actualName);
		
		System.out.println();
		
	}


	/*
	@Then("User finally delete the place using {string} with {string} http request")
	public void user_finally_delete_the_place_using_with_http_request(String resource, String method) throws IOException {
	    
		ResourcesAPI resourceAPI = ResourcesAPI.valueOf(resource);
		
		req = given().spec(utils.requestSpecificationBuilder()).body(data.deleteDataRequest(placeId));
		
		
		//Call the method in the previous lines
		user_calls_using_http_request(resource, method);
		
		
		System.out.println();
		
		String msg = utils.getJsonPath(response, "status");
		
		Assert.assertEquals("OK", msg);
		
		
	}
	
	*/
	
	@Given("Delete Place Payload")
	public void delete_Place_Payload() throws IOException {
	    
		
		req = given().spec(utils.requestSpecificationBuilder()).body(data.deleteDataRequest(placeId));
		
		
	}

	
	
	
	

}
