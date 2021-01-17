package command.macroCommand;

import command.macroCommand.commands.Command;
import command.macroCommand.commands.lightCommands.LightOffCommand;
import command.macroCommand.commands.lightCommands.LightOnCommand;
import command.macroCommand.commands.stereoComands.StereoOffCommand;
import command.macroCommand.commands.stereoComands.StereoOnCommand;
import command.macroCommand.initiator.RemoteControlWithUndo;
import command.macroCommand.receivers.Light;
import command.macroCommand.receivers.Stereo;

public class MainClient {
    public static void main(String[] args) {
        RemoteControlWithUndo remoteControlWithUndo = new RemoteControlWithUndo();

        // Создание устройств
        Light livingRoomLight = new Light("Living Room");
        Light kitchenLight = new Light("Kitchen");
        Stereo stereo = new Stereo();

        // Создание команд для управления устройствами
        LightOnCommand lightOnCommand1 = new LightOnCommand(livingRoomLight);
        LightOffCommand lightOffCommand1 = new LightOffCommand(livingRoomLight);

        LightOnCommand lightOnCommand2 = new LightOnCommand(kitchenLight);
        LightOffCommand lightOffCommand2 = new LightOffCommand(kitchenLight);

        StereoOnCommand stereoOnCommand = new StereoOnCommand(stereo);
        StereoOffCommand stereoOffCommand = new StereoOffCommand(stereo);

        // Создаём массивы команд включения и выключения всех устройств
        Command[] allOnCommands = {lightOnCommand1, lightOnCommand2, stereoOnCommand};
        Command[] allOffCommands = {lightOffCommand1, lightOffCommand2, stereoOffCommand};

        // Создаём два объекта макрокоманд, где будут храниться массивы
        MacroCommand allOnMacro = new MacroCommand(allOnCommands);
        MacroCommand allOffMacro = new MacroCommand(allOffCommands);

        // Связываем макрокоманды с кнопкой обычным способом
        remoteControlWithUndo.setCommand(0, allOnMacro, allOffMacro);

        // Тестируем:
        System.out.println(remoteControlWithUndo);
        remoteControlWithUndo.undoButtonWasPushed(); // Ничего не должно произойти, поскольку в undoButton пока NoCommand
        System.out.println();

        System.out.println("--- Pushing Macro On ---");
        remoteControlWithUndo.onButtonWasPushed(0); // Должно всё ВКЛ
        remoteControlWithUndo.undoButtonWasPushed(); // Отменяем: должно всё ВЫКЛ
        System.out.println();

        System.out.println("--- Pushing Macro Off ---");
        remoteControlWithUndo.offButtonWasPushed(0); // Должно всё ВЫКЛ
        remoteControlWithUndo.undoButtonWasPushed(); // Отменяем: должно снова всё ВКЛ

        // Результат:
        /*
            --- RemoteControl ---
            [ slot 0 ]: command.macroCommand.MacroCommand, command.macroCommand.MacroCommand
            --- undoButtonWasPushed:

            --- Pushing Macro On ---
            Living Room: Light is On
            Kitchen: Light is On
            Stereo is On
            --- undoButtonWasPushed:
            Living Room: Light is Off
            Kitchen: Light is Off
            Stereo is Off

            --- Pushing Macro Off ---
            Living Room: Light is Off
            Kitchen: Light is Off
            Stereo is Off
            --- undoButtonWasPushed:
            Living Room: Light is On
            Kitchen: Light is On
            Stereo is On
         */
    }
}
