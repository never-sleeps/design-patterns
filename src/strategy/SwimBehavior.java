package strategy;

public class SwimBehavior implements MoveBehavior{
    @Override
    public void move() {
        System.out.println("I'm swimming!");
    }
}
