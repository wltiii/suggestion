package suggestion.core

import com.fasterxml.jackson.annotation.JsonProperty

import groovy.transform.ToString
import groovy.transform.Canonical

@ToString
@Canonical
final class Suggestion {
    @JsonProperty
	Conditions conditions
    @JsonProperty
	String activity
	
}
