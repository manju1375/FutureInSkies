
package learning.spacex.com.futureinskies.models;

import java.util.HashMap;
import java.util.Map;

public class Telemetry {

    private String flightClub;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getFlightClub() {
        return flightClub;
    }

    public void setFlightClub(String flightClub) {
        this.flightClub = flightClub;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
