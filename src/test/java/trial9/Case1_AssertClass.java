package trial9;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

/*
* Test Case 8: Verify All Products and product detail page
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Products' button
5. Verify user is navigated to ALL PRODUCTS page successfully
6. The products list is visible
7. Click on 'View Product' of first product
8. User is landed to product detail page
9. Verify that detail is visible: product name, category, price, availability, condition, brand
*/
public class Case1_AssertClass {
    @Test
    public void test() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("http://automationexercise.com");

        String expectedUrl = "https://automationexercise.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
        //<li><a href="/products"><i class="material-icons card_travel" style="font-size: 16px;"></i> Products</a></li>

        driver.findElement(By.xpath("//*[text()=' Products']")).click();

        //<h2 class="title text-center">All Products</h2>
        WebElement allProductsText = driver.findElement(By.xpath("//*[text()='All Products']"));
        Assert.assertTrue(allProductsText.isDisplayed());


        //<li><a href="/product_details/1" style="color: brown;"><i class="fa fa-plus-square"></i>View Product</a></li>

        List<WebElement> productList=driver.findElements(By.xpath("//*[text()='View Product']"));
        Assert.assertTrue(productList.size()>0);

        driver.findElement(By.xpath("(//*[text()='View Product'])[1]")).click();

        WebElement productName=driver.findElement(By.xpath("(//h2)[3]"));
        Assert.assertTrue(productName.isDisplayed());

        WebElement category= driver.findElement(By.xpath("//*[text()='Category: Women > Tops']"));
        Assert.assertTrue(category.isDisplayed());

        driver.close();

        					}
}
