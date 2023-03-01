package addingGameCart;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import helpers.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static io.qameta.allure.Allure.step;

public class CartTesting extends TestBase {
    @ValueSource(
            strings = {"RimWorld", "Oxygen Not Included", "Mount & Blade II: Bannerlord"}
    )
    @Owner("Sukhinin Dmitrii")
    @Severity(SeverityLevel.BLOCKER)
    @ParameterizedTest(name = "Проверка добавления игры {0} в корзину")
    void testCart(String gameName) {
        step("Ввести в поле поиска " + gameName + " и нажать Enter", () ->
                inputSearch.setValue(gameName).pressEnter());
        step("В выпадающем списке нажать на " + gameName, () ->
                resultSearch.$(byText(gameName)).click());
        step("На открывшейся странице проверить наличие " + gameName + " и нажать кнопку 'В корзину'", () -> {
            appName.shouldHave(text(gameName));
            addButton.click();
        });
        step("На открывшейся  странице проверить успешность добваления игры в корзину", () -> {
            pageContent.shouldHave(text("YOUR SHOPPING CART"));
            purchaseSelf.shouldHave(text("Purchase for myself"));
            purchaseGift.shouldHave(text("Purchase as a gift"));
        });
    }
}
