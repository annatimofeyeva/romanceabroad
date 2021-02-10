package com.romanceabroad.ui;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
import java.util.HashMap;
import java.util.Map;

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
    protected TestBrowser testBrowser;
    protected String valueOfBox;


    protected enum TestBox {
        WEB, MOBILE, SAUCE
    }

    protected enum TestBrowser {
        CHROME, FIREFOX, OPERA
    }


    @BeforeMethod(groups = {"user", "admin", "chrome"}, alwaysRun = true)
    @Parameters({"browser", "version", "platform", "testBox", "deviceName", "testEnv"})
    public void setup(@Optional("chrome") String browser,
                      @Optional("null") String version,
                      @Optional("null") String platform,
                      @Optional("web") String box,
                      @Optional("null") String device,
                      @Optional("qa") String env,
                      Method method) throws MalformedURLException {
        System.out.println(env);
        Reports.start(method.getDeclaringClass().getName() + " : " + method.getName());
        testBox = TestBox.WEB;
        if (box != null && box.equalsIgnoreCase("sauce")) {
            testBox = TestBox.SAUCE;
        } else if (box != null && box.equalsIgnoreCase("mobile"))
            testBox = TestBox.MOBILE;

/*        if (box.equalsIgnoreCase("web")) {
            testBox = TestBox.WEB;
        } else if (box.equalsIgnoreCase("sauce")) {
            testBox = TestBox.SAUCE;
        } else if (box.equalsIgnoreCase("mobile")) {
            testBox = TestBox.MOBILE;
        }*/

        if (browser.equalsIgnoreCase("chrome")) {
            testBrowser = TestBrowser.CHROME;
        } else if (browser.equalsIgnoreCase("firefox")) {
            testBrowser = TestBrowser.FIREFOX;
        } else if (browser.equalsIgnoreCase("opera")) {
            testBrowser = TestBrowser.OPERA;
        }


        switch (testBox) {
            case WEB:

                switch (testBrowser) {
                    case FIREFOX:
                        System.setProperty("webdriver.gecko.driver", "geckodriver");
                        // Create firefox instance
                        driver = new FirefoxDriver();
                        break;

                    case OPERA:
                        System.setProperty("webdriver.opera.driver", "operadriver");
                        driver = new OperaDriver();
                        driver.manage().deleteAllCookies();
                        break;

                    default:
                        System.setProperty("webdriver.chrome.driver", "chromedriver");
                        driver = new ChromeDriver();
                        driver.get("chrome://settings/clearBrowserData");

                }
                driver.manage().window().maximize();
                break;

            case SAUCE:
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("username", "AnjaT");
                capabilities.setCapability("accessKey", "9aea376b483242119ddd19306d70f6ac");
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
                break;

            case MOBILE:

                switch (testBrowser) {
                    case CHROME:
                        // Set up for mobile optimization
                        Map<String, String> mobileEmulation = new HashMap<String, String>();
                        mobileEmulation.put("deviceName", "Nexus 4");
                        ChromeOptions chromeOptions = new ChromeOptions();
                        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
                        System.setProperty("webdriver.chrome.driver", "chromedriver");
                        driver = new ChromeDriver(chromeOptions);
                        driver.get("chrome://settings/clearBrowserData");
                        System.out.println(mobileEmulation.get("deviceName"));
                        break;
                }
                break;

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




        if (env.contains("qa")) {
            driver.get(Data.mainUrl);
        } else if (env.contains("uat")) {
            driver.get("https://www.google.com/");
        } else if (env.contains("prod")) {
            driver.get("https://www.yahoo.com/");
        }

        valueOfBox = box;
    }

    @AfterMethod
    public void tearDown(ITestResult testResult) {
        // Local Reports
        if (testResult.getStatus() == ITestResult.FAILURE) {
            Reports.fail(driver, testResult.getName());
        }
        Reports.stop();

/*        // SauceLabs reports
        ((JavascriptExecutor) driver).executeScript
                ("sauce:job-result=" + (testResult.isSuccess() ? "passed" : "failed"));*/
        driver.quit();
    }
}