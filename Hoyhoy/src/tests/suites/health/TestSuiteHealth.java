package tests.suites.health;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import tests.health.ConnectTheDotsLandingPageTest;
import tests.health.FieldValidationLandingPageTest;


/**
 * This is a test suite class that will run all the health tests
 * @author Erwin
 */
@RunWith(Suite.class)
@SuiteClasses({FieldValidationLandingPageTest.class,ConnectTheDotsLandingPageTest.class})
public class TestSuiteHealth {

	public TestSuiteHealth() {
		// TODO Auto-generated constructor stub
	}

}
