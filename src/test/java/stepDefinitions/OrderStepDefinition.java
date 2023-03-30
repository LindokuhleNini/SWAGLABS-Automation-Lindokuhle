package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.LoginPage;
import pageObjects.PageObjectManager;
import utilities.TestBase;
import utilities.TestContextSetup;

import static org.testng.Assert.assertEquals;
import static stepDefinitions.LoginStepDefinitions.testContextSetup;

public class OrderStepDefinition {
    public WebDriver driver;
    public TestBase testBase;
    public CartPage cartPage;
    public LoginPage loginPage;
    public PageObjectManager pageObjectManager;
    public LoginStepDefinitions myStepDefinitions;
    public CheckoutPage checkoutPage;

    //public CartPage cartPage;

    @Given("^the user is on the login page$")
    public void the_user_is_on_the_login_page() throws Throwable {
        String username = "standard_user";
        String password = "secret_sauce";
        testContextSetup = new TestContextSetup();
        loginPage = testContextSetup.pageObjectManager.getLoginPage();
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.clickLoginBtn();
        Thread.sleep(1000);
    }

    @Given("^the user is on the home page$")
    public void the_user_is_on_the_home_page() throws Throwable {

    }

    @Given("^the user is on the cart page$")
    public void the_user_is_on_the_cart_page() throws Throwable {

    }

    @Given("^the user is on the checkout page$")
    public void the_user_is_on_the_checkout_page() throws Throwable {
        String firstName = "Lindokuhle";
        String lastName = "Nini";
        String postalCode = "8001";
        //testContextSetup = new TestContextSetup();
        checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
        checkoutPage.setFirstName(firstName);
        checkoutPage.setLastName(lastName);
        checkoutPage.setPostalCode(postalCode);
        checkoutPage.selectContinue();
        Thread.sleep(1000);
    }

    @Given("^the user is on the order confirmation page$")
    public void the_user_is_on_the_order_confirmation_page() throws Throwable {

    }

    @When("^the user logs in with valid credentials$")
    public void the_user_logs_in_with_valid_credentials() throws Throwable {

    }

    @When("^the user adds 4 items to the cart$")
    public void the_user_adds_4_items_to_the_cart() throws Throwable {
        cartPage = testContextSetup.pageObjectManager.getCartPage();
        cartPage.addToCart(4);
    }

    @When("^the user proceeds to checkout$")
    public void the_user_proceeds_to_checkout() throws Throwable {

    }

    @When("^the user enters their details and confirms the order$")
    public void the_user_enters_their_details_and_confirms_the_order() throws Throwable {

    }

    @When("^the user checks the Total amount$")
    public void the_user_checks_the_total_amount() throws Throwable {

    }

    @Then("^the user should be redirected to the home page$")
    public void the_user_should_be_redirected_to_the_home_page() throws Throwable {

    }

    @Then("the cart should display all {int} items")
    public void theCartShouldDisplayAllItems(int num) {
        cartPage = testContextSetup.pageObjectManager.getCartPage();
        cartPage.openCart();
        assertEquals(CartPage.count, num);
    }

    @Then("^the user should be redirected to the checkout page$")
    public void the_user_should_be_redirected_to_the_checkout_page() throws Throwable {
        cartPage = testContextSetup.pageObjectManager.getCartPage();
        cartPage.goToCheckout();
    }

    @Then("^the order should be processed successfully$")
    public void the_order_should_be_processed_successfully() throws Throwable {
        checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
        checkoutPage.confirmCheckout();
    }

    @Then("^the Total amount should be equal to the sum of the Tax and Item total$")
    public void the_total_amount_should_be_equal_to_the_sum_of_the_tax_and_item_total() throws Throwable {

    }


}
