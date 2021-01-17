package command.command.initiator;

import command.command.commands.Command;
import command.command.commands.NoCommand;

/**
 * Пульт поддерживает 4 команды "вкл"/"выкл", которые хранятся в соответствующих массивах.
 *
 * Класс RemoteControl управляет набором объектов команд (по одному на кнопку).
 * При нажатии кнопки вызывается соответствующий метод ButtonWasPushed(), который активизирует метод execute() объекта команды.
 * Класс пульта больше ничего не знает о тех классах, к которым он обращается, так как он отделен от них объектом команды.
 */
public class RemoteControl {
    Command[] onCommands;
    Command[] offCommands;

    public RemoteControl() {
        this.onCommands = new Command[4];
        this.offCommands = new Command[4];

        Command noCommand = new NoCommand();
        for (int i = 0; i < 4; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        this.onCommands[slot] = onCommand;
        this.offCommands[slot] = offCommand;
    }

    public void onButtonWasPushed(int slot) {
        this.onCommands[slot].execute();
    }

    public void offButtonWasPushed(int slot) {
        this.offCommands[slot].execute();
    }

    /**
     * @return описание всех ячеек с соответствующими командами
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n--- RemoteControl ---");
        for (int i = 0; i < onCommands.length; i++) {
            stringBuilder.append("\n[ slot " + i + " ]: " + onCommands[i].getClass().getName() + ", " + offCommands[i].getClass().getName());
        }
        return stringBuilder.toString();
    }
}
