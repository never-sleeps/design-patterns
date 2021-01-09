package strategy;

public class RunBehavior implements MoveBehavior{
    @Override
    public void move() {
        System.out.println("I'm running!");
    }
}
