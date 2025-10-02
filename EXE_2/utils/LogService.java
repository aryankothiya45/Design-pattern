package utils;

import java.util.logging.*;

public class LogService {
    public static Logger getLogger(String name) {
        Logger logger = Logger.getLogger(name);
        logger.setUseParentHandlers(false);

        ConsoleHandler handler = new ConsoleHandler();
        handler.setFormatter(new SimpleFormatter());

        logger.addHandler(handler);
        return logger;
    }
}

