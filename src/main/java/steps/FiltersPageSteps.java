package steps;

import io.qameta.allure.Step;
import pages.FiltersPage;
import pages.MainPage;

public class FiltersPageSteps {

    FiltersPage filtersPage = new FiltersPage();

    public void inputPriceFrom(String item) {
        filtersPage.inputPriceFrom(item);
    }

    public void clickMakerCheckboxes(String... items) {
        filtersPage.clickMakerCheckboxes(items);
    }

    public void clickShowButton() {
        filtersPage.clickShowButton();
    }
}
