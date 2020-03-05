package application;

import sensor.Sensor;
import sensor.SensorType;
import trafficlight.TrafficLight;

public class ParkingSpot {
	
	private Sensor sensor;
	private TrafficLight trafficLight;
	private Bus bus;
	private int id;
	private int b;
	private int h;
	
	private static int ID_COUNTER = 1;
	
	public boolean isFree() {
		return bus == null;
	}
	
	public Bus getBus() {
		return bus;
	}
	
	public int getId() {
		return id;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}
	
	public void leave() {
		System.out.println("Bus " + bus + " verlässt den Parkplatz " + this.toString());
		sensor.activation(this, SensorType.LEAVE);
		setBus(null);
	}

	public ParkingSpot(int i, int j) {
		this.sensor = new Sensor();
		sensor.addListener(ControlUnit.instance);
		this.trafficLight = new TrafficLight();
		this.id = ID_COUNTER;
		ID_COUNTER++;
		this.b = i;
		this.h = j;
	}
	
	public Sensor getSensor() {
		return sensor;
	}
	
	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}
	
	public TrafficLight getTrafficLight() {
		return trafficLight;
	}
	
	public void setTrafficLight(TrafficLight trafficLight) {
		this.trafficLight = trafficLight;
	}

	public void enter() {
		System.out.println("Bus " + bus + " fährt in freien Parkplatz " + this.toString());
		sensor.activation(this, SensorType.ENTER);
	}
	
	@Override
	public String toString() {
		return "PARKINGSLOT(id=" + this.id + ", b=" + b + ", h=" + h + ")";
	}

}
