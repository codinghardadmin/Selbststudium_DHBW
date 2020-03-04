package application;

public class EinfahrtB03 extends Einfahrt {
    public EinfahrtB03(Einfahrt successor) {
    	super();
        this.setSuccessor(successor);
    }

    public void einfahrt(Bus bus) {
        if (kannEinfahren(bus, BusType.B03)) {
        	System.out.println("EinfahrtB03 mit Bus des Typs: " + bus.getType());
        	this.bus = bus;
        	this.sensor.activation(this, SensorType.ENTER);
        }
        else
            super.einfahrt(bus);
    }
    
    public void leave() {
    	System.out.println("Bus " + bus + " verlässt die Einfahrt B03");
    	this.sensor.activation(this, SensorType.LEAVE);
    	this.addBusToWartungsbuehne(bus);
    	this.setBus(null);
    }
}