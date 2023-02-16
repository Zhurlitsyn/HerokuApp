import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.*;

public class AddRemoveElementsTest extends BaseTest {

    @Test
    public void addRemove() {
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElements(By.xpath("//button[text()='Delete']")).get(1).click();
        int numberOfElements = driver.findElements(By.xpath("//button[text()='Delete']")).size();
        assertEquals(numberOfElements, 1, "Number of DELETE button is wrong");
    }

    @Test
    public void checkBoxes() {
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("[type=checkbox]"));
        boolean isChecked = checkboxes.get(0).isSelected();
        assertFalse(isChecked, "Checked!");
        checkboxes.get(0).click();
        isChecked = checkboxes.get(0).isSelected();
        assertTrue(isChecked, "NonChecked!");

        isChecked = checkboxes.get(1).isSelected();
        assertTrue(isChecked, "NonChecked!");
        checkboxes.get(1).click();
        isChecked = checkboxes.get(1).isSelected();
        assertFalse(isChecked, "Checked!");
        }

        @Test
    public void dropdown() {
        driver.get("http://the-internet.herokuapp.com/dropdown");
        List<WebElement> dropdown = driver.findElements(By.id("dropdown"));

        }

    }



