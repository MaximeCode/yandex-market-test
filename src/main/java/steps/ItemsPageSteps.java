package steps;

import io.qameta.allure.Step;
import pages.ItemsPage;

public class ItemsPageSteps {

    ItemsPage itemsPage = new ItemsPage();

    @Step("В меню выбираем пункт \"{0}\"")
    public void checkNumberOfItemsOnPage(int item) {
        itemsPage.checkNumberOfItemsOnPage(item);
    }

    @Step("В подменю выбираем подпункт \"{0}\"")
    public void search(String text) {
        itemsPage.search(text);
    }

    @Step("В подменю выбираем подпункт \"{0}\"")
    public void checkItemTitleByNumber(int number, String title) {
        itemsPage.checkItemTitleByNumber(number, title);
    }
}
