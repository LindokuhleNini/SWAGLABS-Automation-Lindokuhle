package stepDefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import pageObjects.CartPage;
import pageObjects.LoginPage;
import pageObjects.PageObjectManager;
import utilities.ExcelHelper;
import utilities.TestBase;
import utilities.TestContextSetup;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static stepDefinitions.LoginStepDefinitions.cartPage;
import static stepDefinitions.LoginStepDefinitions.testContextSetup;

public class CartStepDefinitions {

    public WebDriver driver;
    public TestBase testBase;
    //public TestContextSetup testContextSetup;
    public CartPage cartPage;
    public LoginPage loginPage;
    public PageObjectManager pageObjectManager;
    public LoginStepDefinitions myStepDefinitions;

    /*public CartStepDefinitions(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
        //this.cartPage = testContextSetup.pageObjectManager.getCartPage();
    }*/

    @Given("^the user is logged in$")
    public void the_user_is_logged_in() throws Throwable {

    }

    @And("^the user is on the product page$")
    public void the_user_is_on_the_product_page() throws Throwable {
        String username = "standard_user";
        String password = "secret_sauce";
        testContextSetup = new TestContextSetup();
        loginPage = testContextSetup.pageObjectManager.getLoginPage();
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.clickLoginBtn();
        Thread.sleep(1000);
    }

    @When("^the user adds n items to the cart$")
    public void the_user_adds_something_items_to_the_cart() throws Throwable {
        //testContextSetup = new TestContextSetup();
        cartPage = testContextSetup.pageObjectManager.getCartPage();
        cartPage.addToCart(2);
    }

    @When("^the user logs out$")
    public void the_user_logs_out() throws Throwable {
        cartPage = testContextSetup.pageObjectManager.getCartPage();
        cartPage.logout();
        testContextSetup.testBase.setupBrowser().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        testContextSetup.testBase.setupBrowser().quit();
        CartPage.count = 0;
    }

    @When("^the user adds 3 items to the cart$")
    public void the_user_adds_3_items_to_the_cart() throws Throwable {
        cartPage = testContextSetup.pageObjectManager.getCartPage();
        cartPage.addToCart(3);
    }

    @Then("^the cart should have \"([^\"]*)\" items$")
    public void the_cart_should_have_something_items(String strArg1) throws Throwable {

    }

    @Then("^the user should be redirected to the login page$")
    public void the_user_should_be_redirected_to_the_login_page() throws Throwable {

    }

    @Then("^the cart should still have \"([^\"]*)\" items$")
    public void the_cart_should_still_have_something_items(String strArg1) throws Throwable {

    }

    @And("^each item should be displayed in the cart$")
    public void each_item_should_be_displayed_in_the_cart() throws Throwable {

    }

    @And("^the user removes 1 item from the cart$")
    public void the_user_removes_1_item_from_the_cart() throws Throwable {
        cartPage = testContextSetup.pageObjectManager.getCartPage();
        cartPage.removeItem();
        cartPage.count -= 1;
    }

    @And("^the user logs back in$")
    public void the_user_logs_back_in() throws Throwable {

    }

    @And("^each item should still be displayed in the cart$")
    public void each_item_should_still_be_displayed_in_the_cart() throws Throwable {

    }

    @When("the user adds n items to the cart again")
    public void theUserAddsNItemsToTheCartAgain() {
        cartPage = testContextSetup.pageObjectManager.getCartPage();
        cartPage.addToCart(2);
    }

    @Then("the user should see all {int} items in the cart")
    public void theUserShouldSeeAllItemsInTheCart(int num) {
        cartPage = testContextSetup.pageObjectManager.getCartPage();
        cartPage.openCart();
        assertEquals(CartPage.count, num);

    }

    @And("the user navigates back to the All items page")
    public void theUserNavigatesBackToTheAllItemsPage() throws InterruptedException {
        cartPage = testContextSetup.pageObjectManager.getCartPage();
        cartPage.goToAllItems();
    }

    @Then("the user should see only {int} items in the cart")
    public void theUserShouldSeeOnlyItemsInTheCart(int num) {
        cartPage = testContextSetup.pageObjectManager.getCartPage();
        cartPage.openCart();
        assertEquals(CartPage.count, num);
        //testContextSetup.testBase.setupBrowser().quit();
    }

    @And("the user logs out again")
    public void theUserLogsOutAgain() throws InterruptedException {
        cartPage = testContextSetup.pageObjectManager.getCartPage();
        cartPage.logout();
        testContextSetup.testBase.setupBrowser().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //testContextSetup.testBase.setupBrowser().quit();
        CartPage.count = 0;
    }
}
