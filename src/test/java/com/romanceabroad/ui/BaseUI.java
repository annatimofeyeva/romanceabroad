package com.romanceabroad.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

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
    UserProfilePage userProfilePage;
    ContactUsPage contactUsPage;
    FooterPage footerPage;
    SoftAssert softAssert = new SoftAssert();
    protected TestBox testBox;


    protected enum TestBox {
        LOCAL, SAUCE
    }

    @BeforeMethod(groups = {"user", "admin", "chrome"}, alwaysRun = true)
    @Parameters({"browser", "version", "platform", "testbox"})
    public void setUp(@Optional("chrome") String browser, @Optional ("null") String version, @Optional ("null") String platform,
                      @Optional ("null") String box, Method method) {
        Reports.start(method.getDeclaringClass().getName() + " : " + method.getName());

        if(box.equalsIgnoreCase("local")) {
            testBox = TestBox.LOCAL;
        }else if(box.equalsIgnoreCase("sauce")) {
            testBox = TestBox.SAUCE;
        }

        switch(testBox) {
            case LOCAL:
            // Check if parameter passed from TestNG is 'firefox'
            if (browser.equalsIgnoreCase("firefox")) {
                // Set path to geckodriveradd
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
            break;
            case SAUCE:
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("username", "annaTim");
                capabilities.setCapability("accessKey", "1a487018-9eff-4ad6-a49e-a7349d84b7ad");
                capabilities.setCapability("browserName", browser);
                capabilities.setCapability("version", version);
                capabilities.setCapability("platform", platform);
                capabilities.setCapability("name", method.getName());
                try {
                    driver = new RemoteWebDriver(
                            new URL("http://" + System.getenv("SAUCE_USERNAME") +
                                    System.getenv("SAUCE_ACCESS_KEY") +
                                    "@ondemand.saucelabs.com:80/wd/hub"), capabilities);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
        }// switch end

        wait = (new WebDriverWait(driver, 20));
        mainPage = new MainPage(driver, wait);
        searchPage = new SearchPage(driver, wait);
        blogPage = new BlogPage(driver, wait);
        mediaPage = new MediaPage(driver, wait);
        giftsPage = new GiftsPage(driver, wait);
        loginPage = new LoginPage(driver, wait);
        contactUsPage = new ContactUsPage(driver, wait);
        howWeWorkPage = new HowWeWorkPage(driver, wait);
        userProfilePage = new UserProfilePage(driver, wait);
        footerPage = new FooterPage(driver, wait);

        driver.manage().window().maximize();
        driver.get(Data.mainUrl);
    }

    @AfterMethod
    public void tearDown(ITestResult testResult) {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            Reports.fail(driver, testResult.getName());
        }
        Reports.stop();
        driver.quit();
    }
}
