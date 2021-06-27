package home;

import base.BaseTests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTests extends BaseTests {

    @Test
    public void testChangeShipTo(){
        homePage.ClickLanguageButton();
        homePage.ClickShipToButton();
        homePage.EnterShipToSearchTextbox("Colombia");
        homePage.SelectShipToCountry("Colombia");
        homePage.ClickSaveButton();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
