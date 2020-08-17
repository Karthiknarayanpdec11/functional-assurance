package framework;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromiumDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * DriverFactory which will create respective driver Object
 *
 * @author Cognizant
 */
public class WebDriverFactory {
    /**
     * Function to return the object for WebDriver {@link WebDriver} object
     *
     * @return Instance of the {@link WebDriver} object
     */
    public static WebDriver createWebDriverInstance(String strDevice) {
        WebDriver driver = null;
        try {
            ChromeOptions chromeOptions;
            FirefoxOptions firefoxOptions;
            URL testGridUrl = new URL(System.getProperty("gridURL").trim());
            String strExecutionPlatform = System.getProperty("executionPlatform").trim().toUpperCase();
            //LOCAL_CHROME, LOCAL_FIREFOX, AWS_CHROME, AWS_FIREFOX, AWS_DEVICEFARM_CHROME, AWS_DEVICEFARM_FIREFOX


            switch (strExecutionPlatform) {
                case "LOCAL_CHROME":
                    chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--no-sandbox");
                    chromeOptions.addArguments("--disable-dev-shm-usage");
                    chromeOptions.addArguments("start-maximized");
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(chromeOptions);
                    break;
                case "LOCAL_FIREFOX":
                    firefoxOptions = new FirefoxOptions();
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver(firefoxOptions);
                    break;
                case "GRID_CHROME":
                    DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
                    chromeOptions = new ChromeOptions();
                    desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
                    driver = new RemoteWebDriver(testGridUrl, desiredCapabilities);
                    break;
                case "GRID_FIREFOX":
                    driver = new RemoteWebDriver(testGridUrl, DesiredCapabilities.firefox());
                    ExtentCucumberAdapter.addTestStepLog(strExecutionPlatform + " Driver Creation Completed");
                    break;
                default:
                    ExtentCucumberAdapter.addTestStepLog("ExecutionPlatform Platform must be set in settings file.");
            }
            ExtentCucumberAdapter.addTestStepLog(strExecutionPlatform + " Driver Creation Completed");
        } catch (
                Exception ex) {
            ex.printStackTrace();
        }
        return driver;
    }

    public static Properties readData() {
        Properties objProp = new Properties();
        try {
            String env = System.getProperty("env");
            File file = new File("TestSettings.properties");
            FileInputStream fileInput = null;
            fileInput = new FileInputStream(file);
            objProp.load(fileInput);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objProp;
    }

    //    public static URL getTestGridUrl() {
    //        String strAWSprojectArn = readData().getProperty("AWSprojectArn");
    //        System.out.println("eeee:" + strAWSprojectArn);
    //        DeviceFarmClient client = DeviceFarmClient.builder().region(Region.US_WEST_2).build();
    //        CreateTestGridUrlRequest request = CreateTestGridUrlRequest.builder()
    //                .expiresInSeconds(300) // 5 minutes
    //                .projectArn(strAWSprojectArn)
    //                .build();
    //        URL testGridUrl = null;
    //        try {
    //            CreateTestGridUrlResponse response = client.createTestGridUrl(request);
    //            testGridUrl = new URL(response.url());
    //        } catch (Exception e) {
    //            e.printStackTrace();
    //        }
    //        System.out.println("testGridUrl: " + testGridUrl);
    //        return testGridUrl;
    //    }
}


