package suggestion

import org.drools.RuleBase
import spock.lang.Specification
import suggestion.core.RuleBaseDouble
import suggestion.health.TemplateHealthCheck
import suggestion.resources.SuggestionResource
import io.dropwizard.jersey.setup.JerseyEnvironment
import io.dropwizard.setup.Environment
import com.codahale.metrics.health.HealthCheckRegistry

class SuggestionApplicationSpec extends Specification {
	
	def "validate run registers the resource"() {
		
		given: "environment has mock jersey and health check implementations"
		def mockJerseyEnvironment = Mock(JerseyEnvironment)
		def mockHealthCheckRegistry = Mock(HealthCheckRegistry)
		def mockEnvironment = Mock(Environment)
		mockEnvironment.healthChecks() >> mockHealthCheckRegistry
		mockEnvironment.jersey() >> mockJerseyEnvironment
		
		and: "a configuration for portland OR"
		SuggestionConfiguration configuration = new SuggestionConfiguration(defaultRules: '/suggestion/rules/defaultRules.drl')
		
		and: "a health check expected to be registered"
		TemplateHealthCheck expectedHealthCheck = new TemplateHealthCheck('/suggestion/rules/defaultRules.drl')
		
		when: "run is called"
		new SuggestionApplication().run(configuration, mockEnvironment)
		
		then: "expect resource and health check to be registered"
		1 * mockJerseyEnvironment.register(_ as SuggestionResource)
		1 * mockHealthCheckRegistry.register("template", expectedHealthCheck)
	}

}
