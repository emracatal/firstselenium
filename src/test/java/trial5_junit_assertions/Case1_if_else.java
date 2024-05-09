package trial5_junit_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
/*test case1
        1-https://www.amazon.com/ sayfasına gidin
        2-Arama çubuğuna "nutella" yazdırın
        3-Entera basıp arama yaptırın
        4-Bulunan sonuç içerisinde "nutella" olup olmadığını döndürün
        */

public class Case1_if_else {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void test01() {
        driver.get("https://www.amazon.com/");
        WebElement searchBar = driver.findElement(By.id("twotabsearchtextbox"));
        String expectedWord = "nutella";
        searchBar.sendKeys(expectedWord);
        searchBar.submit();
        WebElement searchResult = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small'][1]"));
        String searchResultStr = searchResult.getText();
        if (searchResultStr.contains(expectedWord)) {
            System.out.println(expectedWord + " found,test passed");
        } else {
            System.out.println(expectedWord + "NOT found, test FAILED!!");
        }
    }
}
