package exemplos.banco;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "classpath:features/banco", 
		tags = "@Conta", 
		glue = "exemplos.banco.steps", 
		monochrome = true, 
		dryRun = false)
public class ContaTest {
	
}
