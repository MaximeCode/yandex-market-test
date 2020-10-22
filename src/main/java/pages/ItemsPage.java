package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ItemsPage {

    WebDriver driver;
    Wait<WebDriver> wait;

    @FindBy(tagName = "article")
    List<WebElement> items;

    @FindBy(id = "header-search")
    WebElement searchInput;

    public ItemsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 5);
        this.driver = driver;
    }

    public void checkNumberOfItemsOnPage(int number) {
        Assert.assertEquals("Элементов на странице не столько, сколько ожидалось.", number, items.size());
    }

    public String getItemTitleByNumber(int number) {
        return items.get(number - 1).findElement(By.xpath(".//h3/a")).getAttribute("title");
    }

    public void search(String text) {
        String url = driver.getCurrentUrl();
        searchInput.clear();
        searchInput.sendKeys(text + Keys.ENTER);
        wait.until(driver -> !driver.getCurrentUrl().equals(url));
    }

    public void checkItemTitleByNumber(int number, String title) {
        Assert.assertEquals("Выведен не тот элемент, который ожидался.",
                title, getItemTitleByNumber(number));
    }
}
