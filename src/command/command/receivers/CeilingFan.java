package command.command.receivers;

/**
 * Вентилятор
 */
public class CeilingFan {
    public static final int HIGH = 2;
    public static final int LOW = 1;
    public static final int OFF = 0;

    int speed; // переменная состояния, представляющая скорость вращения вентилятора

    public CeilingFan() {
        this.speed = OFF;
    }

    public int getSpeed() {
        return speed;
    }

    // методы, задающие скорость вращения вентилятора
    public void high() {
        this.speed = HIGH;
        printSpeed();
    }

    public void low() {
        this.speed = LOW;
        printSpeed();
    }

    public void off() {
        this.speed = OFF;
        printSpeed();
    }

    public void printSpeed() {
        System.out.println("CeilingFan: speed " + speed);
    }
}
