//import org.junit.Test;
//import pages.*;
//
//public class YandexMarketTest extends BaseTest {
//
//    @Test
//    public void yandexMarketTest1() {
//        MainPage mainPage = new MainPage();
//        mainPage.clickMenuItem("Маркет");
//        mainPage.switchToNextWindow();
//        MarketPage marketPage = new MarketPage();
//        marketPage.clickMenuItem("Электроника");
//        MarketSectionPage marketSectionPage = new MarketSectionPage();
//        marketSectionPage.clickMenuItem("Телевизоры");
//        marketSectionPage.clickFiltersButton();
//        FiltersPage filtersPage = new FiltersPage();
//        filtersPage.inputPriceFrom("20000");
//        filtersPage.clickMakerCheckboxes("Samsung", "LG");
//        filtersPage.clickShowButton();
//        ItemsPage itemsPage = new ItemsPage();
//        itemsPage.checkNumberOfItemsOnPage(48);
//        String title = itemsPage.getItemTitleByNumber(1);
//        itemsPage.search(title);
//        itemsPage = new ItemsPage();
//        itemsPage.checkItemTitleByNumber(1, title);
//    }
//
//    @Test
//    public void yandexMarketTest2() {
//        MainPage mainPage = new MainPage();
//        mainPage.clickMenuItem("Маркет");
//        mainPage.switchToNextWindow();
//        MarketPage marketPage = new MarketPage();
//        marketPage.clickMenuItem("Электроника");
//        MarketSectionPage marketSectionPage = new MarketSectionPage();
//        marketSectionPage.clickMenuItem("Наушники и Bluetooth-гарнитуры");
//        marketSectionPage.clickFiltersButton();
//        FiltersPage filtersPage = new FiltersPage();
//        filtersPage.inputPriceFrom("5000");
//        filtersPage.clickMakerCheckboxes("Beats");
//        filtersPage.clickShowButton();
//        ItemsPage itemsPage = new ItemsPage();
//        itemsPage.checkNumberOfItemsOnPage(16);
//        String title = itemsPage.getItemTitleByNumber(1);
//        itemsPage.search(title);
//        itemsPage = new ItemsPage();
//        itemsPage.checkItemTitleByNumber(1, title);
//    }
//}
