import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MtsTest {

    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeAll
    public static void setupDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterAll
    public static void closeBrowser(){
        driver.quit();
    }

    @BeforeEach
    public void openSite(){
        driver.get("https://www.mts.by/");
        acceptCookies();
    }

    @AfterEach
    public void closeSite() {
        if (driver != null) {
            driver.manage().deleteAllCookies();
        }
    }

    private void acceptCookies(){
        try {
            By cookieButton = By.xpath("//*[@id=\"cookie-agree\"]");
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(cookieButton));
            button.click();
        }
        catch (Exception ignored){}
    }

    @Test
    void checkBlockTitle(){
        WebElement title = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/h2"));
        assertEquals("Онлайн пополнение\nбез комиссии", title.getText());
    }

    @Test
    void checkPaymentLogo(){
        WebElement logoContainer = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul"));
        List<WebElement> logos = logoContainer.findElements(By.tagName("img"));
        assertTrue(logos.size() >= 5);
        for (WebElement logo : logos){
            assertTrue(logo.isDisplayed());
        }
    }

    @Test
    void checkLinkDetails(){
        WebElement link = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/a"));

        assertTrue(link.isDisplayed());
        assertTrue(link.isEnabled());
        link.click();

        wait.until(ExpectedConditions.urlContains("help"));
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("help"));

        driver.get("https://www.mts.by/");
    }

    @Test
    void checkFieldsAndContinue(){
        // Выбираем опцию Услуги связи
        WebElement serviceSelect = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button"));
        serviceSelect.click();
        WebElement communicationOption = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[1]/p"));
        communicationOption.click();

        WebElement phoneNumber = driver.findElement(By.xpath("//*[@id=\"connection-phone\"]"));
        phoneNumber.click();
        phoneNumber.sendKeys("297777777");

        WebElement sumInput = driver.findElement(By.xpath("//*[@id=\"connection-sum\"]"));
        sumInput.click();
        sumInput.sendKeys("100");

        WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        continueButton.click();


//        // Намеренно падающий тест для демонстрации неработающей кнопки "Продолжить"
//        assertNotEquals("https://www.mts.by/", driver.getCurrentUrl());
    }
}
