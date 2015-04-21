package suggestion.core

import org.drools.RuleBase;
import org.drools.WorkingMemory;

class WeatherActivityAnalyzer {
	
	Suggestion suggestActivity(RuleBase ruleBase, Conditions conditions) {
		Suggestion fact = new Suggestion(conditions, "outside activity not recommended")
		
		WorkingMemory workingMemory = addFacts(ruleBase, fact)

		workingMemory.fireAllRules()
		workingMemory.dispose()
		
		fact
	}

	private WorkingMemory addFacts(RuleBase ruleBase, Suggestion fact) {
		WorkingMemory workingMemory = ruleBase.newStatefulSession()
	
		workingMemory.insert(fact)
	
		workingMemory
	}
}
