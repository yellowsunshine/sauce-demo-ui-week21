package com.saucedemo.pages;

import com.saucedemo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends Utility {
    /**
     * logger defined to print log
     */
    private static final Logger log = LogManager.getLogger(CheckoutPage.class.getName());

    public CheckoutPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(id = "first-name")
    WebElement firstName;

    @CacheLookup
    @FindBy(id = "last-name")
    WebElement lastName;

    @CacheLookup
    @FindBy(id = "postal-code")
    WebElement postalCode;

    @CacheLookup
    @FindBy(id = "continue")
    WebElement continueButton;

    @CacheLookup
    @FindBy(id = "finish")
    WebElement finishButton;

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='THANK YOU FOR YOUR ORDER']")
    WebElement message;


    public void enterPersonalInformationOnCheckOutPage(String name, String lname, String pcode){
        doSendTextToElement(firstName, name);
        doSendTextToElement(lastName, lname);
        doSendTextToElement(postalCode, pcode);
    }

    public void clickOnContinueButton(){
        doClickOnElement(continueButton);
    }

    public void clickOnFinishButton(){
        doClickOnElement(finishButton);
    }

    public void verifyMessage(String expectedMessage){
        Assert.assertTrue(message.getText().equalsIgnoreCase(expectedMessage));
    }





}
