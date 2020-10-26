package steps;

import pages.MainPage;

public class MainPageSteps {

    MainPage mainPage = new MainPage();

    public void clickMenuItem(String item) {
        mainPage.clickMenuItem(item);
    }

    public void switchToNextWindow() {
        mainPage.switchToNextWindow();
    }
}
