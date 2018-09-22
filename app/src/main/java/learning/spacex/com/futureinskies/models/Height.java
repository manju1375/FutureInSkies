
package learning.spacex.com.futureinskies.models;

import java.util.HashMap;
import java.util.Map;

public class Height {

    private Double meters;
    private Integer feet;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Double getMeters() {
        return meters;
    }

    public void setMeters(Double meters) {
        this.meters = meters;
    }

    public Integer getFeet() {
        return feet;
    }

    public void setFeet(Integer feet) {
        this.feet = feet;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
