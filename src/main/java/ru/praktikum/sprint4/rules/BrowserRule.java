package ru.praktikum.sprint4.rules;

import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class BrowserRule extends ExternalResource {

    private WebDriver driver;

    protected void before() {
        String browserName = getBrowser();
        switch (browserName) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                FirefoxOptions ffOptions = new FirefoxOptions();
                ffOptions.addArguments("-headless");
                driver = new FirefoxDriver(ffOptions);
                break;
            default:
                System.out.println("Поддерживауются chrome и firefox. А вы выбрали " + browserName);
        }
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    protected void after() {
        driver.quit();

    }

    public WebDriver getDriver() {
        return driver;
    }

    private String getBrowser() {
        String value = System.getProperty("browser");
        if (value == null) throw new RuntimeException("browser is not specified as a run config option yet!");
        if (value.isEmpty()) throw new RuntimeException("browser run config option is empty!");
        return value;
    }
}
