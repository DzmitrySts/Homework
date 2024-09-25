import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;

public class MtsTest {

    private WebDriver driver;
    private MtsHomePage mtsHomePage;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://mts.by");
        mtsHomePage = new MtsHomePage(driver);
        MtsHomePage.acceptCookies(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    @Epic("Mts.by")
    @Feature("Homepage")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверка названия блока 'Онлайн пополнение без комиссии'")
    public void checkBlockName() {
        assertEquals("Онлайн пополнение\n" + "без комиссии", mtsHomePage.getBlockNameText());
        attachScreenshot();
    }

    @Test
    @Epic("Mts.by")
    @Feature("Homepage")
    @Severity(SeverityLevel.MINOR)
    @Description("Проверка наличия логотипов платежных систем")
    public void checkLogo() {
        assertTrue(mtsHomePage.isLogoVisible());
        attachScreenshot();
    }

    @Test
    @Epic("Mts.by")
    @Feature("Homepage")
    @Severity(SeverityLevel.MINOR)
    @Description("Проверка ссылки 'Подробнее о сервисе'")
    public void checkLink() {
        assertEquals("Подробнее о сервисе", mtsHomePage.getLinkText());
        mtsHomePage.clickLink();
        MtsHomePage.acceptCookies(driver);
        assertTrue(mtsHomePage.targetElementPresent());
        attachScreenshot();
        mtsHomePage.navigateBack();
    }

    @Test
    @Epic("Mts.by")
    @Feature("Homepage")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверка кнопки 'Продолжить'")
    public void checkButton() {
        mtsHomePage.enterPhoneNumber("297777777");
        mtsHomePage.enterSum("10");
        assertTrue(mtsHomePage.isContinueButtonEnabled());
        assertTrue(mtsHomePage.isContinueButtonVisible());
        mtsHomePage.clickContinueButton();
        MtsHomePage.switchToIframe(driver);
        assertTrue(mtsHomePage.newFrameVisible());
        attachScreenshot();
        driver.switchTo().defaultContent();
    }

    @Test
    @Epic("Mts.by")
    @Feature("Homepage")
    @Severity(SeverityLevel.MINOR)
    @Description("Проверка плейсхолдеров")
    public void checkPlaceholders() {
        mtsHomePage.dropdownButton();
        mtsHomePage.selectServices();
        assertEquals("Номер телефона", mtsHomePage.getPhoneInput());
        assertEquals("Сумма", mtsHomePage.getSumInput());
        assertEquals("E-mail для отправки чека", mtsHomePage.getEmailInput());
        attachScreenshot();

        mtsHomePage.dropdownButton();
        mtsHomePage.selectInternet();
        assertEquals("Номер абонента", mtsHomePage.getInternetPhoneInput());
        assertEquals("Сумма", mtsHomePage.getInternetSumInput());
        assertEquals("E-mail для отправки чека", mtsHomePage.getInternetEmailInput());
        attachScreenshot();

        mtsHomePage.dropdownButton();
        mtsHomePage.selectInstalment();
        assertEquals("Номер счета на 44", mtsHomePage.getInstalmentPhoneInput());
        assertEquals("Сумма", mtsHomePage.getInstalmentSumInput());
        assertEquals("E-mail для отправки чека", mtsHomePage.getInstalmentEmailInput());
        attachScreenshot();

        mtsHomePage.dropdownButton();
        mtsHomePage.selectDebt();
        assertEquals("Номер счета на 2073", mtsHomePage.getDebtPhoneInput());
        assertEquals("Сумма", mtsHomePage.getDebtSumInput());
        assertEquals("E-mail для отправки чека", mtsHomePage.getDebtEmailInput());
        attachScreenshot();
    }

    @Test
    @Epic("Mts.by")
    @Feature("Payment Process")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка процесса оплаты")
    public void checkPaymentProcess() {
        mtsHomePage.enterPhoneNumber("297777777");
        mtsHomePage.enterSum("10");
        assertTrue(mtsHomePage.isContinueButtonEnabled());
        assertTrue(mtsHomePage.isContinueButtonVisible());
        mtsHomePage.clickContinueButton();

        MtsHomePage.switchToIframe(driver);

        assertEquals("Оплата: Услуги связи Номер:375297777777", mtsHomePage.getPhoneNumberText());
        assertEquals("10.00 BYN", mtsHomePage.getSumText());
        assertEquals("Оплатить 10.00 BYN", mtsHomePage.getContinueButtonText());

        assertEquals("Номер карты", mtsHomePage.getCardNumberText());
        assertEquals("Срок действия", mtsHomePage.getExpirationDateText());
        assertEquals("CVC", mtsHomePage.getCVCText());
        assertEquals("Имя держателя (как на карте)", mtsHomePage.getCardHolderText());

        assertTrue(mtsHomePage.isPaymentIconsVisible());
        attachScreenshot();

        driver.switchTo().defaultContent();

    }

    @Step("Сделать скриншот")
    @Attachment(value = "Скриншот", type = "image/png")
    private void attachScreenshot() {
        takeScreenshot();
    }

    @Step("Сделать скриншот")
    private void takeScreenshot() {
        ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}