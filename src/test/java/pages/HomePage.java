package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriverWait webDriverWait;
    private WebDriver driver;
    public HomePage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, 5);
    }

    public ResultPage searchForSomething(String input) {
        WebElement search = driver.findElement(By.xpath("//*[@id=\"searchString\"]"));
        search.sendKeys(input);
        search.sendKeys(Keys.RETURN);
        return new ResultPage(driver);
    }
}
