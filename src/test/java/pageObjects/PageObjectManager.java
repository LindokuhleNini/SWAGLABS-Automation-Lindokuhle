package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    public WebDriver driver;
    public LoginPage loginPage;
    public CartPage cartPage;
    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLoginPage(){
        loginPage = new LoginPage(driver);
        return loginPage;
    }

    public CartPage getCartPage(){
        cartPage = new CartPage(driver);
        return cartPage;
    }
}
