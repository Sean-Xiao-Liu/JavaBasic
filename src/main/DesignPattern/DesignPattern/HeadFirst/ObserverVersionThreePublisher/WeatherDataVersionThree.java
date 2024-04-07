package DesignPattern.HeadFirst.ObserverVersionThreePublisher;

import java.util.List;
import java.util.concurrent.Flow;

public class WeatherDataVersionThree implements Flow.Publisher {
    private float temperature;
    private float humidity;
    private float pressure;
    private List<Flow.Subscriber> subscribers;


    @Override
    public void subscribe(Flow.Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void setMeasurements(float temp, float humidity, float pressure){
        this.temperature = temp;
        this.humidity = humidity;
        this.pressure = pressure;
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
