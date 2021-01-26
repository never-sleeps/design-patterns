package decorator.baseComponents;

public class Cappuccino extends Beverage {
    public Cappuccino() {
        description = "Сappuccino";
    }

    @Override
    public double cost() {
        return 2.25;
    }
}
