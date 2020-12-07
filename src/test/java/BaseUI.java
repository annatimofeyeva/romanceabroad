import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;

public class BaseUI {
    protected WebDriver driver;
    protected WebDriverWait wait;
    MainPage mainPage;
    SearchPage searchPage;
    BlogPage blogPage;
    MediaPage mediaPage;
    GiftsPage giftsPage;
    LoginPage loginPage;
    HowWeWorkPage howWeWorkPage;
    ContactUsPage contactUsPage;
    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod(groups = {"user", "admin", "chrome"}, alwaysRun = true)
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser, Method method) {

        // Check if parameter passed from TestNG is 'firefox'
        if (browser.equalsIgnoreCase("firefox")) {
            // Set path to geckodriver
            System.setProperty("webdriver.gecko.driver", "geckodriver");
            // Create firefox instance
            driver = new FirefoxDriver();
        }
//        // Check if parameter passed as 'IE'
//        else if (browser.equalsIgnoreCase("ei")) {
//            // Set path to EIdriver
//            System.setProperty("webdriver.ie.driver", "IEDriverServer");
//            driver = new InternetExplorerDriver();
//            driver.manage().deleteAllCookies();
//        }
        // Check if parameter passed as 'chrome'
        else if (browser.equalsIgnoreCase("chrome")) {
            // Set path to geckodriver
            System.setProperty("webdriver.chrome.driver", "chromedriver");
            driver = new ChromeDriver();
            driver.get("chrome://settings/clearBrowserData");
        }
        // Check if parameter passed as 'opera'
        else if (browser.equalsIgnoreCase("opera")) {
            // Set path to operadriverOld
            System.setProperty("webdriver.opera.driver", "operadriver");
            driver = new OperaDriver();
            driver.manage().deleteAllCookies();
        } else {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
            driver = new ChromeDriver();
            driver.get("chrome://settings/clearBrowserData");
        }

        wait = (new WebDriverWait(driver, 20));
        mainPage = new MainPage(driver, wait);
        searchPage = new SearchPage(driver, wait);
        blogPage = new BlogPage(driver, wait);
        mediaPage = new MediaPage(driver, wait);
        giftsPage = new GiftsPage(driver, wait);
        loginPage = new LoginPage(driver, wait);
        contactUsPage = new ContactUsPage(driver, wait);
        howWeWorkPage = new HowWeWorkPage(driver, wait);

        driver.manage().window().maximize();
        driver.get(Data.mainUrl);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
