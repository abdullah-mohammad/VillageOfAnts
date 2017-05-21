


public class StorageFood extends Event{

	private int amunt;
	
	public StorageFood(Ant sender,int amunt) {
		super("Food has been deposited by "+sender.getNameAnt(), sender);
		this.amunt = amunt;
	}

	@Override
	public void action(Colonial colonial) {
		
		colonial.setFoodAmount(colonial.getFoodAmount() + this.amunt);
	}

	public int getAmunt() {
		return amunt;
	}

	public void setAmunt(int amunt) {
		this.amunt = amunt;
	}
	
}
