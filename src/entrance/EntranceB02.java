package entrance;

import application.Bus;
import application.BusType;
import sensor.SensorType;

public class EntranceB02 extends Entrance {
    public EntranceB02(Entrance successor) {
    	super();
        this.setSuccessor(successor);
    }

    public void entrance(Bus bus) {
        if (canDriveIn(bus, BusType.B02)) {
        	System.out.println("EinfahrtB02 mit Bus des Typs: " + bus.getType());
        	this.bus = bus;
        	this.sensor.activation(this, SensorType.ENTER);
        }
        else
            super.entrance(bus);
    }
    
    public void leave() {
    	System.out.println("Bus " + bus + " verlässt die Einfahrt B02");
    	this.sensor.activation(this, SensorType.LEAVE);
    	this.addBusToMaintainancePlatform(bus);
    	this.setBus(null);
    }
}