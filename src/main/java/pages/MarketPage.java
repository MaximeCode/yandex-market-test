package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

import java.util.List;

public class MarketPage {
    @FindBy(xpath = "//div[@data-zone-name='category-link']")
    List<WebElement> menuItems;

    public MarketPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void clickMenuItem(String item) {
        try {
            menuItems.stream()
                    .map(e -> e.findElement(By.tagName("span")))
                    .filter(e -> e.getText().equals(item))
                    .findFirst()
                    .orElseThrow(() -> new Exception("Не найден пункт меню."))
                    .click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
