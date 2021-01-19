package facade.equipment;

/**
 * Усилитель звука
 */
public class Amplifier {
    public void on() {
        System.out.println("Amplifier on");
    }

    public void setVolume(int value) {
        System.out.println("Amplifier setting volume to " + value);
    }

    public void off() {
        System.out.println("Amplifier off");
    }
}
