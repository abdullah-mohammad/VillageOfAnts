
import java.util.ArrayList;

public class BoxEvent {
	
	private static BoxEvent instance = null;
	private ArrayList <Event> box;
	
	private BoxEvent(){
		box = new ArrayList<>();
	}
	
	boolean isEmpty(){
		return box.isEmpty();
	}
	
	void addEvent(Event event){
		box.add(event);
	}
	
	Event getNextEvent(){
		Event event = box.get(0);
		box.remove(0);
		return event;
	}
	
	static BoxEvent getInstance(){
		if(instance == null){
			instance = new BoxEvent();
		}
		return instance;
	}
}