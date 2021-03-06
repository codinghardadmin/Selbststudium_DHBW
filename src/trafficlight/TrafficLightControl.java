package trafficlight;

import commands.ICommand;

public class TrafficLightControl {
	private ICommand command;

    public void setCommand(ICommand command) {
        this.command = command;
    }

    public void sendCommand() {
        command.execute();
    }
}
