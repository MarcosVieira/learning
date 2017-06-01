package exemplos.testes;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "classpath:features/testes", 
		tags = "@Testes",
		glue = "exemplos.testes.steps", 
		monochrome = true, 
		dryRun = false)
public class Testes {
	
}
