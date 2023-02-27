package communityTabTesting;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import helpers.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class CommunityTesting extends TestBase {
    @Test
    @Owner("Sukhinin Dmitrii")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка перехода по ссылкам из выпадающего списка 'COMMUNITY'")
    void dropdownTesting() {
        step("Навести мышку на кнопку 'COMMUNITY' в верхней части экрана", () ->
                $("#global_header").$(byText("COMMUNITY")).hover());
        step("Выбрать из выпадающего списка 'Home'", () ->
                $(".supernav_content").$(byText("Home")).click());
        step("Проверить в открывшемся окне наличие текста: 'Community Activity'", () ->
                $(".community_home_title").shouldHave(text("Community Activity")));
        step("Навести мышку на кнопку 'COMMUNITY' в верхней части экрана", () ->
                $("#global_header").$(byText("COMMUNITY")).hover());
        step("Выбрать из выпадающего списка 'Discussions'", () ->
                $(".supernav_content").$(byText("Discussions")).click());
        step("Проверить в открывшемся окне наличие текста: 'Welcome to the Steam Discussions'", () ->
                $(".large_title").shouldHave(text("Welcome to the Steam Discussions")));
        step("Навести мышку на кнопку 'COMMUNITY' в верхней части экрана", () ->
                $("#global_header").$(byText("COMMUNITY")).hover());
        step("Выбрать из выпадающего списка 'Workshop'", () ->
                $(".supernav_content").$(byText("Workshop")).click());
        step("Проверить в открывшемся окне наличие текста: 'Workshop Home'", () ->
                $(".homeTabSpacer").shouldHave(text("Workshop Home")));
        step("Навести мышку на кнопку 'COMMUNITY' в верхней части экрана", () ->
                $("#global_header").$(byText("COMMUNITY")).hover());
        step("Выбрать из выпадающего списка 'Market'", () ->
                $(".supernav_content").$(byText("Market")).click());
        step("Проверить в открывшемся окне наличие текста: 'Community Market'", () ->
                $("#BG_top").shouldHave(text("Community Market")));
        step("Навести мышку на кнопку 'COMMUNITY' в верхней части экрана", () ->
                $("#global_header").$(byText("COMMUNITY")).hover());
        step("Выбрать из выпадающего списка 'Broadcasts'", () ->
                $(".supernav_content").$(byText("Broadcasts")).click());
        step("Проверить в открывшемся окне наличие текста: 'Community and official content for all games and software on Steam'", () ->
                $(".community_home_subtitle").$(byText("Community and official content for all games and software on Steam")));
    }
}
