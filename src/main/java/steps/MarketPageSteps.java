package steps;

import io.qameta.allure.Step;
import pages.MainPage;
import pages.MarketPage;

public class MarketPageSteps {

    MarketPage marketPage = new MarketPage();

    @Step("В меню выбираем пункт \"{0}\"")
    public void clickMenuItem(String item) {
        marketPage.clickMenuItem(item);
    }
}
