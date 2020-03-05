package application;

public class Bus {

	private static int ID_COUNTER = 1;
	
	private BusType busType;
	private int id;

	private ParkingSpot parkingSpot;
	
	public Bus(BusType busType) {
		this.busType = busType;
		this.id = ID_COUNTER;
		ID_COUNTER++;
	}
	
	public BusType getType() {
		return busType;
	}
	
	public int getID() {
		return id;
	}
	
	@Override
	public String toString() {
		return "BUS("+ busType + ", " + id + ")";
	}

	public void setParkingSpot(ParkingSpot parkingSpot) {
		this.parkingSpot = parkingSpot;
	}
	
	public ParkingSpot getParkingSpot() {
		return parkingSpot;
	}

}
