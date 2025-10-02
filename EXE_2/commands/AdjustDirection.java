package commands;

import core.SatelliteUnit;

public class AdjustDirection implements Command {
    private SatelliteUnit satellite;
    private String newDirection;

    public AdjustDirection(SatelliteUnit sat, String dir) {
        this.satellite = sat;
        this.newDirection = dir;
    }

    @Override
    public void run() {
        try {
            satellite.changeDirection(newDirection);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }
}
