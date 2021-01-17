package command.command.initiator;

import command.command.commands.Command;
import command.command.commands.NoCommand;

/**
 * Пульт поддерживает 4 команды "вкл"/"выкл", которые хранятся в соответствующих массивах.
 *
 * Класс RemoteControl управляет набором объектов команд (по одному на кнопку). При нажатии кнопки вызывается соответствующий метод ButtonWasPushed(), который активизирует метод execute() объекта команды.
 * Класс пульта больше ничего не знает о тех классах, к которым он обращается, так как он отделен от них объектом команды.
 */
public class RemoteControlWithUndo {
    Command[] onCommands;
    Command[] offCommands;
    Command undoCommand; // переменная для хранения последней выполненной команды

    public RemoteControlWithUndo() {
        this.onCommands = new Command[4];
        this.offCommands = new Command[4];

        Command noCommand = new NoCommand();
        for (int i = 0; i < 4; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        undoCommand = noCommand;
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        this.onCommands[slot] = onCommand;
        this.offCommands[slot] = offCommand;
    }

    /**
     * При нажатии на кнопку мы сначала выполняем команду, а затем сохраняем ссылку на эту команду в переменной undoCommand
     * @param slot номер слота (ряда) команд
     */
    public void onButtonWasPushed(int slot) {
        this.onCommands[slot].execute();
        this.undoCommand = onCommands[slot];
    }

    public void offButtonWasPushed(int slot) {
        this.offCommands[slot].execute();
        this.undoCommand = offCommands[slot];
    }

    /**
     * При нажатии кнопки отмены мы вызываем метод undo() команды, хранящейся в переменной undoCommand.
     * Вызов отменяет операцию последней выполненной команды (выполняет логически противоположный метод)
     */
    public void undoButtonWasPushed() {
        System.out.print("undoButtonWasPushed: ");
        this.undoCommand.undo();
    }

    /**
     * @return описание всех ячеек с соответствующими командами
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n--- RemoteControl ---");
        for (int i = 0; i < onCommands.length; i++) {
            if (!(onCommands[i] instanceof NoCommand)) {
                stringBuilder.append("\n[ slot " + i + " ]: " + onCommands[i].getClass().getName() + ", " + offCommands[i].getClass().getName());
            }

        }
        stringBuilder.append("\n UndoCommand: " + undoCommand.getClass().getName()).append("\n");
        return stringBuilder.toString();
    }
}
