
package learning.spacex.com.futureinskies.models;

import java.util.HashMap;
import java.util.Map;

public class Engines {

    private Integer number;
    private String type;
    private String version;
    private String layout;
    private Integer engineLossMax;
    private String propellant1;
    private String propellant2;
    private ThrustSeaLevel_ thrustSeaLevel;
    private ThrustVacuum_ thrustVacuum;
    private Integer thrustToWeight;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public Integer getEngineLossMax() {
        return engineLossMax;
    }

    public void setEngineLossMax(Integer engineLossMax) {
        this.engineLossMax = engineLossMax;
    }

    public String getPropellant1() {
        return propellant1;
    }

    public void setPropellant1(String propellant1) {
        this.propellant1 = propellant1;
    }

    public String getPropellant2() {
        return propellant2;
    }

    public void setPropellant2(String propellant2) {
        this.propellant2 = propellant2;
    }

    public ThrustSeaLevel_ getThrustSeaLevel() {
        return thrustSeaLevel;
    }

    public void setThrustSeaLevel(ThrustSeaLevel_ thrustSeaLevel) {
        this.thrustSeaLevel = thrustSeaLevel;
    }

    public ThrustVacuum_ getThrustVacuum() {
        return thrustVacuum;
    }

    public void setThrustVacuum(ThrustVacuum_ thrustVacuum) {
        this.thrustVacuum = thrustVacuum;
    }

    public Integer getThrustToWeight() {
        return thrustToWeight;
    }

    public void setThrustToWeight(Integer thrustToWeight) {
        this.thrustToWeight = thrustToWeight;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
