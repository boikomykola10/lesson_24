import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class NewTab {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void start() {
        driver = new ChromeDriver();
        wait = (new WebDriverWait(driver, Duration.ofSeconds(10)));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rozetka.com.ua/");
    }
    @Test
    public void windowsHandlesExp() throws InterruptedException {
        WebElement loginBtn = driver.findElement(
                By.xpath("//button[@class='header__button ng-star-inserted']"));
        loginBtn.click();

        WebElement regBtn = driver.findElement(
                By.xpath("//button[@class='auth-modal__register-link button button--link ng-star-inserted']"));
        regBtn.click();

        TimeUnit.SECONDS.sleep(5);

        WebElement privatePolicyBtn = driver.findElement(
                By.xpath("//a[@class='button button_type_link']"));
        privatePolicyBtn.click();
        TimeUnit.SECONDS.sleep(5);

        String mainTab = driver.getWindowHandle();

        for (String tab: driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }
        TimeUnit.SECONDS.sleep(5);

        driver.switchTo().window(mainTab);

        TimeUnit.SECONDS.sleep(5);
    }

    @AfterMethod
    public void after() {
        driver.quit();
    }
}
