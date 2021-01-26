package observer.manual.subscribers;

import observer.manual.DisplayElement;
import observer.manual.publisher.Subject;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private float pressure;
    private Subject weatherData;

    /**
     * @param weatherData объект WeatherData, который используется для регистрации элемента в качестве наблюдателя
     */
    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    /**
     * при вызове метода мы сохраняем значения и далее вызываем display()
     * @param temp температура
     * @param humidity влажность
     * @param pressure давление
     */
    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }

    /**
     * Вывод текущих значений в консоль
     */
    @Override
    public void display() {
        System.out.println("Current conditions: temperature = " + temperature + ", humidity = " + humidity + ", pressure = " + pressure);
    }
}
