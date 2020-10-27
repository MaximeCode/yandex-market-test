package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

import java.util.List;

public class MainPage {
    @FindBy(className = "services-new__item-title")
    List<WebElement> menuItems;

    public MainPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void clickMenuItem(String item) {
        try {
            menuItems.stream()
                    .filter(e -> e.getText().equals(item))
                    .findFirst()
                    .orElseThrow(() -> new Exception("Не найден пункт меню \"" + item +"\"."))
                    .click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void switchToNextWindow() {
        BaseSteps.getDriver().close();
        BaseSteps.getDriver().switchTo().window(BaseSteps.getDriver().getWindowHandles().stream()
                .findFirst().orElse(null));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
