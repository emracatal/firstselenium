package trial4_junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test04 {

    //3 farklı web sitesine git kapat testi
    // @Before @Test @After notasyonları ile
// Olusturdugumuz test class'inin icindeki test method'lari
    // hep ayni web sitesi ile ilgili ise her seferinde yeniden driver olusturmaya
    // ve her method icin bu driver'i kapatmaya gerek yoktur
    // Class'in basinda bir kere setup calisip, en sonda kapansa olur
    // dersek BeforeClass ve AfterClass kullaniriz
    //BeforeClass AfterClass ve driver static olarak tanımlanmalı

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @AfterClass
    public static void tearDown(){
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
    @Ignore
    public void test03(){
        driver.get("https:www.facebook.com");
    }

}
