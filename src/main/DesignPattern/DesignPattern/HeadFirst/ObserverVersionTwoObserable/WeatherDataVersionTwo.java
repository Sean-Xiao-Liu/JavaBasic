package DesignPattern.HeadFirst.ObserverVersionTwoObserable;

import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

public class WeatherDataVersionTwo extends Observable { // extends the build in java observable class, which is not abstract
    private Vector<Observer> obs;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherDataVersionTwo() { // default constructor
    }


    /** not passing argument in the notifyObservers method, means observers will try to pull state change from Subject**/
    public void measurementsChanged(){
        setChanged(); // build in method of Observable class
        notifyObservers(); // build in method of Observable class
    }

    public void setMeasurements(float temp, float humidity, float pressure){
        this.temperature = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }


    /** the following getters methods will be invoked by Observers
     * pass WeatherDataVersionTwo as argument for constructors of observers
     * **/
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
