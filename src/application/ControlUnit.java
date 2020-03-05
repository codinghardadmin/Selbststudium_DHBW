package application;

import java.util.List;
import java.util.Random;

import commands.GreenCommand;
import commands.ICommand;
import commands.RedCommand;
import entrance.Entrance;
import sensor.ISensorListener;
import sensor.SensorType;
import trafficlight.TrafficLight;
import trafficlight.TrafficLightControl;

public enum ControlUnit implements ISensorListener {
	instance;
	
	private TrafficLightControl control;
	
	ControlUnit() {
		this.control = new TrafficLightControl();
	}
	
	public void releaseBusses(List<Bus> list) {
		for (Bus bus : list) {
			ParkingSpot parkingSpot = bus.getParkingSpot();
			System.out.println();
			
			System.out.println(parkingSpot);
			
			TrafficLight trafficLight = parkingSpot.getTrafficLight();
			
			ICommand cmdGreen = new GreenCommand(trafficLight);
			control.setCommand(cmdGreen);
			control.sendCommand();
			
			System.out.println("Parkplatz: " + trafficLight);
			
			Random random = new Random();
			int timeToDrive = random.nextInt(300) + 200;
			System.out.println("Bus " + parkingSpot.getBus() + " fährt in " + timeToDrive + " ms los");
			
			parkingSpot.leave();
			bus.setParkingSpot(null);
			
			System.out.println();
		}
	}
	
	@Override
	public void activate(Entrance entrance, SensorType sensorType) {
		if (sensorType == SensorType.ENTER) {
			System.out.println("[ControlUnit] Activate Sensor Einfahrt Enter");
			TrafficLight trafficLight = entrance.getTrafficLight();
			
			ICommand cmdGreen = new GreenCommand(trafficLight);
			
			control.setCommand(cmdGreen);
			control.sendCommand();
			
			System.out.println("Einfahrt: " + trafficLight);
			
			Random random = new Random();
			int timeToDrive = random.nextInt(300) + 200;
			
			System.out.println("Bus " + entrance.getBus() + " fährt in die Einfahrt hinein und benötigt " + timeToDrive + " ms");
			
			entrance.leave();
			
		} else {
			System.out.println("[ControlUnit] Activate Sensor Einfahrt Leave");
			TrafficLight trafficLight = entrance.getTrafficLight();
			
			ICommand cmdRed = new RedCommand(trafficLight);
			
			control.setCommand(cmdRed);
			control.sendCommand();
			
			System.out.println("Einfahrt: " + trafficLight);
		}
	}
	
	@Override
	public void activate(MaintainancePlatform maintainancePlatform) {
		System.out.println("[ControlUnit] Activate Sensor Wartungsebene Leave");
		
		System.out.println("Es wird nach einem freien Parkplatz für Bus " + maintainancePlatform.getBus() + " gesucht");
		
		ParkingSpot parkingSpot = Busdepot.instance.getFreeRedParkingSpot();
		
		TrafficLight trafficLight = parkingSpot.getTrafficLight();
		
		ICommand cmdGreen = new GreenCommand(trafficLight);
		
		control.setCommand(cmdGreen);
		control.sendCommand();
		
		System.out.println("Wartungsbühne: " + trafficLight);
	}
	
	@Override
	public void activate(ParkingSpot parkingSlot, SensorType sensorType) {
		if (sensorType == SensorType.ENTER) {
			System.out.println("[ControlUnit] Activate Sensor Parkplatz Enter");
			TrafficLight trafficLight = parkingSlot.getTrafficLight();
			
			ICommand cmdRed = new RedCommand(trafficLight);
			
			control.setCommand(cmdRed);
			control.sendCommand();
			
			System.out.println("Parkplatz: " + trafficLight);
		} else {
			
			System.out.println("[ControlUnit] Activate Sensor Parkplatz Leave");
			TrafficLight trafficLight = parkingSlot.getTrafficLight();
			
			ICommand cmdRed = new RedCommand(trafficLight);
			
			control.setCommand(cmdRed);
			control.sendCommand();
			
			System.out.println("Parkplatz: " + trafficLight);
		}
		
	}
}