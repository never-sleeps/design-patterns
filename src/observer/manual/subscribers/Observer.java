package observer.manual.subscribers;

/**
 * Интерфейс Observer реализуется всеми наблюдателями.
 * Таким образом, все наблюдатели должны реализовать метод update.
 */
public interface Observer {
    /**
     * В качестве параметров - данные состояния, передаваемые наблюдателям при изменении состояния субъекта
     * @param temp температура
     * @param humidity влажность
     * @param pressure давление
     */
    void update(float temp, float humidity, float pressure);
}
