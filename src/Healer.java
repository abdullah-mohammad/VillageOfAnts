
import java.util.Enumeration;

public class Healer extends Ant{

	public static int numberHealer = 1;
	private boolean active;

	public Healer(Colonial colonial){
		super("Healer "+numberHealer,100,1,colonial);
		numberHealer++;
		active = false;
		//System.out.println("Creat an ant "+this.getNameAnt());
	}
	
	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	@Override
	public void newCycle(Colonial colonial){
		
		if(this.isActive()){
			if(this.getActive()){
				if(this.isOutColonial()){
					if(this.getPosition() < colonial.getNumberAnt().get(this.getSiteChoix()).getPosition()){
						this.setPosition(this.getPosition() + this.getSpeed());
						this.setNumberCycles(this.getNumberCycles() - 1);
						System.out.println("The Ant  (" + this.getNameAnt() + ") Advance towards (" + colonial.getLocations().getLocations()[this.getSiteChoix()].getName() + ").");
					}else{
						System.out.println("The Ant  (" + this.getNameAnt() + ") Collects the ant " + colonial.getNumberAnt().get(this.getSiteChoix()).getNameAnt() + ".");
						this.setNumberCycles(this.getNumberCycles() - 1);
						this.setOutColonial(false);
					}
					
					if(this.getNumberCycles() <= 0){
						colonial.getNumberAnt().get(this.getSiteChoix()).setSupported(false);
						this.setActive(false);
					}	
				}else{
					if(this.getPosition() > 0){
						this.setPosition(this.getPosition() - this.getSpeed());
						this.setNumberCycles(this.getNumberCycles() - 1);
						System.out.println("The Ant  (" + this.getNameAnt() + ") Return to the colonial with the ant (" + colonial.getNumberAnt().get(this.getSiteChoix()).getNameAnt() + ").");
					}else{
						int index = -1;
						
						Enumeration<Integer> eNbAn = colonial.getNumberAnt().keys();
						
						while(eNbAn.hasMoreElements()){
							
							int key = eNbAn.nextElement();
							
							if(colonial.getNumberAnt().get(key) == this){
								index = key;
								break;
							}
						}
						BoxEvent.getInstance().addEvent(new Recovery(this,index));
						this.setOutColonial(true);
					}
					if(this.getNumberCycles() <= 0){
						this.setActive(false);
						colonial.getNumberAnt().get(this.getSiteChoix()).setPosition(this.getPosition());
						colonial.getNumberAnt().get(this.getSiteChoix()).setSupported(false);
					}
				}
			}else{
				this.setNumberCycles(this.getNumberCycles() - 1);
				if(this.getNumberCycles() <=0){
					
					System.out.println(this.getNameAnt() + "is dead");
					int index = -1;
					
					Enumeration<Integer> eNbAn = colonial.getNumberAnt().keys();
					
					while(eNbAn.hasMoreElements()){
						
						int key = eNbAn.nextElement();
						
						if(colonial.getNumberAnt().get(key) == this){
							index = key;
							break;
						}
					}
					
					colonial.getNumberAnt().remove(index);
				}
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
		
}
