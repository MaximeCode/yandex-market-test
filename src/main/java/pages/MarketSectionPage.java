package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

import java.util.List;

public class MarketSectionPage {
    @FindBy(xpath = "//ul[@data-autotest-id='subItems']//a | //ul[@data-autotest-id='subItems']/../../div/a")
    List<WebElement> menuItems;

    @FindBy(xpath = "//span[text()='Все фильтры']")
    WebElement filtersButton;

    public MarketSectionPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
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

    public void clickFiltersButton() {
        filtersButton.click();
    }

}
