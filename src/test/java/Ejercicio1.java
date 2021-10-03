import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static utilities.Miscellaneous.*;

public class Ejercicio1 extends Base{
    @BeforeTest
    public void initialize(){
        driver=initializeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
    }

    @Test
    public void test() throws InterruptedException {

        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys("Josdy");

        WebElement lastName =  driver.findElement(By.id("lastName"));
        lastName.sendKeys("Valdez");

        WebElement userEmail = driver.findElement(By.id("userEmail"));
        userEmail.sendKeys("abc@hotmail.com");

        WebElement femaleRadioBtn = driver.findElement(By.xpath("//label[contains(text(),'Female')]"));
        femaleRadioBtn.click();

        WebElement userNumber = driver.findElement(By.id("userNumber"));
        userNumber.sendKeys("12345678990");

        WebElement dateOfBirthInput = driver.findElement(By.id("dateOfBirthInput"));
        dateOfBirthInput.click();
        WebElement chooseDate = driver.findElement(By.xpath("//div[@class='react-datepicker__week' and contains(.,'10')]"));
        chooseDate.click();

        WebElement musicCheckBx = driver.findElement(By.xpath("//div[@id=\"hobbiesWrapper\"]/div[2]/div[3]"));
        musicCheckBx.click();

        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("Lima, Peru");


        List<WebElement> dropdownState = driver.findElements(By.xpath("//div[@id='state']"));
        dropdownState.get(0).click();
        List<WebElement> selectState = driver.findElements(By.className("css-26l3qy-menu"));

        selectState.get(0).click();

        List<WebElement> dropdownCity = driver.findElements(By.xpath("//div[@id='city']"));

        List<WebElement> selectCity = driver.findElements(By.className("css-26l3qy-menu"));

        selectCity.get(0).click();


        WebElement btnSubmit = driver.findElement(By.cssSelector("#submit"));
        btnSubmit.click();

        String expectedTitle="Thanks for submitting the form";
        WebElement titleA= driver.findElement(By.xpath("//div[@id=\"example-modal-sizes-title-lg\"]"));

        Assert.assertEquals(expectedTitle,titleA.getText());

        WebElement btnClose=driver.findElement(By.id("closeLargeModal"));
        btnClose.click();
        btnClose.click();






    }

    @AfterTest
    public void close(){
        driver.close();
    }





}
