import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class javascriptExecutor {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://rozetka.com.ua/");
    }

    @Test
    public void javaScript() throws InterruptedException {
        WebElement searchInput = driver.findElement(By.xpath("/html/body/app-root/div/div/rz-header" +
                "/rz-main-header/header/div/div/div/form/div/div/input"));
        WebElement searchBtn = driver.findElement(
                By.xpath("/html/body/app-root/div/div/rz-header" +
                        "/rz-main-header/header/div/div/div/form/button"));

        searchInput.sendKeys("MAC");

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", searchBtn);

        TimeUnit.SECONDS.sleep(10);

    }

    @AfterMethod
    public void after() {
        driver.quit();
    }
}
