package com.fleetGru.Runners;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin =
                {       "json:target/cucumber.json",
                        "html:target/cucumber/report.html",
                        "junit:target/junit/junit-report.xml",
                        "rerun:target/rerun.txt",





                },


        features ="src/test/resources/features",
        glue     ="com/fleetGru/StepDefinitions",


    


        dryRun = false,
        tags = "@FLEET10-1092"



)

public class CukesRunner {
}