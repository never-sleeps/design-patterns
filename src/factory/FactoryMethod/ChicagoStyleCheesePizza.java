package factory.FactoryMethod;

public class ChicagoStyleCheesePizza extends Pizza {
    public ChicagoStyleCheesePizza() {
        name = "Chicago Style Cheese Pizza";
        dough = "Extra thick dough";
        sauce = "Tomato sauce";

        toppings.add("Shredded Mozzarella Cheese");
    }

    // Чикагская пицца переопределяет метод cut: она нарезается квадратами, а не клиньями
    @Override
    void cut() {
        System.out.println("Cutting the pizza into square slices...");
    }
}
