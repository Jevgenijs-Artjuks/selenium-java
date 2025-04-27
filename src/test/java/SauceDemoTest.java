import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SauceDemoTest {
    ChromeDriver driver;

    @BeforeMethod
    public void beforeTest() {
        driver = new ChromeDriver();
        driver = new ChromeDriver();
        driver.get("https://saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@data-test='login-button']")).click();


    }

    @Test
    public void verifyLoggedInTest() {
        String productsText = driver.findElement(By.className("title")).getText();
        assertThat(productsText).isEqualTo("Products");
        driver.close();
        driver.quit();
    }
    @AfterMethod()
    public void tearDown() {

    }
}

