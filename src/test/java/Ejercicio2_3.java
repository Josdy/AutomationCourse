import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Ejercicio2_3 extends Base{
    @BeforeTest
    public void initialize(){
        driver=initializeDriver();
        driver.get("https://demoqa.com/buttons");
    }

    @Test
    public void Click() {

        List<WebElement> btnClick = driver.findElements(By.className("btn-primary"));

        btnClick.get(2).click();



        WebElement m= driver.findElement(By.xpath("//div//p[@id=\"dynamicClickMessage\"]"));
        Assert.assertEquals("You have done a dynamic click", m.getText());


    }

    @AfterTest
    public void close(){
        driver.close();
    }
}
