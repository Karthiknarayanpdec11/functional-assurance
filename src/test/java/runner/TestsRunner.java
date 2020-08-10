package runner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import stepdefinitions.CukeHooks;


@RunWith(Cucumber.class)
@CucumberOptions(strict = true, monochrome = true,
        features = "src/test/resources/features/",
        tags = "@UITest and @Smoke",
        glue = {"stepdefinitions"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class TestsRunner {

    private TestsRunner() {

    }

    protected static final Logger LOG = LoggerFactory.getLogger(TestsRunner.class);
    protected static Integer passedCount;
    protected static Integer failedCount;
    //protected static String finalOutput = "{\"moduleName\":regressiontest_ui/regressiontest_api/regressiontest_rwd_ui,\"pass\":passCount,\"fail\":failCount,\"status\":In Progress/Pass/Fail};";

    @BeforeClass
    public static void beforeClass() {
        LOG.info("########### INSIDE BEFORE CLASS ###########");
        CukeHooks.passedCount = 0;
        CukeHooks.failedCount = 0;
        String status = "PASS";
    }


    @AfterClass
    public static void afterSuite() {
        LOG.info("########### INSIDE AFTER CLASS ###########");
        String status = "PASS";
        if (CukeHooks.failedCount > 0) {
            status = "FAIL";
        }
    }
}
