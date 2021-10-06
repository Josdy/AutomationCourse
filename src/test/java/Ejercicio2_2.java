import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Ejercicio2_2 extends Base{
    @BeforeTest
    public void initialize(){
        driver=initializeDriver();
        driver.get("https://demoqa.com/buttons");
    }
    @Test
    public void rightClick() {
        Actions act = new Actions(driver);
        WebElement btnContextClick = driver.findElement(By.xpath("//div//button[@id=\"rightClickBtn\"]"));

        act.contextClick(btnContextClick).perform();



        WebElement m= driver.findElement(By.xpath("//div//p[@id=\"rightClickMessage\"]"));
        Assert.assertEquals("You have done a right click", m.getText());


    }


    @AfterTest
    public void close(){
        driver.close();
    }
}
