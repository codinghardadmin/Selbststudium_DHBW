package application;

import java.util.List;
import java.util.Random;

public enum Zentralrechner implements ISensorListener {
	instance;
	
	private TrafficLightControl control;
	
	Zentralrechner() {
		this.control = new TrafficLightControl();
	}
	
	public void releaseBusses(List<Parkplatz> list) {
		for (int i = 0; i < 12; i++) {
			Parkplatz parkplatz = list.get(i);
			TrafficLight trafficLight = parkplatz.getTrafficLight();
			
			ICommand cmdGreen = new GreenCommand(trafficLight);
			control.setCommand(cmdGreen);
			control.sendCommand();
			
			System.out.println(trafficLight);
			
			Random random = new Random();
			int timeToDrive = random.nextInt(300) + 200;
			System.out.println("Bus " + parkplatz.getBus() + " fährt in " + timeToDrive + " ms los");
			
			parkplatz.leave();
			System.out.println();
		}
	}
	
	@Override
	public void activate(Einfahrt einfahrt, SensorType sensorType) {
		if (sensorType == SensorType.ENTER) {
			System.out.println("[Zentralrechner] activate einfahrt enter");
			TrafficLight trafficLight = einfahrt.getTrafficLight();
			
			ICommand cmdGreen = new GreenCommand(trafficLight);
			ICommand cmdRed = new RedCommand(trafficLight);
			
			control.setCommand(cmdGreen);
			control.sendCommand();
			
			System.out.println(trafficLight);
			
			Random random = new Random();
			int timeToDrive = random.nextInt(300) + 200;
			
			System.out.println("Bus " + einfahrt.getBus() + " fährt in die Einfahrt hinein und benötigt " + timeToDrive + " ms");
			
			einfahrt.leave();
			
		} else {
			System.out.println("[Zentralrechner] activate einfahrt leave");
			TrafficLight trafficLight = einfahrt.getTrafficLight();
			
			ICommand cmdRed = new RedCommand(trafficLight);
			
			control.setCommand(cmdRed);
			control.sendCommand();
			
			System.out.println(trafficLight);
		}
	}
	
	@Override
	public void activate(Wartungsbuehne wartungsbuehne) {
		System.out.println("[Zentralrechner] activate wartungsbuehne");
		
		System.out.println("Es wird nach einem freien Parkplatz gesucht");
	}
	
	@Override
	public void activate(Parkplatz parkplatz, SensorType sensorType) {
		if (sensorType == SensorType.ENTER) {
			
			System.out.println("[Zentralrechner] activate parkplatz enter");
			TrafficLight trafficLight = parkplatz.getTrafficLight();
			
			ICommand cmdGreen = new GreenCommand(trafficLight);
			
			control.setCommand(cmdGreen);
			control.sendCommand();
			
			System.out.println(trafficLight);
		} else {
			
			System.out.println("[Zentralrechner] activate parkplatz leave");
			TrafficLight trafficLight = parkplatz.getTrafficLight();
			
			ICommand cmdGreen = new GreenCommand(trafficLight);
			ICommand cmdRed = new RedCommand(trafficLight);
			
			control.setCommand(cmdRed);
			control.sendCommand();
			
			System.out.println(trafficLight);
		}
		
	}
}