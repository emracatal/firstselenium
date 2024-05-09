package trial4_junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test03 {

    //3 farklı web sitesine git kapat testi
    // @Before @Test @After notasyonları ile
    //driver önce tanımlanmalı..

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void test01(){
        driver.get("https:www.amazon.com");
    }

    @Test
    public void test02(){
        driver.get("https:www.bestbuy.com");

    }

    @Test
    public void test03(){
        driver.get("https:www.facebook.com");
    }

}
