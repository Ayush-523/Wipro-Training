package com.wipro.JavaBasics.DesignPattern;


public class ObserverDemo {
    public static void main(String[] args) {

        // Create observers
        Observer mobile = new MobileDisplay("Mobile App");
        Observer website = new WebDisplay("Website");
        Observer led = new LEDDisplay("LED Screen");

        // Register observers
        Observer[] observers = { mobile, website, led };

        // Create subject
        WeatherStation station = new WeatherStation(observers);

        // New weather update
        station.setWeatherData("Temperature: 30°C, Humidity: 60%");
    }
}

// Step 1: Observer Interface
interface Observer {
    void update(String data);
}

// Step 2: Concrete Observers

class MobileDisplay implements Observer {
    String name;

    MobileDisplay(String name) {
        this.name = name;
    }

    public void update(String data) {
        System.out.println(name + " received update: " + data);
    }
}

class WebDisplay implements Observer {
    String name;

    WebDisplay(String name) {
        this.name = name;
    }

    public void update(String data) {
        System.out.println(name + " received update: " + data);
    }
}

class LEDDisplay implements Observer {
    String name;

    LEDDisplay(String name) {
        this.name = name;
    }

    public void update(String data) {
        System.out.println(name + " received update: " + data);
    }
}

// Step 3: Subject (Publisher)
class WeatherStation {

    private Observer[] observers;

    WeatherStation(Observer[] observers) {
        this.observers = observers;
    }

    public void setWeatherData(String data) {
        notifyObservers(data);
    }

    private void notifyObservers(String data) {
        for (Observer obs : observers) {
            obs.update(data);
        }
    }
}