package tests.localizationtesting;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import helpers.TestBase;
import pages.MainPage;

import java.util.List;
import java.util.stream.Stream;

import static io.qameta.allure.Allure.step;

public class LocalizationTesting extends TestBase {
    MainPage mainPage = new MainPage();

    static Stream<Arguments> mainPageSteamButtons() {
        return Stream.of(
                Arguments.of(Locale.UA, List.of("КРАМНИЦЯ", "СПІЛЬНОТА", "ПРО STEAM", "ПІДТРИМКА")),
                Arguments.of(Locale.EN, List.of("STORE", "COMMUNITY", "ABOUT", "SUPPORT")),
                Arguments.of(Locale.RU, List.of("МАГАЗИН", "СООБЩЕСТВО", "О STEAM", "ПОДДЕРЖКА"))
        );
    }

    @Owner("Sukhinin Dmitrii")
    @Severity(SeverityLevel.CRITICAL)
    @MethodSource
    @ParameterizedTest(name = "Для локализации {0} отображаются кнопки {1}")
    void mainPageSteamButtons(
            Locale locale,
            List<String> buttons
    ) {
        mainPage.openPage();
        step("В правой верхней части экрана нажать на кнопку выбора языка", () ->
                mainPage.languageButton());
        step("В выпадающем списке выбрать " + locale, () ->
                mainPage.choiceLanguage(locale));
        step("Проверить перевод кнопок на главной странице: " + buttons, () ->
                mainPage.checkButtons(buttons));
    }
}
