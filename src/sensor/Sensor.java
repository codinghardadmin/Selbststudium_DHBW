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

    public void activation(MaintainancePlatform platforms) {
        for (ISensorListener listener : listeners)
            listener.activate(platforms);
    }
    
    public void activation(Entrance entrance, SensorType sensorType) {
        for (ISensorListener listener : listeners)
            listener.activate(entrance, sensorType);
    }
    
    public void activation(ParkingSpot parkingSpot, SensorType sensorType) {
        for (ISensorListener listener : listeners)
            listener.activate(parkingSpot, sensorType);
    }

    public void addListener(ISensorListener listener) {
        listeners.add(listener);
    }

    public void removeListener(ISensorListener listener) {
        listeners.remove(listener);
    }
}