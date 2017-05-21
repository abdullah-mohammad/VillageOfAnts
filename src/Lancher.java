

public class Lancher {

	public static void main(String[] args) {
		Colonial colonial = new Colonial();
		
		colonial.setLocations(new Locations());
		
		
		for (int i=0 ; i < 5 ; i++) {
			colonial.getNumberAnt().put(colonial.getIndexAnt(), new Worker(colonial));
			colonial.getNumberAnt().put(colonial.getIndexAnt(), new Soldier(colonial));
			colonial.getNumberAnt().put(colonial.getIndexAnt(), new Healer(colonial));
			colonial.getNumberAnt().put(colonial.getIndexAnt(), new Explorer(colonial));
		}
		/*
		for (int i=0 ; i < 3 ; i++) {
			colonial.getNumberAnt().put(colonial.getIndexAnt(), new Soldier(colonial));
		}
		
		for (int i=0; i < 2; i++){
			colonial.getNumberAnt().put(colonial.getIndexAnt(), new Healer(colonial));
		}
		
		for (int i=0; i < 1; i++){
			colonial.getNumberAnt().put(colonial.getIndexAnt(), new Explorer(colonial));
		}
		*/
		for (int i = 0; i < 15; i++){
			System.out.println("-- Start of a new cycle --"+i);
			for (int j=0 ; j < colonial.getNumberAnt().size(); j++){
				colonial.getNumberAnt().get(j).newCycle(colonial);
			}
			
			System.out.println("== Event Management");
			
			while(!BoxEvent.getInstance().isEmpty()){
				Event event = BoxEvent.getInstance().getNextEvent();
				System.out.println(event.getMessage());
				event.action(colonial);
			}
			System.out.println("== End of Events");
			System.out.println("-- End of cycle -- \n\n");
		}
	}

}
