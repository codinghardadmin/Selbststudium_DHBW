package application;

import java.util.ArrayList;

public class Sensor {
    private ArrayList<ISensorListener> listeners;

    public Sensor() {
        listeners = new ArrayList<>();
    }

    public void activation(Wartungsbuehne wartungsbuehne) {
        for (ISensorListener listener : listeners)
            listener.activate(wartungsbuehne);
    }
    
    public void activation(Einfahrt einfahrt, SensorType sensorType) {
        for (ISensorListener listener : listeners)
            listener.activate(einfahrt, sensorType);
    }
    
    public void activation(Parkplatz parkplatz, SensorType sensorType) {
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