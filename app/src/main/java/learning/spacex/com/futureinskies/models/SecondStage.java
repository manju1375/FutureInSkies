
package learning.spacex.com.futureinskies.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SecondStage {

    private Integer block;
    private List<Payload> payloads = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getBlock() {
        return block;
    }

    public void setBlock(Integer block) {
        this.block = block;
    }

    public List<Payload> getPayloads() {
        return payloads;
    }

    public void setPayloads(List<Payload> payloads) {
        this.payloads = payloads;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
