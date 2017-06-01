package exemplos.loja;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "classpath:features/loja", 
		tags = "@Produto", 
		glue = "exemplos.loja.steps", 
		monochrome = true, 
		dryRun = false)
public class ProdutoTest {
	
}
