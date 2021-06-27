package home;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTests extends BaseTests {

    @Test
    public void testChangeShipTo() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.ClickLanguageButton();
        homePage.ClickShipToButton();
        homePage.EnterShipToSearchTextbox("Colombia");
        homePage.SelectShipToCountry("Colombia");
        homePage.ClickSaveButton();
        System.out.println("output: " + homePage.GetAllDataByScriptTag());
        Thread.sleep(5000);


    }

}
