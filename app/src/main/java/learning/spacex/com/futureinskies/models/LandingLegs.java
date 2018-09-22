
package learning.spacex.com.futureinskies.models;

import java.util.HashMap;
import java.util.Map;

public class LandingLegs {

    private Integer number;
    private Object material;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Object getMaterial() {
        return material;
    }

    public void setMaterial(Object material) {
        this.material = material;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
