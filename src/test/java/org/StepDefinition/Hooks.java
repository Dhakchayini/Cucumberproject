package org.StepDefinition;

import org.baseclass.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseClass {

	@Before

	public void beforeRun() {

		browserlaunch();

	}

	@After

	public void afterExecute() {

		driver.close();
		
	}

}
