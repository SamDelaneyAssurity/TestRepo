import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TradeMeTest {
    private WebDriver driver;


    @Test
    public void testGold() throws Exception
    {
        System.out.println("hello");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.tmsandbox.co.nz/");
        WebElement button = driver.findElement(By.cssSelector("#generalSearch > div.field.field-right"));
        WebElement search = driver.findElement(By.xpath("//*[@id=\"searchString\"]"));
        search.sendKeys("gold");
        //search.submit();
        search.sendKeys(Keys.RETURN);
        WebDriverWait webDriver = new WebDriverWait(driver, 5);
        webDriver.until(ExpectedConditions.visibilityOfElementLocated(By.id("Footer_FooterLinks_browseLink")));
        //button.click();
        WebElement count = driver.findElement(By.cssSelector("#totalCount"));
        WebElement listings = driver.findElement(By.xpath("//*[@id=\"SuperGridGallery_BucketList_ClassifiedPrice_listingClassifiedPriceAmountPoa\"]"));
        WebElement clickView = driver.findElement(By.xpath("//*[@id=\"ListingViewBar_listViewTab_icon_a\"]"));
        System.out.println(listings.getText());
        //assertEquals(listings.getText(), "For sale by tender");
        System.out.println("Amount of listing "+count.getText());
        //assertEquals(count.getText(), "28");
        clickView.click();
        webDriver.until(ExpectedConditions.visibilityOfElementLocated(By.id("Footer_FooterLinks_browseLink")));
        Select select = new Select(driver.findElement(By.id("listingTitleBarSelect")));
        select.selectByValue("buynow_asc");
        WebElement list = driver.findElement(By.cssSelector("#mainContent"));
        var price = list.findElements(By.className("listingBidPrice"));
        for(int i=0; i<Math.min(3, price.size()); i++)
        {
            System.out.println("price: "+(i+1)+" "+price.get(i).getText() + " dollers");
        }
        WebElement title = list.findElement(By.className("title"));
        System.out.println("Name "+title.getText());
        driver.quit();
    }
}
