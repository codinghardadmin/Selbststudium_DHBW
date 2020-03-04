package application;

public class Parkplatz {
	
	private Sensor sensor;
	private TrafficLight trafficLight;
	private Bus bus;
	
	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}
	
	public void leave() {
		System.out.println("Bus " + bus + " verlässt den Parkplatz");
		sensor.activation(this, SensorType.LEAVE);
		setBus(null);
	}

	public Parkplatz() {
		this.sensor = new Sensor();
		sensor.addListener(Zentralrechner.instance);
		this.trafficLight = new TrafficLight();
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
		System.out.println("Bus " + bus + " fährt in freien Parkplatz");
		sensor.activation(this, SensorType.ENTER);
		setBus(null);
	}

}
