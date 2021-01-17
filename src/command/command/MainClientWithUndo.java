package command.command;

import command.command.commands.lightCommands.LightOffCommand;
import command.command.commands.lightCommands.LightOnCommand;
import command.command.initiator.RemoteControlWithUndo;
import command.command.receivers.Light;

/**
 * Клиент в терминологии паттерна.
 * Создаёт объекты команд, связываемые с объектами пульта. Каждый объект команды инкапсулирует запрос к некоторому устройству.
 */
public class MainClientWithUndo {
    public static void main(String[] args) {
        RemoteControlWithUndo remoteControl = new RemoteControlWithUndo();

        // Создание устройств
        Light livingRoomLight = new Light("Living Room");
        Light kitchenLight = new Light("Kitchen");

        // Создание команд c поддержкой отмены
        LightOnCommand livingRoomLightOnCommand = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOffCommand = new LightOffCommand(livingRoomLight);
        LightOnCommand kitchenLightOnCommand = new LightOnCommand(kitchenLight);
        LightOffCommand kitchenLightOffCommand = new LightOffCommand(kitchenLight);

        // Готовые команды связываются с ячейками пульта
        remoteControl.setCommand(0, livingRoomLightOnCommand, livingRoomLightOffCommand);
        remoteControl.setCommand(1, kitchenLightOnCommand, kitchenLightOffCommand);


        // Проверяем работу:
        // Перебираем все ячейки: включение, выключение, отмена
        // Освещение в комнате
        System.out.println(remoteControl);
        remoteControl.onButtonWasPushed(0);

        System.out.println(remoteControl);
        remoteControl.offButtonWasPushed(0);

        System.out.println(remoteControl);
        remoteControl.undoButtonWasPushed();

        // Освещение на кухне
        System.out.println(remoteControl);
        remoteControl.onButtonWasPushed(1);

        System.out.println(remoteControl);
        remoteControl.offButtonWasPushed(1);

        System.out.println(remoteControl);
        remoteControl.undoButtonWasPushed();
    }
}
