import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.openqa.selenium.Keys.*;
import static org.testng.Assert.assertTrue;

public class Hover extends BaseTest {

    boolean isNotFound = true;
    String userName;
    String messageNotFound = "Not Found";
    WebElement element;

    @Test
    public void hoverUserNames() {
        Actions action = new Actions(driver);
        driver.get("http://the-internet.herokuapp.com/hovers");
        List<WebElement> figureList = driver.findElements(By.className("figure"));
        // check UserName match
        for (int i = 0; i < figureList.size(); i++) {
            action.moveToElement(figureList.get(i)).perform();
            userName = figureList.get(i).findElement(By.tagName("h5")).getText();
            Assert.assertEquals(userName, "name: user" + (i + 1), "The Names don't match");
        }
    }

    @Test
    public void hoverUserProfiles() {
        Actions action = new Actions(driver);
        driver.get("http://the-internet.herokuapp.com/hovers");

        // check 404 error user 1
        element = driver.findElement(By.xpath("//div[@class='figure'][1]"));
        action.moveToElement(element).perform();
        element.findElement(By.linkText("View profile")).click();
        String hOne = driver.findElement(By.tagName("h1")).getText();
        isNotFound = (hOne.equals(messageNotFound));
        assertTrue(isNotFound, "404: Page Not Found");
        driver.navigate().back();

        // check 404 error user 2
        element = driver.findElement(By.xpath("//div[@class='figure'][2]"));
        action.moveToElement(element).perform();
        element.findElement(By.linkText("View profile")).click();
        String hTwo = driver.findElement(By.tagName("h1")).getText();
        isNotFound = (hOne.equals(messageNotFound));
        assertTrue(isNotFound, "404: Page Not Found");
        driver.navigate().back();

        // check 404 error user 3
        element = driver.findElement(By.xpath("//div[@class='figure'][3]"));
        action.moveToElement(element).perform();
        element.findElement(By.linkText("View profile")).click();
        String hThree = driver.findElement(By.tagName("h1")).getText();
        isNotFound = (hOne.equals(messageNotFound));
        assertTrue(isNotFound, "404: Page Not Found");
        driver.navigate().back();


        /*for (int i = 0; i < figureList.size(); i++) {
            action.moveToElement(figureList.get(i)).perform();
            figureList.get(i).findElement(By.linkText("View profile"))
                    .sendKeys(Keys.chord(CONTROL, SHIFT, ENTER));
            action.sendKeys(Keys.chord(CONTROL, SHIFT, ENTER)).perform();
            ArrayList<String> stringSet = (ArrayList<String>) driver.getWindowHandles();
            driver.switchTo().window(stringSet.get(1));
            //driver.get("http://the-internet.herokuapp.com/users/" + i);
            String hOne = driver.findElement(By.tagName("h1")).getText();
            isNotFound = (hOne.equals(messageNotFound));
            assertTrue(isNotFound, "404: Page Not Found");
            driver.close();
            driver.switchTo().window(stringSet.get(0));*/
    }

}



