package command.command;

import command.command.commands.lightCommands.LightOffCommand;
import command.command.commands.lightCommands.LightOnCommand;
import command.command.commands.stereoComands.StereoOffCommand;
import command.command.commands.stereoComands.StereoOnWithDiskCommand;
import command.command.commands.stereoComands.StereoOnWithRadioCommand;
import command.command.initiator.RemoteControl;
import command.command.receivers.Light;
import command.command.receivers.Stereo;

/**
 * Клиент в терминологии паттерна.
 * Создаёт объекты команд, связываемые с объектами пульта. Каждый объект команды инкапсулирует запрос к некоторому устройству.
 */
public class MainClient {
    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();

        // Создание устройств
        Light livingRoomLight = new Light("Living Room");
        Light kitchenLight = new Light("Kitchen");
        Stereo stereo = new Stereo();

        // Создание команд для управления освещением
        LightOnCommand livingRoomLightOnCommand = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOffCommand = new LightOffCommand(livingRoomLight);
        LightOnCommand kitchenLightOnCommand = new LightOnCommand(kitchenLight);
        LightOffCommand kitchenLightOffCommand = new LightOffCommand(kitchenLight);

        // Создание команд для управления стереосистемой
        StereoOnWithDiskCommand stereoOnWithDiskCommand = new StereoOnWithDiskCommand(stereo);
        StereoOnWithRadioCommand stereoOnWithRadioCommand = new StereoOnWithRadioCommand(stereo);
        StereoOffCommand stereoOffCommand = new StereoOffCommand(stereo);

        // Готовые команды связываются с ячейками пульта
        remoteControl.setCommand(0, livingRoomLightOnCommand, livingRoomLightOffCommand);
        remoteControl.setCommand(1, kitchenLightOnCommand, kitchenLightOffCommand);
        remoteControl.setCommand(2, stereoOnWithDiskCommand, stereoOffCommand);
        remoteControl.setCommand(3, stereoOnWithRadioCommand, stereoOffCommand);

        System.out.println(remoteControl); // Выводим список ячеек и связанных к ними команд

        // Проверяем работу: Перебираем все ячейки и для каждой ячейки имитируем нажатие кнопок "вкл" и "выкл"
        // Освещение в комнате
        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);
        // Освещение на кухне
        remoteControl.onButtonWasPushed(1);
        remoteControl.offButtonWasPushed(1);

        // Стереосистема: режим диска
        System.out.println();
        remoteControl.onButtonWasPushed(2);
        System.out.println();
        remoteControl.offButtonWasPushed(2);
        // Стереосистема: режим радио
        System.out.println();
        remoteControl.onButtonWasPushed(3);
        System.out.println();
        remoteControl.offButtonWasPushed(3);

    }
}
