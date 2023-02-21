package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import pageObjects.CartPage;
import pageObjects.PageObjectManager;

public class TestContextSetup {

    public WebDriver driver;
    public PageObjectManager pageObjectManager;
    public TestBase testBase;
    public CartPage cartPage;
    public GenericUtils genericUtils;
    public ExcelHelper excelHelper;

    public TestContextSetup(){
        testBase = new TestBase();
        pageObjectManager = new PageObjectManager(testBase.setupBrowser());
        excelHelper = new ExcelHelper();
        excelHelper.excelSetup();
        //genericUtils = new GenericUtils(testBase.setupBrowser());
    }


}
