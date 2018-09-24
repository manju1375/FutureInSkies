
package learning.spacex.com.futureinskies.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LandingLegs {

    @SerializedName("number")
    @Expose
    private Integer number;
    @SerializedName("material")
    @Expose
    private Object material;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Object getMaterial() {
        return material;
    }

    public void setMaterial(Object material) {
        this.material = material;
    }

}
