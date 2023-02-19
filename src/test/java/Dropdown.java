import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class Dropdown extends BaseTest {

    @Test
    public void dropdown() {
        driver.get("http://the-internet.herokuapp.com/dropdown");
        Select select = new Select(driver.findElement(By.id("dropdown")));
        List<WebElement> dd = select.getOptions();

        boolean checkSize = true;
        int amountText = 0;
        for (int i = 1; i < dd.size(); i++) {
            if (!dd.get(i).getText().trim().isEmpty()) {
                amountText++;
                checkSize = ((dd.size()-1) == amountText);
            }
        }
        assertTrue(checkSize, "Non visible items!");

        select.selectByIndex(1);
        boolean strSelected = dd.get(1).isSelected();
        assertTrue(strSelected, "The Item is not 'selected'");

        select.selectByIndex(2);
        strSelected = dd.get(2).isSelected();
        assertTrue(strSelected, "The Item is not 'selected'");

    }
}
