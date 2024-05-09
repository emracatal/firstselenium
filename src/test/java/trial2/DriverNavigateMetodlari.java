package trial2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverNavigateMetodlari {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.amazon.com");
        //driver.navigate().to("url") -
        driver.navigate().to("https://www.facebook.com");
        System.out.println(driver.getTitle());
        //driver.navigate().back() -
        driver.navigate().back();
        System.out.println(driver.getCurrentUrl());
        //driver.navigate().forward() -
        System.out.println(driver.getTitle());
        //driver.navigate().refresh()
        driver.navigate().refresh();
        //driver.close() - açılan browser kapatılacaktır
        //driver.close();
        //driver.quit() - birden fazla window/tab varsa tamamını kapatır.close ve quit aynı anda kullanılmaz.
        //driver.quit();




    }
}
