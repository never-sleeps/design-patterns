package decorator;

/**
 * Объекты должны быть взаимозаменяемы друг с другом, поэтому расширяем класс Beverage
 */
public abstract class CondimentDecorator extends Beverage {
    public abstract String getDescription();
}
