package suggestion.core

import org.drools.RuleBaseFactory
import org.drools.RuleBase
import org.drools.WorkingMemory
import org.drools.compiler.DroolsError
import org.drools.compiler.PackageBuilder
import org.drools.compiler.PackageBuilderErrors
import org.drools.rule.Package
import spock.lang.Specification
import spock.lang.Ignore
import suggestion.RuleBaseInitializer

class WeatherActivityAnalyzerSpec extends Specification {
	
	WeatherActivityAnalyzer analyzer
	Suggestion fact
	
	def setup() {
		analyzer = new WeatherActivityAnalyzer()
	}
	
	def "golfing is suggested for conditions"() {
		given: "weather conducive to golfing"
		Conditions conditions = new Conditions(82, 64, 0, 4, 6, 30, 50)
		
		and: "test double stands in for Drools implementations"
		RuleBase ruleBase = new RuleBaseDouble()
		
		expect:
		analyzer.suggestActivity(ruleBase, conditions) == new Suggestion(conditions, "play golf")
	}

	def "cross country skiing is suggested for conditions"() {
		given: "weather conducive to cross country skiing"
		Conditions conditions = new Conditions(25, 20, 3, 2, 10, 30, 50)
		
		and: "test double stands in for Drools implementations"
		RuleBase ruleBase = new RuleBaseDouble()
		
		expect:
		analyzer.suggestActivity(ruleBase, conditions) == new Suggestion(conditions, "cross country ski")
	}

	def "staying indoors is suggested for conditions"() {
		given: "weather is not conducive to outdoor activity"
		Conditions conditions = new Conditions(102, 80, 6, 40, 80, 90, 100)
		
		and: "test double stands in for Drools implementations"
		RuleBase ruleBase = new RuleBaseDouble()
		
		expect:
		analyzer.suggestActivity(ruleBase, conditions) == new Suggestion(conditions, "outside activity not recommended")
	}
	
	@Ignore
	def "invoking rules engine with ideal golfing weather"() {
		given: "a rule base is initialized"
		RuleBase ruleBase = new RuleBaseInitializer().init()
		
		and: "conditions are perfect for cross country skiing"
		Conditions conditions = new Conditions(82, 64, 0, 4, 6, 30, 50)
		fact = new Suggestion(conditions, "")

		and: "rules are added to the drools working memory"
		WorkingMemory workingMemory = addFacts(ruleBase, fact)
		
		when: "the rules are fired"
		int actualNumberOfRulesFired = workingMemory.fireAllRules()
		workingMemory.dispose()
		
		then: "expect the hello world rule is fired"
		fact.conditions.high == 82
		fact.activity == "play golf"
		println "fact.activity is ${fact.activity}"
	}
	
	@Ignore
	def "invoking rules engine with ideal cross country skiiing weather"() {
		given: "a rule base is initialized"
		RuleBase ruleBase = new RuleBaseInitializer().init()
		
		and: "conditions are perfect for cross country skiing"
		Conditions conditions = new Conditions(25, 20, 3, 2, 10, 30, 50)
		fact = new Suggestion(conditions, "")

		and: "rules are added to the drools working memory"
		WorkingMemory workingMemory = addFacts(ruleBase, fact)
		
		when: "the rules are fired"
		int actualNumberOfRulesFired = workingMemory.fireAllRules()
		workingMemory.dispose()
		
		then: "expect the hello world rule is fired"
		fact.conditions.high == 25
		fact.activity == "cross country ski"
		println "fact.activity is ${fact.activity}"
	}
	
	private WorkingMemory addFacts(RuleBase ruleBase, Suggestion fact) {
		WorkingMemory workingMemory = ruleBase.newStatefulSession()
	
		workingMemory.insert(fact)
	
		return workingMemory
	}
}
