package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.CartPage;
import pageObjects.LoginPage;
import pageObjects.PageObjectManager;
import utilities.ExcelHelper;
import utilities.TestBase;
import utilities.TestContextSetup;

import java.util.concurrent.TimeUnit;

public class LoginStepDefinitions {
    public WebDriver driver;
    public TestBase testBase;
    public LoginPage loginPage;
    public static CartPage cartPage;
    public static TestContextSetup testContextSetup;
    public PageObjectManager pageObjectManager;

    public LoginStepDefinitions(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
        this.loginPage = testContextSetup.pageObjectManager.getLoginPage();
    }
    @Given("^I am on the login page$")
    public void i_am_on_the_login_page() throws Throwable {

    }

    @When("^I enter wrong username \"([^\"]*)\" and correct password \"([^\"]*)\"$")
    public void i_enter_wrong_username_something_and_correct_password_something(String username, String password) throws Throwable {
        username = ExcelHelper.getCellDataString(1, 0);
        password = ExcelHelper.getCellDataString(1, 1);
        loginPage.setUsername(username);
        loginPage.setPassword(password);
    }

    @When("^I enter a correct password \"([^\"]*)\" and an empty username \"([^\"]*)\"$")
    public void i_enter_a_correct_password_something_and_an_empty_username_something(String username, String password) throws Throwable {
        username = "";
        password = ExcelHelper.getCellDataString(2, 1);
        loginPage.setUsername(username);
        loginPage.setPassword(password);
    }

    @When("^I enter a correct username \"([^\"]*)\" and a wrong password \"([^\"]*)\"$")
    public void i_enter_a_correct_username_something_and_a_wrong_password_something(String username, String password) throws Throwable {
        username = ExcelHelper.getCellDataString(3, 0);
        password = ExcelHelper.getCellDataString(3, 1);
        loginPage.setUsername(username);
        loginPage.setPassword(password);
    }

    @When("^I enter a correct username \"([^\"]*)\" and an empty password \"([^\"]*)\"$")
    public void i_enter_a_correct_username_something_and_an_empty_password_something(String username, String password) throws Throwable {
        username = ExcelHelper.getCellDataString(4, 0);
        password = "";
        loginPage.setUsername(username);
        loginPage.setPassword(password);
    }

    @When("^I enter a wrong username \"([^\"]*)\" and a wrong password \"([^\"]*)\"$")
    public void i_enter_a_wrong_username_something_and_a_wrong_password_something(String username, String password) throws Throwable {
        username = ExcelHelper.getCellDataString(5, 0);
        password = ExcelHelper.getCellDataString(5, 1);
        loginPage.setUsername(username);
        loginPage.setPassword(password);
    }

    @When("^I enter a correct username \"([^\"]*)\" and a correct password \"([^\"]*)\"$")
    public void i_enter_a_correct_username_something_and_a_correct_password_something(String username, String password) throws Throwable {
        username = "standard_user";
        password = "secret_sauce";
        loginPage.setUsername(username);
        loginPage.setPassword(password);

    }

    @Then("^I should see an error message$")
    public void i_should_see_an_error_message() throws Throwable {

    }

    @Then("^I should be logged in to my account$")
    public void i_should_be_logged_in_to_my_account() throws Throwable {

    }

    @And("^click the login button$")
    public void click_the_login_button() throws Throwable {
        loginPage.clickLoginBtn();
        Thread.sleep(1000);

        if (loginPage.errorVisible()){
            testContextSetup.testBase.setupBrowser().quit();
        }
    }

}
