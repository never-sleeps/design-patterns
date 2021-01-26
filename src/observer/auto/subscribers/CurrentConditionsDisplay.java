package observer.auto.subscribers;

import observer.auto.DisplayElement;
import observer.auto.publisher.WeatherData;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private float pressure;

    Observable observable;

    /**
     * @param observable объект WeatherData, который используется для регистрации элемента в качестве наблюдателя
     */
    public CurrentConditionsDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    /**
     * В методе сначала проверяем, что субъект относится к типу WeatherData, затем используем его get-методы
     * для получения значений температуры, влажности и давления, после чего вызываем display()
     * @param obs Observable
     * @param arg необязательные данные
     */
    public void update(Observable obs, Object arg) {
        if (obs instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) obs;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            this.pressure = weatherData.getPressure();
            display();
        }
    }

    /**
     * Вывод текущих значений в консоль
     */
    @Override
    public void display() {
        System.out.println("Current conditions: temperature = " + temperature + ", humidity = " + humidity + ", pressure = " + pressure);
    }
}
