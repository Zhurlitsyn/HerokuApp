import org.openqa.selenium.By;
import org.testng.annotations.Test;

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

}



