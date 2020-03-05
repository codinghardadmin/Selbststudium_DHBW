package entrance;

import java.util.List;

import application.Bus;
import application.BusType;
import application.ControlUnit;
import application.MaintainancePlatform;
import sensor.Sensor;
import trafficlight.TrafficLight;

public abstract class Entrance {
    private Entrance successor;
    protected List<MaintainancePlatform> platforms;
    
    protected Sensor sensor;
    protected TrafficLight trafficLight;
    protected Bus bus;
    
    public abstract void leave();
    
    public void addBusToMaintainancePlatform(Bus bus) {
    	boolean wasFree = false;
    	for (MaintainancePlatform platform : platforms) {
    		if (platform.getBus() == null) {
    			wasFree = true;
    			platform.setBus(bus);
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

	public Entrance() {
		this.sensor = new Sensor();
		sensor.addListener(ControlUnit.instance);
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

    public void entrance(Bus bus) {
        if (getSuccessor() != null)
            getSuccessor().entrance(bus);
        else
            System.out.println("Keine gültige Einfahrt fuer Bustyp: " + bus.getType());
    }

    protected boolean canDriveIn(Bus bus, BusType busType) {
        return (bus == null) || (bus.getType() == busType);
    }

    public Entrance getSuccessor() {
        return successor;
    }

    public void setSuccessor(Entrance successor) {
        this.successor = successor;
    }

	public void setPlatforms(List<MaintainancePlatform> platforms) {
		this.platforms = platforms;
	}
}