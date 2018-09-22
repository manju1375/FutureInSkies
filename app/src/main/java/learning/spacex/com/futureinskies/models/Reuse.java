
package learning.spacex.com.futureinskies.models;

import java.util.HashMap;
import java.util.Map;

public class Reuse {

    private Boolean core;
    private Boolean sideCore1;
    private Boolean sideCore2;
    private Boolean fairings;
    private Boolean capsule;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Boolean getCore() {
        return core;
    }

    public void setCore(Boolean core) {
        this.core = core;
    }

    public Boolean getSideCore1() {
        return sideCore1;
    }

    public void setSideCore1(Boolean sideCore1) {
        this.sideCore1 = sideCore1;
    }

    public Boolean getSideCore2() {
        return sideCore2;
    }

    public void setSideCore2(Boolean sideCore2) {
        this.sideCore2 = sideCore2;
    }

    public Boolean getFairings() {
        return fairings;
    }

    public void setFairings(Boolean fairings) {
        this.fairings = fairings;
    }

    public Boolean getCapsule() {
        return capsule;
    }

    public void setCapsule(Boolean capsule) {
        this.capsule = capsule;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
