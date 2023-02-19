import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class Hover extends BaseTest {

    boolean isNotFound = true;
    String userName;
    String messageNotFound = "Not Found";
    WebElement element;

    @Test
    public void hoverUsers() {
        Actions action = new Actions(driver);
        driver.get("http://the-internet.herokuapp.com/hovers");
        List<WebElement> figureList = driver.findElements(By.className("figure"));
        // check UserName match
        for (int i = 0; i < figureList.size(); i++) {
            action.moveToElement(figureList.get(i)).perform();
            userName = figureList.get(i).findElement(By.tagName("h5")).getText();
            Assert.assertEquals(userName, "name: user" + (i + 1), "The Names don't match");
        }
        // check 404 error
        for (int i = 0; i < figureList.size(); i++) {
            action.moveToElement(figureList.get(i)).perform();
            figureList.get(i).findElement(By.linkText("View profile")).click();
            isNotFound = (driver.findElement(By.cssSelector("h1")).getText().equals(messageNotFound));
            assertTrue(isNotFound, "404: Page Not Found");
            driver.navigate().back();
        }

    }
}
