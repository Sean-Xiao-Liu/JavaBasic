package DesignPattern.HeadFirst.ObserverVersionOne;

public class WeatherStationSimulator {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData(); // This is subject side

        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherData);
        ForcastConditionDisplay forcastConditionDisplay = new ForcastConditionDisplay(weatherData);

        weatherData.setMeasurements(10,20,30);
        weatherData.setMeasurements(40,50,60);
        weatherData.setMeasurements(70,80,90);

        weatherData.removeObserver(currentConditionDisplay);
        System.out.println("remove current condition display observer");
        weatherData.setMeasurements(10,20,30);
        weatherData.setMeasurements(40,50,60);
        weatherData.setMeasurements(70,80,90);

    }
}
