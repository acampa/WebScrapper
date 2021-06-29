package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    //Web elements
    private static By AccountButton = By.xpath("//span[@class = 'user-account-port']/a");
    private static By LanguageButton = By.xpath("//div[@data-role = 'region-pannel']/a");
    private static By ShipToButton = By.xpath("//span[@class = 'shipping-text']");
    private static By ShipToSearchTextbox = By.xpath("//input[@placeholder = 'Search']");
    private static By SaveButton = By.xpath("//button[@data-role = 'save']");
    private static By AllDataByScriptTag =  By.xpath("//script[contains(text(), 'window.runParams')]");
    private static By HelpButton = By.xpath("//span[text() = 'Help']");
    private static By SignInButton = By.xpath("//a[@class = 'sign-btn']");
    private static By EmailAddressTextbox = By.id("fm-login-id");
    private static By PasswordTextbox = By.id("fm-login-password");
    //Constructor
    public HomePage(WebDriver driver){
        super(driver);
    }
    //Methods
    public void EnterPasswordTextbox(String password){
        wait.until(ExpectedConditions.presenceOfElementLocated(PasswordTextbox));
        driver.findElement(PasswordTextbox).sendKeys(password);
    }
    public void EnterEmailAddressTextbox(String emailAddress){
        wait.until(ExpectedConditions.presenceOfElementLocated(EmailAddressTextbox));
        driver.findElement(EmailAddressTextbox).sendKeys(emailAddress);
    }
    public void ClickSignInButton(){
        wait.until(ExpectedConditions.elementToBeClickable(SignInButton));
        driver.findElement(SignInButton).click();
    }
    public void RemovePopUp(){
        if(!(driver.findElements(By.xpath("//div[@class = 'poplayer-content']")).isEmpty())){
            driver.findElement(By.xpath("//img[@class = 'btn-close']")).click();
        };
    }
    public void GoTo(){
        driver.getCurrentUrl();
    }
    public void ClickAccountButton(){
        wait.until(ExpectedConditions.elementToBeClickable(AccountButton));
        driver.findElement(AccountButton).click();
    }
    public void ClickHelpButton(){
        wait.until(ExpectedConditions.elementToBeClickable(HelpButton));
        driver.findElement(HelpButton).click();
    }
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
