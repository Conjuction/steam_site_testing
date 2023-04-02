package searchtesting;

import helpers.TestBase;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.MainPage;

import static io.qameta.allure.Allure.step;

public class SearchTesting extends TestBase {
    MainPage mainPage = new MainPage();
    @CsvSource({
            "Dota, Dota 2",
            "mount, Mount & Blade II: Bannerlord",
            "dark, Dark Souls"
    })
    @Owner("Sukhinin Dmitrii")
    @Severity(SeverityLevel.CRITICAL)
    @ParameterizedTest(name = "В выпадающем списке должен быть товар {1} при вводе {0}")
    void findGame(
            String str,
            String game
    ) {
        step("В окне поиска ввести: " + str, () ->
                mainPage.searchBox(str));
        step("В выпадающем списке проверить наличие: " + game, () ->
                mainPage.dropdownList(game));
    }
}
