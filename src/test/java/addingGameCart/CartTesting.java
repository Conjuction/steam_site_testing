package addingGameCart;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import helpers.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
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
                $("#store_nav_search_term").setValue(gameName).pressEnter());
        step("В выпадающем списке нажать на " + gameName, () ->
                $("#search_resultsRows").$(byText(gameName)).click());
        step("На открывшейся странице проверить наличие " + gameName + " и нажать кнопку 'В корзину'", () -> {
            $("#appHubAppName").shouldHave(text(gameName));
            $(".btn_green_steamui").click();
        });
        step("На открывшейся  странице проверить успешность добваления игры в корзину", () -> {
            $(".page_content").shouldHave(text("YOUR SHOPPING CART"));
            $("#btn_purchase_self").shouldHave(text("Purchase for myself"));
            $("#btn_purchase_gift").shouldHave(text("Purchase as a gift"));
        });
    }
}
