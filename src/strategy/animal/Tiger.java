package strategy.animal;

import strategy.behavior.RunBehavior;

public class Tiger extends Animal{
    public Tiger() {
        moveBehavior = new RunBehavior();
    }

    @Override
    public void display() {
        System.out.print("I'm tiger.");
    }
}
