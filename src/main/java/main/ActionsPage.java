package main;
import base.Page;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class ActionsPage extends Page {

   public void CheckboxesHandle() {
      open_page("checkboxes");
      driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
      WebElement chkbox = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
      Assert.assertTrue(chkbox.isSelected(),"Check box is selected");
      chkbox.click();
   }

public void ContextMenu() {
   open_page("context_menu");
   WebElement element = driver.findElement(By.id("hot-spot"));
   Actions action = new Actions(driver);
   action.contextClick(element).perform();
   WebDriverWait wait = new WebDriverWait(driver,30);
   Alert alert =  wait.until(ExpectedConditions.alertIsPresent());
   String message = alert.getText();
   Assert.assertEquals(message,"You selected a context menu");
   alert.accept();
   driver.navigate().refresh();
   driver.findElement(By.xpath("//h3[normalize-space()='Context Menu']")).click();
}

public void DragandDrop() {
   open_page("drag_and_drop");
   WebElement PerformDragSource = driver.findElement(By.id("column-b"));
   WebElement PerformDragTarget = driver.findElement(By.id("column-a"));
   Actions action = new Actions(driver);
   action.dragAndDrop(PerformDragSource,PerformDragTarget).perform();

}

public void DropDown() {

   open_page("dropdown");
   WebElement Display = driver.findElement(By.id("dropdown"));
   Select select = new Select(Display);
   select.selectByVisibleText("Option 1");
   select.selectByIndex(1);

}

public void HandleFrames() {
   open_page("iframe");
   driver.switchTo().frame("mce_0_ifr");
   WebElement editor = driver.findElement(By.id("tinymce"));
   editor.clear();
   editor.sendKeys("Hello World Java");
   String Frametext =editor.getText();
   Assert.assertEquals(Frametext,"Hello World Java");

}
public void MouseOver(){
   open_page("hovers");
   List<WebElement> ele = driver.findElements(By.cssSelector(".figure"));
   Actions actions = new Actions(driver);
   actions.moveToElement(ele.get(0)).perform();
   WebElement Profile1= driver.findElement(By.cssSelector("a[href='/users/1']"));
  boolean status = Profile1.isDisplayed();
  Assert.assertTrue(status,"true");
  Profile1.click();
}

}
