import core.ControlCenter;
import core.SatelliteUnit;
import commands.*;
import utils.LogService;

import java.util.*;
import java.util.logging.Logger;

public class MainApp {
    private static final Logger logger = LogService.getLogger(MainApp.class.getName());

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ControlCenter center = ControlCenter.getInstance();

        // Command Registry
        Map<String, CommandFactory> registry = new HashMap<>();
        registry.put("rotate", (sat, arg) -> new AdjustDirection(sat, arg));
        registry.put("enablePanels", (sat, arg) -> new EnablePanels(sat));
        registry.put("disablePanels", (sat, arg) -> new DisablePanels(sat));
        registry.put("gatherData", (sat, arg) -> new GatherData(sat));

        logger.info("=== Satellite Control Center Started ===");
        System.out.println("Commands: rotate <dir>, enablePanels, disablePanels, gatherData, exit");

        boolean active = true;
        while (active) {
            try {
                System.out.print(">> ");
                String input = sc.nextLine().trim();

                if (input.equalsIgnoreCase("exit")) {
                    active = false;
                    break;
                }

                String[] parts = input.split(" ");
                String cmdName = parts[0];
                String arg = parts.length > 1 ? parts[1] : null;

                CommandFactory factory = registry.get(cmdName);
                if (factory != null) {
                    Command command = factory.create(center.getSatellite(), arg);
                    center.processCommand(command);
                } else {
                    logger.warning("Invalid Command: " + cmdName);
                    System.out.println("[ERROR] Unknown command: " + cmdName);
                }

            } catch (Exception e) {
                logger.severe("Unexpected Error: " + e.getMessage());
                System.out.println("[ERROR] Something went wrong.");
            }
        }

        sc.close();
        logger.info("=== Exiting Control Center ===");
        System.out.println("Session Ended.");
    }
}

@FunctionalInterface
interface CommandFactory {
    Command create(SatelliteUnit sat, String arg);
}
