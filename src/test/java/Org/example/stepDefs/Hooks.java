package Org.example.stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class Hooks {

    public static WebDriver myDriver = null;

    @Before
    public void open_Browser() {
        String googlePAth = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", googlePAth);
        myDriver = new ChromeDriver();
        myDriver.manage().window().maximize();
        myDriver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        myDriver.navigate().to("https://demo.nopcommerce.com/");
        //logIn = new LogInPage(myDriver);

    }

    @After
    public void close_Browser() throws InterruptedException {
        Thread.sleep(3000);
       myDriver.quit();

    }

}
