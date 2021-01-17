package command.command;

import command.command.commands.ceilingFanCommands.CeilingFanHighCommand;
import command.command.commands.ceilingFanCommands.CeilingFanLowCommand;
import command.command.commands.ceilingFanCommands.CeilingFanOffCommand;
import command.command.initiator.RemoteControlWithUndo;
import command.command.receivers.CeilingFan;

/**
 * Клиент в терминологии паттерна.
 * Создаёт объекты команд, связываемые с объектами пульта. Каждый объект команды инкапсулирует запрос к некоторому устройству.
 */
public class MainClientWithUndoWithState {
    public static void main(String[] args) {
        RemoteControlWithUndo remoteControl = new RemoteControlWithUndo();

        // Создание устройств
        CeilingFan ceilingFan = new CeilingFan();

        // Создание команд для высокой и низкой скорости и выключения вентилятора
        CeilingFanHighCommand highCommand = new CeilingFanHighCommand(ceilingFan);
        CeilingFanLowCommand lowCommand = new CeilingFanLowCommand(ceilingFan);
        CeilingFanOffCommand offCommand = new CeilingFanOffCommand(ceilingFan);

        // Готовые команды связываются с ячейками пульта
        remoteControl.setCommand(0, highCommand, offCommand);
        remoteControl.setCommand(1, lowCommand, offCommand);


        // Проверяем работу:
        System.out.println(remoteControl);
        remoteControl.onButtonWasPushed(0);     // включаем высокую скорость

        System.out.println(remoteControl);
        remoteControl.offButtonWasPushed(0);    // выключаем венилятор

        System.out.println(remoteControl);
        remoteControl.undoButtonWasPushed();        // отмена! должна включиться высокая скорость

        // Освещение на кухне
        System.out.println(remoteControl);
        remoteControl.onButtonWasPushed(1);     // включаем среднюю скорость

        System.out.println(remoteControl);
        remoteControl.undoButtonWasPushed();        // отмена! должна вернуться высокая скорость
    }
}
