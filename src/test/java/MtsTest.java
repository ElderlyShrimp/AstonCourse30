import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.example.PaymentBlockPage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class MtsTest {

    private static WebDriver driver;
    private static WebDriverWait wait;
    private PaymentBlockPage paymentBlock;

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
        paymentBlock = new PaymentBlockPage(driver);
        paymentBlock.acceptCookies();
    }

    @AfterEach
    public void closeSite() {
        if (driver != null) {
            driver.manage().deleteAllCookies();
        }
    }

    @Test
    void checkBlockTitle(){
        String actualTitle = paymentBlock.getTitle();
        assertEquals("Онлайн пополнение\nбез комиссии", actualTitle);
    }

    @Test
    void checkPaymentLogo(){
        int logosCount = paymentBlock.getPaymentLogosCount();
        assertTrue(logosCount >= 5);
        assertTrue(paymentBlock.areAllLogosDisplayed());
    }

    @Test
    void checkLinkDetails(){
        assertTrue(paymentBlock.detailsLinkDisplayed());
        assertTrue(paymentBlock.detailsLinkEnabled());

        paymentBlock.clickDetailsLink();

        wait.until(ExpectedConditions.urlContains("help"));
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("help"));

        driver.get("https://www.mts.by/");
        paymentBlock.acceptCookies();
    }

    @Test
    void checkFieldsAndContinue(){
        paymentBlock
                .selectService("Услуги связи")
                .typePhoneNumber("297777777")
                .typeSum("100")
                .clickContinueButton();
    }
}