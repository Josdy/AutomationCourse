import org.testng.annotations.*;

public class Test extends Base{
    @BeforeTest
    public void initialize(){
        driver=initializeDriver();
    }
    @org.testng.annotations.Test
    public void test() throws  InterruptedException{
        driver.get("https://www.google.com/");
        Thread.sleep(5000);
    }

    @AfterTest
    public void closeDriver(){
        driver.close();
    }
}
