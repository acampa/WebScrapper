package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    //Web elements
    private WebDriver driver;
    private static By LanguageButton = By.xpath("//span[@class = 'language_txt']");
    private static By ShipToButton = By.xpath("//span[@class = 'shipping-text']");
    private static By ShipToSearchTextbox = By.xpath("//input[@placeholder = 'Search']");
    private static By SaveButton = By.xpath("//button[@data-role = 'save']");

    public HomePage(WebDriver driver){
        this.driver =driver;
    }
    //Methods
    public void ClickSaveButton(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(SaveButton));
        driver.findElement(SaveButton).click();
    }
    public void EnterShipToSearchTextbox(String country){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(ShipToSearchTextbox));
        driver.findElement(ShipToSearchTextbox).sendKeys(country);
    }
    public void SelectShipToCountry(String country){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format("//li[@data-name = '%s']", country))));
        driver.findElement(By.xpath(String.format("//li[@data-name = '%s']", country))).click();

    }
    public void ClickShipToButton(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(ShipToButton));
        driver.findElement(ShipToButton).click();
    }

    public void ClickLanguageButton(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(LanguageButton));
        driver.findElement(LanguageButton).click();
        driver.findElement(LanguageButton).click();
    }
}
