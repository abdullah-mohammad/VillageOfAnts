



public abstract class Ant {
	
	private String nameAnt;				// Ant name
	private int numberCycles;			// Ant life points number
	private int speed;					// Ant speed of movement.
	private int siteChoix;					// Ant destination choice
	private int position;				// position of the Ant
	private boolean isActive;			// is the Ant injured or not
	private boolean isSupported; 	 	// supported by the healers
	private boolean isOutColonial;		// Ant leave the Colonial
	
	public Ant(String nameAnt,int numberCycles,int speed,Colonial colonial){
		this.nameAnt 		= nameAnt;			
		this.numberCycles	= numberCycles;
		this.speed 			= speed;
		this.siteChoix 		= -1;
		this.position 		= 0;
		this.isActive 		= true;
		this.isSupported 	= false;
		this.isOutColonial 	= true;
		//colonial.setIndexAnt(colonial.getIndexAnt() + 1);
	}
	
	public abstract void newCycle(Colonial colonial);

	public boolean isSupported() {
		return isSupported;
	}

	public void setSupported(boolean isSupported) {
		this.isSupported = isSupported;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public int getSiteChoix() {
		return siteChoix;
	}

	public void setSiteChoix(int siteSelection) {
		this.siteChoix = siteSelection;
	}

	public String getNameAnt() {
		return nameAnt;
	}

	public void setNameAnt(String nameAnt) {
		this.nameAnt = nameAnt;
	}

	public int getNumberCycles() {
		return numberCycles;
	}

	public void setNumberCycles(int numberCycles) {
		this.numberCycles = numberCycles;
	}

	public boolean isOutColonial() {
		return isOutColonial;
	}

	public void setOutColonial(boolean isOutColonial) {
		this.isOutColonial = isOutColonial;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
	
	
	
}
