


public class Birth extends Event{

	public Birth(Ant sender) {
		super("Ten new ants come in the Colonial", sender);
	}

	@Override
	public void action(Colonial colonial) {
		// TODO Auto-generated method stub		
		for(int i=0;i<5;i++){
			colonial.getNumberAnt().put(colonial.getIndexAnt(),new Worker(colonial));
		}
		
		for(int i=0;i<2;i++){
			colonial.getNumberAnt().put(colonial.getIndexAnt(),new Soldier(colonial));
		}
		
		for(int i=0;i<2;i++){
			colonial.getNumberAnt().put(colonial.getIndexAnt(),new Healer(colonial));
		}
		
		for(int i=0;i<1;i++){
			colonial.getNumberAnt().put(colonial.getIndexAnt(),new Explorer(colonial));
		}
	}
}
