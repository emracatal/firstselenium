package trial7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.security.Key;
import java.time.Duration;

/*
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
4. Click on 'Signup / Login' button
6. Enter name and email address
7. Click 'Signup' button
9. Fill details: Title, Name, Email, Password, Date of birth
10. Select checkbox 'Sign up for our newsletter!'
11. Select checkbox 'Receive special offers from our partners!'
12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
13. Click 'Create Account button'
14. Verify that 'ACCOUNT CREATED!' is visible
15. Click 'Continue' button
16. Verify that 'Logged in as username' is visible
*/
public class Case1 {
    @Test
    public void test01() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("http://automationexercise.com");

        //<a href="/login"><i class="fa fa-lock"></i> Signup / Login</a>
        WebElement signUpLoginButton = driver.findElement(By.xpath("//a[@href='/login']"));
        Actions actions = new Actions(driver);
        actions.click(signUpLoginButton).perform();

        //<input type="text" data-qa="signup-name" placeholder="Name" name="name" value="" required="">
        WebElement newUserNameInput = driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
        actions.click(newUserNameInput)
                .sendKeys("lolej")
                .sendKeys(Keys.TAB)
                .sendKeys("lolej50422@bsomek.com")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

        //<input type="radio" name="title" id="id_gender2" value="Mrs">
        WebElement titleRadioButton = driver.findElement(By.xpath("//input[@id='id_gender2']"));
        actions.click(titleRadioButton)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("Lolej12345")
                .sendKeys(Keys.TAB)
                .sendKeys("3")
                .sendKeys(Keys.TAB)
                .sendKeys("March")
                .sendKeys(Keys.TAB)
                .sendKeys("2006")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.SPACE)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.SPACE)
                .sendKeys(Keys.TAB)
                .sendKeys("lolej")
                .sendKeys(Keys.TAB)
                .sendKeys("surname")
                .sendKeys(Keys.TAB)
                .sendKeys("company")
                .sendKeys(Keys.TAB)
                .sendKeys("address")
                .sendKeys(Keys.TAB)
                .sendKeys("address2")
                .sendKeys(Keys.TAB)
                .sendKeys("India")
                .sendKeys(Keys.TAB)
                .sendKeys("state")
                .sendKeys(Keys.TAB)
                .sendKeys("city")
                .sendKeys(Keys.TAB)
                .sendKeys("11111")
                .sendKeys(Keys.TAB)
                .sendKeys("+901231231212")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

        //<h2 class="title text-center" data-qa="account-created" style="color: green;"><b>Account Created!</b></h2>
        String expectedString = "ACCOUNT CREATED!";
        String actualString = driver.findElement(By.xpath("//h2[@data-qa='account-created']")).getText();
        Assert.assertEquals(expectedString, actualString);
        driver.close();
    }
}

