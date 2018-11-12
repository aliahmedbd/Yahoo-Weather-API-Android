package aliahmed.info.yahooweatherapi.weather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Location {

@SerializedName("city")
@Expose
private String city;
@SerializedName("country")
@Expose
private String country;
@SerializedName("region")
@Expose
private String region;

public String getCity() {
return city;
}

public void setCity(String city) {
this.city = city;
}

public String getCountry() {
return country;
}

public void setCountry(String country) {
this.country = country;
}

public String getRegion() {
return region;
}

public void setRegion(String region) {
this.region = region;
}

}