import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class Checkboxes extends BaseTest {

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
}
