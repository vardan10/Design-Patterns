import java.util.HashSet;
import java.util.Set;

interface Subject {
    public void notify(int temp, int pressure, int humidity);
    public void addObservers(Observer o);
    public void removeObservers(Observer o);
}

interface Observer {
    public void update(int temp, int pressure, int humidity);
}

class WeatherData implements Subject {
    private Set<Observer> observers;
    private int temp;
    private int pressure;
    private int humidity;

    WeatherData(){
        observers = new HashSet<>();
        this.temp = 0;
        this.pressure = 0;
        this.humidity = 0;
    }

    WeatherData(int temp, int pressure, int humidity){
        observers = new HashSet<>();
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
    }

    private void readingsChanged(){
        notify(temp, pressure, humidity);
    }

    @Override
    public void notify(int temp, int pressure, int humidity) {
        for(Observer o: observers)
            o.update(temp, pressure, humidity);
    }

    @Override
    public void addObservers(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObservers(Observer o) {
        observers.remove(o);
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
        readingsChanged();
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
        readingsChanged();
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
        readingsChanged();
    }
}

class WeatherStation1 implements Observer{

    @Override
    public void update(int temp, int pressure, int humidity) {
        System.out.println("Station 1: New Update: temp: " + temp + ", pressure: " + pressure + ", humidity: " + humidity);
    }
}

class WeatherStation2 implements Observer{

    @Override
    public void update(int temp, int pressure, int humidity) {
        System.out.println("Station 2: New Update: temp: " + temp + ", pressure: " + pressure + ", humidity: " + humidity);
    }
}

public class ObserverPattern {
    public static void main(String[] args) {
        WeatherStation1 station1 = new WeatherStation1();
        WeatherStation2 station2 = new WeatherStation2();
        WeatherData data = new WeatherData(15,10,20);

        data.addObservers(station1);
        data.addObservers(station2);

        data.setHumidity(10);
    }

}
