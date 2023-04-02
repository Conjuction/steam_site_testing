package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CommunityPage {
    private final SelenideElement communityButton = $("#global_header");
    private final SelenideElement communityDropdown =  $(".supernav_content");
    private final SelenideElement headerActivity =  $(".community_home_title");
    private final SelenideElement headerDiscussions =  $(".large_title");
    private final SelenideElement headerWorkshop =  $(".homeTabSpacer");
    private final SelenideElement headerMarket =  $("#BG_top");
    private final SelenideElement headerContent =  $(".community_home_subtitle");

   public CommunityPage hoverCommunity(){
      communityButton.$(byText("COMMUNITY")).hover();
      return this;
   }

    public CommunityPage selectHome(){
        communityDropdown.$(byText("Home")).click();
        return this;
    }

    public CommunityPage selectDiscussions(){
        communityDropdown.$(byText("Discussions")).click();
        return this;
    }

    public CommunityPage selectWorkshop(){
        communityDropdown.$(byText("Workshop")).click();
        return this;
    }

    public CommunityPage selectMarket(){
        communityDropdown.$(byText("Market")).click();
        return this;
    }

    public CommunityPage selectBroadcasts(){
        communityDropdown.$(byText("Broadcasts")).click();
        return this;
    }

    public CommunityPage checkResultHome(){
        headerActivity.shouldHave(text("Community Activity"));
        return this;
    }

    public CommunityPage checkResultDiscussions(){
        headerDiscussions.shouldHave(text("Welcome to the Steam Discussions"));
        return this;
    }

    public CommunityPage checkResultWorkshop(){
        headerWorkshop.shouldHave(text("Workshop Home"));
        return this;
    }

    public CommunityPage checkResultMarket(){
        headerMarket.shouldHave(text("Community Market"));
        return this;
    }

    public CommunityPage checkResultBroadcasts(){
        headerContent.$(byText("Community and official content for all games and software on Steam"));
        return this;
    }
}
