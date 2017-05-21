

public class Queen extends Ant{
	
	private int BirthCycle;
	
	
	public Queen(Colonial colonial){
		
		super("Queen",999999,0,colonial);	
		
		this.BirthCycle = 0;
	}
	
	public int getBirthCycle() {
		return BirthCycle;
	}

	public void setBirthCycle(int birthCycle) {
		BirthCycle = birthCycle;
	}
	
	@Override
	public void newCycle(Colonial colonial){
		
		BirthCycle++;
		

		if (BirthCycle == 5){
			BirthCycle = 0;
			Event event = new Birth(this);
			System.out.println("The queen gives birth to new ants");
			BoxEvent.getInstance().addEvent(event);
		}
		
		if (colonial.getFoodAmount() > 0) {
			
			colonial.setFoodAmount(colonial.getFoodAmount() - 1);
			
		}
		
	}

}
