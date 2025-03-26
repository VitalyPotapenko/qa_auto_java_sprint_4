package ru.praktikum.sprint4.pom;

import org.openqa.selenium.By;

public class OrderPageSteps {

    //локатор поля "Имя"
    private final By customerFirstName = By.xpath(".//input[@placeholder='* Имя']");
    //локатор поля "Фамилия"
    private final By customerFamilyName = By.xpath(".//input[@placeholder='* Фамилия']");
    //локатор поля "Адрес: куда привезти заказ"
    private final By customerAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //локатор поля "* Станция метро"
    private final By customerUndergroundStation = By.xpath(".//input[@placeholder='* Станция метро']");
    //локатор выбора значения станции метро
    private final String undergroundStationMenuItem = ".//li[@class='select-search__row']" + "//div[text()='";
    //локатор поля "* Телефон: на него позвонит курьер"
    private final By customerPhoneNumber = By.xpath(".//input[@placeholder='* Телефон: на него позвонит " + "курьер']");
    //локатор поля "* Когда привезти самокат"
    private final By orderDeliveryDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //Локатор кнопки "Далее"
    private final By nextButton = By.xpath(".//div[contains(@class,'Order_NextButton__')]" + "//button[text()='Далее']");
    //Локатор выпадающего меню "* Срок аренды"
    private final By rentPeriodMenu = By.xpath(".//div[@class = 'Dropdown-placeholder']");
    //Локатор пунктов выпадающего меню "* Срок аренды"
    private final String rentPeriodItem = ".//div[@class='Dropdown-menu']//div[@class='Dropdown-option' " + "and text()='";
    //Локатор чекбокса с выбором Цвета самоката
    private final String colourCheckbox = ".//input[@id='";
    //Локатор текстового поля "Комментарий для курьера"
    private final By commentForDelivery = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //Локатор кнопки "Заказать"
    private final By orderButton = By.xpath(".//div[contains(@class,'Order_Buttons__')]" + "//button[text()='Заказать']");
    //Локатор окна подтверждения заказа
    private final By orderConfirmationModalWindow = By.xpath(".//div[contains(@class,'Order_Modal__')]");
    //Локатор кнопки подтверждения заказа
    private final By confirmationButton = By.xpath(".//div[contains(@class,'Order_Buttons__')]" + "//button[text()='Да']");
    //Локатор окна сообщения об успешном офрмлении заказа
    private final By orderSuccessInformationWindow = By.xpath(".//div[contains(@class,'Order_ModalHeader__')" + "and text()='Заказ оформлен']");

    public By getCustomerFirstName() {
        return customerFirstName;
    }

    public By getCustomerFamilyName() {
        return customerFamilyName;
    }

    public By getCustomerAddress() {
        return customerAddress;
    }

    public By getCustomerUndergroundStationInputField() {
        return customerUndergroundStation;
    }

    public By getUndergroundStationMenuItem(String station) {
        return By.xpath(undergroundStationMenuItem + station + "']");
    }

    public By getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public By getNextButton() {
        return nextButton;
    }

    public By getOrderDeliveryDate() {
        return orderDeliveryDate;
    }

    public By getRentPeriodMenu() {
        return rentPeriodMenu;
    }

    public By getRentPeriodItem(String itemText) {
        return By.xpath(rentPeriodItem + itemText + "']");
    }

    public By getColourCheckbox(String colour) {
        return By.xpath(colourCheckbox + colour + "']");
    }

    public By getCommentForDelivery() {
        return commentForDelivery;
    }

    public By getOrderButton() {
        return orderButton;
    }

    public By getOrderConfirmationModalWindow() {
        return orderConfirmationModalWindow;
    }

    public By getConfirmationButton() {
        return confirmationButton;
    }

    public By getOrderSuccessInformationWindow() {
        return orderSuccessInformationWindow;
    }
}
