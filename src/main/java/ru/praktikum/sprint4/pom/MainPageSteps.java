package ru.praktikum.sprint4.pom;

import org.openqa.selenium.By;

public class MainPageSteps {

    private final String url = "https://qa-scooter.praktikum-services.ru/";
    //локатор верхней кнопки "Заказать"
    private final By topOrderButton = By.xpath(".//div[contains(@class,'Header_Nav')]" + "//button[text()='Заказать']");
    //локатор нижней кнопки "Заказать"
    private final By bottomOrderButton = By.xpath(".//div[contains(@class,'Home_FinishButton')]" + "//button[text()='Заказать']");
    //общая часть локатора для хэдера списка важных вопросов
    private final String faqAccordionPanel = ".//div[@aria-labelledby='";
    //общая часть локатора для кнопок раскрытия элементов списка FAQ
    private final String faqAccordionItemButton = ".//div[@data-accordion-component='AccordionItemButton' " + "and text()='";

    public String getUrl() {
        return url;
    }

    public By getFaqAccordionButtonByQuestionText(String faqQuestionText) {
        return By.xpath(faqAccordionItemButton + faqQuestionText + "']");
    }

    public By getFaqAccordionPanel(String id) {
        return By.xpath(faqAccordionPanel + id + "']//p");
    }

    public By getOrderButton(String orderButton) {
        switch (orderButton) {
            case "topOrderButton":
                return topOrderButton;
            case "bottomOrderButton":
                return bottomOrderButton;
            default:
                throw new IllegalArgumentException("orderButton parameter values must be either topOrderButton or " + "bottomOrderButton but was: " + orderButton);
        }
    }

}
