package templateMethod;

/**
 * класс Tea расширяет класс CaffeineBeverage
 */
public class Tea extends BeverageWithCaffeine {
    @Override
    void brew() {
        System.out.println("Steeping the tea");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding lemon");
    }

    /*
     * В этом классе переопределять метод customerWantsCondiments из класса CaffeineBeverage не будем,
     * для него останется дефолтная (или пустая) реализация метода-перехватчика
     */
}
