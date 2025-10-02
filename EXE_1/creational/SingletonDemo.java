package EXE_1.creational;

public // Singleton Pattern Example: Config Manager

class ConfigManager {
    private static ConfigManager instance;
    private String dbUrl;

    private ConfigManager() {
        dbUrl = "jdbc:mysql://localhost:3306/mydb";
    }

    public static ConfigManager getInstance() {
        if(instance == null) {
            instance = new ConfigManager();
        }
        return instance;
    }

    public String getDbUrl() { return dbUrl; }
}

public class SingletonDemo {
    public static void main(String[] args) {
        ConfigManager c1 = ConfigManager.getInstance();
        ConfigManager c2 = ConfigManager.getInstance();
        System.out.println(c1.getDbUrl());
        System.out.println("Same instance? " + (c1 == c2));
    }
}
 {
    
}
