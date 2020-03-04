package application;

import java.util.List;

public abstract class Einfahrt {
    private Einfahrt successor;
    protected List<Wartungsbuehne> buehnen;
    
    protected Sensor sensor;
    protected TrafficLight trafficLight;
    protected Bus bus;
    
    protected abstract void leave();
    
    public void addBusToWartungsbuehne(Bus bus) {
    	boolean wasFree = false;
    	for (Wartungsbuehne buehne : buehnen) {
    		if (buehne.getBus() == null) {
    			wasFree = true;
    			buehne.setBus(bus);
    			break;
    		}
    	}
    	if (!wasFree) {
    		System.out.println("Fehler: Es ist momentan keine Wartungbuehne frei");
    	}
    }
	
	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public Einfahrt() {
		this.sensor = new Sensor();
		sensor.addListener(Zentralrechner.instance);
		this.trafficLight = new TrafficLight();
	}
	
	public Sensor getSensor() {
		return sensor;
	}
	
	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}
	
	public TrafficLight getTrafficLight() {
		return trafficLight;
	}
	
	public void setTrafficLight(TrafficLight trafficLight) {
		this.trafficLight = trafficLight;
	}

    public void einfahrt(Bus bus) {
        if (getSuccessor() != null)
            getSuccessor().einfahrt(bus);
        else
            System.out.println("Keine gültige Einfahrt fuer Bustyp: " + bus.getType());
    }

    protected boolean kannEinfahren(Bus bus, BusType busType) {
        return (bus == null) || (bus.getType() == busType);
    }

    public Einfahrt getSuccessor() {
        return successor;
    }

    public void setSuccessor(Einfahrt successor) {
        this.successor = successor;
    }

	public void setBuehnen(List<Wartungsbuehne> buehnenList) {
		buehnen = buehnenList;
	}
}