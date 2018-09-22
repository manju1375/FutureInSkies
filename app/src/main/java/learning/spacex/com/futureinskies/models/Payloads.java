
package learning.spacex.com.futureinskies.models;

import java.util.HashMap;
import java.util.Map;

public class Payloads {

    private String option1;
    private CompositeFairing compositeFairing;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public CompositeFairing getCompositeFairing() {
        return compositeFairing;
    }

    public void setCompositeFairing(CompositeFairing compositeFairing) {
        this.compositeFairing = compositeFairing;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
