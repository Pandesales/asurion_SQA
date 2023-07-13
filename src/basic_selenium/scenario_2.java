package basic_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class scenario_2 {

    public static void main (String [] args) throws InterruptedException{

        System.out.println("Software test automation by Angelica Desales");

        //Browser driver exe
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Angelica Desales\\OneDrive\\Desktop\\automation\\chromedriver\\chromedriver.exe");

        //chrome browser instance
        WebDriver driver = new ChromeDriver();

        //open application
        driver.get("https://www.saucedemo.com/");

        //maximize browser
        driver.manage().window().maximize();

        //commands for logging in
        driver.findElement(By.id("user-name")).sendKeys("locked_out_user"); //username
        driver.findElement(By.id("password")).sendKeys("secret_sauce"); //password

        //clicking the login button
        driver.findElement(By.id("login-button")).click();

        //find the error message element
        WebElement errorMessage = driver.findElement(By.xpath("//h3[@data-test='error']"));

        //string to create an instance for the if statement
        String actualErrorMessage = errorMessage.getText();
        String expectedErrorMessage = "Epic sadface: Sorry, this user has been locked out.";

        if (actualErrorMessage.equals(expectedErrorMessage)){
            System.out.println("Test passed");
        }
        else {
            System.out.println("Test failed");
        }

        Thread.sleep(5000);

        driver.quit();

    }
}
