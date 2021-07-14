import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoogleTest {

    private WebDriver driver;

    @BeforeAll
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
    }

    @AfterEach
    public void tearDown() {
        if(driver != null) {
            driver.quit();
        }
    }

    @Test
    public void checkTitle() {
        assertEquals("Google", driver.getTitle());
    }

    @Test
    public void testCheese() throws Exception {
        WebElement qureyBox = driver.findElement(By.name("q99"));
        qureyBox.sendKeys("cheese");
        qureyBox.sendKeys(Keys.RETURN);
        Thread.sleep(2000);
    }
}
