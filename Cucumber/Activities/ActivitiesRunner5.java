package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "features",
    glue = {"stepdefinitions"},
    tags = "@activity5",
    strict = true
)

public class ActivitiesRunner5 {
    //empty
}