
import java.util.ArrayList;

public class Locations {

	private FoodLocation [] locations;

	public Locations(){
		this.locations = InitLocations();
	}
	
	private FoodLocation[] InitLocations() {
		ArrayList<FoodLocation> locationsArrayList = new ArrayList<>();
		FoodLocation [] locationsInit;
		
		for (int i=1 ; i<=5 ; i++) { 
			locationsArrayList.add(new FoodLocation(i));
		}
		
		locationsArrayList.toArray(locationsInit = new FoodLocation[locationsArrayList.size()]);
		
		return locationsInit;
	}

	public FoodLocation [] getLocations() {
		return locations;
	}

	public void setLocations(FoodLocation [] locations) {
		this.locations = locations;
	}
	
}
