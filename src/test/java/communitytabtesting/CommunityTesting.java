package communitytabtesting;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import helpers.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static io.qameta.allure.Allure.step;

public class CommunityTesting extends TestBase {
    @Test
    @Owner("Sukhinin Dmitrii")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка перехода по ссылкам из выпадающего списка 'COMMUNITY'")
    void dropdownTesting() {
        step("Навести мышку на кнопку 'COMMUNITY' в верхней части экрана", () ->
                communityButton.$(byText("COMMUNITY")).hover());
        step("Выбрать из выпадающего списка 'Home'", () ->
                communityDropdown.$(byText("Home")).click());
        step("Проверить в открывшемся окне наличие текста: 'Community Activity'", () ->
                headerActivity.shouldHave(text("Community Activity")));
        step("Навести мышку на кнопку 'COMMUNITY' в верхней части экрана", () ->
                communityButton.$(byText("COMMUNITY")).hover());
        step("Выбрать из выпадающего списка 'Discussions'", () ->
                communityDropdown.$(byText("Discussions")).click());
        step("Проверить в открывшемся окне наличие текста: 'Welcome to the Steam Discussions'", () ->
                headerDiscussions.shouldHave(text("Welcome to the Steam Discussions")));
        step("Навести мышку на кнопку 'COMMUNITY' в верхней части экрана", () ->
                communityButton.$(byText("COMMUNITY")).hover());
        step("Выбрать из выпадающего списка 'Workshop'", () ->
                communityDropdown.$(byText("Workshop")).click());
        step("Проверить в открывшемся окне наличие текста: 'Workshop Home'", () ->
                headerWorkshop.shouldHave(text("Workshop Home")));
        step("Навести мышку на кнопку 'COMMUNITY' в верхней части экрана", () ->
                communityButton.$(byText("COMMUNITY")).hover());
        step("Выбрать из выпадающего списка 'Market'", () ->
                communityDropdown.$(byText("Market")).click());
        step("Проверить в открывшемся окне наличие текста: 'Community Market'", () ->
                headerMarket.shouldHave(text("Community Market")));
        step("Навести мышку на кнопку 'COMMUNITY' в верхней части экрана", () ->
                communityButton.$(byText("COMMUNITY")).hover());
        step("Выбрать из выпадающего списка 'Broadcasts'", () ->
                communityDropdown.$(byText("Broadcasts")).click());
        step("Проверить в открывшемся окне наличие текста: 'Community and official content for all games and software on Steam'", () ->
                headerContent.$(byText("Community and official content for all games and software on Steam")));
    }
}
