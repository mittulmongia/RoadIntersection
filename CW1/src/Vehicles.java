
public class Vehicles extends Thread {
	private String plateNumber;
	private String vehicleType;
	private float crossingTime;
	private String crossingDirection;
	private String crossingStatus;
	private float vehicleLength;
	private float vehicleEmission;
	private String segment;
	
	public void run()
	{ // Added code for Threads
		System.out.println("Started....Vehicle");
	
	}
	
	public String getPlateNumber() { 
		return plateNumber; 
	}
	 
	
	public String getVehicleType() { 
		return vehicleType; 
	}
	
	public synchronized void setPlateNumber (String plateNumber) {
		this.plateNumber = plateNumber;
	}
	
	public synchronized void setVehicleType (String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public synchronized void setCrossingTime(float crossingTime) {
		this.crossingTime = crossingTime;
	}
	public synchronized void setCrossingDirection (String crossingDirection) {
		this.crossingDirection = crossingDirection;
	}
	public synchronized void setCrossingStatus(String crossingStatus) {
		this.crossingStatus = crossingStatus;
	}
	public synchronized void setVehicleLength(float vehicleLength) {
		this.vehicleLength = vehicleLength;
	}
	public synchronized void setVehicleEmission(float vehicleEmission) {
		this.vehicleEmission = vehicleEmission;
	}
	
	public synchronized void setSegment(String segmentNumber) {
		this.segment = segmentNumber;
	}
public synchronized float calculateEmissions(float waitingTime) {
		
		return this.getVehicleEmission() * (waitingTime/60);
	}
	
	
	public float getCrossingTime() {
		return crossingTime;
	}
	
	
	public String getCrossingDirection() { 
		return crossingDirection; 
	}
	
		
	public String getCrossingStatus(){
		return crossingStatus;
	}

	public float getVehicleLength() {
		return vehicleLength; 
	}
	

	
	public float getVehicleEmission() {
		return vehicleEmission;
	}
	
	
	public String getSegment() {
		return segment;
	}
	
}

