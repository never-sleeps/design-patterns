package command.simleCommand.initiator;

import command.simleCommand.commands.Command;

public class SimpleRemoteControl {
    /**
     * Ячейка для хранения команды
     */
    Command command;

    public SimpleRemoteControl() {
    }

    /**
     * Ячейка для назначения команды
     */
    public void setCommand(Command slot) {
        this.command = slot;
    }

    /**
     * Метод, вызываемый при нажатии кнопки
     */
    public void buttonWasPressed() {
        command.execute();
    }
}
