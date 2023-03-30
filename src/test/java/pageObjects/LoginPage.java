package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class LoginPage{

    public WebDriver driver;

    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.className("error");


    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void setUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void setPassword(String password) {
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clearUsername(){
        driver.findElement(usernameField).clear();
    }

    public void clearPassword(){
        driver.findElement(passwordField).clear();
    }

   public void clickLoginBtn(){
        driver.findElement(loginButton).click();
       // return new ProductsPage(driver);
   }

    public boolean errorVisible(){
        try {
            if (driver.findElement(errorMessage).isDisplayed()){
                return true;
            }
        } catch (NoSuchElementException e){
            return false;
        }

        return false;
    }


}
