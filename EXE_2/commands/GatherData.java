package commands;

import core.SatelliteUnit;

public class GatherData implements Command {
    private SatelliteUnit satellite;

    public GatherData(SatelliteUnit sat) {
        this.satellite = sat;
    }

    @Override
    public void run() {
        satellite.collectInformation();
    }
}
