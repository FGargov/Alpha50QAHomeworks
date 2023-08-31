package googlesearchtest;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleSearchByTermTest {
    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeAll
    public static void classSetup() { //тук правим подготовка за един път преди да започнат тестовете.
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless");
        driver = new FirefoxDriver(options);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));

        driver.get("https://google.com");//зареждаме google заради Agree съгласието.

        //Agree to consent
        WebElement agreeButton = driver.findElement(By.xpath("//button[@id='L2AGLb']"));
        //WebElement agreeButton = driver.findElement(By.id("L2AGLb"));
        agreeButton.click();

    }

    @AfterAll
    public static void classTearDown() {
        driver.close();
    }

    @BeforeEach
    public void testSetup() {
        driver.get("https://google.com");//изпълняваме го преди всеки тест.
        //driver.navigate().to("https://google.com");
    }

    @Test
    public void resultFound_when_searchTermProvided_telerikAcademy() {
        String searchTerm = "Telerik Academy";
        //Type text in search field
        WebElement searchField = driver.findElement(By.xpath("//textarea[@type='search']"));
        searchField.sendKeys(searchTerm);

        //Click search button
        WebElement searchButton = driver.findElement(By.xpath("(//input[@type='submit' and @name='btnK'])[2]"));
        wait.until(ExpectedConditions.visibilityOf(searchButton));// когато искаме да използваме wait за този тест. По същия начин и за другите тесотве.
        searchButton.click();

        //Assert result found
        WebElement firstResult = driver.findElement(By.xpath("//a/h3[1]"));
        //Assertions.assertEquals("Telerik Academy: Programming and Digital Training", firstResult.getText(), "Search result not found");
        Assertions.assertTrue(firstResult.getText().contains(searchTerm), "Search result not found.");
    }

    @Test
    public void resultFound_when_searchTermProvided_alphaQa() {
        //Type text in search field
        WebElement searchField = driver.findElement(By.xpath("//textarea[@type='search']"));
        searchField.sendKeys("Alpha QA");

        //Click search button
        WebElement searchButton = driver.findElement(By.xpath("(//center/input[@type='submit' and @name='btnK'])[2]"));
        searchButton.click();

        //Assert result found
        /*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        WebElement firstResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a/h3[1]")));*/
        WebElement firstResult = driver.findElement(By.xpath("//a/h3[1]"));
        Assertions.assertEquals("QA Training - Telerik Academy Alpha", firstResult.getText(), "Search result not found");

    }
}
