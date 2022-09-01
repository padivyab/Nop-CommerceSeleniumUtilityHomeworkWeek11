package electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class ElectronicsTest extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp()
    {
        openBrowser(baseUrl);

    }
    @Test
    public void textVerified() throws InterruptedException {
        //1.1 Mouse Hover on “Electronics” Tab
        //1.2 Mouse Hover on “Cell phones” and click
        //1.3 Verify the text “Cell phones”
        mouseHoverToElement(By.xpath("//div[@class='header-menu']/ul[1]/li[2]/a[1]"));
        Thread.sleep(1000);
       // mouseHoverToElement(By.xpath("//div[@class='header-menu']/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
       // clickOnElement(By.xpath("//div[@class='header-menu']/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
        mouseHoverToElementAndClick(By.xpath("//div[@class='header-menu']/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
        Thread.sleep(1000);
        String actualText = getTextFromElement(By.xpath("//div[@class='center-2']/div[1]/div[1]/h1[1]"));
        String expectedText = "Cell phones";
        Assert.assertEquals(expectedText,actualText);

    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {

        //2.1 Mouse Hover on “Electronics” Tab
        //2.2 Mouse Hover on “Cell phones” and click
        //2.3 Verify the text “Cell phones”
        this.textVerified();

        //2.4 Click on List View Tab
        clickOnElement(By.xpath("//div[@class='page-body']/div[1]/div[1]/a[2]"));
        Thread.sleep(1000);

        //2.5 Click on product name “Nokia Lumia 1020” link
        clickOnElement(By.xpath("//div[@class='item-grid']/div[3]/div[1]/div[2]/h2[1]/a[1]"));
        Thread.sleep(1000);

        //2.6 Verify the text “Nokia Lumia 1020”
        String actualTextNokia = getTextFromElement(By.xpath("//div[@class='product-essential']/div[2]/div[1]/h1[1]"));
        String expectedTextNokia = "Nokia Lumia 1020";
        Assert.assertEquals(expectedTextNokia,actualTextNokia);
        Thread.sleep(1000);

        //2.7 Verify the price “$349.00”
        String actualTextPrice = getTextFromElement(By.xpath("//span[@id='price-value-20']"));
        String expectedTextPrice = "$349.00";
        Assert.assertEquals(expectedTextPrice,actualTextPrice);
        Thread.sleep(1000);

        //2.8 Change quantity to 2
        clearTextFromField(By.xpath("//input[@id='product_enteredQuantity_20']"));
        sendTextToElement(By.xpath("//input[@id='product_enteredQuantity_20']"),"2");
        Thread.sleep(1000);

        //2.9 Click on “ADD TO CART” tab
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));
        Thread.sleep(1000);

        //2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String actualTextMsg = getTextFromElement(By.xpath("//p[@class='content']"));
        String expectedTextMsg = "The product has been added to your shopping cart";
        Assert.assertEquals(expectedTextMsg,actualTextMsg);
        Thread.sleep(1000);

        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//span[@class='close']"));
        Thread.sleep(1000);

        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverToElement(By.xpath("//div[@class='header-links']/ul[1]/li[4]/a[1]/span[1]"));
        clickOnElement(By.xpath("//button[@class='button-1 cart-button']"));
        Thread.sleep(1000);

        //2.12 Verify the message "Shopping cart"
        String actualTextCart = getTextFromElement(By.xpath("//div[@class='center-1']/div[1]/div[1]/h1[1]"));
        String expectedTextCart = "Shopping cart";
        Assert.assertEquals(expectedTextCart,actualTextCart);
        Thread.sleep(1000);

        //2.13 Verify the quantity is 2
        String actualTextQu = getTextFromElement(By.xpath("//input[@class='qty-input']"));
        String expectedTextQu = "";
        Assert.assertEquals(expectedTextQu,actualTextQu);
        Thread.sleep(1000);

        //2.14 Verify the Total $698.00
        String actualTextTotal = getTextFromElement(By.xpath("//div[@class='total-info']/table[1]/tbody/tr[4]/td[2]/span[1]/strong[1]"));
        String expectedTextTotal = "$698.00";
        Assert.assertEquals(expectedTextTotal,actualTextTotal);
        Thread.sleep(1000);

        //2.15 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        Thread.sleep(1000);

        //2.16 Click on checkout
        clickOnElement(By.xpath("//button[@id='checkout']"));
        Thread.sleep(1000);

        //“2.17 Verify the Text “Welcome, Please Sign In!”
        String actualTextSign = getTextFromElement(By.xpath("//div[@class='center-1']/div[1]/div[1]/h1[1]"));
        String expectedTextSign = "Welcome, Please Sign In!";
        Assert.assertEquals(expectedTextSign,actualTextSign);
        Thread.sleep(1000);

        //2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[@class='button-1 register-button']"));
        Thread.sleep(1000);

        //2.19 Verify the text “Register”
        String actualTextRegister = getTextFromElement(By.xpath("//div[@class='center-1']/div[1]/div[1]/h1[1]"));
        String expectedTextRegister = "Register";
        Assert.assertEquals(expectedTextRegister,actualTextRegister);
        Thread.sleep(1000);

        //2.20 Fill the mandatory fields
        sendTextToElement(By.xpath("//input[@id='FirstName']"),"divsa");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='LastName']"),"patel");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='Email']"),"divys0057@gmail.com");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='Password']"),"divpa02");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='ConfirmPassword']"),"divpa02");
        Thread.sleep(1000);

        //2.21 Click on “REGISTER” Button
        clickOnElement(By.xpath("//button[@class='button-1 register-next-step-button']"));
        Thread.sleep(1000);

        //2.22 Verify the message “Your registration completed”
        String actualTextReg = getTextFromElement(By.xpath("//div[@class='center-1']/div[1]/div[2]/div[1]"));
        String expectedTextReg = "Your registration completed";
        Assert.assertEquals(expectedTextReg,actualTextReg);
        Thread.sleep(1000);

        //2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[@class='button-1 register-continue-button']"));
        Thread.sleep(1000);

        //2.24 Verify the text “Shopping cart”
        String actualTextCart1 = getTextFromElement(By.xpath("//div[@class='center-1']/div[1]/div[1]/h1[1]"));
        String expectedTextCart1 = "Shopping cart";
        Assert.assertEquals(expectedTextCart1,actualTextCart1);
        Thread.sleep(1000);

        //2.25 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        Thread.sleep(1000);

        //2.26 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
        Thread.sleep(1000);

        //2.27 Fill the Mandatory fields
        selectByValueFromDropdown(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"133");
        Thread.sleep(1000);

        sendKeysToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "dakor");
        Thread.sleep(1000);

        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"),"230 cder");
        Thread.sleep(1000);

        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"),"L1S4F5");
        Thread.sleep(1000);

        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"),"9898075648");
        Thread.sleep(1000);

        //2.28 Click on “CONTINUE”
        clickOnElement(By.xpath("//div[@id='billing-buttons-container']/button[4]"));

        //2.29 Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.xpath("//input[@id='shippingoption_2']"));
        Thread.sleep(1000);

        //2.30 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        Thread.sleep(1000);

        //2.31 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        Thread.sleep(1000);

        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));
        Thread.sleep(1000);

        //2.32 Select “Visa” From Select credit card dropdown
        selectByValueFromDropdown(By.xpath("//select[@id='CreditCardType']"),"visa");
        //Thread.sleep(1000);

        //2.33 Fill all the details
        sendTextToElement(By.xpath("//input[@id='CardholderName']"),"divspa");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='CardNumber']"),"4012888888881881");
        Thread.sleep(1000);

        selectByValueFromDropdown(By.xpath("//select[@id='ExpireMonth']"),"6");
        Thread.sleep(1000);

        selectByValueFromDropdown(By.xpath("//select[@id='ExpireYear']"),"2026");
        Thread.sleep(1000);

        sendTextToElement(By.xpath("//input[@id='CardCode']"),"568");
        Thread.sleep(1000);

        //2.34 Click on “CONTINUE”CHECKOUT”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        Thread.sleep(1000);

        //2.35 Verify “Payment Method” is “Credit Card”
        String actualTextPayment = getTextFromElement(By.xpath("//div[@class='order-review-data']/div[1]/div[2]/ul[1]/li[1]/span[2]"));
        String expectedTextPayment = "Credit Card";
        Assert.assertEquals(expectedTextPayment,actualTextPayment);
        Thread.sleep(1000);

        //2.36 Verify “Shipping Method” is “2nd Day Air”
        String actualTextPayment1 = getTextFromElement(By.xpath("//div[@class='order-review-data']/div[2]/div[2]/ul[1]/li[1]/span[2]"));
        String expectedTextPayment1 = "2nd Day Air";
        Assert.assertEquals(expectedTextPayment1,actualTextPayment1);
        Thread.sleep(1000);
        //2.37 Verify Total is “$698.00”
        String actualTextPayment2 = getTextFromElement(By.xpath("//div[@class='total-info']/table[1]/tbody[1]/tr[4]/td[2]/span[1]/strong[1]"));
        String expectedTextPayment2 = "$698.00";
        Assert.assertEquals(expectedTextPayment2,actualTextPayment2);
        Thread.sleep(1000);

        //2.38 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[@class='button-1 confirm-order-next-step-button']"));
        Thread.sleep(1000);

        //2.39 Verify the Text “Thank You”
        String actualTextPaymentThank = getTextFromElement(By.xpath("//div[@class='center-1']/div[1]/div[1]/h1[1]"));
        String expectedTextPaymentThank = "Thank you";
        Assert.assertEquals(expectedTextPaymentThank,actualTextPaymentThank);
        Thread.sleep(1000);

        //2.40 Verify the message “Your order has been successfully processed!”
        String actualTextPaymentMsg = getTextFromElement(By.xpath("//div[@class='center-1']/div[1]/div[2]/div[1]/div[1]/strong[1]"));
        String expectedTextPaymentMsg = "Your order has been successfully processed!";
        Assert.assertEquals(expectedTextPaymentMsg,actualTextPaymentMsg);
        Thread.sleep(1000);

        //2.41 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 order-completed-continue-button']"));
        Thread.sleep(1000);

        //2.42 Verify the text “Welcome to our store”
        String actualTextPaymentText1 = getTextFromElement(By.xpath("//div[@class='center-1']/div[1]/div[1]/div[2]/div[1]/h2[1]"));
        String expectedTextPaymentText1 = "Welcome to our store";
        Assert.assertEquals(expectedTextPaymentText1,actualTextPaymentText1);
        Thread.sleep(1000);
        //2.43 Click on “Logout” link
        clickOnElement(By.xpath("//a[@href=\"/logout\"]"));
        Thread.sleep(1000);

        //2.44 Verify the URL is “https://demo.nopcommerce.com/”
        String actualTextPaymentLink1 = getTextFromElement(By.xpath("//div[@class='header-logo']/a/img[1]"));
        String expectedTextPaymentLink1 = "";
        Assert.assertEquals(expectedTextPaymentLink1,actualTextPaymentLink1);
        Thread.sleep(1000);

    }
    @After
    public void close()
    {
        //closeBrowser();

    }




}
