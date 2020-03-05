package sensor;

import java.util.ArrayList;

import application.MaintainancePlatform;
import application.ParkingSpot;
import entrance.Entrance;

public class Sensor {
    private ArrayList<ISensorListener> listeners;

    public Sensor() {
        listeners = new ArrayList<>();
    }

    public void activation(MaintainancePlatform wartungsbuehne) {
        for (ISensorListener listener : listeners)
            listener.activate(wartungsbuehne);
    }
    
    public void activation(Entrance einfahrt, SensorType sensorType) {
        for (ISensorListener listener : listeners)
            listener.activate(einfahrt, sensorType);
    }
    
    public void activation(ParkingSpot parkplatz, SensorType sensorType) {
        for (ISensorListener listener : listeners)
            listener.activate(parkplatz, sensorType);
    }

    public void addListener(ISensorListener listener) {
        listeners.add(listener);
    }

    public void removeListener(ISensorListener listener) {
        listeners.remove(listener);
    }
}