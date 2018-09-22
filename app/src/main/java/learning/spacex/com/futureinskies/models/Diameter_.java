
package learning.spacex.com.futureinskies.models;

import java.util.HashMap;
import java.util.Map;

public class Diameter_ {

    private Double meters;
    private Double feet;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Double getMeters() {
        return meters;
    }

    public void setMeters(Double meters) {
        this.meters = meters;
    }

    public Double getFeet() {
        return feet;
    }

    public void setFeet(Double feet) {
        this.feet = feet;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
