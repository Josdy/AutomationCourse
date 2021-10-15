import com.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;


public class Ejercicio2_1 extends Base{

    @BeforeTest
    public void initialize(){
        driver=initializeDriver();
        driver.get("https://demoqa.com/buttons");
    }
    @Test
    public void doubleClick() {
        Actions act = new Actions(driver);
        WebElement btndoubleClick = driver.findElement(By.xpath("//div//button[@id=\"doubleClickBtn\"]"));

        act.doubleClick(btndoubleClick).perform();



        WebElement m= driver.findElement(By.xpath("//div//p[@id=\"doubleClickMessage\"]"));
        Assert.assertEquals("You have done a double click", m.getText());


    }

    @AfterTest
    public void close(){
        driver.close();
    }

}
