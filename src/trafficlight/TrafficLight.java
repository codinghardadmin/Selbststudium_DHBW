package trafficlight;


public class TrafficLight {
    private TrafficLightType type;
    private int id;
    
    private static int ID_COUNTER = 1;
    
    public TrafficLight() {
    	type = TrafficLightType.RED;
    	this.id = ID_COUNTER;
    	ID_COUNTER++;
    }

    public void setGreen() {
        type = TrafficLightType.GREEN;
    }
    
    public void setRed() {
        type = TrafficLightType.RED;
    }
    
    public boolean isRed() {
    	return type == TrafficLightType.RED;
    }

    public String toString() {
        return "TRAFFICLIGHT(" + id + ") ist nun: " + type.toString() + "";
    }
}