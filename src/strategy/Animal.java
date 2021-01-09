package strategy;

public abstract class Animal {
    MoveBehavior moveBehavior;

    public void performMove() {
        moveBehavior.move();
    }

    public void display() {
        System.out.print("I'm animal.");
    }
}
