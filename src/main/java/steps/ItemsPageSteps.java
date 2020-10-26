package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.ItemsPage;

public class ItemsPageSteps {

    ItemsPage itemsPage = new ItemsPage();

    public void checkNumberOfItemsOnPage(int item) {
        itemsPage.checkNumberOfItemsOnPage(item);
    }

    public void search(String text) {
        itemsPage.search(text);
    }

    public void checkItemTitleByNumber(int number, String title) {
        itemsPage.checkItemTitleByNumber(number, title);
    }

    public String getItemTitleByNumber(int number) {
        return getItemTitleByNumber(number);
    }
}
