package singleton;

/**
 * Включая synchronized в объявление getInstance(), мы заставляем каждый поток дождаться своей очереди для входа в него.
 *
 * Однако синхронизация метода приводит к значительным затратам ресурсов, что может замедлить приложение в 100 и боле раз.
 * Если getInstance() не приводит к значительному ухудшению быстродействия, это можно опустить.
 * Но если метод применяется в интенсивно используемой чисти приложения, стоит отказаться от данного варианта.
 */
class Singleton1 {
    private static Singleton1 uniqueInstance;

    public static synchronized Singleton1 getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton1();
        }
        return uniqueInstance;
    }
}

/**
 * Если приложение всегда создаёт и использует экземпляр синглеторного класса
 * или затраты на создание не столь существенны, экземпляр можно создать заранее.
 * JVM гарантирует, что экземпляр будет создан до того, как какой-нибудь поток сможет обратиться к статической переменной uniqueInstance.
 */
class Singleton2 {
    private static Singleton2 uniqueInstance = new Singleton2();

    public static Singleton2 getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton2();
        }
        return uniqueInstance;
    }
}

/**
 * В getInstance() проверяем экземпляр: если он null, то входим в блок synchronized.
 * Т.е. синхронизация выполняется только при первом вызове.
 *
 * volatile гарантирует, что параллельные потоки будут правильно работать с переменной uniqueInstance.
 * НО! Многие реализации volatile в Java 1.4 и меньше допускают неверную синхронизацию условной блокировки.
 * Для таких случаев следует воспользоваться другой реализацией паттерна.
 */
class Singleton3 {
    private static volatile Singleton3 uniqueInstance;

    public static Singleton3 getInstance() {
        if (uniqueInstance == null) {
            synchronized (Singleton3.class) {
                uniqueInstance = new Singleton3();
            }
        }
        return uniqueInstance;
    }
}

/*
p.s.
Модификатор volatile накладывает некоторые дополнительные условия на чтение/запись переменной:
1. Она всегда будет атомарно читаться и записываться. Даже если это 64-битные double или long.
2. Java-машина не будет помещать ее в кэш. Так что ситуация, когда 10 потоков работают со своими локальными копиями исключена.
 */

