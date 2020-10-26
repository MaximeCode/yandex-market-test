package steps;

import io.qameta.allure.Step;
import pages.MainPage;
import pages.MarketSectionPage;

public class MarketSectionPageSteps {

    MarketSectionPage marketSectionPage = new MarketSectionPage();

    @Step("В меню выбираем пункт \"{0}\"")
    public void clickMenuItem(String item) {
        marketSectionPage.clickMenuItem(item);
    }

    @Step("В подменю выбираем подпункт \"{0}\"")
    public void clickFiltersButton() {
        marketSectionPage.clickFiltersButton();
    }
}
