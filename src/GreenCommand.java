

public class GreenCommand implements ICommand {
    private TrafficLight light;

    public GreenCommand(TrafficLight light) {
        this.light = light;
    }

    public void execute() {
        light.setGreen();
    }
}