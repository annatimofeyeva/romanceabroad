import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseUI {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
        wait = (new WebDriverWait(driver, 20));
        driver.manage().window().maximize();
        driver.get(Data.mainUrl);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public void getDropDownListByIndex(WebElement element, int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    public void getDropDownListByText(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public void getDropDownListByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public void getBlogPage(By locator) {
        driver.findElement(locator).click();
    }

    public void getBookNowPage(By locator) {
        driver.findElement(locator).click();
    }

    public void getGiftsPage(By locator) {
        driver.findElement(locator).click();
    }

    public void getHowWeWorkPage(By locator) {
        driver.findElement(locator).click();
    }

    public void getMediaPage(By locator) {
        driver.findElement(locator).click();
    }

    public void getRegistrationPage(By locator) {
        driver.findElement(locator).click();
    }

    public void getSearchPage(By locator) {
        driver.findElement(locator).click();
    }

    public void getTourToUkrainePage(By locator) {
        driver.findElement(locator).click();
    }

    public String generateUniqueUserName(String name, int length) {
        return name + RandomStringUtils.random(length, "172984757");
    }
}
