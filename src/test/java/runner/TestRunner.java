package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
//        monochrome = true,
        dryRun = false,
        features ="classpath:features",
        glue={"steps","cucumberhooks"},
        tags = "@test",
        plugin = {"pretty",
                "html:target/report/cucumber.html",
                "json:target/report/cucumber.json",
                "usage:target/report/cucumber-usage.json",
                "junit:target/report/cucumberjunit.xml",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
