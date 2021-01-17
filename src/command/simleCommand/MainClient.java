package command.simleCommand;

import command.simleCommand.commands.LightOnCommand;
import command.simleCommand.initiator.SimpleRemoteControl;
import command.simleCommand.receivers.Light;

/**
 * Клиент в терминологии паттерна.
 */
public class MainClient {
    public static void main(String[] args) {
        /**
         * Объект remoteControl - инициатор, ему будет передаваться объект команды
         */
        SimpleRemoteControl remoteControl = new SimpleRemoteControl();
        /**
         * Объект light будет получателем запроса
         */
        Light light = new Light();

        /**
         * lightOnCommand - команда с указанием её получателя
         */
        LightOnCommand lightOnCommand = new LightOnCommand(light);

        remoteControl.setCommand(lightOnCommand); // Команда передаётся Инициатору
        remoteControl.buttonWasPressed(); // Имитируем нажатие кнопки
    }
}
