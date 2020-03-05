package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import entrance.Entrance;
import entrance.EntranceB01;
import entrance.EntranceB02;
import entrance.EntranceB03;

public enum Busdepot {
	instance;
	
	private List<Bus> completeBusList;
	private List<Bus> busList;
	private List<ParkingSpot> parkingSpots;
	private List<MaintainancePlatform> platformList1;
	private List<MaintainancePlatform> platformList2;
	private List<MaintainancePlatform> platformList3;
	private MaintainanceHall hall;

	public void createStructure() {
		completeBusList = new ArrayList<>();
    	for (int i = 0; i < 25; i++) {
    		Bus bus = new Bus(BusType.B01);
    		completeBusList.add(bus);
    	}
    	for (int i = 0; i < 25; i++) {
    		Bus bus = new Bus(BusType.B02);
    		completeBusList.add(bus);
    	}
    	for (int i = 0; i < 25; i++) {
    		Bus bus = new Bus(BusType.B03);
    		completeBusList.add(bus);
    	}
    	System.out.println("Busse erstellt");
    	
    	Collections.shuffle(completeBusList);
    	System.out.println("Busse zufällig verteilt");
    	
    	parkingSpots = new ArrayList<ParkingSpot>();
    	int counter = 0;
    	for (int i = 1; i <= 15; i++) {
    		for (int j = 1; j <= 5; j++) {
    			Bus bus = completeBusList.get(counter);
    			ParkingSpot parkingSpot = new ParkingSpot(i,j);
        		parkingSpot.setBus(bus);
        		bus.setParkingSpot(parkingSpot);
        		parkingSpots.add(parkingSpot);
        		
        		counter++;
    		}
    	}
    	System.out.println("Busse zu Parkplätzen hinzugefügt");
    	
    	System.out.println("Wähle 12 zufällige Busse aus mit jeweils 4 pro Bustyp");
    	busList = new ArrayList<>();
    	busList.addAll(getFourRandomBus(BusType.B01));
    	busList.addAll(getFourRandomBus(BusType.B02));
    	busList.addAll(getFourRandomBus(BusType.B03));
    	
    	Entrance entranceB01 = new EntranceB01();
		Entrance entranceB02 = new EntranceB02(entranceB01);
		Entrance entranceB03 = new EntranceB03(entranceB02);
    	
    	hall = new MaintainanceHall();
    	hall.setEntrance(entranceB03);
    	
    	platformList1 = new ArrayList<MaintainancePlatform>();
    	for (int i = 0; i < 4; i++) {
    		MaintainancePlatform platform = new MaintainancePlatform();
    		platformList1.add(platform);
    	}
    	entranceB01.setPlatforms(platformList1);
    	
    	platformList2 = new ArrayList<MaintainancePlatform>();
    	for (int i = 0; i < 4; i++) {
    		MaintainancePlatform platform = new MaintainancePlatform();
    		platformList2.add(platform);
    	}
    	entranceB02.setPlatforms(platformList2);
    	
    	platformList3 = new ArrayList<MaintainancePlatform>();
    	for (int i = 0; i < 4; i++) {
    		MaintainancePlatform platform = new MaintainancePlatform();
    		platformList3.add(platform);
    	}
    	entranceB03.setPlatforms(platformList3);
    	
    	System.out.println("Wartungshallen, Einfahrten, Bühnen erstellt");
    	System.out.println();
	}
	
	public void releaseBusses() {
		ControlUnit.instance.releaseBusses(busList);
	}

	public void driveToEntrances() {
		for (int i = 0; i < 12; i++) {
			Bus bus = busList.get(i);
    		hall.getEntrance().entrance(bus);
    		System.out.println();
    	}
	}

	public void driveToMaintainanceHalls() {
		for (MaintainancePlatform platform : platformList1) {
    		platform.enter();
    		platform.maintainance();
    		platform.leave();
    		System.out.println();
    	}
    	for (MaintainancePlatform platform : platformList2) {
    		platform.enter();
    		platform.maintainance();
    		platform.leave();
    		System.out.println();
    	}
    	for (MaintainancePlatform platform : platformList3) {
    		platform.enter();
    		platform.maintainance();
    		platform.leave();
    		System.out.println();
    	}
	}

	public void driveToFreeParkingSlots() {
		for (Bus bus : busList) {
    		ParkingSpot parkingSpot = getFreeParkingSpot();
    		parkingSpot.setBus(bus);
    		
    		parkingSpot.enter();
    		System.out.println();
    	}
	}
	
	private ParkingSpot getFreeParkingSpot() {
    	for (ParkingSpot parkingSpot : this.parkingSpots) {
    		if (parkingSpot.isFree()) {
    			return parkingSpot;
    		}
    	}
		return null;
    }
	
	public ParkingSpot getFreeRedParkingSpot() {
    	for (ParkingSpot parkingSpot : this.parkingSpots) {
    		if (parkingSpot.isFree() && parkingSpot.getTrafficLight().isRed()) {
    			return parkingSpot;
    		}
    	}
		return null;
    }
	
	private List<Bus> getFourRandomBus(BusType type) {
		Random random = new Random();
		List<Bus> list = new ArrayList<>();
		while(list.size() < 4) {
			int rand = random.nextInt(completeBusList.size());
			Bus bus = completeBusList.get(rand);
			if (bus.getType() == type) {
				if (!list.contains(bus)) {
					list.add(bus);
				}
			}
		}
		return list;
	}
	
}
