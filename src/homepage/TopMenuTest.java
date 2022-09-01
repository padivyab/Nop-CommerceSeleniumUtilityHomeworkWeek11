package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class TopMenuTest extends Utility {

    String baseurl = "https://demo.nopcommerce.com/";


    @Before
    public void setUp() {

        openBrowser(baseurl);
    }
    public void selectMenu(String menu)
    {

        //1.1 create method with name "selectMenu" it has one parameter name "menu" of type string
        //1.2 This method should click on the menu whatever name is passed as parameter.
        List<WebElement> topMenuName = driver.findElements(By.xpath("//div[@class='header-menu']/ul[1]"));

        for(WebElement name : topMenuName)
        {
            if(name.getText().equalsIgnoreCase(menu))
            {
                name.click();
                break;

            }
        }
        //1.3. create the @Test method name verifyPageNavigation.use selectMenu method to
        //select the Menu and click on it and verify the page navigation.
    }

    @Test
    public void verifyComputerPageNavigation()
    {
        //1.3. create the @Test method name verifyPageNavigation.use selectMenu method to select the Menu and click on it and verify the page navigation.
        selectMenu("Computers");
        verifyText("Computers",By.xpath("//div[@class='header-menu']/ul[1]/li[1]/a[1]"),"Computers");
    }

    @Test
    public void verifyElectronicsPageNavigation()
    {
        selectMenu("Electronics");
        verifyText("Electronics",By.xpath("//div[@class='header-menu']/ul[1]/li[2]/a[1]"),"Electronics");
    }

    @Test
    public void verifyApparelPagenavigation()
    {
        selectMenu("Apparel");
        verifyText("Apparel",By.xpath("//div[@class='header-menu']/ul[1]/li[3]/a[1]"),"Apparel");
    }

    @Test
    public void verifyDigitalDownloadPagenavigation()
    {
        selectMenu("Digital downloads");
        verifyText("Digital downloads",By.xpath("//div[@class='header-menu']/ul[1]/li[4]/a[1]"),"Digital downloads");
    }

    @Test
    public void verifyBooksPagenavigation()
    {
        selectMenu("Books");
        verifyText("Books",By.xpath("//div[@class='header-menu']/ul[1]/li[5]/a[1]"),"Books");
    }

    @Test
    public void verifyJewelryPagenavigation()
    {
        selectMenu("Jewelry");
        verifyText("Jewelry",By.xpath("//div[@class='header-menu']/ul[1]/li[6]/a[1]"),"Jewelry");
    }

    @Test
    public void verifyGiftCardsPagenavigation()
    {
        selectMenu("Gift Cards");
        verifyText("Gift Cards",By.xpath("//div[@class='header-menu']/ul[1]/li[7]/a[1]"),"Gift Cards");

    }
    @After
    public void close()
    {
        //closeBrowser();

    }


}
