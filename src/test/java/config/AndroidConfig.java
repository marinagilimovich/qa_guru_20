package config;

import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.LoadType.MERGE;

@Config.LoadPolicy(MERGE)
@Config.Sources({
        "system:properties",
        "classpath:ios.properties"
})
public interface AndroidConfig extends Config {
    @Key("device")
    String device();

    @Key("os_version")
    String osVersion();

    @Key("app")
    String app();
}