package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.UnsupportedEncodingException;
import static java.net.URLEncoder.encode;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.HomePage;

public class BaseTests {
    private WebDriver driver;
    protected HomePage homePage;
    private String searchQuery = "women's socks";
    private String baseUrl = "https://www.aliexpress.com/wholesale?catId=0&initiative_id=&SearchText=";
    //WebDriverWait wait_;

    @BeforeClass
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        try {
            driver = new ChromeDriver();
            driver.get(baseUrl + encode(searchQuery, "UTF-8"));
            System.out.println(driver.getTitle());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        homePage = new HomePage(driver);
        //wait_ = new WebDriverWait(driver, 5);
    }
    @AfterClass
    public void TearDown(){
        driver.quit();
    }
}
