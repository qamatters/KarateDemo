package com.myPersonal.karate;

// This package is for the java files used in the project

import com.intuit.karate.junit4.Karate;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Karate.class)
@CucumberOptions(features = {"classpath:smoke" },

 tags = {"@Smoke"})

public class TestRunner_Smoke {


}
