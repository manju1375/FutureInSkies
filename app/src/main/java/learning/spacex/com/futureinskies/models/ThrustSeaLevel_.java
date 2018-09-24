
package learning.spacex.com.futureinskies.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ThrustSeaLevel_ {

    @SerializedName("kN")
    @Expose
    private Integer kN;
    @SerializedName("lbf")
    @Expose
    private Integer lbf;

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

}
