package localizationTesting;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import helpers.TestBase;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class LocalizationTesting extends TestBase {

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
        step("В правой верхней части экрана нажать на кнопку выбора языка", () ->
                language.click());
        step("В выпадающем списке выбрать " + locale, () ->
                languageChoice.$(byText((locale.getDesc()))).click());
        step("Проверить перевод кнопок на главной странице: " + buttons, () ->
                $$(".supernav_container a").filter(visible).shouldHave(texts(buttons)));
    }
}
