package trial5_junit_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Case3 {

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

    int aliYas = 56;
    int veliYas = 68;
    int emeklilikYasi = 65;

    @Test
    public void test01() {

        //case1 : Veli'nin emekli olabileceğini test edin //PASSED bekliyoruz
        Assert.assertTrue(veliYas > emeklilikYasi);
        //asserTrue ile true bekliyoruz, yaptığımız karşılaştırma da true olduğu için PASSED olur.
    }
    @Test
    public void test02() {
        //case2 : Ali'nin emekli olamayacağını test edin //PASSED bekliyoruz
        Assert.assertFalse(aliYas > emeklilikYasi);
    }
    @Test
    public void test03() {
        //case3 : emekli yaşının 65 olduğunu test edin//PASSED bekliyoruz
        Assert.assertEquals(65, emeklilikYasi);
    }
    @Test
    public void test04() {
        //case4 :Ali'nin emekli olabileceğini test edin//FAILED bekliyoruz
        Assert.assertTrue(aliYas > emeklilikYasi);
    }
    @Test
    public void test05() {
        //case5 : Veli'nin emekli olamayacağını test edin//FAILED bekliyoruz
        Assert.assertFalse(veliYas > emeklilikYasi);
    }
    @Test
    public void test06() {
        //case6 : emekli yaşının 63 olduğunu test edin//FAILED bekliyoruz
        Assert.assertEquals(63,emeklilikYasi);
    }
}
