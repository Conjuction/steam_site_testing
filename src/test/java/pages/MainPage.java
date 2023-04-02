package pages;

import com.codeborne.selenide.SelenideElement;
import localizationtesting.Locale;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {
    private final SelenideElement inputSearch =  $("#store_nav_search_term");
    private final SelenideElement dropdown =  $("#search_suggestion_contents");
    private final SelenideElement language =  $("#language_pulldown");
    private final SelenideElement languageChoice =  $("#language_dropdown");
    private final SelenideElement genre =  $(".home_page_gutter");

    public MainPage searchBox(String str){
        inputSearch.setValue(str);
        return this;
    }

    public MainPage dropdownList(String game){
        dropdown.shouldHave(text(game));
        return this;
    }

    public MainPage languageButton(){
        language.click();
        return this;
    }

    public MainPage choiceLanguage(Locale locale){
        languageChoice.$(byText((locale.getDesc()))).click();
        return this;
    }

    public MainPage checkButtons(List<String> buttons){
        $$(".supernav_container a").filter(visible).shouldHave(texts(buttons));
        return this;
    }

    public MainPage choiceGenre(String categories){
        genre.$(byText(categories)).click();
        return this;
    }
}
