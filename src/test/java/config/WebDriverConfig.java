package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties"
})

public interface WebDriverConfig extends Config {
    @Key("baseUrl")
    String getBaseUrl();

    @Key("browserName")
    String getBrowser();

    @Key("browserVersion")
    String getBrowserVersion();

    @Key("remoteUrl")
    String getRemoteUrl();

    @Key("browserSize")
    String getBrowserSize();
}
