package tests;

import org.junit.runner.JUnitCore;

public class MyRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JUnitCore jCore = new JUnitCore();
		jCore.run(GetArticleFromFD.class);
		System.exit(0);
	}
}
