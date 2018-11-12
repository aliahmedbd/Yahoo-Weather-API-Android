package aliahmed.info.yahooweatherapi.weather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Guid {

@SerializedName("isPermaLink")
@Expose
private String isPermaLink;

public String getIsPermaLink() {
return isPermaLink;
}

public void setIsPermaLink(String isPermaLink) {
this.isPermaLink = isPermaLink;
}

}