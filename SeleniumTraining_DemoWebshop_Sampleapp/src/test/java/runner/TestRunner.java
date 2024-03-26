package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@CucumberOptions(
    features = { "src/test/Demo_WebShop"},
    glue={"step_definition",
    "hooks"},
    plugin = {"pretty",
        "json:target/reports/cucumber.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
    },
        monochrome = true,
        snippets = SnippetType.CAMELCASE,
        publish = true,
        tags = "@ExecuteTest"
)

@RunWith(Cucumber.class)
public class TestRunner {
}
