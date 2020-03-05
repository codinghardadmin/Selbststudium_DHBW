package entrance;

import application.Bus;
import application.BusType;
import sensor.SensorType;

public class EntranceB01 extends Entrance {
	public EntranceB01() {
		super();
	}
	
	public void entrance(Bus bus) {
        if (canDriveIn(bus, BusType.B01)) {
        	System.out.println("EinfahrtB01 mit Bus des Typs: " + bus.getType());
        	this.bus = bus;
        	this.sensor.activation(this, SensorType.ENTER);
        }
        else
            super.entrance(bus);
    }
	
	public void leave() {
    	System.out.println("Bus " + bus + " verlässt die Einfahrt B01");
    	this.sensor.activation(this, SensorType.LEAVE);
    	this.addBusToMaintainancePlatform(bus);
    	this.setBus(null);
    }
}