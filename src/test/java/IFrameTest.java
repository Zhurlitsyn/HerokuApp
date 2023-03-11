import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class IFrameTest extends BaseTest {

    @Test
    public void iFrame() {
        driver.get("http://the-internet.herokuapp.com/iframe");
        driver.switchTo().frame("mce_0_ifr");
        driver.findElement(By.id("tinymce"));
        driver.switchTo().defaultContent();
    }
}
