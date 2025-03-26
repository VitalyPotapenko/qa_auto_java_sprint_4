package ru.praktikum.sprint4.rules;

import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BrowserRule extends ExternalResource {

    private final Set<WebDriver> drivers = new HashSet<>();

    protected void before() {
        //Создаём драйвер для Mozilla FireFox
        FirefoxOptions ffOptions = new FirefoxOptions();
        ffOptions.addArguments("-headless");
        WebDriver ffDriver = new FirefoxDriver(ffOptions);
        ffDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        drivers.add(ffDriver);
        //Создаём драйвер для Google Chrome
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        WebDriver chromeDriver = new ChromeDriver(chromeOptions);
        chromeDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        drivers.add(chromeDriver);
    }

    protected void after() {
        for (WebDriver driver : drivers) {
            driver.quit();
        }
    }

    public Set<WebDriver> getDrivers() {
        return drivers;
    }
}
