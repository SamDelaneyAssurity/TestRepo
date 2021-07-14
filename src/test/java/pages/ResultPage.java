package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultPage {
    private final WebDriverWait webDriverWait;
    private WebDriver driver;
    @FindBy(id = "totalCount")
    private WebElement totalCount;

    public ResultPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(totalCount));
        this.driver = driver;
    }
    public int totalAmount() {
        return Integer.parseInt(totalCount.getText());
    }
}
