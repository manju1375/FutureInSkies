
package learning.spacex.com.futureinskies.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Diameter_ {

    @SerializedName("meters")
    @Expose
    private Double meters;
    @SerializedName("feet")
    @Expose
    private Double feet;

    public Double getMeters() {
        return meters;
    }

    public void setMeters(Double meters) {
        this.meters = meters;
    }

    public Double getFeet() {
        return feet;
    }

    public void setFeet(Double feet) {
        this.feet = feet;
    }

}
