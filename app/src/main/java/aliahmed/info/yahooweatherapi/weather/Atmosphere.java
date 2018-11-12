package aliahmed.info.yahooweatherapi.weather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Atmosphere {

@SerializedName("humidity")
@Expose
private String humidity;
@SerializedName("pressure")
@Expose
private String pressure;
@SerializedName("rising")
@Expose
private String rising;
@SerializedName("visibility")
@Expose
private String visibility;

public String getHumidity() {
return humidity;
}

public void setHumidity(String humidity) {
this.humidity = humidity;
}

public String getPressure() {
return pressure;
}

public void setPressure(String pressure) {
this.pressure = pressure;
}

public String getRising() {
return rising;
}

public void setRising(String rising) {
this.rising = rising;
}

public String getVisibility() {
return visibility;
}

public void setVisibility(String visibility) {
this.visibility = visibility;
}

}