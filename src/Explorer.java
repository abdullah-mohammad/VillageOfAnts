


public class Explorer extends Ant{

	public static int numberOfExplorer = 1;

	public Explorer(Colonial colonial){
		super("Explorer "+numberOfExplorer,100,1,colonial);
		numberOfExplorer++;
		//System.out.println("Creat an ant "+this.getNameAnt());
	}
	
	@Override
	public void newCycle(Colonial colonial){
	if (this.isActive()){
			
			if(this.isOutColonial()){
				
				if(this.getPosition() == 0){
					
				}
				else if (this.getPosition() > 0 && this.getPosition() < colonial.getLocations().getLocations()[this.getSiteChoix()].getDistance()) {
					
				}
				else{
					
				}
			}
			else{
				
				if (this.getPosition() <= colonial.getLocations().getLocations()[this.getSiteChoix()].getDistance() && this.getPosition() > 0){
					
				} 
				else {
					
					this.setOutColonial(true); 
					this.setPosition(0);	
					this.setNumberCycles(this.getNumberCycles() - 1);
				}
			}
		}
		else {
			
			if (!this.isSupported()) {
					
			}
		}
	}
	
}
