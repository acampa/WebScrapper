package home;

import base.BaseTests;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;
import pages.HomePage;
import scrapper.ProductInfo;

public class HomePageTests extends BaseTests {

    @Test
    public void Login() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.GoTo();
        homePage.RemovePopUp();
        homePage.ClickAccountButton();
        homePage.ClickSignInButton();
        homePage.EnterEmailAddressTextbox("vivianahj@hotmail.com");
        homePage.EnterPasswordTextbox("DUDY06");
        Thread.sleep(5000);
    }
    @Test
    public void ChangeShipTo() {
        HomePage homePage = new HomePage(driver);
        homePage.ClickHelpButton();
        homePage.ClickLanguageButton();
        homePage.ClickShipToButton();
        homePage.EnterShipToSearchTextbox("Colombia");
        homePage.SelectShipToCountry("Colombia");
        homePage.ClickSaveButton();
    }
    @Test
    public JSONArray GetScrubbedData() {
        ChangeShipTo();
        HomePage homePage = new HomePage(driver);
        String rawData = homePage.GetAllDataByScriptTag();
        String removeGarbageDataBefore = rawData.replace("window.runParams = ", "").replace("{};", "");
        String removeGarbageDataAfter = removeGarbageDataBefore.substring(0, removeGarbageDataBefore.indexOf("window.runParams"));
        JSONObject jsonObject = new JSONObject(removeGarbageDataAfter);
        JSONObject data = jsonObject.getJSONObject("mods").getJSONObject("itemList");
        JSONArray contentArray = data.getJSONArray("content");
        return contentArray;
    }
    @Test
    public void CreateProductInfoList() throws InterruptedException {
        JSONArray data = GetScrubbedData();
        System.out.println(String.format("There were %s items found", data.length()));
        for(int i = 0; i <data.length(); ++i){
            System.out.println(data.get(i));
            ProductInfo productInfo = new ProductInfo();
            productInfo.setTitle(data.getJSONObject(i).getJSONObject("title").getString("displayTitle"));

            ObjectMapper objectMapper = new ObjectMapper();
            try {
                String jsonString = objectMapper.writeValueAsString(productInfo);
                System.out.println(jsonString);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        Thread.sleep(5000);
    }

}
