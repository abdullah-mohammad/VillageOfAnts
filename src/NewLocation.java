


public class NewLocation extends Event{
	
	private int index;
	
	public NewLocation(Ant sender, int index) {
		super("The ant "+sender.getNameAnt()+" To find a new Food Location", sender);
		this.index = index;
	}

	@Override
	public void action(Colonial colonial) {
		
	}
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

}
