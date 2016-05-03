package tests;

import org.junit.runner.JUnitCore;

public class MyRunner {

	/**
	 * This class is needed for the executable jar
	 * For normal testing you can just execute the individual tests
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JUnitCore jCore = new JUnitCore();
		jCore.run(TestProfiles.class);
		System.exit(0);
	}
}
