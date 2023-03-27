package com.fleetGru.StepDefinitions;

import com.fleetGru.Utilities.*;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {



        @After
        public void teardownScenario(Scenario scenario) throws InterruptedException {

            if (scenario.isFailed()){

                byte [] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", scenario.getName());

            }


            //BrowserUtils.sleep(5);

            BrowserUtils.sleep(5);

            //Thread.sleep(5000);
           // Driver.closeDriver();

        }
}
