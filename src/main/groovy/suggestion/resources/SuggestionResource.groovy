package suggestion.resources

import org.drools.RuleBase

import suggestion.RuleBaseInitializer
import suggestion.core.Conditions
import suggestion.core.Suggestion
import suggestion.core.WeatherActivityAnalyzer

import com.codahale.metrics.annotation.Timed

import groovy.transform.EqualsAndHashCode;
import groovy.transform.ToString;

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.PathParam
import javax.ws.rs.core.MediaType

import java.util.concurrent.atomic.AtomicLong

@Path("/suggestions")
@Produces(MediaType.APPLICATION_JSON)
public class SuggestionResource {
	private final RuleBase ruleBase
	private final WeatherActivityAnalyzer weatherActivityAnalyzer

    public SuggestionResource(RuleBase ruleBase) {
        this(ruleBase, new WeatherActivityAnalyzer())
    }

    public SuggestionResource(RuleBase ruleBase, WeatherActivityAnalyzer weatherActivityAnalyzer) {
        this.ruleBase = ruleBase
		this.weatherActivityAnalyzer = weatherActivityAnalyzer
    }

    @GET
    @Timed
	@Path("{high}/{low}/{precip}/{wind}/{maxwind}/{humidity}/{maxhumidity}")
    public Suggestion suggestActivity(@PathParam("high") Integer high, 
		                               @PathParam("low") Integer low, 
		                               @PathParam("precip") Integer precipitation, 
		                               @PathParam("wind") Integer wind, 
		                               @PathParam("maxwind") Integer maxWind, 
		                               @PathParam("humidity") Integer humidity, 
		                               @PathParam("maxhumidity") Integer maxHumidity) {

	    final Conditions conditions = new Conditions(high,
			                                   low,
											   precipitation,
											   wind,
											   maxWind,
											   humidity,
											   maxHumidity)									  
	
        weatherActivityAnalyzer.suggestActivity(ruleBase, conditions)
    }
}
