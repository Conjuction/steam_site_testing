package tests.genretesting;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import helpers.TestBase;
import pages.MainPage;
import pages.ResultsPage;

import static io.qameta.allure.Allure.step;

public class GenreTesting extends TestBase {
    MainPage mainPage = new MainPage();
    ResultsPage resultsPage = new ResultsPage();
    @CsvSource({
            "Free to Play, FREE TO PLAY GAMES",
            "Early Access, EARLY ACCESS TITLES",
            "Action, ACTION",
            "Adventure, Adventure",
            "Casual, Casual",
            "Indie, Indie",
            "Massively Multiplayer, Massively Multiplayer",
            "Racing, Racing",
            "RPG, RPG",
            "Simulation, Simulation",
            "Sports, Sports",
            "Strategy, Strategy",
    })
    @Owner("Sukhinin Dmitrii")
    @Severity(SeverityLevel.CRITICAL)
    @ParameterizedTest(name = "При выборе игры по жанру {0}, переход на страницу {1}")
    void checkGenre(
            String categories,
            String str
    ) {
        mainPage.openPage();
        step("В левой части экрана выбрать жанр: " + categories, () ->
                mainPage.choiceGenre(categories));
        step("В открывшемся окне проверить наличие текста: " + str, () ->
                resultsPage.resultCheck(str));
        step("Нажать на логотип 'Steam' для перехода на главную страницу", () ->
                resultsPage.clickLogo());
    }
}
