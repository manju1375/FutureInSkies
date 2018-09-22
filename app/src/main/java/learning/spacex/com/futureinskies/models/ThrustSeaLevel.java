
package learning.spacex.com.futureinskies.models;

import java.util.HashMap;
import java.util.Map;

public class ThrustSeaLevel {

    private Integer kN;
    private Integer lbf;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getKN() {
        return kN;
    }

    public void setKN(Integer kN) {
        this.kN = kN;
    }

    public Integer getLbf() {
        return lbf;
    }

    public void setLbf(Integer lbf) {
        this.lbf = lbf;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
