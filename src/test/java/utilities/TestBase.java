package utilities;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class TestBase {

    public WebDriver driver;
    TestContextSetup testContextSetup;

    public WebDriver setupBrowser(){
        String browser = "edge";
        String url = "https://www.saucedemo.com/";

        if(driver == null){
            switch (browser.toUpperCase()){
                case "CHROME", "GOOGLE CHROME" ->{
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.get(url);
                    driver.manage().window().maximize();
                }
                case "EDGE", "MICROSOFT EDGE" ->{
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    driver.get(url);
                    driver.manage().window().maximize();
                }
            }
        }

        return driver;
    }

    @AfterClass
    public void tearDown() {
        //driver.quit();
    }
}
