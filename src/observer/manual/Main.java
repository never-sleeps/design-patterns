package observer.manual;

import observer.manual.publisher.WeatherData;
import observer.manual.subscribers.CurrentConditionsDisplay;

public class Main {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay display = new CurrentConditionsDisplay(weatherData);

        // имитация новых погодных данных
        weatherData.setMeasurements(10, 20, 100);
        weatherData.setMeasurements(20, 30, 110);
        weatherData.setMeasurements(30, 40, 120);
    }
}
