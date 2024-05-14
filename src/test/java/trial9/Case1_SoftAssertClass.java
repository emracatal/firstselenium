package trial9;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
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
public class Case1_SoftAssertClass {
    WebDriver driver;
    @Test
    public void test() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("http://automationexercise.com");

        //1-softAssert objesi oluşturmalısın
        SoftAssert softAssert=new SoftAssert();

        String expectedUrl = "https://automationexercise.com/";
        String actualUrl = driver.getCurrentUrl();

        //2-assert yerine sofAssert yerleştir.
        softAssert.assertEquals(expectedUrl, actualUrl,"url test");
        //<li><a href="/products"><i class="material-icons card_travel" style="font-size: 16px;"></i> Products</a></li>

        driver.findElement(By.xpath("//*[text()=' Products']")).click();

        //<h2 class="title text-center">All Products</h2>
        WebElement allProductsText = driver.findElement(By.xpath("//*[text()='All Products']"));
        softAssert.assertTrue(allProductsText.isDisplayed(),"all products text visible");

        //<li><a href="/product_details/1" style="color: brown;"><i class="fa fa-plus-square"></i>View Product</a></li>

        List<WebElement> productList=driver.findElements(By.xpath("//*[text()='View Product']"));
        softAssert.assertTrue(productList.size()>0,"productlist visible");

        driver.findElement(By.xpath("(//*[text()='View Product'])[1]")).click();

        WebElement productName=driver.findElement(By.xpath("(//h2)[3]"));
        softAssert.assertTrue(productName.isDisplayed(),"productname visible");

        WebElement category= driver.findElement(By.xpath("//*[text()='Category: Women > Tops']"));
        softAssert.assertTrue(category.isDisplayed(),"category visible");

        //3.sona softAssert.assertAll() ekle.
        softAssert.assertAll();
        driver.close();

        					}
}
