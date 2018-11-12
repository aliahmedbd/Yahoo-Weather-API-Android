package aliahmed.info.yahooweatherapi.weather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Condition {

@SerializedName("code")
@Expose
private String code;
@SerializedName("date")
@Expose
private String date;
@SerializedName("temp")
@Expose
private String temp;
@SerializedName("text")
@Expose
private String text;

public String getCode() {
return code;
}

public void setCode(String code) {
this.code = code;
}

public String getDate() {
return date;
}

public void setDate(String date) {
this.date = date;
}

public String getTemp() {
return temp;
}

public void setTemp(String temp) {
this.temp = temp;
}

public String getText() {
return text;
}

public void setText(String text) {
this.text = text;
}

}