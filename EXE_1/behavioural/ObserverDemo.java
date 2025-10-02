
import java.util.*;

interface Device {
    void update(int temp);
}

class WeatherStation {
    private List<Device> devices = new ArrayList<>();
    private int temperature;

    public void addDevice(Device d) { devices.add(d); }
    public void removeDevice(Device d) { devices.remove(d); }

    public void setTemperature(int temp) {
        this.temperature = temp;
        notifyDevices();
    }

    private void notifyDevices() {
        for(Device d : devices) {
            d.update(temperature);
        }
    }
}

class Mobile implements Device {
    public void update(int temp) { System.out.println("Mobile: Temp updated to " + temp); }
}

class TV implements Device {
    public void update(int temp) { System.out.println("TV: Temp updated to " + temp); }
}

public class ObserverDemo {
    public static void main(String[] args) {
        WeatherStation ws = new WeatherStation();
        ws.addDevice(new Mobile());
        ws.addDevice(new TV());
        ws.setTemperature(30);
        ws.setTemperature(25);
    }
}

