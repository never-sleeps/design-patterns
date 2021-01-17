package command.macroCommand.receivers;

/**
 * Класс устройства электроники.
 * Классы устройств выполняют непосредственную работу по управлению домашней электроникой.
 */
public class Light {
    String name; // Название комнаты, к которой находится элемент освещения

    public Light(String name) {
        this.name = name;
    }

    public void on() {
        System.out.println(name + ": Light is On");
    }

    public void off() {
        System.out.println(name + ": Light is Off");
    }
}
