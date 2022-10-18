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

public class Lesson_24 {
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
    public void testCheckbox() {
        WebElement login = driver.findElement(
                By.xpath("//button[@class='header__button ng-star-inserted']"));
        login.click();

        WebElement rememberCheckboxInput = driver.findElement(By.id("remember_me"));
        WebElement rememberCheckbox = driver.findElement(
                By.xpath("//label[@class='auth-modal__remember-checkbox']"));

        System.out.println(rememberCheckboxInput.isSelected());

        rememberCheckbox.click();

        System.out.println(rememberCheckboxInput.isSelected());
    }

    @AfterMethod
    public void after() {
       // driver.quit();
    }
}
