package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ResultsPage {
    private final SelenideElement result =  $(".responsive");
    private final SelenideElement logo =  $("#logo_holder");

    public ResultsPage resultCheck(String str){
        result.shouldHave(text(str));
        return this;
    }

    public ResultsPage clickLogo(){
        logo.click();
        return this;
    }
}
