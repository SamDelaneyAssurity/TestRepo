package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultPage {
    private final WebDriverWait webDriverWait;
    private WebDriver driver;
    public ResultPage(WebDriver driver) {
        webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Footer_FooterLinks_browseLink")));
        this.driver = driver;
    }
    public String totalAmount() {
        return driver.findElement(By.cssSelector("#totalCount")).getText();
    }
}
