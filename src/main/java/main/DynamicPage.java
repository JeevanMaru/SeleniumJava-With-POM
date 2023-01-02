package main;
import base.Page;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DynamicPage extends Page {

    public WebDriverWait wait= new WebDriverWait(driver,30);

    public void DynamicContent() {
        open_page("javascript_alerts");
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();

        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        Alert confirm = driver.switchTo().alert();
        System.out.println(confirm.getText());
        confirm.dismiss();

        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        Alert pop1 = driver.switchTo().alert();
        System.out.println(pop1.getText());
        pop1.sendKeys("Welcome to Selenium 4");
        pop1.accept();
        if (driver.getPageSource().contains("You entered: Welcome to Selenium 4"))
            System.out.println("Successfully clicked OK button on popup");

    }

    public void NotificationMessage() {
        open_page("notification_message_rendered");
        driver.findElement(By.cssSelector("a[href='/notification_message']")).click();
        WebElement element = driver.findElement(By.xpath("//div[@id='flash']"));
        String notificationsuccess = element.getText();
        Assert.assertTrue(notificationsuccess.contains("Action"),"rendered message displayed");
    }

    public void ExplicitWait() {
        open_page("dynamic_loading/2");
        driver.findElement(By.cssSelector("div[id='start'] button")).click();
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[normalize-space()='Hello World!']")));
        boolean status = element.isDisplayed();
        Assert.assertTrue(status, "Element is Displayed");
        String Textmessage = element.getText();
       Assert.assertEquals(Textmessage,"Hello World!");

    }

    public void DynamicControlsExplicitWait() {
        open_page("dynamic_controls");
        driver.findElement(By.cssSelector("button[onclick='swapCheckbox()']")).click();
        boolean status = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#checkbox")));
        Assert.assertTrue(status,"Remove button is disabled");
        driver.findElement(By.cssSelector("button[onclick='swapCheckbox()']")).click();
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#checkbox")));
        boolean elementStatus = element.isDisplayed();
        Assert.assertTrue(elementStatus,"Remove button is enabled");

        //Enable button and verify enabled text
          driver.findElement(By.cssSelector("button[onclick='swapInput()']")).click();
          WebElement ele = driver.findElement(By.xpath("//p[@id='message']"));
          WebElement ElementisEnable = wait.until(ExpectedConditions.elementToBeClickable(ele));
          String gettext = ElementisEnable.getText();
          Assert.assertEquals(gettext,"It's enabled!");

        //Disable textbox and verify message
            driver.findElement(By.cssSelector("button[onclick='swapInput()']")).click();
            boolean status1 = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("input[type='text']")));
            Assert.assertTrue(status1,"Disabled Textbox");

         }

 public void HandleDynamicContent() {
    open_page("dynamic_content");
    driver.navigate().refresh();
   String Dynamictext = driver.findElement(By.cssSelector("body div[class='row'] div[id='content'] div[id='content'] div:nth-child(1) div:nth-child(2)")).getText();
   Assert.assertNotEquals(Dynamictext.contains("Quis sed necessitatibus nostrum aliquam sit voluptatum"),"Data has been refreshed");
    }
}




