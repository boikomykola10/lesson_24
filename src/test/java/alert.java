import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class alert {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void before() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.google.com.ua/");
    }

    @Test
    public void testAlert() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("alert('Are you sure?');");

        TimeUnit.SECONDS.sleep(10);

        driver.switchTo().alert().accept();

        TimeUnit.SECONDS.sleep(10);
    }

    @AfterMethod
    public void after() {
        driver.quit();
    }
}


