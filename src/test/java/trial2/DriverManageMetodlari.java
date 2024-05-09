package trial2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DriverManageMetodlari {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //implicitlyWait ve maximize yazmazsak kodlar çalışmayabilir..
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //window,timeout(bekleme) ve cookie yönetimi

        //driver.manage().window() metodları
        driver.get("https://www.amazon.com");
        //driver.manage().window().getSize()
        System.out.println(driver.manage().window().getSize()); //(1050, 892) pixel
        //driver.manage().window().getSize() - sol alt köşenin pozisyonu
        System.out.println(driver.manage().window().getPosition());
        //driver.manage().window().setPosition(new Point(x, y)) - sol alt köşenin pozisyonunu belirlediğimiz yere atar
        driver.manage().window().setPosition(new Point(50, 20));
        //driver.manage().window().setSize(new Dimension(900, 900)) - window size atar
        driver.manage().window().setSize(new Dimension(900, 900));
        //driver.manage().window().maximize(); window genişliğinde büyütür
        driver.manage().window().maximize();
        System.out.println("maximize" + driver.manage().window().getSize());
        System.out.println("maximize" + driver.manage().window().getPosition());
        //driver.manage().window().fullscreen(); window genişliğinden daha fazla büyütür
        driver.manage().window().fullscreen();
        System.out.println("fullscreen" +driver.manage().window().getSize());
        System.out.println("fullscreen" + driver.manage().window().getPosition());
        //driver.manage().window().minimize() simge durumunda küçült
        driver.manage().window().minimize();

        //driver.manage().timeouts() metodları
        //driver.manage().timeouts().implicitlyWait()
        // drivere sayfanın yüklenmesi ve web elementlerin bulunması için beklemesi gereken MAX süreyi verir
        //her sayfa açıldığında mutlaka yapılması isteniyor.
        //Duration selenium4 ile geldi,daha önce TimeUnit vardı
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }
}
