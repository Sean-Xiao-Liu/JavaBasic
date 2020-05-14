package DesignPattern.HeadFirst.ObserverVersionOne;

public class CurrentConditionDisplay implements Observer, DisplayElement{
    private Subject subject;
    private float temperature;
    private float humidity;
    private float pressure;
    private float index;

    public CurrentConditionDisplay(Subject weatherData){ // current condition display interact with Subject interface by taking the implementation of Subject, which is weatherData, as an argument
        this.subject = weatherData; // weatherData is implementation of Subject
        subject.registerObserver(this); // since CurrentConditionDisplay implements Observer, it is sub class of Observer
    }

    @Override
    public void display() {
        index = temperature + humidity + pressure;
        System.out.println("Current condition " + temperature +  " degree, " + humidity + " percent, " + pressure + " psi. " + "The heat index is " + index);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.pressure = pressure;
        this.humidity = humidity;
        this.temperature = temp;
        display();
    }
}

