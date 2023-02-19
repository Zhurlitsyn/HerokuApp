import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.openqa.selenium.Keys.ARROW_DOWN;
import static org.openqa.selenium.Keys.ARROW_UP;
import static org.testng.Assert.assertTrue;

public class InputField extends BaseTest {

    @Test
    public void inputPositiveNumber() {
        driver.get("http://the-internet.herokuapp.com/inputs");
        WebElement wb = driver.findElement(By.cssSelector("input[type=number]"));
        wb.click();
        wb.sendKeys(Keys.chord(ARROW_UP, ARROW_UP,ARROW_UP));
        int checkDigit = Integer.valueOf(wb.getAttribute("value"));
        Assert.assertEquals(checkDigit, 3, "Wrong digital entered");
        wb.clear();
        wb.sendKeys(Keys.chord(ARROW_DOWN, ARROW_DOWN,ARROW_DOWN, ARROW_DOWN));
        checkDigit = Integer.valueOf(wb.getAttribute("value"));
        Assert.assertEquals(checkDigit, -4, "Wrong digital entered");
    }
}
