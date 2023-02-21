package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
public class CartPage{

    private WebDriver driver;
    private By addBackpack = By.id("add-to-cart-sauce-labs-backpack");
    private By addBikeLight = By.id("add-to-cart-sauce-labs-bike-light");
    private By addBoltTShirt = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private By addFleeceJacket = By.id("add-to-cart-sauce-labs-fleece-jacket");
    private By addOnesie = By.id("add-to-cart-sauce-labs-onesie");
    private By addRedTShirt = By.id("add-to-cart-test.allthethings()-t-shirt-(red)");
    private By addMenuBtn = By.id("react-burger-menu-btn");
    private By logoutBtn = By.id("logout_sidebar_link");
    private By cartBtn = By.className("shopping_cart_link");
    private By allProducts = By.id("inventory_sidebar_link");
    private By removeItem = By.id("remove-sauce-labs-bike-light");
    public static int count = 0;

    public CartPage(WebDriver driver){
        this.driver = driver;
    }

    public void addToCart(int num){
        By items[] = {addBackpack, addBikeLight, addBoltTShirt, addFleeceJacket, addOnesie, addRedTShirt};
        By arr[] = new By[20];

        for (int x=0; x<num; x++){
            if(items[x] != arr[x]){
                driver.findElement(items[x]).click();
                arr[x] = items[x];
                count++;
            }
        }
    }

    public void goToAllItems() throws InterruptedException {
        driver.findElement(addMenuBtn).click();
        Thread.sleep(1000);
        driver.findElement(allProducts).click();
    }

    public void removeItem(){
        driver.findElement(removeItem).click();
    }


    public void openCart(){
        driver.findElement(cartBtn).click();
    }

    public void logout() throws InterruptedException {
        try {
            driver.findElement(addMenuBtn).click();
            Thread.sleep(1000);
            driver.findElement(logoutBtn).click();
        } catch (NoSuchElementException e){
            System.out.println(e);
        }

    }


}
