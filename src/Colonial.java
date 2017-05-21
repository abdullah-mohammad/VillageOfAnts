import java.util.Hashtable;


public class Colonial {

	private Locations locations;
	private int foodAmount;
	private Hashtable<Integer,Ant> numberAnt;
	private int indexAnt;
	
	public Colonial(){
		
		this.locations 	= null;
		this.foodAmount = 0;
		this.indexAnt 	= 0;
		
		this.numberAnt = new Hashtable<>();
		numberAnt.put(this.indexAnt,new Queen(this));
	}

	public Locations getLocations() {
		return locations;
	}

	public void setLocations(Locations locations) {
		this.locations = locations;
	}

	public int getFoodAmount() {
		return foodAmount;
	}

	public void setFoodAmount(int foodAmount) {
		this.foodAmount = foodAmount;
	}

	public Hashtable<Integer,Ant> getNumberAnt() {
		return numberAnt;
	}

	public void setNumberAnt(Hashtable<Integer,Ant> numberAnt) {
		this.numberAnt = numberAnt;
	}

	public int getIndexAnt() {
		return indexAnt;
	}

	public void setIndexAnt(int indexAnt) {
		this.indexAnt = indexAnt;
	}
	
}
