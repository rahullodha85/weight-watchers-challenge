package exercise1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class WebPageTest {

    static WebDriver driver;

    public WebPageTest() {
        getChromeDriver();
        driver.navigate().to("file:///" + this.getClass().getClassLoader().getResource("testPage.html").getPath()); //Users/461967/dev/weight-watchers-challenge/src/main/resources/testPage.html");
    }

    public WebDriver getChromeDriver() {
        String driverPath = System.getProperty("user.dir") + "/drivers/chromedriver";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver(getChromeOptions());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-geolocation");

        return options;
    }

    public String readItemByIndex(int index) {
        String item = driver.findElement(By.className("”itemContent”")).findElements(By.tagName("span")).get(index).getText();
        return item;
    }

    public Map<String, String> readAll() {
        Map<String, String> map = new HashMap<>();
        List<WebElement> foodItems = driver.findElement(By.className("”itemContent”"))
                .findElements(By.cssSelector("span[ng-bind='food.name']"));
        List<WebElement> foodServing = driver.findElement(By.className("”itemContent”"))
                .findElements(By.cssSelector("span[ng-bind='food._servingDesc']"));

        for (int i = 0; i < foodItems.size(); i++) {
            map.put(foodItems.get(i).getText(), foodServing.get(i).getText());
        }
        return map;
    }

    public void closeBrowser() {
        driver.quit();
    }
}
