package resources;

public enum ResourcesAPI {

	
	addPlaceAPI("maps/api/place/add/json"),
	getPlaceAPI("maps/api/place/get/json"),
	deletePlaceAPI("maps/api/place/delete/json");
	
	private String resource;
	
	ResourcesAPI(String resource) {
		
		this.resource = resource;
	}
	
	public String getResource() {
		
		return resource;
		
	}
	
	
}
