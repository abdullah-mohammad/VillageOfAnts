


public abstract class Event {

	private String message;
	private Ant sender;
	
	public abstract void action(Colonial colonial);
	
	public Event(String message,Ant sender){
		
		this.message = message;
		this.sender  = sender;
	}

	public String getMessage() {
		return message;
	}

	public Ant getSender() {
		return sender;
	}

	public void setSender(Ant sender) {
		this.sender = sender;
	}
}
