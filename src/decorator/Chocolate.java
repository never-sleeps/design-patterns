package decorator;

/**
 * Класс декоратора расширяет CondimentDecorator
 */
public class Chocolate extends CondimentDecorator {
    /**
     * Храним ссылку на напиток
     */
    Beverage beverage;

    public Chocolate(Beverage beverage) {
        this.beverage = beverage;
    }

    /**
     * В описании должно содержаться не только название напитка (например, "Эспрессо"), но и все дополнения (например, "Эспрессо, шоколад").
     * Таким образом, мы сначала получаем описание напитка, делегируя вызов декорируемому объекту, а затем присоединяем к нему название дополнения.
     * @return Название напитка + дополнение
     */
    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Chocolate";
    }

    /**
     * Сначала вызов делегируется декорируемому объекту, а затем стоимость шоколада прибавляется к результату
     * @return стоимость напитка с шоколадом
     */
    @Override
    public double cost() {
        return .20 + beverage.cost();
    }
}
