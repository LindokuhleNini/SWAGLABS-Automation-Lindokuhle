package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.LoginPage;
import utilities.TestContextSetup;
import static stepDefinitions.LoginStepDefinitions.testContextSetup;

public class OrderStepDefinitions {
    public WebDriver driver;
    public CartPage cartPage;
    public LoginPage loginPage;
    public CheckoutPage checkoutPage;

    @Given("^the user is on the login page2$")
    public void the_user_is_on_the_login_page2() throws Throwable {
        testContextSetup = new TestContextSetup();
        loginPage = testContextSetup.pageObjectManager.getLoginPage();
    }

    @When("^the user logs in with valid credentials2$")
    public void the_user_logs_in_with_valid_credentials2() throws Throwable {

        String username = "standard_user";
        String password = "secret_sauce";
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.clickLoginBtn();
        Thread.sleep(1000);
    }

    @And("^the user adds 4 items to the cart2$")
    public void the_user_adds_4_items_to_the_cart2() throws Throwable {
        cartPage = testContextSetup.pageObjectManager.getCartPage();
        cartPage.addToCart(4);
    }

    @Then("^the user should see 4 items in the cart$")
    public void the_user_should_see_4_items_in_the_cart() throws Throwable {
        cartPage = testContextSetup.pageObjectManager.getCartPage();
        assert cartPage.getCartCount().equals("4");
    }

    @When("^the user proceeds to checkout2$")
    public void the_user_proceeds_to_checkout2() throws Throwable {
        cartPage = testContextSetup.pageObjectManager.getCartPage();
        cartPage.openCart();
        cartPage.goToCheckout();
    }

    @And("^the user enters their details$")
    public void the_user_enters_their_details() throws Throwable {
        String firstName = "Lindokuhle";
        String lastName = "Nini";
        String postalCode = "8001";
        checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
        checkoutPage.setFirstName(firstName);
        checkoutPage.setLastName(lastName);
        checkoutPage.setPostalCode(postalCode);
        checkoutPage.selectContinue();
        Thread.sleep(1000);
    }

    @Then("^the order total should be correct$")
    public void the_order_total_should_be_correct() throws Throwable {

    }

    @And("^the user completes the order$")
    public void the_user_completes_the_order() throws Throwable {

    }

}
