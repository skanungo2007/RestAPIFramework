package testData;

import java.util.ArrayList;
import java.util.List;

import pojo.DeletePlace;
import pojo.LocationPojo;
import pojo.PlacePojo;

public class TestData {

	
	public PlacePojo addRequest(String name, String address, String phone) {
		
		PlacePojo place = new PlacePojo();
		
		place.setAccuracy(50);
		place.setName(name);
		place.setLanguage("English-IN");
		place.setAddress(address);
		place.setPhone_number(phone);
		place.setWebsite("https://www.frontlineshops.com");
		
		
		LocationPojo loc = new LocationPojo();
		loc.setLat(-38.383494);
		loc.setLng(33.427362);
		place.setLocation(loc);

		
		List<String> type = new ArrayList<String>();
		type.add("PC Center");
		type.add("Shop");
		place.setTypes(type);
		
		
		System.out.println("********************************");
		System.out.println("Latitude: " + place.getLocation().getLat());
		System.out.println("Longitude: " + place.getLocation().getLng());
		System.out.println("Accuracy: " + place.getAccuracy());
		System.out.println("Name: " + place.getName());
		System.out.println("Phone: " + place.getPhone_number());
		System.out.println("Address: " + place.getAddress());
		System.out.println("WebSite: " + place.getWebsite());
		System.out.println("Language: " + place.getLanguage());
		
		for(int i=0; i<type.size(); i++) {
			
			System.out.println(place.getTypes().get(i)); //or use type.get(i);
		}
		
		System.out.println("********************************");
		
		System.out.println();
		
		return place;
	}
	
	
	public DeletePlace deleteDataRequest(String placeId) {
		
		DeletePlace delPlace = new DeletePlace();
		
		delPlace.setPlace_id(placeId);
		
		return delPlace;
	}
}
