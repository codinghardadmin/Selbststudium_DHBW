package application;

import java.util.Random;

import sensor.Sensor;

public class MaintainancePlatform {
	
	private Sensor sensor;
	private Bus bus;
	
	public Bus getBus() {
		return bus;
	}
	
	public void enter() {
		Random random = new Random();
		int timeToDrive = random.nextInt(300) + 200;
		System.out.println("Bus " + bus + " fährt innerhalb von " + timeToDrive + " ms auf die Wartungsbuehne");
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public MaintainancePlatform() {
		this.sensor = new Sensor();
		sensor.addListener(ControlUnit.instance);
	}
	
	public Sensor getSensor() {
		return sensor;
	}
	
	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}

	public void maintainance() {
		Random random = new Random();
		int wartungsZeit = random.nextInt(2000) + 1000;
		System.out.println("Bus " + bus + " wurde in " + wartungsZeit + " ms gewartet");
	}

	public void leave() {
		System.out.println("Bus " + bus + " verlässt die Wartungbuehne");
		this.sensor.activation(this);
		this.setBus(null);
	}

}
