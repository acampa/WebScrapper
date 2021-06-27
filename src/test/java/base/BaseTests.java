package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.UnsupportedEncodingException;
import static java.net.URLEncoder.encode;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import pages.HomePage;

public class BaseTests {
    public WebDriver driver;
    private String searchQuery = "women's socks";
    private String baseUrl = "https://www.aliexpress.com/wholesale?catId=0&initiative_id=&SearchText=";

    @BeforeSuite
    public void SetUp() {
        try {
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
            driver = new ChromeDriver();
            driver.get(baseUrl + encode(searchQuery, "UTF-8"));
            System.out.println(driver.getTitle());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
    @AfterSuite
    public void TearDown(){
        driver.quit();
    }
}
