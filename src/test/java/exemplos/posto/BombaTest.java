package exemplos.posto;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "classpath:features/posto", 
		tags = "@Bomba", 
		glue = "exemplos.posto.steps", 
		monochrome = true, 
		dryRun = false)
public class BombaTest {
	
}
