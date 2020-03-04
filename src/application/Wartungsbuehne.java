package application;

import java.util.List;
import java.util.Random;

public class Wartungsbuehne {
	
	private Sensor sensor;
	private Bus bus;
	
	public Bus getBus() {
		return bus;
	}
	
	public void enter() {
		System.out.println("Bus ist nun auf der Wartungsbuehne");
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public Wartungsbuehne() {
		this.sensor = new Sensor();
		sensor.addListener(Zentralrechner.instance);
	}
	
	public Sensor getSensor() {
		return sensor;
	}
	
	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}

	public void wartung() {
		Random random = new Random();
		int wartungsZeit = random.nextInt(2000) + 1000;
		System.out.println("Bus wurde " + wartungsZeit + " ms gewartet");
	}

	public void leave(List<Parkplatz> parkplaetze) {
		System.out.println("Bus verlässt die Wartungbuehne");
		this.setBus(null);
		this.sensor.activation(this);
	}

}
