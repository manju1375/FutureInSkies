
package learning.spacex.com.futureinskies.models;

import java.util.HashMap;
import java.util.Map;

public class CompositeFairing {

    private Height_ height;
    private Diameter_ diameter;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Height_ getHeight() {
        return height;
    }

    public void setHeight(Height_ height) {
        this.height = height;
    }

    public Diameter_ getDiameter() {
        return diameter;
    }

    public void setDiameter(Diameter_ diameter) {
        this.diameter = diameter;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
