package driver;

import com.codeborne.selenide.Configuration;
import config.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverSettings {
    public static void configure() {
        Configuration.browser = WebDriver.config.getBrowserName();
        Configuration.browserVersion = WebDriver.config.getBrowserVersion();
        Configuration.browserSize = WebDriver.config.getBrowserSize();
        Configuration.baseUrl = WebDriver.config.getBaseUrl();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("--lang=en-en");

        String remoteUrl = WebDriver.config.getRemoteUrl();
        if (remoteUrl != null) {
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.remote = WebDriver.config.getRemoteUrl();
        }

        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        Configuration.browserCapabilities = capabilities;
    }
}
