package steps;

import io.qameta.allure.Step;
import pages.FiltersPage;
import pages.MainPage;

public class FiltersPageSteps {

    FiltersPage filtersPage = new FiltersPage();

    @Step("В меню выбираем пункт \"{0}\"")
    public void clickMenuItem(String item) {
        filtersPage.inputPriceFrom(item);
    }

    @Step("В подменю выбираем подпункт \"{0}\"")
    public void switchToNextWindow(String... items) {
        filtersPage.clickMakerCheckboxes(items);
    }

    @Step("В подменю выбираем подпункт \"{0}\"")
    public void clickShowButton() {
        filtersPage.clickShowButton();
    }
}
