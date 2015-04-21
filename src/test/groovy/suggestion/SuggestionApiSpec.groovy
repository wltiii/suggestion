package suggestion

import org.drools.RuleBase
import suggestion.core.RuleBaseDouble
import suggestion.core.Suggestion
import specification.ResourceSpec
import spock.lang.Specification
import spock.lang.Shared
import suggestion.resources.SuggestionResource;

class SuggestionApiSpec extends ResourceSpec {
	
	@Override
	void setUpResources() {
		RuleBase ruleBase = new RuleBaseDouble()
		jersey.addResource(new SuggestionResource(ruleBase))
	}
	
	def 'GET request returns suggestion for conditions'() {
		when:
		def result = jersey.client().resource('/suggestions/82/64/0/4/6/30/50').get(Suggestion) 
		
		then:
		result.conditions.high == 82
		result.activity == "play golf"
	}

}
