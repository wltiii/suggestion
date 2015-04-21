package suggestion;

import spock.lang.Specification
import org.drools.RuleBase;

class RuleBaseInitializerSpec extends Specification {
	
	def "loads property file"() {
		given:
		RuleBase ruleBase = new RuleBaseInitializer().init('/suggestion/rules/defaultRules.drl')
		
		expect:
		ruleBase.getPackages().length == 1
	}

}
