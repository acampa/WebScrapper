package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    //Web elements
    private static By LanguageButton = By.xpath("//div[@data-role = 'region-pannel']/a");
    private static By ShipToButton = By.xpath("//span[@class = 'shipping-text']");
    private static By ShipToSearchTextbox = By.xpath("//input[@placeholder = 'Search']");
    private static By SaveButton = By.xpath("//button[@data-role = 'save']");
    private static By AllDataByScriptTag =  By.xpath("//script[contains(text(), 'window.runParams')]");

    public HomePage(WebDriver driver){
        super(driver);
    }
    //Methods
    public String GetAllDataByScriptTag(){
        wait.until(ExpectedConditions.presenceOfElementLocated(AllDataByScriptTag));
        return driver.findElement(AllDataByScriptTag).getAttribute("innerHTML");
    }
    public void ClickSaveButton(){
        wait.until(ExpectedConditions.elementToBeClickable(SaveButton));
        driver.findElement(SaveButton).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(SaveButton));
    }
    public void EnterShipToSearchTextbox(String country){
        wait.until(ExpectedConditions.presenceOfElementLocated(ShipToSearchTextbox));
        driver.findElement(ShipToSearchTextbox).sendKeys(country);
    }
    public void SelectShipToCountry(String country){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format("//li[@data-name = '%s']", country))));
        driver.findElement(By.xpath(String.format("//li[@data-name = '%s']", country))).click();

    }
    public void ClickShipToButton(){
        wait.until(ExpectedConditions.elementToBeClickable(ShipToButton));
        driver.findElement(ShipToButton).click();
    }

    public void ClickLanguageButton(){
        wait.until(ExpectedConditions.elementToBeClickable(LanguageButton));
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(LanguageButton)).click().build().perform();
    }
}
