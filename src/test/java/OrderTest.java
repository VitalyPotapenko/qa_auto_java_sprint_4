import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import ru.praktikum.sprint4.pom.MainPageSteps;
import ru.praktikum.sprint4.pom.OrderPageSteps;
import ru.praktikum.sprint4.rules.BrowserRule;
import ru.praktikum.sprint4.steps.Steps;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderTest {

    @Rule
    public final BrowserRule browserRule = new BrowserRule();

    private final String orderButton;
    private final String customerName;
    private final String customerFamilyName;
    private final String customerAddress;
    private final String customerUndergroundStation;
    private final String customerPhoneNumber;
    private final String deliveryDateShift;
    private final String rentPeriod;
    private final String colour;
    private final String commentForDelivery;


    public OrderTest(String orderButton, String customerName, String customerFamilyName, String customerAddress, String customerUndergroundStation, String customerPhoneNumber, String deliveryDateShift, String rentPeriod, String colour, String commentForDelivery) {
        this.orderButton = orderButton;
        this.customerName = customerName;
        this.customerFamilyName = customerFamilyName;
        this.customerAddress = customerAddress;
        this.customerUndergroundStation = customerUndergroundStation;
        this.customerPhoneNumber = customerPhoneNumber;
        this.deliveryDateShift = deliveryDateShift;
        this.rentPeriod = rentPeriod;
        this.colour = colour;
        this.commentForDelivery = commentForDelivery;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{{"topOrderButton", "Имя", "Фамилия", "Улица Дом", "Бульвар Рокоссовского", "77777777777", "1", "сутки", "black", "комментарий"},
                {"bottomOrderButton", "Имярек", "ФАМИЛИЯ", "Улица Дом Квартира", "Театральная", "00000000000", "30", "семеро суток", "grey", "comment"},};
    }


    @Test
    public void orderShouldBeCreatedSuccessfullyWhenOrderAttributesFilledCorrectly() {

        WebDriver driver = browserRule.getDriver();
        MainPageSteps mainPage = new MainPageSteps();
        OrderPageSteps orderPage = new OrderPageSteps();
        Steps steps = new Steps(driver);

        try {
            steps.open(mainPage.getUrl()).clickCoveredElement(mainPage.getOrderButton(orderButton));
            steps.enterText(orderPage.getCustomerFirstName(), customerName).enterText(orderPage.getCustomerFamilyName(), customerFamilyName).enterText(orderPage.getCustomerAddress(), customerAddress).selectMenuItem(orderPage.getCustomerUndergroundStationInputField(), orderPage.getUndergroundStationMenuItem(customerUndergroundStation), customerUndergroundStation).enterText(orderPage.getCustomerPhoneNumber(), customerPhoneNumber).clickCoveredElement(orderPage.getNextButton()).enterText(orderPage.getOrderDeliveryDate(), calculateDeliveryDate(deliveryDateShift)).hitKey(orderPage.getOrderDeliveryDate(), Keys.RETURN).click(orderPage.getRentPeriodMenu()).click(orderPage.getRentPeriodItem(rentPeriod)).click(orderPage.getColourCheckbox(colour)).enterText(orderPage.getCommentForDelivery(), commentForDelivery).clickCoveredElement(orderPage.getOrderButton()).waitUntilVisible(orderPage.getOrderConfirmationModalWindow()).click(orderPage.getConfirmationButton());
            //При успешном оформлении заказа ожидается появление информационного окна
            assertTrue("Order was not created successfully", steps.checkExists(orderPage.getOrderSuccessInformationWindow()));
        } catch (IllegalArgumentException e) {
            Assert.fail("Incorrect Arguments were used. " + e.getMessage());
        }
    }

    private String calculateDeliveryDate(String deliveryDateShift) {
        LocalDate today = LocalDate.now();
        LocalDate deliveryDate = today.plusDays(Long.parseLong(deliveryDateShift));
        return deliveryDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

}
