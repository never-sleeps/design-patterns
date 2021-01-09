package observer.manual;

public interface Subject {

    /**
     * @param o реализация Observer - регистрируемый наблюдатель
     */
    void registerObserver(Observer o);

    /**
     * @param o реализация Observer - исключаемый наблюдатель
     */
    void removeObserver(Observer o);

    /**
     * метод вызывается для оповещения наблюдателей об изменении состояния объекта
     */
    void notifyObservers();
}
