package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utility {

	public static RequestSpecification request = null;
	
	
	public static String readKey(String key) throws IOException {
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src/test/java\\config\\config.properties");
		Properties property = new Properties();
		property.load(fis);
		return property.get(key).toString();
		
	}
	
	public static String getJsonPath(Response response, String key) {
		
		
		JsonPath jp = new JsonPath(response.asString());
		
		return jp.get(key).toString();
		
	}
	
	public RequestSpecification requestSpecificationBuilder() throws IOException {
		
		String uri = Utility.readKey("uri");

		//Avoid replacing the log file
		if(request==null) {
			
			PrintStream stream = new PrintStream(new File("log.txt"));
			
			request = new RequestSpecBuilder()
					.setContentType(ContentType.JSON)
					.setBaseUri(uri)
					.addQueryParam("key", "qaclick123")
					.addHeader("Content-Type", "application/json")
					.addFilter(RequestLoggingFilter.logRequestTo(stream))
					.addFilter(ResponseLoggingFilter.logResponseTo(stream))
					.build();
			
			return request;
			
			
		} 
			
		
		return request;

		
	}
	
	
	public ResponseSpecification responseSpecificationBuilder() {
		
		ResponseSpecification resp = new ResponseSpecBuilder()
				.expectStatusCode(200)
				.expectContentType(ContentType.JSON)
				.expectHeader("Content-Type", "application/json;charset=UTF-8")
				.expectHeader("Server", "Apache/2.4.41 (Ubuntu)")
				.build();
		
		return resp;
		
	}
	
	
}
