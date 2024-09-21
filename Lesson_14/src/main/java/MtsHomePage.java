import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class MtsHomePage {

    private WebDriver driver;

    public MtsHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getBlockNameText() {
        return driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/h2")).getText();
    }

    public boolean isLogoVisible() {
        return driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[1]")).isDisplayed() &&
                driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[2]")).isDisplayed() &&
                driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[3]")).isDisplayed() &&
                driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[4]")).isDisplayed() &&
                driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[5]")).isDisplayed();
    }

    public String getLinkText() {
        return driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/a")).getText();
    }

    public void clickLink() {
        driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/a")).click();
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public void enterPhoneNumber(String phoneNumber) {
        driver.findElement(By.xpath("//*[@id=\"connection-phone\"]")).sendKeys(phoneNumber);
    }

    public void enterSum(String sum) {
        driver.findElement(By.xpath("//*[@id=\"connection-sum\"]")).sendKeys(sum);
    }

    public boolean isContinueButtonEnabled() {
        return driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button")).isEnabled();
    }

    public boolean isContinueButtonVisible() {
        return driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button")).isDisplayed();
    }

    public void clickContinueButton() {
        driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button")).click();
    }

    public String getPlaceholder(String xpath) {
        return driver.findElement(By.xpath(xpath)).getAttribute("placeholder");
    }

    public void dropdownButton() {
        driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button")).click();
    }

    public void selectServices() {
        driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[1]/p")).click();
    }

    public void selectInternet() {
        driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[2]/p")).click();
    }

    public void selectInstalment() {
        driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[3]/p")).click();
    }

    public void selectDebt() {
        driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[4]/p")).click();
    }

    public String getPhoneNumberText() {
        return driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/div/div[2]")).getText();
    }

    public String getSumText() {
        return driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/div/div[1]/span[1]")).getText();
    }

    public String getContinueButtonText() {
        return driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/button")).getText();
    }

    public String getCardPlaceholderTextByXPath(String xpath) {
        return driver.findElement(By.xpath(xpath)).getAttribute("placeholder");
    }

    public boolean isVisaIconVisible() {
        return driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/img[1]")).isDisplayed();
    }

    public boolean isMastercardIconVisible() {
        return driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/img[2]")).isDisplayed();
    }

    public boolean isBelcardIconVisible() {
        return driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/img[3]")).isDisplayed();
    }

    public boolean isMaestroIconVisible() {
        return driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/img[4]")).isDisplayed();
    }
}