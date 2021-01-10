package decorator;

public class MainCafe {

    public static void main(String[] args) {
        // заказываем эспрессо без дополнений
        Beverage espresso = new Espresso();
        System.out.println(espresso.getDescription() + " $" + espresso.cost()); // выводим описание и стоимость

        // закажем капучино с шоколадом и сливками
        Beverage cappuccino = new Cappuccino();
        cappuccino = new Chocolate(cappuccino); // заворачиваем в объект "шоколад"
        cappuccino = new Cream(cappuccino);     // заворачиваем в объект "сливки"
        System.out.println(cappuccino.getDescription() + " $" + cappuccino.cost()); // выводим описание и стоимость
    }
}
