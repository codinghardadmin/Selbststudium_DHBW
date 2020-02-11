

public class RedCommand implements ICommand {
    private TrafficLight light;

    public RedCommand(TrafficLight light) {
        this.light = light;
    }

    public void execute() {
        light.setRed();
    }
}