import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class NotificationMessage extends BaseTest {
    String messageVerFirst = "Action unsuccesful, please try again\n" + '×';
    String messageVerSecond = "Action successful\n" + '×';
    boolean checkMatch = true;


    @Test
    public void notificationMessage() {
        driver.get("http://the-internet.herokuapp.com/notification_message_rendered");
        driver.findElement(By.linkText("Click here")).click();
        String messageText = driver.findElement(By.id("flash")).getText();
        String temp = messageText;
        checkMatch = (messageText.equals(messageVerFirst) || messageText.equals(messageVerSecond));
        assertTrue(checkMatch, "Wrong another message");

    }
}
