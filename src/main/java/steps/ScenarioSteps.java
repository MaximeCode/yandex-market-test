package steps;

import io.cucumber.java.ru.Допустим;

public class ScenarioSteps {

    MainPageSteps mainPageSteps = new MainPageSteps();
    MarketPageSteps marketPageSteps = new MarketPageSteps();
    MarketSectionPageSteps marketSectionPageSteps = new MarketSectionPageSteps();
    FiltersPageSteps filtersPageSteps = new FiltersPageSteps();
    ItemsPageSteps itemsPageSteps = new ItemsPageSteps();

    public static String stash;

    @Допустим("Переходим в {string}")
    public void переходим_в_(String string) {
        mainPageSteps.clickMenuItem(string);
        mainPageSteps.switchToNextWindow();
    }

    @Допустим("Выбираем раздел {string}")
    public void выбираем_раздел(String string) {
        marketPageSteps.clickMenuItem(string);
    }

    @Допустим("Выбираем подраздел {string}")
    public void выбираем_подраздел(String string) {
        marketSectionPageSteps.clickMenuItem(string);
    }

    @Допустим("Заходим в расширенный поиск")
    public void заходим_в_расширенный_поиск() {
        marketSectionPageSteps.clickFiltersButton();
    }

    @Допустим("Задаём параметр поиска по цене от {string} рублей.")
    public void задаём_параметр_поиска_по_цене_от(String string) {
        filtersPageSteps.inputPriceFrom(string);
    }

    @Допустим("Выбираем производителей {string} и {string}.")
    public void выбираем_производителей_(String... strings) {
        filtersPageSteps.clickMakerCheckboxes(strings);
    }

    @Допустим("Выбираем производителей {string}.")
    public void выбираем_производителей_(String string) {
        filtersPageSteps.clickMakerCheckboxes(string);
    }

    @Допустим("Нажимаем кнопку \"Применить\".")
    public void нажимаем_кнопку_Применить() {
        filtersPageSteps.clickShowButton();
    }

    @Допустим("Проверяем, что элементов на странице {int}.")
    public void проверяем_что_элементов_на_странице(Integer number) {
        itemsPageSteps.checkNumberOfItemsOnPage(number);
    }

    @Допустим("Запоминаем первый элемент в списке.")
    public void запоминаем_первый_элемент_в_списке() {
        stash = itemsPageSteps.getItemTitleByNumber(1);
    }

    @Допустим("В поисковую строку вводим запомненное значение.")
    public void в_поисковую_строку_вводим_запомненное_значение() {
        itemsPageSteps.search(stash);
    }

    @Допустим("Находим и проверяем, что наименование товара соответствует запомненному значению.")
    public void находим_и_проверяем_что_наименование_товара_соответствует_запомненному_значению() {
        itemsPageSteps.checkItemTitleByNumber(1, stash);
    }
}
