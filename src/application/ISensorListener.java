package application;

public interface ISensorListener {

	void activate(Einfahrt einfahrt, SensorType sensorType);
	void activate(Wartungsbuehne wartungsbuehne);
	void activate(Parkplatz parkplatz, SensorType sensorType);
}