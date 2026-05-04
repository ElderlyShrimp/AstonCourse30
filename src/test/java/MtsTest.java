import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.example.PaymentBlockPage;
import io.qameta.allure.Allure;

import java.io.FileInputStream;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Feature("Онлайн пополнение без комиссии")
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

    @Story("Проверка заголовка блока")
    @Description("Тест проверяет, что заголовок блока соответствует ожидаемому тексту")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    void checkBlockTitle(){
        String actualTitle = paymentBlock.getTitle();
        assertEquals("Онлайн пополнение\nбез комиссии", actualTitle);
    }

    @Story("Проверка логотипов платёжных систем")
    @Description("Тест проверяет, что логотипы Visa, MasterCard и др. отображаются на странице")
    @Severity(SeverityLevel.NORMAL)
    @Test
    void checkPaymentLogo(){
        int logosCount = paymentBlock.getPaymentLogosCount();
        assertTrue(logosCount >= 5);
        assertTrue(paymentBlock.areAllLogosDisplayed());
    }

    @Story("Проверка ссылки 'Подробнее о сервисе'")
    @Description("Тест проверяет, что ссылка работает и ведёт на страницу /help/")
    @Severity(SeverityLevel.NORMAL)
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

    @Story("Заполнение формы и проверка кнопки 'Продолжить'")
    @Description("Тест проверяет, что форма корректно заполняется")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    void checkFieldsAndContinue(){
        paymentBlock
                .selectService("Услуги связи")
                .typePhoneNumber("297777777")
                .typeSum("100")
                .clickContinueButton();
    }

    private void attachScreenshot() {
        try {
            Allure.addAttachment("Скриншот", new FileInputStream(
                    ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}