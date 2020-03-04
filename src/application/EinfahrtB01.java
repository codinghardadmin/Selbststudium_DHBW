package application;

public class EinfahrtB01 extends Einfahrt {
	public EinfahrtB01() {
		super();
	}
	
	public void einfahrt(Bus bus) {
        if (kannEinfahren(bus, BusType.B01)) {
        	System.out.println("EinfahrtB01 mit Bus des Typs: " + bus.getType());
        	this.bus = bus;
        	this.sensor.activation(this, SensorType.ENTER);
        }
        else
            super.einfahrt(bus);
    }
	
	public void leave() {
    	System.out.println("Bus " + bus + " verlässt die Einfahrt B01");
    	this.sensor.activation(this, SensorType.LEAVE);
    	this.addBusToWartungsbuehne(bus);
    	this.setBus(null);
    }
}