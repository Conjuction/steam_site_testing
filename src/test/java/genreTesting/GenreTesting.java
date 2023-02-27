package genreTesting;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import helpers.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class GenreTesting extends TestBase {
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
        step("В левой чати экрана выбрать жанр: " + categories, () ->
                $(".home_page_gutter").$(byText(categories)).click());
        step("В открывшемся окне проверить наличие текста: " + str, () ->
                $(".responsive").shouldHave(text(str)));
        step("Нажать на логотип 'Steam' для перехода на главную страницу", () ->
                $("#logo_holder").click());
    }
}
