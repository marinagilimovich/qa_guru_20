package config;

import org.aeonbits.owner.ConfigFactory;

public class ProjectConfig {
    public static final BrowserstackConfig browserstackConfig =
            ConfigFactory.create(BrowserstackConfig.class, System.getProperties());
    public static final AndroidConfig androidConfig =
            ConfigFactory.create(AndroidConfig.class, System.getProperties());
}