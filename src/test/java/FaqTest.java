import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import ru.praktikum.sprint4.pom.MainPageSteps;
import ru.praktikum.sprint4.rules.BrowserRule;
import ru.praktikum.sprint4.steps.Steps;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FaqTest {

    @Rule
    public final BrowserRule browserRule = new BrowserRule();

    private final String faqQuestion;
    private final String expectedAnswer;

    public FaqTest(String faqQuestion, String expectedText) {
        this.faqQuestion = faqQuestion;
        this.expectedAnswer = expectedText;
    }



    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {"Сколько это стоит? И как оплатить?","Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {"Хочу сразу несколько самокатов! Так можно?","Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, " +
                        "можете просто сделать несколько заказов — один за другим."},
                {"Как рассчитывается время аренды?","Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. " +
                        "Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. " +
                        "Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {"Можно ли заказать самокат прямо на сегодня?","Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {"Можно ли продлить заказ или вернуть самокат раньше?","Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому " +
                        "номеру 1010."},
                {"Вы привозите зарядку вместе с самокатом?","Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете " +
                        "кататься без передышек и во сне. Зарядка не понадобится."},
                {"Можно ли отменить заказ?","Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. " +
                        "Все же свои."},
                {"Я жизу за МКАДом, привезёте?","Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }

    @Test
    public void faqAnswerMustBeReturnedAsResponseToFaqQuestion() {
        for (WebDriver driver : browserRule.getDrivers()) {
            MainPageSteps mainPage = new MainPageSteps();
            Steps steps = new Steps(driver);

            String accordionButtonId = steps.open(mainPage.getUrl())
                    .click(mainPage.getFaqAccordionButtonByQuestionText(faqQuestion))
                    .getId(mainPage.getFaqAccordionButtonByQuestionText(faqQuestion));
                    
            String actualAnswer = steps.getText(mainPage.getFaqAccordionPanel(accordionButtonId));


            assertEquals("faqAnswerMustBeReturnedAsResponseToFaqQuestion failed for run with "
                    + driver.toString() + "expected answer: \"" + expectedAnswer + "\" but was \"" + actualAnswer + "\"",
                    expectedAnswer, actualAnswer);
        }
    }

}
