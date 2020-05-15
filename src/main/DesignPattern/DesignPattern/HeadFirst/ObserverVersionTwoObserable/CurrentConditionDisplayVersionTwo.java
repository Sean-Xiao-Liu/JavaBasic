package DesignPattern.HeadFirst.ObserverVersionTwoObserable;

import DesignPattern.HeadFirst.ObserverVersionOne.DisplayElement;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionDisplayVersionTwo implements Observer, DisplayElement {

    Observable observable;
    private float temperature;
    private float humidity;
    private float pressure;

    public CurrentConditionDisplayVersionTwo(Observable observable) { // Observer needs a observable object as argument
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current condition " + temperature +  " degree, " + humidity + " percent, " + pressure + " psi." );
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof WeatherDataVersionTwo){ // instanceof is a operator to test whether the object is an instance of the specified type (class or subclass or interface)
            WeatherDataVersionTwo weatherDataVersionTwo = (WeatherDataVersionTwo) o;
            this.temperature = ((WeatherDataVersionTwo) o).getTemperature();
            this.humidity = ((WeatherDataVersionTwo) o).getHumidity();
            this.pressure = ((WeatherDataVersionTwo) o).getPressure();
            display();
        }
    }
}
