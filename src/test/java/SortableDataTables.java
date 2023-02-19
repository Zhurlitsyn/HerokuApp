import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class SortableDataTables extends BaseTest {
    @Test
    public void sortableDataTable() {
        driver.get("http://the-internet.herokuapp.com/tables");
        // work with List
        List<WebElement> header = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
        String str = header.get(3).getText();
        Assert.assertEquals(str, "Due", "The values don't match");
        str = header.get(1).getText();
        Assert.assertEquals(str, "First Name", "The values don't match");

        // work with direct link to the cell

        String tempPath = "//table[@id='table1']/tbody";
        String checkCell = driver.findElement(By.xpath(tempPath + "/tr[1]/td[1]")).getText();
        Assert.assertEquals(checkCell, "Smith", "The values don't match");

        checkCell = driver.findElement(By.xpath(tempPath + "/tr[2]/td[4]")).getText();
        Assert.assertEquals(checkCell, "$51.00", "The values don't match");

        checkCell = driver.findElement(By.xpath(tempPath + "/tr[3]/td[5]")).getText();
        Assert.assertEquals(checkCell, "http://www.jdoe.com", "The values don't match");

        tempPath = "//table[@id='table2']/tbody";
        checkCell = driver.findElement(By.xpath(tempPath + "/tr[2]/td[3]")).getText();
        Assert.assertEquals(checkCell, "fbach@yahoo.com", "The values don't match");

        String checkCellFirstName = driver.findElement(By.xpath(tempPath + "/tr[3]/td[2]")).getText();
        Assert.assertEquals(checkCellFirstName, "Jason", "The values don't match");

        String checkCellAction = driver.findElement(By.xpath(tempPath + "/tr[1]/td[6]")).getText();
        Assert.assertEquals(checkCellAction, "edit delete", "The values don't match");
    }
}
