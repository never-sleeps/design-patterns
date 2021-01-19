package facade.equipment;

/**
 * DVD-Проигрыватель
 */
public class DvdPlayer {
    public void on() {
        System.out.println("DvdPlayer on");
    }

    public void play(String movieName) {
        System.out.println("DvdPlayer playing " + movieName);
    }

    public void off() {
        System.out.println("DvdPlayer off");
    }
}
