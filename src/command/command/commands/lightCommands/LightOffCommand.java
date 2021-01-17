package command.command.commands.lightCommands;

import command.command.commands.Command;
import command.command.receivers.Light;

/**
 * Каждая операция, активизируемая нажатием кнопки на пульте, реализуется простым объектом команды.
 * Объект команды хранит ссылку на экземпляр класса устройства, реализующий метод execute(),
 * а execute() вызывает один или несколько методов объекта.
 */
public class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}
