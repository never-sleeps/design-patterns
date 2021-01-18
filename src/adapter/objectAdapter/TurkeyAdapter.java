package adapter.objectAdapter;

/**
 * Адаптер реализует целевой интерфейс и хранит ссылку на экземпляр адаптируемого объекта
 */
public class TurkeyAdapter implements Duck{
    Turkey turkey;

    /**
     * @param turkey ссылка на адаптируемый объект Turkey
     */
    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    /**
     * Реализуем методы интерфейса.
     * В данном случае вызываем близкий по смыслу метод qobble() для Turkey
     */
    @Override
    public void quack() {
        turkey.qobble();
    }

    /**
     * Хотя метод fly() входит в оба интерфейса, индюшка не умеет летать на дальние расстояния.
     * Чтобы установить соответствие, вызываем метод fly() класса Turkey 3 раза (словно она делала остановки)
     */
    @Override
    public void fly() {
        for (int i = 0; i < 3; i++) {
            turkey.fly();
        }
    }
}
