package decorator.baseComponents;

public class Espresso extends Beverage {
    /**
     * Описание напитка задаётся в конструкторе.
     * Переменная description наследуется от Beverage
     */
    public Espresso() {
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
