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
//    "json:target/reports/cucumber.json",
//    "html.target/reports/report-hml"
    },
        monochrome = true,
        snippets = SnippetType.CAMELCASE,
        strict = true,

        tags = "@Developing"
)

@RunWith(Cucumber.class)
public class TestRunner {
}
