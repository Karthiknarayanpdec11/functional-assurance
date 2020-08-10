package stepdefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class CukeHooks extends MasterStepDefs {

	public static Integer passedCount;
	public static Integer failedCount;

	@Before
	public static void setUp(Scenario scenario) {
		LOG.info("Starting - " + scenario.getName());
	}

	// Use this method only for Reporting purposes and not closing driver objects
	@After
	public static void tearDown(Scenario scenario)  {
		LOG.info(scenario.getName() + " Status - " + scenario.getStatus());
		if (scenario.getStatus().toString().equalsIgnoreCase("failed")) {
			CukeHooks.failedCount += 1;
			LOG.info("######### Count of FAILED #########");
			LOG.info(String.valueOf(CukeHooks.failedCount));
			LOG.info("######### Count of Failed #########");
		} else if(scenario.getStatus().toString().equalsIgnoreCase("passed")) {
			CukeHooks.passedCount += 1;
			LOG.info("######### Count of Passed #########");
			LOG.info(String.valueOf(CukeHooks.passedCount));
			LOG.info("######### Count of passed #########");
		}
	}
}