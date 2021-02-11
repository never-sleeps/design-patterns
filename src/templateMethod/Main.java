package templateMethod;

public class Main {
    public static void main(String[] args) {
        BeverageWithCaffeine tea = new Tea();
        BeverageWithCaffeine coffee = new Coffee();

        System.out.println("Making tea:");
        tea.prepareRecipe();

        System.out.println("\nMaking coffee:");
        coffee.prepareRecipe();

        /*
            Making tea:
            Boiling water
            Steeping the tea
            Pouring into cup
            Adding lemon

            Making coffee:
            Boiling water
            Dripping coffee through filter
            Pouring into cup
            Would you like milk with your coffee (yes/no)?
            yes
            Adding milk
         */
    }
}
