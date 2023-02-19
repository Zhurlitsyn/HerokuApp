import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Typos extends BaseTest {

    @Test
    public void typosSpelling() {
        driver.get("http://the-internet.herokuapp.com/typos");
        for (int i = 1; i < 8; i++) {
            driver.navigate().refresh();
            List<WebElement> pTags = driver.findElements(By.tagName("p"));
            String typoSpell = pTags.get(1).getText();
            Assert.assertEquals(typoSpell, "Sometimes you'll see a typo, other times you won't.",
                    "Misspelled word 'won,t'");
        }
    }
}
