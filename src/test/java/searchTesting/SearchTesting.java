package searchTesting;

import helpers.TestBase;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;


public class SearchTesting extends TestBase {
    @CsvSource({
            "Dota, Dota 2",
            "mount, Mount & Blade II: Bannerlord",
            "dark, Dark and Darker"
    })
    @Owner("Sukhinin Dmitrii")
    @Severity(SeverityLevel.CRITICAL)
    @ParameterizedTest(name = "В выпадающем списке должен быть товар {1} при вводе {0}")
    void findGame(
            String str,
            String game
    ) {
        step("В окне посика ввести: " + str, () ->
                $("#store_nav_search_term").setValue(str));
        step("В выпадающем списке проверить наличие: " + game, () ->
                $("#search_suggestion_contents").shouldHave(text(game)));
    }
}
