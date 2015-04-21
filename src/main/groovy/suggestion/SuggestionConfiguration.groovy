package suggestion

import java.util.List;

import groovy.transform.EqualsAndHashCode;
import groovy.transform.Immutable;
import groovy.transform.ToString;
import io.dropwizard.Configuration

import com.fasterxml.jackson.annotation.JsonProperty

import org.hibernate.validator.constraints.NotEmpty

@Immutable
@EqualsAndHashCode
@ToString
public class SuggestionConfiguration extends Configuration {
    @NotEmpty
    @JsonProperty
    private String defaultRules = '/suggestion/rules/defaultRules.drl'
}