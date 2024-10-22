package templateMethod;

/**
 * Абстрактный класс.
 * Он должен субклассироваться классами, предоставляющими реализацию операций.
 * Субклассы могут переопределять некоторый части алгоритма без изменения его структуры.
 */
public abstract class BeverageWithCaffeine {
    /**
     * Шаблонный метод.Объявляется с ключевым словом final, чтобы субклассы не могли изменить последовательность шагов в алгоритме.
     * Шаблонный метод определяет последовательность шагов, каждый из которых представлен методом.
     * Реализация одних методов представляется этим классом (boilWater и pourInCup),
     * реализация других представлена субклассом (brew и addCondiments).
     */
    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }

    /**
     * Примитивная операция ("заварить").
     * Должна реализовывать в конкретном субклассе
     */
    abstract void brew();

    /**
     * Примитивная операция ("добавить ").
     */
    abstract void addCondiments();

    /**
     * Конкретная операция boilWater ("вскипятить воду") определяется в абстрактном классе. Она объявлена с ключевым словом final,
     * чтобы субклассы не могли переопределить её. Она может использоваться как напрямую шаблонным методом, так и субклассами.
     */
    final void boilWater() {
        System.out.println("Boiling water");
    }

    /**
     * Конкретная операция pourInCup ("перелить в чашку")
     */
    final void pourInCup() {
        System.out.println("Pouring into cup");
    }

    /**
     * Метод-перехватчик. Может иметь пустую реализацию или реализацию по умолчанию.
     * Субкласс может переопределить этот метод, но не обязан этого делать.
     *
     * @return в реализации по умолчанию считаем, что клиент хочет добавки в напиток.
     */
    boolean customerWantsCondiments() {
        return true;
    }
}
