package basic_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class scenario_1 {

    public static void main (String[]args) throws InterruptedException{

        /* SCENARIO 1
         * DATE: JULY 13, 2023
         * NAME: ANGELICA D. DESALES
         * UNIVERSITY: FEU-INSTITUTE OF TECHNOLOGY
         * ASSESSMENT: SQA CODING INTERVIEW USING JAVA WITH SELENIUM INTEGRATION
         */

        //Browser driver exe
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Angelica Desales\\OneDrive\\Desktop\\automation\\chromedriver\\chromedriver.exe");

        //chrome browser instance
        WebDriver driver = new ChromeDriver();

        //open application
        driver.get("https://www.saucedemo.com/");

        //maximize browser
        driver.manage().window().maximize();

        //commands for logging in
        driver.findElement(By.id("user-name")).sendKeys("standard_user"); //username
        driver.findElement(By.id("password")).sendKeys("secret_sauce"); //password

        //clicking the login button
        driver.findElement(By.id("login-button")).click();

        //verification of login status
        if (driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html")) {

            System.out.println("Login Successful");
        }
        else {
            System.out.println("Login Failed");
        }

        //verification of the user within the homepage
        driver.get("https://www.saucedemo.com/inventory.html");

        //verify if the homepage is loaded
        String expectedTitle = "Swag Labs";
        String actualTitle = driver.getTitle();

        //verification of the navigation to homepage status
        if (actualTitle.equals(expectedTitle)) {

            System.out.println("User has successfully navigated to homepage");
        }
        else {

            System.out.println("Execution Failed");

        }

        //process for logging out
        driver.findElement(By.id("react-burger-menu-btn")).click();
        driver.findElement(By.id("logout_sidebar_link")).click();

        //verification of logout status
        WebElement loginButton = driver.findElement(By.id("login-button"));
        if (loginButton.isDisplayed()) {

            System.out.println("Successfully logged out!");

        }else {

            System.out.println("Logout failed!");
        }

        //login form element
        WebElement loginForm = driver.findElement(By.id("login_form"));

        //verification if the user is navigated to the login form
        if (loginForm.isDisplayed()) {

            System.out.println("The user is successfully navigated to the login page");

        }
        else {

            System.out.println("Failed to navigate to the login page");

        }

        Thread.sleep(5000);

        //close browser
        /*
        * Note: driver.close() command closes the current tab of the browser.
        * While driver.quit() closes all the tabs within the browser
        */
        driver.quit();
    }
}
