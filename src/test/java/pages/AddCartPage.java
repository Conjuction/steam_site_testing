package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class AddCartPage {
    private final SelenideElement resultSearch =  $("#search_resultsRows");
    private final SelenideElement appName =  $("#appHubAppName");
    private final SelenideElement addButton =  $(".btn_green_steamui");
    private final SelenideElement pageContent =  $(".page_content");
    private final SelenideElement purchaseSelf =  $("#btn_purchase_self");
    private final SelenideElement purchaseGift =  $("#btn_purchase_gift");

    public AddCartPage selectGame(String gameName){
        resultSearch.$(byText(gameName)).click();
        return this;
    }

    public AddCartPage addingCart(String gameName){
        appName.shouldHave(text(gameName));
        addButton.click();
        return this;
    }

    public AddCartPage checkResult(){
        pageContent.shouldHave(text("YOUR SHOPPING CART"));
        purchaseSelf.shouldHave(text("Purchase for myself"));
        purchaseGift.shouldHave(text("Purchase as a gift"));
        return this;
    }
}
