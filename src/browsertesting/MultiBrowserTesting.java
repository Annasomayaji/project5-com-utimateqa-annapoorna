package browsertesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MultiBrowserTesting {

    static String browser = "Chrome";
    static String baseUrl = "https://courses.ultimateqa.com/";
    static WebDriver driver;

    public static void main(String[] args) {

        //set up browser
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else {
            System.out.println("You have entered a wrong browser name");
        }

        //open url
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Print the title of the page.
        String title = driver.getTitle();
        System.out.println(title);
        System.out.println("**************************************************");

        //Print the current url.
        System.out.println(driver.getCurrentUrl());
        System.out.println("**************************************************");

        //Print the page source.
        System.out.println(driver.getPageSource());
        System.out.println("**************************************************");

        //Click on ‘Sign In’ link
        driver.findElement(By.linkText("Sign In")).click();

        //Print the current url
        System.out.println(driver.getCurrentUrl());
        System.out.println("**************************************************");

        //Enter the email to email field.
        driver.findElement(By.id("user[email]")).sendKeys("abc@gmail.com");

        //Enter the password to password field.
        WebElement password = driver.findElement(By.id("user[password]"));
        password.sendKeys("password1");

        //Click on Login Button
        driver.findElement(By.xpath("//div/button[contains(text(),\"Sign in\")]")).click();

        //Navigate to baseUrl

        driver.navigate().back();
        driver.navigate().refresh();
        System.out.println(driver.getCurrentUrl());
        System.out.println("The above is base Url*******************************");

        //Navigate forward to Homepage.
        //driver.findElement(By.linkText("Sign In")).click();
        driver.navigate().forward();
        System.out.println(driver.getCurrentUrl());
        System.out.println("The above is home page******************************");

        //navigate back to base url
        driver.navigate().back();
        driver.navigate().refresh();
        System.out.println(driver.getCurrentUrl());
        System.out.println("The above is base Url*******************************");
        driver.quit();

    }

}
