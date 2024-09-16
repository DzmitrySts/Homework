import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MtsTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver/chromedriver.exe"); // Замените на путь к ChromeDriver
        driver = new ChromeDriver();
        driver.get("https://mts.by");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void checkBlockName() {
        WebElement blockName = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/h2"));
        assertEquals("Онлайн пополнение\n" + "без комиссии", blockName.getText());
    }

    @Test
    public void checkLogo() {
        assertTrue(driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[1]")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[2]")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[3]")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[4]")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[5]")).isDisplayed());
    }

    @Test
    public void checkLink() {
        WebElement link = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/a"));
        assertEquals("Подробнее о сервисе", link.getText());
        link.click();
        driver.navigate().back();
    }

    @Test
    public void checkButton() {
        WebElement phoneNumber = driver.findElement(By.xpath("//*[@id=\"connection-phone\"]"));
        phoneNumber.sendKeys("297777777");

        WebElement sum = driver.findElement(By.xpath("//*[@id=\"connection-sum\"]"));
        sum.sendKeys("10");

        WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        assertTrue(continueButton.isEnabled());
        assertTrue(continueButton.isDisplayed());
        continueButton.click();
    }
}