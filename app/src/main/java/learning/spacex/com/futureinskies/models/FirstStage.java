
package learning.spacex.com.futureinskies.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirstStage {

    private List<Core> cores = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<Core> getCores() {
        return cores;
    }

    public void setCores(List<Core> cores) {
        this.cores = cores;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
