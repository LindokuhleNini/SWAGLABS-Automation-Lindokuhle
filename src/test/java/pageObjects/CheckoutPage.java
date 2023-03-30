package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    WebDriver driver;
    public By firstName = By.id("first-name");
    public By lastName = By.id("last-name");
    public By postalCode = By.id("postal-code");
    public By continueBtn = By.id("continue");
    public By finishBtn = By.id("finish");

    public CheckoutPage(WebDriver driver){
        this.driver = driver;
    }

    public void setFirstName(String first_name){
        driver.findElement(firstName).sendKeys(first_name);
    }

    public void setLastName(String last_name){
        driver.findElement(lastName).sendKeys(last_name);
    }

    public void setPostalCode(String postal_code){
        driver.findElement(postalCode).sendKeys(postal_code);
    }

    public void selectContinue(){
        driver.findElement(continueBtn).click();
    }

    public void confirmCheckout(){
        driver.findElement(finishBtn).click();
    }

}
