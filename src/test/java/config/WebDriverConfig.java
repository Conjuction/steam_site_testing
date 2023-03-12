package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties"
})

public interface WebDriverConfig extends Config {
    @Key("baseUrl")
    @DefaultValue("https://store.steampowered.com/")
    String getBaseUrl();

    @Key("browserName")
    @DefaultValue("chrome")
    String getBrowser();

//    @Key("browserVersion")
//    @DefaultValue("100.0")
//    String getBrowserVersion();

    @Key("remoteUrl")
    String getRemoteUrl();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String getBrowserSize();
}
