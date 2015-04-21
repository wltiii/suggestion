package suggestion

import java.io.Reader;

import org.drools.RuleBase;
import org.drools.RuleBaseFactory
import org.drools.compiler.PackageBuilder;
import org.drools.compiler.DroolsError
import org.drools.compiler.PackageBuilder
import org.drools.compiler.PackageBuilderErrors
import org.drools.rule.Package

class RuleBaseInitializer {
	RuleBase init(final String ruleFile) {
		Reader reader = getRuleFileAsReader(ruleFile)
		PackageBuilder packageBuilder = readRuleFiles(reader)
		addRules(packageBuilder)
	}
	
	private Reader getRuleFileAsReader(String ruleFile) {
		InputStream resourceAsStream = getClass().getResourceAsStream(ruleFile)

		new InputStreamReader(resourceAsStream)
	}

	private PackageBuilder readRuleFiles(final Reader reader) {
	
		PackageBuilder packageBuilder = new PackageBuilder()
		packageBuilder.addPackageFromDrl(reader)
	
		assertNoRuleErrors(packageBuilder)
	
		packageBuilder
	}
	
	private RuleBase addRules(PackageBuilder packageBuilder) {
		RuleBase ruleBase = RuleBaseFactory.newRuleBase()
		Package rulesPackage = packageBuilder.getPackage()
		ruleBase.addPackage(rulesPackage)

		ruleBase
	}
	
	private void assertNoRuleErrors(PackageBuilder packageBuilder) {
		PackageBuilderErrors errors = packageBuilder.getErrors()

		if (errors.getErrors().length > 0) {
			StringBuilder errorMessages = new StringBuilder()
			errorMessages.append("Found errors in package builder\n")
			for (DroolsError errorMessage in errors.getErrors()) {
				errorMessages.append(errorMessage)
				errorMessages.append("\n")
			}
			errorMessages.append("Could not parse knowledge")

			throw new IllegalArgumentException(errorMessages.toString())
		}
	}


}
