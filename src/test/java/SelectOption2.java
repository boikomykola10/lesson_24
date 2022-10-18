import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.imageio.IIOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SelectOption2 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void start() {
        driver = new ChromeDriver();
        wait = (new WebDriverWait(driver, Duration.ofSeconds(10)));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://autodoc.de/");
    }
    @Test
    public void testOption2() throws IIOException, InterruptedException {
        WebElement makerList = driver.findElement(By.xpath("//*[@id=\"form_maker_id\"]"));
        WebElement makerListOption = driver.findElement(By.xpath("//*[@id=\"form_maker_id\"]/optgroup[1]/option[3]"));

        makerList.click();
        makerListOption.click();

        TimeUnit.SECONDS.sleep(10);
    }
    @AfterMethod
    public void after() {
        driver.quit();

    }
}
