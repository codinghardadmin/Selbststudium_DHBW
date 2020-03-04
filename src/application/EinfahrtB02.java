package application;

public class EinfahrtB02 extends Einfahrt {
    public EinfahrtB02(Einfahrt successor) {
    	super();
        this.setSuccessor(successor);
    }

    public void einfahrt(Bus bus) {
        if (kannEinfahren(bus, BusType.B02)) {
        	System.out.println("EinfahrtB02 mit Bus des Typs: " + bus.getType());
        	this.bus = bus;
        	this.sensor.activation(this, SensorType.ENTER);
        }
        else
            super.einfahrt(bus);
    }
    
    public void leave() {
    	System.out.println("Bus " + bus + " verlässt die Einfahrt B02");
    	this.sensor.activation(this, SensorType.LEAVE);
    	this.addBusToWartungsbuehne(bus);
    	this.setBus(null);
    }
}