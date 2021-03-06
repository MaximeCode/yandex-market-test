package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class FiltersPage {

    @FindBy(xpath = "//h4[contains(text(), 'Цена')]/../..//div[@data-prefix='от']/input")
    WebElement priceFromInput;

    @FindBy(xpath = "//h4[contains(text(), 'Производитель')]/../..//input[@type='checkbox']")
    List<WebElement> makerCheckboxes;

    @FindBy(partialLinkText = "Показать")
    WebElement showButton;

    public FiltersPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void inputPriceFrom(String price) {
        priceFromInput.sendKeys(price);
    }

    public void clickMakerCheckbox(String item) {
        try {
            Thread.sleep(5000);
            makerCheckboxes.stream()
                    .filter(e -> item.equals(e.getAttribute("value")))
                    .map(e -> new WebDriverWait(BaseSteps.getDriver(), 5)
                            .until(ExpectedConditions.elementToBeClickable(e.findElement(By.xpath("./..")))))
                    .findFirst()
                    .orElseThrow(() -> new Error("Не удалось найти \"" + item + "\" среди производителей."))
                    .click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void clickShowButton() {
        showButton.click();
    }
}
