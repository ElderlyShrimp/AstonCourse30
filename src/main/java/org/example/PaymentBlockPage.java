package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaymentBlockPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    // Локатор для куки
    private final By cookieButtonLocator = By.xpath("//*[@id=\"cookie-agree\"]");

    // Локатор для заголовка, логотипов и ссылки
    private final By titleLocator = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/h2");
    private final By logosContainerLocator = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul");
    private final By detailsLinkLocator = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/a");

    public PaymentBlockPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }

    public PaymentBlockPage acceptCookies() {
        try {
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(cookieButtonLocator));
            button.click();
        } catch (Exception ignored){}
        return this;
    }

    public String getTitle(){
        return driver.findElement(titleLocator).getText();
    }

    public int getPaymentLogosCount() {
        WebElement container = driver.findElement(logosContainerLocator);
        return container.findElements(By.tagName("img")).size();
    }

    public boolean areAllLogosDisplayed() {
        WebElement container = driver.findElement(logosContainerLocator);
        java.util.List<WebElement> logos = container.findElements(By.tagName("img"));
        for (WebElement logo : logos) {
            if (!logo.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public boolean detailsLinkDisplayed(){
        return driver.findElement(detailsLinkLocator).isDisplayed();
    }

    public boolean detailsLinkEnabled() {
        return driver.findElement(detailsLinkLocator).isEnabled();
    }

    public PaymentBlockPage clickDetailsLink() {
        driver.findElement(detailsLinkLocator).click();
        return this;
    }

    // Локаторы для формы оплаты
    private final By serviceSelectButtonLocator = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button");
    private final By serviceOptionsLocator = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li");
    private final By phoneInputLocator = By.id("connection-phone");
    private final By sumInputLocator = By.id("connection-sum");
    private final By continueButtonLocator = By.xpath("//*[@id=\"pay-connection\"]/button");

    public PaymentBlockPage selectService(String serviceName) {
        driver.findElement(serviceSelectButtonLocator).click();
        java.util.List<WebElement> options = driver.findElements(serviceOptionsLocator);
        for (WebElement option : options) {
            if (option.getText().contains(serviceName)) {
                option.click();
                break;
            }
        }
        return this;
    }

    public PaymentBlockPage typePhoneNumber(String phone) {
        WebElement phoneInput = driver.findElement(phoneInputLocator);
        phoneInput.clear();
        phoneInput.sendKeys(phone);
        return this;
    }

    public PaymentBlockPage typeSum(String sum) {
        WebElement sumInput = driver.findElement(sumInputLocator);
        sumInput.clear();
        sumInput.sendKeys(sum);
        return this;
    }

    public PaymentBlockPage clickContinueButton() {
        driver.findElement(continueButtonLocator).click();
        return this;
    }
}
