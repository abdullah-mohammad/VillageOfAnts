
import java.util.Enumeration;
import java.util.Random;

public class Worker extends Ant{

	public static int numberOfWorker = 1;
	private int foodTrans;
	
	public Worker(Colonial colonial){
		super("Worker "+numberOfWorker,100,3,colonial);
		
		numberOfWorker++;
		this.foodTrans = 0;
		//System.out.println("Creat an ant "+this.getNameAnt());
	}
	
	@Override
	public void newCycle(Colonial colonial){
		if(this.isActive()){
			if(this.isOutColonial()){
				if(this.getPosition() == 0){
					Random choice = new Random();
					
					this.setSiteChoix(choice.nextInt(colonial.getLocations().getLocations().length));
					this.setPosition(this.getPosition() + this.getSpeed());
					this.setNumberCycles(this.getNumberCycles() - 1);
					
					System.out.println("The Ant  (" + this.getNameAnt() + ") Advance towards (" + colonial.getLocations().getLocations()[this.getSiteChoix()].getName() + ").");
				
				}else if(this.getPosition() > 0 && this.getPosition() < colonial.getLocations().getLocations()[this.getSiteChoix()].getDistance()){
					this.setPosition(this.getPosition() + this.getSpeed());
					this.setNumberCycles(this.getNumberCycles() - 1);
					
					System.out.println("The Ant  (" + this.getNameAnt() + ") Advance towards (" + colonial.getLocations().getLocations()[this.getSiteChoix()].getName() + ").");
					
				}else{
					this.setOutColonial(false);
					this.setFoodTrans(2);
					colonial.getLocations().getLocations()[this.getSiteChoix()].setAmunt(colonial.getLocations().getLocations()[this.getSiteChoix()].getAmunt() - 2);		
					
					this.setPosition(colonial.getLocations().getLocations()[this.getSiteChoix()].getDistance());
					this.setNumberCycles(this.getNumberCycles()- 1);
					
					System.out.println("The Ant  (" + this.getNameAnt() + ") Takes food in the (" + colonial.getLocations().getLocations()[this.getSiteChoix()].getName() + ").");
				
				}
			}else{
				if(this.getPosition() <= colonial.getLocations().getLocations()[this.getSiteChoix()].getDistance() && this.getPosition() > 0){
					
					this.setPosition(this.getPosition() - this.getSpeed());
					this.setNumberCycles(this.getNumberCycles() - 1);
					
					System.out.println("The Ant ("+ this.getNameAnt() +") Advance towards the colonial.");
				}else{
					
					this.setOutColonial(true);
					this.setPosition(0);
					this.setNumberCycles(this.getNumberCycles() - 1);
					
					this.setFoodTrans(0);
					
					if(colonial.getFoodAmount() > 0){
						colonial.setFoodAmount(colonial.getFoodAmount() - 1);
						
					}else{
						this.setNumberCycles(this.getNumberCycles() - 2);
					}
				}
			}
			
			if(this.getNumberCycles() <= 0){
				this.setActive(false);
			}
		}else{
			if(!this.isSupported()){
				int index = -1;
				
				Enumeration<Integer> eNbAn = colonial.getNumberAnt().keys();
				
				while(eNbAn.hasMoreElements()){
					
					int key = eNbAn.nextElement();
					
					if(colonial.getNumberAnt().get(key) == this){
						index = key;
						break;
					}
				}
				
				BoxEvent.getInstance().addEvent(new Injured(this,index));
			}
		}
	}

	public int getFoodTrans() {
		return foodTrans;
	}

	public void setFoodTrans(int foodTrans) {
		this.foodTrans = foodTrans;
	}

}
