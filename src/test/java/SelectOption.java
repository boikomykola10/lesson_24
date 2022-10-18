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

public class SelectOption {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void before() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.autodoc.de/");
    }

    @Test
    public void testOption() throws InterruptedException {
        selectOption(driver, "84");

        TimeUnit.SECONDS.sleep(10);
    }
    public static void selectOption(WebDriver driver, String option) {
        WebElement makerList =  driver.findElement(By.xpath("//*[@id=\"form_maker_id\"]"));
        String makerListOption = String.format("//*[@id=\"form_maker_id\"]/optgroup[1]/option[@value='%s']", option);

        makerList.click();
        driver.findElement(By.xpath(makerListOption)).click();
    }

    @AfterMethod
    public void after() {
        driver.quit();
    }
}

