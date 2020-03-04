package application;


public class TrafficLight {
    private TrafficLightType type;
    
    public TrafficLight() {
    	type = TrafficLightType.RED;
    }

    public void setGreen() {
        type = TrafficLightType.GREEN;
    }
    
    public void setRed() {
        type = TrafficLightType.RED;
    }

    public String toString() {
        return "TRAFFICLIGHT(" + hashCode() + ", " + type.toString() + ")";
    }
}