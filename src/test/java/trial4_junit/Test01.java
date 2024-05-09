package trial4_junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test01 {
    @Test
    public void test01() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        /*test case1
        1-https://www.amazon.com/ sayfasına gidin
        2-Arama çubuğuna "nutella yazdırın
        3-Entera basıp arama yaptırın
        4-Bulunan sonuç sayısını yazdırın
        */

        driver.get("https://www.amazon.com/");
        WebElement searchBar=driver.findElement(By.id("twotabsearchtextbox"));
        searchBar.sendKeys("nutella");
        searchBar.submit();
        WebElement searchResultCount = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small'][1]"));
        System.out.println(searchResultCount.getText());
        driver.close();
    }
}
