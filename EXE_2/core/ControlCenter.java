package core;

import commands.Command;
import utils.LogService;

import java.util.logging.Logger;

public class ControlCenter {
    private static ControlCenter instance;
    private SatelliteUnit satellite;
    private Logger logger = LogService.getLogger(ControlCenter.class.getName());

    private ControlCenter() {
        satellite = new SatelliteUnit();
    }

    public static synchronized ControlCenter getInstance() {
        if (instance == null) {
            instance = new ControlCenter();
        }
        return instance;
    }

    public SatelliteUnit getSatellite() {
        return satellite;
    }

    public void processCommand(Command cmd) {
        try {
            cmd.run();
            System.out.println(satellite.toString());
        } catch (Exception e) {
            logger.severe("Command execution failed: " + e.getMessage());
        }
    }
}
