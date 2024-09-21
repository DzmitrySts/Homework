import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

import java.time.Duration;

public class MtsTest {

    private WebDriver driver;
    private MtsHomePage mtsHomePage;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver/chromedriver.exe"); // Замените на путь к ChromeDriver
        driver = new ChromeDriver();
        driver.get("https://mts.by");
        mtsHomePage = new MtsHomePage(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void checkBlockName() {
        assertEquals("Онлайн пополнение\n" + "без комиссии", mtsHomePage.getBlockNameText());
    }

    @Test
    public void checkLogo() {
        assertTrue(mtsHomePage.isLogoVisible());
    }

    @Test
    public void checkLink() {
        assertEquals("Подробнее о сервисе", mtsHomePage.getLinkText());
        mtsHomePage.clickLink();
        mtsHomePage.navigateBack();
    }

    @Test
    public void checkButton() {
        mtsHomePage.enterPhoneNumber("297777777");
        mtsHomePage.enterSum("10");
        assertTrue(mtsHomePage.isContinueButtonEnabled());
        assertTrue(mtsHomePage.isContinueButtonVisible());
        mtsHomePage.clickContinueButton();
    }

    @Test
    public void checkPlaceholders() {
        mtsHomePage.dropdownButton();
        mtsHomePage.selectServices();
        assertEquals("Номер телефона", mtsHomePage.getPlaceholder("//*[@id=\"connection-phone\"]"));
        assertEquals("Сумма", mtsHomePage.getPlaceholder("//*[@id=\"connection-sum\"]"));
        assertEquals("E-mail для отправки чека", mtsHomePage.getPlaceholder("//*[@id=\"connection-email\"]"));

        mtsHomePage.dropdownButton();
        mtsHomePage.selectInternet();
        assertEquals("Номер абонента", mtsHomePage.getPlaceholder("//*[@id=\"internet-phone\"]"));
        assertEquals("Сумма", mtsHomePage.getPlaceholder("//*[@id=\"internet-sum\"]"));
        assertEquals("E-mail для отправки чека", mtsHomePage.getPlaceholder("//*[@id=\"internet-email\"]"));

        mtsHomePage.dropdownButton();
        mtsHomePage.selectInstalment();
        assertEquals("Номер счета на 44", mtsHomePage.getPlaceholder("//*[@id=\"score-instalment\"]"));
        assertEquals("Сумма", mtsHomePage.getPlaceholder("//*[@id=\"instalment-sum\"]"));
        assertEquals("E-mail для отправки чека", mtsHomePage.getPlaceholder("//*[@id=\"instalment-email\"]"));

        mtsHomePage.dropdownButton();
        mtsHomePage.selectDebt();
        assertEquals("Номер счета на 2073", mtsHomePage.getPlaceholder("//*[@id=\"score-arrears\"]"));
        assertEquals("Сумма", mtsHomePage.getPlaceholder("//*[@id=\"arrears-sum\"]"));
        assertEquals("E-mail для отправки чека", mtsHomePage.getPlaceholder("//*[@id=\"arrears-email\"]"));
    }

    @Test
    public void checkPaymentProcess() {
        mtsHomePage.enterPhoneNumber("297777777");
        mtsHomePage.enterSum("10");
        assertTrue(mtsHomePage.isContinueButtonEnabled());
        assertTrue(mtsHomePage.isContinueButtonVisible());
        mtsHomePage.clickContinueButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[contains(@src, 'https://checkout.bepaid.by/widget_v2/index.html')]")));

        assertEquals("Оплата: Услуги связи\n" + "Номер:375297777777", mtsHomePage.getPhoneNumberText());
        assertEquals("10.00 BYN", mtsHomePage.getSumText());
        assertEquals("10.00 BYN", mtsHomePage.getContinueButtonText());
        assertEquals("Номер карты", mtsHomePage.getCardPlaceholderTextByXPath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[1]/label"));
        assertEquals("Срок действия", mtsHomePage.getCardPlaceholderTextByXPath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[1]/app-input/div/div/div[1]/label"));
        assertEquals("CVV", mtsHomePage.getCardPlaceholderTextByXPath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[3]/app-input/div/div/div[1]/label"));
        assertEquals("Имя держателя (как на карте)", mtsHomePage.getCardPlaceholderTextByXPath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[3]/app-input/div/div/div[1]/label"));

        assertTrue(mtsHomePage.isVisaIconVisible());
        assertTrue(mtsHomePage.isMastercardIconVisible());
        assertTrue(mtsHomePage.isBelcardIconVisible());
        assertTrue(mtsHomePage.isMaestroIconVisible());

        driver.switchTo().defaultContent();
    }
}