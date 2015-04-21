package suggestion

import suggestion.resources.SuggestionResource;
import io.dropwizard.Application
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment
import suggestion.health.TemplateHealthCheck

public class SuggestionApplication extends Application<SuggestionConfiguration> {
    public static void main(String[] args) throws Exception {
        new SuggestionApplication().run(args)
    }

    @Override
    public String getName() {
        return "suggestion"
    }

    @Override
    public void initialize(Bootstrap<SuggestionConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(SuggestionConfiguration configuration,
                    Environment environment) {
					
	    final SuggestionResource resource = new SuggestionResource(
	        new RuleBaseInitializer().init(configuration.defaultRules)
	    )
	    final TemplateHealthCheck healthCheck =
	        new TemplateHealthCheck(configuration.defaultRules)
			
	    environment.healthChecks().register("template", healthCheck)
	    environment.jersey().register(resource)
    }

}