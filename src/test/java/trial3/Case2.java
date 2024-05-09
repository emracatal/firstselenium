package trial3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Objects;

public class Case2 {
    public static void main(String[] args) {
        /*test case2
        1-https://www.facebook.com/ adresine gidin
        2-cookies çıkarsa kabul et butonuna basın
        3-e-posta kutusuna rastgele bir mail girin
        4-şifre kutusuna rastgele bir şifre girin
        5-Giriş yap butonuna basın
        6-Uyarı olarak "Giriş Bilgileri Yanlış Geçersiz kullanıcı adı veya şifre" mesajının çıktığını test edin
        7-sayfayı kapatın
        */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("https://www.facebook.com/");
        //driver.findElement(By.xpath("//button[@title='Allow essentials and optional cookies']")).click();
        //<input type="text" class="inputtext _55r1 _6luy" name="email" id="email" data-testid="royal_email" placeholder="E-posta veya Telefon Numarası" autofocus="1" aria-label="E-posta veya Telefon Numarası">
        WebElement emailBox = driver.findElement(By.xpath("//input[@id='email']"
        ));
        emailBox.sendKeys("grwsRGfdS");
        //<input type="password" class="inputtext _55r1 _6luy _9npi" name="pass" id="pass" data-testid="royal_pass" placeholder="Şifre" aria-label="Şifre">
        WebElement passwordBox = driver.findElement(By.xpath("//input[@type='password']"));
        passwordBox.sendKeys("1234512345");
        //<button value="1" class="_42ft _4jy0 _6lth _4jy6 _4jy1 selected _51sy" name="login" data-testid="royal_login_button" type="submit" id="u_0_9_L8">Giriş Yap</button>
        WebElement enterButton = driver.findElement(By.xpath("//button[@data-testid='royal_login_button']"));
        enterButton.click();

        //<div class="pam _3-95 _9ay3 uiBoxRed" role="alert" tabindex="0" id="error_box"><div class="fsl fwb fcb">Wrong credentials</div><div>Invalid username or password</div></div>
        WebElement errorBox = driver.findElement(By.xpath("//div[@id='error_box']"));
        String errorText = errorBox.getText();
        String expectedResult="Wrong credentials\n" +
                "Invalid username or password";
        if(expectedResult.equals(errorText)){
            System.out.println(errorText);
            System.out.println("girilemedi testi başarılı");
        }else{
            System.out.println(errorText);
            System.out.println("girilemedi testi başarı-S-I-Z!!!");

        }
        driver.close();
    }
}
