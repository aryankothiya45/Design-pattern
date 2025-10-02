package commands;

import core.SatelliteUnit;

public class DisablePanels implements Command {
    private SatelliteUnit satellite;

    public DisablePanels(SatelliteUnit sat) {
        this.satellite = sat;
    }

    @Override
    public void run() {
        satellite.powerOffPanels();
    }
}
