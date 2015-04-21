package suggestion.resources

import org.drools.RuleBase
import suggestion.core.Conditions
import suggestion.core.RuleBaseDouble
import suggestion.core.Suggestion
import spock.lang.Specification
import suggestion.resources.SuggestionResource;

class SuggestionResourceSpec extends Specification {
	
	SuggestionResource suggestionResource
	
	def setup() {
		RuleBase ruleBase = new RuleBaseDouble()
		suggestionResource = new SuggestionResource(ruleBase)
	}
	
	def 'suggestActivity returns suggestion for default city'() {
		given:
		Conditions conditions = new Conditions(82, 64, 0, 4, 6, 30, 50)
		
		when:
		def suggestedActivities = suggestionResource.suggestActivity(82, 64, 0, 4, 6, 30, 50)
		
		then:
		suggestedActivities.conditions == conditions
		suggestedActivities.activity == "play golf"
	}
}
