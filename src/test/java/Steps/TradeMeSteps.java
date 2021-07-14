package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.ResultPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TradeMeSteps {
    private ChromeDriver driver;
    private HomePage homePage;
    private ResultPage resultPage;

    @Given("I am conducting a TradeMe search")
    public void iAmConductingATradeMeSearch() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(("https://www.tmsandbox.co.nz"));
        homePage = new HomePage(driver);
    }

    @When("I search for {string}")
    public void iSearchFor(String arg0) {
        resultPage = homePage.searchForSomething(arg0);
    }

    @Then("I see {int} results")
    public void iSeeResults(int arg0) {
        assertEquals(arg0, resultPage.totalAmount());
        driver.quit();
    }
}
