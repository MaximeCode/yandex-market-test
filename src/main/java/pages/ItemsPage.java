package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

import java.util.List;

public class ItemsPage {

    @FindBy(tagName = "article")
    List<WebElement> items;

    @FindBy(id = "header-search")
    WebElement searchInput;

    public ItemsPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void checkNumberOfItemsOnPage(int number) {
        Assert.assertEquals("Элементов на странице не столько, сколько ожидалось.", number, items.size());
    }

    public String getItemTitleByNumber(int number) {
        return items.get(number - 1).findElement(By.xpath(".//h3/a")).getAttribute("title");
    }

    public void search(String text) {
        String url = BaseSteps.getDriver().getCurrentUrl();
        searchInput.clear();
        searchInput.sendKeys(text + Keys.ENTER);
        new WebDriverWait(BaseSteps.getDriver(), 5).until(driver -> !driver.getCurrentUrl().equals(url));
    }

    public void checkItemTitleByNumber(int number, String title) {
        Assert.assertEquals("Выведен не тот элемент, который ожидался.",
                title, getItemTitleByNumber(number));
    }
}
