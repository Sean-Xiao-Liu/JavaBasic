package DesignPattern.HeadFirst.ObserverVersionOne;

import java.util.ArrayList;

public class WeatherData implements Subject {
    private ArrayList<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;


    public WeatherData(){
        observers = new ArrayList<>(); // initialize when the WeatherData instance created
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int i = observers.indexOf(observer); // return index number of object, or -1, when object doesn't exist
        if(i >= 0){
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObserver() {
        for(int i = 0 ; i < observers.size() ; i++){
            observers.get(i)
                     .update(temperature,humidity,pressure); // update all the observers in the observers list, and it depends on Observer how to update; Use one method to update all observers

        }
    }

    public void measurementsChanged(){ // once weather data changed, notify the observers in the list
        notifyObserver();
    }

    public void setMeasurements(float temp, float humidity, float pressure){
        this.temperature = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}
