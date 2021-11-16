package com.practice.utils;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class testBase {

	@BeforeClass
	public void setUp() {
		Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Driver.getDriver().manage().window().maximize();
		Driver.getDriver().get(ConfigurationReader.getProperty("url"));
	}

	@AfterTest
	public void tearDown() {

		Driver.closeDriver();
	}

}
