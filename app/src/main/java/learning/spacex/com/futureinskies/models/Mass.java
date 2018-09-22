
package learning.spacex.com.futureinskies.models;

import java.util.HashMap;
import java.util.Map;

public class Mass {

    private Integer kg;
    private Integer lb;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getKg() {
        return kg;
    }

    public void setKg(Integer kg) {
        this.kg = kg;
    }

    public Integer getLb() {
        return lb;
    }

    public void setLb(Integer lb) {
        this.lb = lb;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
