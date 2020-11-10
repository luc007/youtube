import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions (
	features="src/test/resources/features",
	glue={"classpath:stepdefs"}
)

public class RunTestNGTest extends AbstractTestNGCucumberTests {
}

