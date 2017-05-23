


public class Recovery extends Event{
	
	private int index;
	
	
	public Recovery(Ant sender, int index) {
		super("The ant "+sender.getNameAnt()+"To put the ant in the Colonial", sender);
		this.index = index;
	}

	@Override
	public void action(Colonial colonial) {
		
		colonial.getNumberAnt().remove(this.getSender().getSiteChoice());
		((Healer) colonial.getNumberAnt().get(this.getIndex())).setActive(false);
		this.getSender().setSiteChoice(0);
		
	}
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
}
