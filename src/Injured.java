
import java.util.Enumeration;

public class Injured extends Event{

	private int index;
	
	public Injured(Ant sender , int index) {
		
		super("The Ant " + sender.getNameAnt() + " Is injured", sender);
		this.index = index;
		
	}

	@Override
	public void action(Colonial colonial) {
		
		Enumeration<Integer> eNumberAnt = colonial.getNumberAnt().keys();
		
		while(eNumberAnt.hasMoreElements()){
			int key = eNumberAnt.nextElement();
			if(colonial.getNumberAnt().get(key) instanceof Healer){
				if (!((Healer) colonial.getNumberAnt().get(key)).getActive()) {
					colonial.getNumberAnt().get(key).setSiteChoix(this.getIndex());
					((Healer) colonial.getNumberAnt().get(key)).setActive(true);
					this.getSender().setSupported(true);
					
					break;
				}
			}
			
		}
	}
	
	public int getIndex() {
		return index;
	}
	
	public void setIndex(int index) {
		this.index = index;
	}
}
