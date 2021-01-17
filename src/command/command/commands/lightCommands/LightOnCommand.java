package command.command.commands.lightCommands;

import command.command.commands.Command;
import command.command.receivers.Light;

public class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    /**
     * Вызываем метод объекта Light, противоположный по значению методу, выполняющемуся в execute()
     */
    @Override
    public void undo() {
        light.off();
    }
}
