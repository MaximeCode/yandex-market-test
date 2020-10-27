package steps;

import io.qameta.allure.Step;
import pages.FiltersPage;
import pages.MainPage;

public class FiltersPageSteps {

    FiltersPage filtersPage = new FiltersPage();

    public void inputPriceFrom(String item) {
        filtersPage.inputPriceFrom(item);
    }

    public void clickMakerCheckbox(String item) {
        filtersPage.clickMakerCheckbox(item);
    }

    public void clickShowButton() {
        filtersPage.clickShowButton();
    }
}
