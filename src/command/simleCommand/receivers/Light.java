package command.simleCommand.receivers;

/**
 * Класс устройства электроники.
 * Классы устройств выполняют непосредственную работу по управлению домашней электроникой.
 */
public class Light {
    public void on() {
        System.out.println("Light is On");
    }

    public void off() {
        System.out.println("Light is Off");
    }
}
