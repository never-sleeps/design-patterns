package strategy;

public class Fish extends Animal{

    public Fish() {
        moveBehavior = new SwimBehavior();
    }

    public void display() {
        System.out.print("I'm fish.");
    }
}
