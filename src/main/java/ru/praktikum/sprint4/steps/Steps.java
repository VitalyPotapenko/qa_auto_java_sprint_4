package ru.praktikum.sprint4.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Steps {

    private final WebDriver driver;

    public Steps(WebDriver driver) {
        this.driver = driver;
    }

    public Steps open(String url) {
        driver.get(url);
        return this;
    }

    public Steps clickCoveredElement(By element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(element));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(element));
        return this;
    }

    public Steps click(By element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(element));
        driver.findElement(element).click();
        return this;
    }

    public Steps enterText(By element, String text) {
        driver.findElement(element).sendKeys(text);
        return this;
    }

    public Steps selectMenuItem(By inputField, By menuItem, String menuItemText) {
        driver.findElement(inputField).sendKeys(menuItemText);
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(menuItem)).click();
        return this;
    }

    public boolean checkExists(By element) {
        return !driver.findElements(element).isEmpty();
    }

    public String getText(By element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(element));
        return driver.findElement(element).getText();
    }

    public String getId(By element) {
        return driver.findElement(element).getAttribute("id");
    }

    public Steps waitUntilVisible(By element) {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(element));
        return this;
    }

    public Steps hitKey(By deliveryDate, Keys key) {
        driver.findElement(deliveryDate).sendKeys(key);
        return this;
    }

}
