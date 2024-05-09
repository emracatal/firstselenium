package trial3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Case3 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        /*
        1-https://www.bestbuy.com/ git
        2-cookies çıkarsa kabul et butonuna bas
        3-sayfada kaç adet buton bulunduğunu yazdır
        4-sayfadaki butonların üzerindeki yazıları yazdır
        */
        driver.get("https://www.bestbuy.com/");
        List<WebElement> buttonList = driver.findElements(By.tagName("button"));
        System.out.println();
        for (WebElement each : buttonList) {
            System.out.println(each.getText());
        }

        driver.close();
    }
}
