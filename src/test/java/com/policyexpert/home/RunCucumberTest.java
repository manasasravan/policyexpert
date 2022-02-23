package com.policyexpert.home;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty", "summary"},
		glue = "classpath:com/policyexpert/home",
		features = "src/test/resources/features",
		tags = "@all"
)
public class RunCucumberTest {
}
