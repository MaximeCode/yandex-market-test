package steps;

import io.qameta.allure.Step;
import pages.MainPage;

public class MainPageSteps {

    MainPage mainPage = new MainPage();

    @Step("В меню выбираем пункт \"{0}\"")
    public void clickMenuItem(String item) {
        mainPage.clickMenuItem(item);
    }

    @Step("В подменю выбираем подпункт \"{0}\"")
    public void switchToNextWindow() {
        mainPage.switchToNextWindow();
    }
}
