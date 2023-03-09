import java.util.LinkedList;

public class Phases {
	private String phaseName;
	private float phaseTimer;
	private LinkedList<Vehicles> cars;
	private LinkedList<Vehicles> crossedCars;
	
	public String getPhaseName() { 
		return phaseName; 
	}
	 
	public void setPhaseName (String phaseName) {
		this.phaseName = phaseName;
	}
	
	public float getPhaseTimer() { 
		return phaseTimer; 
	}
	 
	public void setPhaseTimer (float phaseTimer) {
		this.phaseTimer = phaseTimer;
	}
	
	public void setLinkedList() {
		this.cars = new LinkedList<Vehicles>();
		
	}
	
	public LinkedList<Vehicles> getLinkedList(){
		return cars;
	}
	
	public void setCrossedLinkedList() {
		this.crossedCars = new LinkedList<Vehicles>();
		
	}
	
	public LinkedList<Vehicles> getCrossedLinkedList(){
		return crossedCars;
	}
	
	
}
