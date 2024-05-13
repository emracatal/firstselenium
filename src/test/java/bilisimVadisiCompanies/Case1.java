package bilisimVadisiCompanies;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Case1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://bilisimvadisi.com.tr/hakkimizda/firmalar/");
        //<a href="javascript:void(0)" class="loadmore-exbt" data-id="extp-8948"> <span class="load-text">Load more</span><span></span>&nbsp;<span></span>&nbsp;<span></span> </a>
        //WebElement loadMoreButton = driver.findElement(By.xpath("//button[contains(text(),'Daha fazlasını yükle')]"));
        //loadMoreButton.click();
        List<WebElement> linkList = driver.findElements(By.tagName("a"));
        System.out.println();
        for (WebElement each : linkList) {
            String linkText = each.getAttribute("href");
            System.out.println(linkText);
        }
        driver.close();

    }
}
