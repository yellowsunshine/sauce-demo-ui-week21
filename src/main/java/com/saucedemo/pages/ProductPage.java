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

    @FindBy(xpath = "//button[@class='btn btn_primary btn_small btn_inventory']")
    List<WebElement> products;

    @CacheLookup
    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    WebElement cart;

    public void selectOptionFromDropdown(String visibleText) {
        doSelectByVisibleTextFromDropDown(dropDown, visibleText);
    }

    public void selectCostliestProductAndAddToTheBasket() throws InterruptedException {

        for (int i = 0; i < products.size(); i++) {
            if (i == 0 || i == products.size() - 1) {
                log.info("Adding product to the cart: " + products.get(i).toString());
                Thread.sleep(1000);
                doClickOnElement(products.get(i));
            }
        }
    }

    public void openShoppingCart() {
        doClickOnElement(cart);
    }
}








