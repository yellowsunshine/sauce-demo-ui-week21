package com.saucedemo.pages;

import com.saucedemo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductPage extends Utility {

    static List<String> items = new ArrayList<>();

    /**
     * logger defined to print log
     */
    private static final Logger log = LogManager.getLogger(ProductPage.class.getName());

    public ProductPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//select[@class='product_sort_container']")
    WebElement dropDown;


    @FindBy(className = "inventory_item_name")
    List<WebElement> allProducts;

    @CacheLookup
    @FindBy(xpath = "(//button[normalize-space()='Add to cart'])[1]")
    WebElement addToCart;

    @CacheLookup
    @FindBy(id = "back-to-products")
    WebElement backToProducts;

    @CacheLookup
    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    WebElement cart;



    public void selectOptionFromDropdown(String visibleText) {
        doSelectByVisibleTextFromDropDown(dropDown, visibleText);
    }

    public void selectCostliestProductAndAddToTheBasket(String visibleText) {

        for (WebElement product : allProducts) {
            items.add(product.getText());
        }
        for (WebElement products : allProducts) {
            if (products.getText().equalsIgnoreCase(items.get(0))) {
                doClickOnElement(products);
                doClickOnElement(addToCart);
                break;
            }
        }
        doClickOnElement(backToProducts);
        doSelectByVisibleTextFromDropDown(dropDown, visibleText);
    }

    public void selectCheapestProductAndAddToTheBasket(String visibleText) {

        for (WebElement product : allProducts) {
            items.add(product.getText());
        }
        for (WebElement products : allProducts) {
            if (products.getText().equalsIgnoreCase(items.get(5))) {
                doClickOnElement(products);
                doClickOnElement(addToCart);
                break;
            }
        }
    }

    public void openShoppingCart(){
        doClickOnElement(cart);
    }


}








