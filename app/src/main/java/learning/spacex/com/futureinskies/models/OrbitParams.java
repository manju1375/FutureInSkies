
package learning.spacex.com.futureinskies.models;

import java.util.HashMap;
import java.util.Map;

public class OrbitParams {

    private String referenceSystem;
    private String regime;
    private Integer longitude;
    private Double semiMajorAxisKm;
    private Double eccentricity;
    private Double periapsisKm;
    private Double apoapsisKm;
    private Double inclinationDeg;
    private Double periodMin;
    private Integer lifespanYears;
    private String epoch;
    private Double meanMotion;
    private Double raan;
    private Double argOfPericenter;
    private Double meanAnomaly;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getReferenceSystem() {
        return referenceSystem;
    }

    public void setReferenceSystem(String referenceSystem) {
        this.referenceSystem = referenceSystem;
    }

    public String getRegime() {
        return regime;
    }

    public void setRegime(String regime) {
        this.regime = regime;
    }

    public Integer getLongitude() {
        return longitude;
    }

    public void setLongitude(Integer longitude) {
        this.longitude = longitude;
    }

    public Double getSemiMajorAxisKm() {
        return semiMajorAxisKm;
    }

    public void setSemiMajorAxisKm(Double semiMajorAxisKm) {
        this.semiMajorAxisKm = semiMajorAxisKm;
    }

    public Double getEccentricity() {
        return eccentricity;
    }

    public void setEccentricity(Double eccentricity) {
        this.eccentricity = eccentricity;
    }

    public Double getPeriapsisKm() {
        return periapsisKm;
    }

    public void setPeriapsisKm(Double periapsisKm) {
        this.periapsisKm = periapsisKm;
    }

    public Double getApoapsisKm() {
        return apoapsisKm;
    }

    public void setApoapsisKm(Double apoapsisKm) {
        this.apoapsisKm = apoapsisKm;
    }

    public Double getInclinationDeg() {
        return inclinationDeg;
    }

    public void setInclinationDeg(Double inclinationDeg) {
        this.inclinationDeg = inclinationDeg;
    }

    public Double getPeriodMin() {
        return periodMin;
    }

    public void setPeriodMin(Double periodMin) {
        this.periodMin = periodMin;
    }

    public Integer getLifespanYears() {
        return lifespanYears;
    }

    public void setLifespanYears(Integer lifespanYears) {
        this.lifespanYears = lifespanYears;
    }

    public String getEpoch() {
        return epoch;
    }

    public void setEpoch(String epoch) {
        this.epoch = epoch;
    }

    public Double getMeanMotion() {
        return meanMotion;
    }

    public void setMeanMotion(Double meanMotion) {
        this.meanMotion = meanMotion;
    }

    public Double getRaan() {
        return raan;
    }

    public void setRaan(Double raan) {
        this.raan = raan;
    }

    public Double getArgOfPericenter() {
        return argOfPericenter;
    }

    public void setArgOfPericenter(Double argOfPericenter) {
        this.argOfPericenter = argOfPericenter;
    }

    public Double getMeanAnomaly() {
        return meanAnomaly;
    }

    public void setMeanAnomaly(Double meanAnomaly) {
        this.meanAnomaly = meanAnomaly;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
