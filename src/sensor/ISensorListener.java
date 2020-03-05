package sensor;

import application.MaintainancePlatform;
import application.ParkingSpot;
import entrance.Entrance;

public interface ISensorListener {

	void activate(Entrance einfahrt, SensorType sensorType);
	void activate(MaintainancePlatform platforms);
	void activate(ParkingSpot parkingSpot, SensorType sensorType);
}