package trial6_junit_automationexercises;

/*
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Products' button
5. Verify user is navigated to 'ALL PRODUCTS' page successfully
6. Enter product name in search input and click search button
7. Verify SEARCHED PRODUCTS is visible
8. close driver
*/

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Case2 {
    @Test
    public void test01() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("http://automationexercise.com");
        //<img src="/static/images/home/logo.png" alt="Website for automation practice">
        WebElement logoElement = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(logoElement.isDisplayed());

        //<a href="/products"><i class="material-icons card_travel" style="font-size: 16px;"></i> Products</a>
        driver.findElement(By.xpath("//a[text()=' Products']")).click();

        //<h2 class="title text-center">All Products</h2>
        String expectedUrl="https://automationexercise.com/products";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
        //<input type="text" name="search" id="search_product" value="" placeholder="Search Product" class="form-control input-lg">
        WebElement productSearchBox=driver.findElement(By.xpath("//input[@id='search_product']"));
        productSearchBox.sendKeys("tshirt");
        //<button type="button" id="submit_search" class="btn btn-default btn-lg"><i class="fa fa-search"></i></button>
        driver.findElement(By.xpath("//button[@id='submit_search']")).click();
        String expectedUrlSearched="https://automationexercise.com/products?search=tshirt";
        String actualUrlSearched=driver.getCurrentUrl();
        Assert.assertEquals(expectedUrlSearched,actualUrlSearched);
        driver.close();
    }
}
