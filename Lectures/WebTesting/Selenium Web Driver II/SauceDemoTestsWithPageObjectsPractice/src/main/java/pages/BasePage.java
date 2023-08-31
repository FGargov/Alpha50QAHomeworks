package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    private String pageUrl;

    public BasePage(WebDriver webDriver, WebDriverWait driverWait, String pageSpecificUrl) {
        driver = webDriver;
        wait = driverWait;
        pageUrl = pageSpecificUrl;
    }

    public String basePageUrl = "https://www.saucedemo.com/";

    public String getPageUrl() {
        return basePageUrl + pageUrl;
    }
    public void navigate() {
        driver.get(getPageUrl());
    }

    public void assertNavigate() { // за да можем да използваме Assertions класа извън test папката, както е ...Page класовете, премахнах на org.junit.jupiter dependency-то scope-a.
        Assertions.assertEquals(getPageUrl(), driver.getCurrentUrl(), "Page was not navigated.");
    }
}
