package main;
import base.Page;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPage extends Page {

    public void doLogin(String Username, String password)  {
        open_page("login");
        driver.findElement(By.id("username")).sendKeys(Username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("secure"),"Login Successfull");
        driver.findElement(By.cssSelector(".icon-2x.icon-signout")).click();
    }
    public void  InvalidLogin(String Username, String password)  {
        open_page("login");
        driver.findElement(By.id("username")).sendKeys(Username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        String validation = driver.findElement(By.xpath("//div[@id='flash']")).getText();
        Assert.assertTrue(validation.contains("Your password is invalid!"),"Invalid Login credentials");
        
    }

}
