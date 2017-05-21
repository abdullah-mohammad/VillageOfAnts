


public class FoodLocation {
	
	private String name;
	private int amunt;
	private int distance;
	
	private static int numberLocation = 1;
	
	
	public FoodLocation(int distance){
		this.name = ("Location " + numberLocation);
		this.amunt = 200;
		this.distance = distance;
		numberLocation++;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAmunt() {
		return amunt;
	}


	public void setAmunt(int amunt) {
		this.amunt = amunt;
	}


	public int getDistance() {
		return distance;
	}


	public void setDistance(int distance) {
		this.distance = distance;
	}
}
