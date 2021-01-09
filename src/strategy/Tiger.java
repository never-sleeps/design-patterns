package strategy;

public class Tiger extends Animal{
    public Tiger() {
        moveBehavior = new RunBehavior();
    }

    @Override
    public void display() {
        System.out.print("I'm tiger.");
    }
}
