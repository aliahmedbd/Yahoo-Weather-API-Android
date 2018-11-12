package aliahmed.info.yahooweatherapi.weather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Astronomy {

@SerializedName("sunrise")
@Expose
private String sunrise;
@SerializedName("sunset")
@Expose
private String sunset;

public String getSunrise() {
return sunrise;
}

public void setSunrise(String sunrise) {
this.sunrise = sunrise;
}

public String getSunset() {
return sunset;
}

public void setSunset(String sunset) {
this.sunset = sunset;
}

}