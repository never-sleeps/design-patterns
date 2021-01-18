package adapter.objectAdapter;

public class Main {
    public static void main(String[] args) {
        // Создаём объекты Duck и Turkey
        Duck duck = new MallardDuck();
        Turkey turkey = new WildTurkey();

        // Turkey упаковывается в TurkeyAdapter и начинает выглядеть и вести себя подобно Duck
        Duck turkeyAdapter = new TurkeyAdapter(turkey);

        // Тестируем методы Turkey:
        System.out.print("The Turkey says: ");
        turkey.qobble();
        turkey.fly();

        // Тестируем методы Duck
        System.out.print("The Duck says: ");
        duck.quack();
        duck.fly();

        // Тестируем адаптер: Turkey должен вести себя подобно Duck
        System.out.print("The TurkeyAdapter says: ");
        turkeyAdapter.quack();
        turkeyAdapter.fly();

    }
}
