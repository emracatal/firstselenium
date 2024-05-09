package trial2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverGetMetodlari {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        //1-driver.get("url")
        driver.get("https://www.amazon.com");
        //driver.getTitle() - sayfa başlığı getirir
        System.out.println("sayfa title: " + driver.getTitle());
        //driver.getCurrentUrl() - sayfa url getirir
        System.out.println(driver.getCurrentUrl());
        //sayfanın kaynak kodlarını string olarak verir,çok kullanılmaz //kaynak kodlarda x kelimesinin geçtğini test et gibi senaryolarda
        System.out.println(driver.getPageSource());
        //windowa ait unique hashcode döndürür,her seferinde farklı sayfa açılacağından farklı data gelir
        System.out.println(driver.getWindowHandle());
        //birden fazla sayfa-tab açıldıysa hepsini dizi içerisinde döner
        System.out.println(driver.getWindowHandles());


}}
