package suggestion.core

import groovy.transform.Immutable
import groovy.transform.ToString

import org.joda.time.DateTime

import com.fasterxml.jackson.annotation.*

@ToString
@Immutable
final class Conditions {
	
	Integer high
	Integer low
	Integer precipitation
	Integer wind
	Integer maxWind
	Integer humidity
	Integer maxHumidity

}
