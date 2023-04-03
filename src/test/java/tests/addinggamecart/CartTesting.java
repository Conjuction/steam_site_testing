package tests.addinggamecart;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import helpers.TestBase;
import pages.AddCartPage;
import pages.MainPage;

import static io.qameta.allure.Allure.step;

public class CartTesting extends TestBase {
    MainPage mainPage = new MainPage();
    AddCartPage addCartPage = new AddCartPage();
    @ValueSource(
            strings = {"RimWorld", "Oxygen Not Included", "Mount & Blade II: Bannerlord"}
    )
    @Owner("Sukhinin Dmitrii")
    @Severity(SeverityLevel.BLOCKER)
    @ParameterizedTest(name = "Проверка добавления игры {0} в корзину")
    void testCart(String gameName) {
        mainPage.openPage();
        step("Ввести в поле поиска " + gameName + " и нажать Enter", () ->
                mainPage.enterName(gameName));
        step("В выпадающем списке нажать на " + gameName, () ->
                addCartPage.selectGame(gameName));
        step("На открывшейся странице проверить наличие " + gameName + " и нажать кнопку 'В корзину'", () ->
            addCartPage.addingCart(gameName));
        step("На открывшейся  странице проверить успешность добавления игры в корзину", () ->
            addCartPage.checkResult());
    }
}
