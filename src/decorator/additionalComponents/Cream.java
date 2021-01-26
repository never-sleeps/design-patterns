package decorator.additionalComponents;

import decorator.baseComponents.Beverage;

public class Cream extends CondimentDecorator {
    Beverage beverage;

    public Cream(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Cream";
    }

    @Override
    public double cost() {
        return .30 + beverage.cost();
    }
}
