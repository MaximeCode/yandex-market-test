package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage {
    @FindBy(className = "services-new__item-title")
    List<WebElement> menuItems;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickMenuItem(String item) {
        try {
            menuItems.stream()
                    .filter(e -> e.getText().equals(item))
                    .findFirst()
                    .orElseThrow(() -> new Exception("Не найден пункт меню."))
                    .click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void switchToNextWindow(WebDriver driver) {
        driver.close();
        driver.switchTo().window(driver.getWindowHandles().stream().findFirst().orElse(null));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
