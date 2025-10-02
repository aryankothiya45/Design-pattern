package core;

import java.util.Arrays;
import java.util.List;

public class SatelliteUnit {
    private String orientation;
    private boolean solarPanels;
    private int dataStore;

    public SatelliteUnit() {
        this.orientation = "North";
        this.solarPanels = false;
        this.dataStore = 0;
    }

    public void changeDirection(String dir) {
        List<String> validDirs = Arrays.asList("North", "South", "East", "West");
        if (!validDirs.contains(dir)) {
            throw new IllegalArgumentException("Invalid direction: " + dir);
        }
        orientation = dir;
        System.out.println("[INFO] Orientation adjusted to " + dir);
    }

    public void powerOnPanels() {
        solarPanels = true;
        System.out.println("[INFO] Solar Panels Activated.");
    }

    public void powerOffPanels() {
        solarPanels = false;
        System.out.println("[INFO] Solar Panels Deactivated.");
    }

    public void collectInformation() {
        if (solarPanels) {
            dataStore += 10;
            System.out.println("[INFO] Data gathered: " + dataStore + " units.");
        } else {
            System.out.println("[ERROR] Cannot gather data. Panels are OFF.");
        }
    }

    @Override
    public String toString() {
        return "Satellite Status => Direction: " + orientation +
                ", Panels: " + (solarPanels ? "ON" : "OFF") +
                ", Data: " + dataStore;
    }
}
