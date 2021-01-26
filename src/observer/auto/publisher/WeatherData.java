package observer.auto.publisher;

import java.util.Observable;

/**
 * Суперкласс Observable берёт на себя всё управление наблюдателями (регистрация, добавление, оповещение и тд)
 */
public class WeatherData extends Observable {
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {}

    /**
     * Оповещение наблюдателей о появлении новых данных
     */
    public void measurementsChanged() {
        /*
         * Метод сообщат об изменении состояния и о том, что метод notifyObservers() при вызове должен обновить своих наблюдателей.
         * Если вызвать notifyObservers() без предварительного вызова setChanged(), наблюдатели оповещены НЕ БУДУТ,
         * поскольку setChanged() устанавливает флаг changed, а notifyObservers() оповещает наблюдателей только при установленном флаге changed = true.
         * Это необходимо для возможности добавления более гибкой логики оповещений (например, для оповещений только если t изменилась больше, чем на градус).
         */
        setChanged();
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}
