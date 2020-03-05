package entrance;

import application.Bus;
import application.BusType;
import sensor.SensorType;

public class EntranceB03 extends Entrance {
    public EntranceB03(Entrance successor) {
    	super();
        this.setSuccessor(successor);
    }

    public void entrance(Bus bus) {
        if (canDriveIn(bus, BusType.B03)) {
        	System.out.println("EinfahrtB03 mit Bus des Typs: " + bus.getType());
        	this.bus = bus;
        	this.sensor.activation(this, SensorType.ENTER);
        }
        else
            super.entrance(bus);
    }
    
    public void leave() {
    	System.out.println("Bus " + bus + " verlässt die Einfahrt B03");
    	this.sensor.activation(this, SensorType.LEAVE);
    	this.addBusToMaintainancePlatform(bus);
    	this.setBus(null);
    }
}