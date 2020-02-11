

public class TrafficLight {
    private TrafficLightType type;

    public void setGreen() {
        type = TrafficLightType.GREEN;
    }
    
    public void setRed() {
        type = TrafficLightType.RED;
    }

    public String toString() {
    	// ?? green or red oder speicheradresse angezeigt?
        return "trafficlight " + hashCode() + " : " + type.toString();
    }
}