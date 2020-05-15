package DesignPattern.HeadFirst.ObserverVersionTwoObserable;

import java.util.Observable;

public class WeatherStationSimulatorTwo {

    public static void main(String[] args) {
        Observable weatherDataVersionTwo = new WeatherDataVersionTwo();

        CurrentConditionDisplayVersionTwo currentConditionDisplayVersionTwo = new CurrentConditionDisplayVersionTwo(weatherDataVersionTwo);
        ForcastConditionDisplayVersionTwo forcastConditionDisplayVersionTwo = new ForcastConditionDisplayVersionTwo(weatherDataVersionTwo);

        ((WeatherDataVersionTwo) weatherDataVersionTwo).setMeasurements(10,20,30);
        ((WeatherDataVersionTwo) weatherDataVersionTwo).setMeasurements(40,50,60);
        ((WeatherDataVersionTwo) weatherDataVersionTwo).setMeasurements(70,580,90);

        System.out.println();
        System.out.println("delete current observer");
        weatherDataVersionTwo.deleteObserver(currentConditionDisplayVersionTwo);

        ((WeatherDataVersionTwo) weatherDataVersionTwo).setMeasurements(10,20,30);
        ((WeatherDataVersionTwo) weatherDataVersionTwo).setMeasurements(40,50,60);
        ((WeatherDataVersionTwo) weatherDataVersionTwo).setMeasurements(70,580,90);

        System.out.println();
        System.out.println("delete all observers");
        weatherDataVersionTwo.deleteObservers();
        ((WeatherDataVersionTwo) weatherDataVersionTwo).setMeasurements(10,20,30);

    }
}
