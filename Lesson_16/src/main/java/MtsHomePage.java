import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.time.Duration;

public class MtsHomePage {

    private WebDriver driver;

    public MtsHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public static void acceptCookies(WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement acceptCookiesButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Принять')]")));
            acceptCookiesButton.click();
        } catch (Exception e) {
            System.out.println("Окно с принятием куки не найдено");
        }
    }

    public String getBlockNameText() {
        return driver.findElement(By.xpath("//h2[contains(text(), 'Онлайн пополнение')]")).getText();
    }

    public boolean isLogoVisible() {
        List<WebElement> paymentLogo = driver.findElements(By.cssSelector(".pay__partners li"));
        int expectedLogoCount = 5;
        return !paymentLogo.isEmpty() && paymentLogo.size() == expectedLogoCount;
    }

    public String getLinkText() {
        return driver.findElement(By.xpath("//a[contains(text(), 'Подробнее о сервисе')]")).getText();
    }

    public void clickLink() {
        driver.findElement(By.xpath("//a[contains(text(), 'Подробнее о сервисе')]")).click();
    }

    public boolean targetElementPresent() {
        return driver.findElement(By.xpath("//span[text()='Порядок оплаты и безопасность интернет платежей']")).isDisplayed();
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public void enterPhoneNumber(String phoneNumber) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement phoneInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='connection-phone']")));
        phoneInput.sendKeys(phoneNumber);
    }

    public void enterSum(String sum) {
        driver.findElement(By.xpath("//*[@id='connection-sum']")).sendKeys(sum);
    }

    public boolean isContinueButtonEnabled() {
        return driver.findElement(By.xpath("//*[@id='pay-connection']/button")).isEnabled();
    }

    public boolean isContinueButtonVisible() {
        return driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button")).isDisplayed();
    }

    public void clickContinueButton() {
        driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button")).click();
    }

    public boolean newFrameVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='app-wrapper__content']"))).isDisplayed();
    }

    public void dropdownButton() {
        driver.findElement(By.xpath("//button[@class='select__header']")).click();
    }

    public void selectServices() {
        driver.findElement(By.xpath("//p[contains(text(), 'Услуги связи')]")).click();
    }

    public void selectInternet() {
        driver.findElement(By.xpath("//p[contains(text(), 'Домашний интернет')]")).click();
    }

    public void selectInstalment() {
        driver.findElement(By.xpath("//p[contains(text(), 'Рассрочка')]")).click();
    }

    public void selectDebt() {
        driver.findElement(By.xpath("//p[contains(text(), 'Задолженность')]")).click();
    }

    public String getPhoneInput() {
        return driver.findElement(By.xpath("//*[@id='connection-phone']")).getAttribute("placeholder");
    }

    public String getSumInput() {
        return driver.findElement(By.xpath("//*[@id='connection-sum']")).getAttribute("placeholder");
    }

    public String getEmailInput() {
        return driver.findElement(By.xpath("//*[@id='connection-email']")).getAttribute("placeholder");
    }

    public String getInternetPhoneInput() {
        return driver.findElement(By.xpath("//*[@id='internet-phone']")).getAttribute("placeholder");
    }

    public String getInternetSumInput() {
        return driver.findElement(By.xpath("//*[@id='internet-sum']")).getAttribute("placeholder");
    }

    public String getInternetEmailInput() {
        return driver.findElement(By.xpath("//*[@id='internet-email']")).getAttribute("placeholder");
    }

    public String getInstalmentPhoneInput() {
        return driver.findElement(By.xpath("//*[@id='score-instalment']")).getAttribute("placeholder");
    }

    public String getInstalmentSumInput() {
        return driver.findElement(By.xpath("//*[@id='instalment-sum']")).getAttribute("placeholder");
    }

    public String getInstalmentEmailInput() {
        return driver.findElement(By.xpath("//*[@id='instalment-email']")).getAttribute("placeholder");
    }

    public String getDebtPhoneInput() {
        return driver.findElement(By.xpath("//*[@id='score-arrears']")).getAttribute("placeholder");
    }

    public String getDebtSumInput() {
        return driver.findElement(By.xpath("//*[@id='arrears-sum']")).getAttribute("placeholder");
    }

    public String getDebtEmailInput() {
        return driver.findElement(By.xpath("//*[@id='arrears-email']")).getAttribute("placeholder");
    }

    public static void switchToIframe(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@class='bepaid-iframe']")));
    }

    public String getPhoneNumberText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Оплата:')]"))).getText();
    }

    public String getSumText() {
        return driver.findElement(By.xpath("//span[contains(text(), '10.00 BYN')]")).getText();
    }

    public String getContinueButtonText() {
        return driver.findElement(By.xpath("//button[@class='colored disabled']")).getText();
    }

    public String getCardNumberText() {
        return driver.findElement(By.xpath("//label[@class='ng-tns-c46-1 ng-star-inserted']")).getText();
    }

    public String getExpirationDateText() {
        return driver.findElement(By.xpath("//label[@class='ng-tns-c46-4 ng-star-inserted']")).getText();
    }

    public String getCVCText() {
        return driver.findElement(By.xpath("//label[@class='ng-tns-c46-5 ng-star-inserted']")).getText();
    }

    public String getCardHolderText() {
        return driver.findElement(By.xpath("//label[@class='ng-tns-c46-3 ng-star-inserted']")).getText();
    }

    public boolean isPaymentIconsVisible() {
        List<WebElement> paymentIcons = driver.findElements(By.xpath("//img[contains(@class, 'ng-tns-c61-0')]"));
        int expectedPaymentLogoCount = 5;
        return !paymentIcons.isEmpty() && paymentIcons.size() == expectedPaymentLogoCount;
    }
}