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

public class clear {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void before() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://rozetka.com.ua/");
    }

    @Test
    public void testClear() throws InterruptedException {
        WebElement searchInput =  driver.findElement(By.name("search"));
        searchInput.sendKeys("Bla bla bla");

        TimeUnit.SECONDS.sleep(10);

        searchInput.clear();

        TimeUnit.SECONDS.sleep(10);
    }

    @AfterMethod
    public void after() {
        driver.quit();
    }
}


