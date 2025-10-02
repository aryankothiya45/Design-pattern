package commands;

import core.SatelliteUnit;

public class EnablePanels implements Command {
    private SatelliteUnit satellite;

    public EnablePanels(SatelliteUnit sat) {
        this.satellite = sat;
    }

    @Override
    public void run() {
        satellite.powerOnPanels();
    }
}
