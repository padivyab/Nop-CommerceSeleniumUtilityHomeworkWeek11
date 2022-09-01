package computer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.webaudio.WebAudio;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

import javax.swing.*;

public class TestSuite extends Utility {

    String baseurl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp()
    {
        openBrowser(baseurl);

    }
    @Test
    public void computerTestMenu()
    {
        //1.1 Click on Computer Menu.
        //clickOnElement(By.linkText("Computers"));

        //1.2 Click on Desktop
        //clickOnElement(By.xpath("//div[@class='item-grid']/div[1]/div[1]/h2[1]/a[1]"));
        Actions actions =new Actions(driver);
        WebElement computer = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        WebElement Desktop = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]"));
        actions.moveToElement(computer).build().perform();
        actions.moveToElement(Desktop).click().build().perform();


        //1.3 Select Sort By position "Name: Z to A"
        //clickOnElement(By.xpath("//select[@id='products-orderby']/option[3]"));
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"),"Name: Z to A");

        //1.4 Verify the Product will arrange in Descending order.
        String actualText = getTextFromElement(By.xpath("//select[@id='products-orderby']/option[3]"));
        String expectedText = "Name: Z to A";
        Assert.assertEquals(expectedText,actualText);

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessfully() throws InterruptedException {
        //2.1 Click on Computer Menu.
        //clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));

        //2.2 Click on Desktop
        //clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]"));
        //Thread.sleep(1000);

        this.computerTestMenu();
        //2.3 Select Sort By position "Name: A to Z"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"),"Name: A to Z");

        //2.4 Click on "Add To Cart"
        Thread.sleep(1000);
        clickOnElement(By.xpath("//div[@class='item-box'][1]//button[text()='Add to cart']"));

        //2.5 Verify the Text "Build your own computer"
        String actualText = getTextFromElement(By.xpath("//div[@class='item-grid']/div[1]/div[1]/div[2]/h2[1]/a[1]"));
        String expectedText = "Build your own computer";
        Assert.assertEquals(expectedText,actualText);
        Thread.sleep(1000);

        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectByValueFromDropdown(By.xpath("//select[@name='product_attribute_1']"),"1");
        Thread.sleep(1000);

        //2.7.Select "8GB [+$60.00]" using Select class.
        selectByValueFromDropdown(By.xpath("//select[@name='product_attribute_2']"),"5");
        Thread.sleep(1000);

        //2.8 Select HDD radio "400 GB [+$100.00]"
        clickOnElement(By.xpath("//input[@id='product_attribute_3_7']"));
        Thread.sleep(1000);

        //2.9 Select OS radio "Vista Premium [+$60.00]"
        clickOnElement(By.xpath("//input[@id='product_attribute_4_9']"));
        Thread.sleep(1000);

        //A 2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        //clickOnElement(By.xpath("//input[@id='product_attribute_5_10']"));
        //Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@id='product_attribute_5_12']"));
        Thread.sleep(1000);

        //2.11 Verify the price "$1,475.00"
        String actualText1 = getTextFromElement(By.xpath("//span[@id='price-value-1']"));
        String expectedText1 = "$1,475.00";
        Assert.assertEquals(expectedText1,actualText1);
        Thread.sleep(1000);

        //2.12 Click on "ADD TO CARD" Button.
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));

        //2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String actualText2 = getTextFromElement(By.xpath("//div[@id='bar-notification']/div[1]/p[1]"));
        String expectedText2 = "The product has been added to your shopping cart";
        Assert.assertEquals(expectedText2,actualText2);

        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//span[@class='close']"));
        Thread.sleep(1000);

        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverToElement(By.xpath("//span[@class='cart-label']"));
        clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));
        Thread.sleep(1000);

        //2.15 Verify the message "Shopping cart"
        String actualText4 = getTextFromElement(By.xpath("//div[@class='page-title']/h1[1]"));
        String expectedText4 = "Shopping cart";
        Assert.assertEquals(expectedText4,actualText4);
        Thread.sleep(1000);

        //2.16 Change the Qty to "2" and Click on "Update shopping cart"
        clearTextFromField(By.xpath("//input[@class='qty-input']"));
        sendTextToElement(By.xpath("//input[@class='qty-input']"),"2");
        clickOnElement(By.xpath("//button[@id='updatecart']"));
        Thread.sleep(1000);

        //2.17 Verify the Total"$2,950.00"
        String actualTextTotal = getTextFromElement(By.xpath("//div[@class='cart-footer']/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]/span[1]/strong[1]"));
        String expectedTextTotal = "$2,950.00";
        Assert.assertEquals(expectedTextTotal,actualTextTotal);

        //2.18 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        Thread.sleep(1000);

        //2.19 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
        //Thread.sleep(1000);

        //2.20 Verify the Text “Welcome, Please Sign In!”
        String actualTextMsg = getTextFromElement(By.xpath("//div[@class='page-title']"));
        String expectedTextMsg = "Welcome, Please Sign In!";
        Assert.assertEquals(expectedTextMsg,actualTextMsg);
        Thread.sleep(1000);

        //2.21Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[@class='button-1 checkout-as-guest-button']"));
        Thread.sleep(1000);

        //2.22 Fill the all mandatory field
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"),"divs");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"),"patel");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"),"div96@gmail.com");
        //selectByVisibleTextFromDropDown(By.name("country"),"India");
        selectByValueFromDropdown(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"133");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"),"oshawa");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"),"200 smomervilli");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"),"l1D4R7");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']") ,"9898034567");



        //2.23 Click on “CONTINUE”
        clickOnElement(By.xpath("//div[@id='billing-buttons-container']/button[4]"));

        //2.24 Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.xpath("//input[@id='shippingoption_1']"));
        Thread.sleep(1000);

        //2.25 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        Thread.sleep(1000);

        //2.26 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));
        Thread.sleep(1000);

        //2.27 Select “Master card” From Select credit card dropdown
        selectByValueFromDropdown(By.xpath("//select[@id='CreditCardType']"),"MasterCard");
        Thread.sleep(1000);

        //2.28 Fill all the details
        sendTextToElement(By.xpath("//input[@id='CardholderName']"),"divpatel");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"),"5123 4590 4605 8920");
        Thread.sleep(1000);
        //selectByValueFromDropdown(By.xpath("//div[@class='section payment-info']/div[1]/table[1]/tbody[1]/tr[4]/td[2]/select[1]/option[7]"),"7");
        selectByValueFromDropdown(By.xpath("//select[@id='ExpireMonth']"),"7");
        Thread.sleep(1000);
        selectByValueFromDropdown(By.xpath("//select[@id='ExpireYear']"),"2025");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='CardCode']"),"233");
        Thread.sleep(1000);

        //2.29 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));

        //2.30 Verify “Payment Method” is “Credit Card”
        String actualTextPayment = getTextFromElement(By.xpath("//div[@class='order-summary-content']/div[1]/div[1]/div[2]/ul[1]/li[1]/span[2]"));
        String expectedTextPayment = "Credit Card";
        Assert.assertEquals(expectedTextPayment,actualTextPayment);

        //2.32 Verify “Shipping Method” is “Next Day Air”
        String actualTextMsg1 = getTextFromElement(By.xpath("//div[@class='order-summary-content']/div[1]/div[2]/div[2]/ul[1]/li[1]/span[2]"));
        String expectedTextMsg1 = "Next Day Air";
        Assert.assertEquals(expectedTextMsg1,actualTextMsg1);
        Thread.sleep(1000);

        //2.33 Verify Total is “$2,950.00”
        String actualTextTotalMsg = getTextFromElement(By.xpath("//div[@class='total-info']/table[1]/tbody[1]/tr[4]/td[2]/span[1]/strong[1]"));
        String expectedTextTotalMsg = "$2,950.00";
        Assert.assertEquals(expectedTextTotalMsg,actualTextTotalMsg);
        Thread.sleep(1000);

        //2.34 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[@class='button-1 confirm-order-next-step-button']"));
        Thread.sleep(1000);

        //2.35 Verify the Text “Thank You”
        String actualTextFinalMsg = getTextFromElement(By.xpath("//div[@class='master-column-wrapper']/div[1]/div[1]/div[1]/h1[1]"));
        String expectedTextFinalMsg = "Thank you";
        Assert.assertEquals(expectedTextFinalMsg,actualTextFinalMsg);
        Thread.sleep(1000);

        //2.36 Verify the message “Your order has been successfully processed!”
        String actualTextSuccMsg = getTextFromElement(By.xpath("//div[@class='center-1']/div[1]/div[2]/div[1]/div[1]/strong[1]"));
        String expectedTextSuccMsg = "Your order has been successfully processed!";
        Assert.assertEquals(expectedTextSuccMsg,actualTextSuccMsg);
        Thread.sleep(1000);

        //2.37 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 order-completed-continue-button']"));
        Thread.sleep(1000);

        //2.37 Verify the text “Welcome to our store”
        String actualTextHomeMsg = getTextFromElement(By.xpath("//div[@class='center-1']/div[1]/div[1]/div[2]/div[1]/h2[1]"));
        String expectedTextHomeMsg = "Welcome to our store";
        Assert.assertEquals(expectedTextHomeMsg,actualTextHomeMsg);
        Thread.sleep(1000);

    }
    @After
    public void close()
    {
        closeBrowser();

    }

}
