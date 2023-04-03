package config;

import org.aeonbits.owner.ConfigFactory;

public class WebDriver {
    public static RemoteWebDriverConfig config = ConfigFactory.create(RemoteWebDriverConfig.class, System.getProperties());
}
