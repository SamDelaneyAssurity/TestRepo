import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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
import pages.HomePage;
import pages.ResultPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TradeMeTest {
    private HomePage homePage;
    private WebDriver driver;
    private ResultPage resultPage;


    @BeforeAll
    public static void setupClass()
    {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setupBrowser()
    {
        driver = new ChromeDriver();
        driver.get(("https://www.tmsandbox.co.nz"));
        homePage = new HomePage(driver);
    }


    @Test
    public void testGold() throws Exception
    {

        resultPage = homePage.searchForSomething();

        String count = resultPage.totalAmount();
        WebElement listings = driver.findElement(By.xpath("//*[@id=\"SuperGridGallery_BucketList_ClassifiedPrice_listingClassifiedPriceAmountPoa\"]"));
        WebElement clickView = driver.findElement(By.xpath("//*[@id=\"ListingViewBar_listViewTab_icon_a\"]"));
        System.out.println(listings.getText());
        System.out.println("Amount of listing "+count);
        clickView.click();
        Thread.sleep(5000);
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
