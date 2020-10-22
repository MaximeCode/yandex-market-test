import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class OldYandexMarketTest {
    WebDriver driver;
    String baseUrl;
    Wait<WebDriver> wait;

    @Before
    @Ignore
    public void before() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
//        System.setProperty("webdriver.gecko.driver", "driver/geckodriver.exe");
//        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        baseUrl = "https://yandex.ru";
        driver.get(baseUrl);
    }

    @Test
    @Ignore
    public void yandexTest1() throws Exception {
        List<WebElement> elements = driver.findElements(By.className("services-new__item-title"));
        elements.stream()
                .filter(e -> e.getText().equals("Маркет"))
                .findFirst()
                .orElseThrow(() -> new Exception("Не найден пункт меню."))
                .click();
        driver.close();
        driver.switchTo().window(driver.getWindowHandles().stream().findFirst().orElse(null));
        Thread.sleep(5000);
        elements = driver.findElements(By.xpath("//div[@data-zone-name='category-link']"));
        WebElement element = elements.stream()
                .map(e -> e.findElement(By.tagName("span")))
                .filter(e -> e.getText().equals("Электроника"))
                .findFirst()
                .orElseThrow(() -> new Exception("Не найден пункт меню."));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        elements = driver.findElements(By.xpath("//ul[@data-autotest-id='subItems']//a | //ul[@data-autotest-id='subItems']/../../div/a"));
        elements.stream()
                .filter(e -> e.getText().equals("Телевизоры"))
                .findFirst()
                .orElseThrow(() -> new Exception("Не найден пункт меню."))
                .click();
        element = driver.findElement(By.xpath("//span[text()='Все фильтры']"));
        element.click();
        element = driver.findElement(By.xpath("//h4[contains(text(), 'Цена')]/../..//div[@data-prefix='от']/input"));
        element.sendKeys("20000");
        Thread.sleep(5000);
        elements = driver.findElements(By.xpath("//h4[contains(text(), 'Производитель')]/../..//input[@type='checkbox']"));
        elements = elements.stream()
                .filter(e -> Arrays.asList("Samsung", "LG").contains(e.getAttribute("value")))
                .map(e -> wait.until(ExpectedConditions.elementToBeClickable(e.findElement(By.xpath("./..")))))
                .collect(Collectors.toList());
        elements.forEach(WebElement::click);
        driver.findElement(By.partialLinkText("Показать")).click();
        elements = driver.findElements(By.tagName("article"));
        Assert.assertEquals("Элементов на странице не столько, сколько ожидалось.", 48, elements.size());
        element = elements.get(0);
        String title = element.findElement(By.xpath(".//h3/a")).getAttribute("title");
        driver.findElement(By.id("header-search")).sendKeys(title);
        String url = driver.getCurrentUrl();
        new Actions(driver).sendKeys(Keys.ENTER).perform();
        wait.until(driver -> !url.equals(driver.getCurrentUrl()));
        elements = driver.findElements(By.tagName("article"));
        element = elements.get(0).findElement(By.xpath(".//h3/a"));
        Assert.assertEquals("Выведен не тот элемент, который ожидался.",
                title, element.getAttribute("title"));
    }

    @Test
    @Ignore
    public void yandexTest2() throws Exception {
        List<WebElement> elements = driver.findElements(By.className("services-new__item-title"));
        elements.stream()
                .filter(e -> e.getText().equals("Маркет"))
                .findFirst()
                .orElseThrow(() -> new Exception("Не найден пункт меню."))
                .click();
        driver.close();
        driver.switchTo().window(driver.getWindowHandles().stream().findFirst().orElse(null));
        Thread.sleep(5000);
        elements = driver.findElements(By.xpath("//div[@data-zone-name='category-link']"));
        WebElement element = elements.stream()
                .map(e -> e.findElement(By.tagName("span")))
                .filter(e -> e.getText().equals("Электроника"))
                .findFirst()
                .orElseThrow(() -> new Exception("Не найден пункт меню."));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        elements = driver.findElements(By.xpath("//ul[@data-autotest-id='subItems']//a | //ul[@data-autotest-id='subItems']/../../div/a"));
        elements.stream()
                .filter(e -> e.getText().equals("Наушники и Bluetooth-гарнитуры"))
                .findFirst()
                .orElseThrow(() -> new Exception("Не найден пункт меню."))
                .click();
        element = driver.findElement(By.xpath("//span[text()='Все фильтры']"));
        element.click();
        element = driver.findElement(By.xpath("//h4[contains(text(), 'Цена')]/../..//div[@data-prefix='от']/input"));
        element.sendKeys("5000");
        Thread.sleep(5000);
        elements = driver.findElements(By.xpath("//h4[contains(text(), 'Производитель')]/../..//input[@type='checkbox']"));
        elements = elements.stream()
                .filter(e -> e.getAttribute("value").equals("Beats"))
                .map(e -> wait.until(ExpectedConditions.elementToBeClickable(e.findElement(By.xpath("./..")))))
                .collect(Collectors.toList());
        elements.forEach(WebElement::click);
        driver.findElement(By.partialLinkText("Показать")).click();
        elements = driver.findElements(By.tagName("article"));
        Assert.assertEquals("Элементов на странице не столько, сколько ожидалось.", 16, elements.size());
        element = elements.get(0);
        String title = element.findElement(By.xpath(".//h3/a")).getAttribute("title");
        driver.findElement(By.id("header-search")).sendKeys(title);
        String url = driver.getCurrentUrl();
        new Actions(driver).sendKeys(Keys.ENTER).perform();
        wait.until(driver -> !url.equals(driver.getCurrentUrl()));
        elements = driver.findElements(By.tagName("article"));
        element = elements.get(0).findElement(By.xpath(".//h3/a"));
        Assert.assertEquals("Выведен не тот элемент, который ожидался.",
                title, element.getAttribute("title"));
    }

    @After
    @Ignore
    public void after() {
        driver.quit();
    }
}
