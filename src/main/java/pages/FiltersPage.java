package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FiltersPage {

    Wait<WebDriver> wait;

    @FindBy(xpath = "//h4[contains(text(), 'Цена')]/../..//div[@data-prefix='от']/input")
    WebElement priceFromInput;

    @FindBy(xpath = "//h4[contains(text(), 'Производитель')]/../..//input[@type='checkbox']")
    List<WebElement> makerCheckboxes;

    @FindBy(partialLinkText = "Показать")
    WebElement showButton;

    public FiltersPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 5);
    }

    public void inputPriceFrom(String price) {
        priceFromInput.sendKeys(price);
    }

    public void clickMakerCheckboxes(String... items) {
        try {
            Thread.sleep(5000);
            makerCheckboxes.stream()
                    .filter(e -> Arrays.asList(items).contains(e.getAttribute("value")))
                    .map(e -> wait.until(ExpectedConditions.elementToBeClickable(e.findElement(By.xpath("./..")))))
                    .collect(Collectors.toList())
                    .forEach(WebElement::click);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickShowButton() {
        showButton.click();
    }
}
