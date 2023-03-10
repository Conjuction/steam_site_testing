package helpers;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class TestBase {
    public final SelenideElement inputSearch =  $("#store_nav_search_term");
    public final SelenideElement resultSearch =  $("#search_resultsRows");
    public final SelenideElement appName =  $("#appHubAppName");
    public final SelenideElement addButton =  $(".btn_green_steamui");
    public final SelenideElement pageContent =  $(".page_content");
    public final SelenideElement purchaseSelf =  $("#btn_purchase_self");
    public final SelenideElement purchaseGift =  $("#btn_purchase_gift");
    public final SelenideElement genre =  $(".home_page_gutter");
    public final SelenideElement result =  $(".responsive");
    public final SelenideElement logo =  $("#logo_holder");
    public final SelenideElement language =  $("#language_pulldown");
    public final SelenideElement languageChoice =  $("#language_dropdown");
    public final SelenideElement dropdown =  $("#search_suggestion_contents");
    public final SelenideElement communityButton =  $("#global_header");
    public final SelenideElement communityDropdown =  $(".supernav_content");
    public final SelenideElement headerActivity =  $(".community_home_title");
    public final SelenideElement headerDiscussions =  $(".large_title");
    public final SelenideElement headerWorkshop =  $(".homeTabSpacer");
    public final SelenideElement headerMarket =  $("#BG_top");
    public final SelenideElement headerContent =  $(".community_home_subtitle");

    @BeforeAll
    static void openPage() {
        step("Открыть главную страницу 'Steam'", () ->
                open("https://store.steampowered.com/"));
    }
    @BeforeAll
    static void beforeAll() {
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("browserVersion", "100");
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.remote = System.getProperty("remote", "https://user1:1234@selenoid.autotests.cloud/wd/hub");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }

}
