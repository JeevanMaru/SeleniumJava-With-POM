package main;
import base.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class FileActionPage extends Page {

    public void FileUpload() {
        open_page("upload");
        driver.findElement(By.cssSelector("#file-upload")).sendKeys(System.getProperty("user.dir")+"\\Upload\\SampleText.txt");
        driver.findElement(By.id("file-submit")).click();
        String Uploadedmessage= driver.findElement(By.cssSelector("div[class='example'] h3")).getText();
        String expected="File Uploaded!";
        Assert.assertEquals(Uploadedmessage,expected);

    }

    public void FileDownload() {
        open_page("download");
       WebElement DownloadFile = driver.findElement(By.xpath("//a[normalize-space()='some-file.txt']"));
        DownloadFile.isEnabled();
        String ActualTitle = DownloadFile.getText();
        DownloadFile.click();
        String expected="some-file.txt";
        Assert.assertEquals(expected,ActualTitle);

    }

    public void HandlingFloatingMenu() {
        open_page("floating_menu");
        ((JavascriptExecutor)driver).executeScript("scroll(0,600)");
        WebElement FloatingMenu= driver.findElement(By.cssSelector("a[href='#home']"));
        System.out.println(FloatingMenu.isDisplayed());
        ((JavascriptExecutor)driver).executeScript("scroll(0,-300)");
    }

    public void HandlingTab() {
        open_page("windows");
        driver.findElement(By.xpath("//a[normalize-space()='Click Here']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Click Here']")).sendKeys(Keys.CONTROL+"t");
        WebElement element = driver.findElement(By.cssSelector("div[class='example'] h3"));
        String text = element.getText();
       Assert.assertEquals(text,"Opening a new window");
        System.out.println(text);

    }

}
