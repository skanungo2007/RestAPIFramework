package stepDefinition;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	
	@Before("@DeletePlace")
	public void generatePlaceId() throws IOException {
		
		StepDefinitions sd = new StepDefinitions();
		
		if(StepDefinitions.placeId==null) {
			
			sd.add_Place_Payload_with_and("Frontline", "Garia, Kolkata", "+91 76040 85216");
			sd.user_calls_using_http_request("addPlaceAPI", "POST");
			sd.user_should_get_a_valid_response_with_response_code(200);
			
			
		}
		
		
	}

}
