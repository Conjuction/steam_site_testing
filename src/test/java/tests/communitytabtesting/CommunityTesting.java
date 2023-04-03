package tests.communitytabtesting;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import helpers.TestBase;
import pages.CommunityPage;

import static io.qameta.allure.Allure.step;

public class CommunityTesting extends TestBase {
    @Test
    @Owner("Sukhinin Dmitrii")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка перехода по ссылкам из выпадающего списка 'COMMUNITY'")
    void dropdownTesting() {
        CommunityPage communityPage = new CommunityPage();

        step("Навести мышку на кнопку 'COMMUNITY' в верхней части экрана", () ->
                communityPage.hoverCommunity());
        step("Выбрать из выпадающего списка 'Home'", () ->
                communityPage.selectHome());
        step("Проверить в открывшемся окне наличие текста: 'Community Activity'", () ->
                communityPage.checkResultHome());
        step("Навести мышку на кнопку 'COMMUNITY' в верхней части экрана", () ->
                communityPage.hoverCommunity());
        step("Выбрать из выпадающего списка 'Discussions'", () ->
                communityPage.selectDiscussions());
        step("Проверить в открывшемся окне наличие текста: 'Welcome to the Steam Discussions'", () ->
                communityPage.checkResultDiscussions());
        step("Навести мышку на кнопку 'COMMUNITY' в верхней части экрана", () ->
                communityPage.hoverCommunity());
        step("Выбрать из выпадающего списка 'Workshop'", () ->
                communityPage.selectWorkshop());
        step("Проверить в открывшемся окне наличие текста: 'Workshop Home'", () ->
                communityPage.checkResultWorkshop());
        step("Навести мышку на кнопку 'COMMUNITY' в верхней части экрана", () ->
                communityPage.hoverCommunity());
        step("Выбрать из выпадающего списка 'Market'", () ->
                communityPage.selectMarket());
        step("Проверить в открывшемся окне наличие текста: 'Community Market'", () ->
                communityPage.checkResultMarket());
        step("Навести мышку на кнопку 'COMMUNITY' в верхней части экрана", () ->
                communityPage.hoverCommunity());
        step("Выбрать из выпадающего списка 'Broadcasts'", () ->
                communityPage.selectBroadcasts());
        step("Проверить в открывшемся окне наличие текста: 'Community and official content for all games and software on Steam'", () ->
                communityPage.checkResultBroadcasts());
    }
}
