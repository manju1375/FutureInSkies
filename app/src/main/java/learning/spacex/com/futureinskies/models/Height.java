
package learning.spacex.com.futureinskies.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Height {

    @SerializedName("meters")
    @Expose
    private Double meters;
    @SerializedName("feet")
    @Expose
    private Integer feet;

    public Double getMeters() {
        return meters;
    }

    public void setMeters(Double meters) {
        this.meters = meters;
    }

    public Integer getFeet() {
        return feet;
    }

    public void setFeet(Integer feet) {
        this.feet = feet;
    }

}
