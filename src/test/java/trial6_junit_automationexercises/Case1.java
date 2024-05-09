package trial6_junit_automationexercises;

/*
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'Login to your account' is visible
6. Enter correct email address and password
7. Click 'login' button
8. Verify that 'Logged in as username' is visible
*/

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class Case1 {
    @Test
    public void test01() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://automationexercise.com");
        //<img src="/static/images/home/logo.png" alt="Website for automation practice">
        WebElement logoElement = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(logoElement.isDisplayed());

        //<a href="/login"><i class="fa fa-lock"></i> Signup / Login</a>
        WebElement signupLoginButton = driver.findElement(By.xpath("//a[@href='/login']"));
        signupLoginButton.click();
        //h2[text()='Login to your account']
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Login to your account']")).isDisplayed());
        //<input type="email" data-qa="login-email" placeholder="Email Address" name="email" value="" required="">
        WebElement loginEmail = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        loginEmail.sendKeys("wefom69449@mfyax.com");
        //<input type="password" data-qa="login-password" placeholder="Password" name="password" value="" required="">
        WebElement loginPassword = driver.findElement(By.xpath("//input[@data-qa='login-password']"));
        loginPassword.sendKeys("12345");
        //<button type="submit" data-qa="login-button" class="btn btn-default">Login</button>
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).submit();
        //<a><i class="fa fa-user"></i> Logged in as <b>deneme</b></a>
        WebElement loggedInText=driver.findElement(By.xpath("//a[text()=' Logged in as ']"));
        Assert.assertTrue(loggedInText.isDisplayed());

        //<a href="/logout" style="color:brown;"><i class="fa fa-lock"></i> Logout</a>
        driver.findElement(By.xpath("//a[text()=' Logout']")).click();
        String expectedUrl="https://automationexercise.com/login";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
        driver.close();

    }


}
