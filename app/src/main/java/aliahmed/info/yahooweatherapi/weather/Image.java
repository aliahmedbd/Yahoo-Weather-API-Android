package aliahmed.info.yahooweatherapi.weather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Image {

@SerializedName("title")
@Expose
private String title;
@SerializedName("width")
@Expose
private String width;
@SerializedName("height")
@Expose
private String height;
@SerializedName("link")
@Expose
private String link;
@SerializedName("url")
@Expose
private String url;

public String getTitle() {
return title;
}

public void setTitle(String title) {
this.title = title;
}

public String getWidth() {
return width;
}

public void setWidth(String width) {
this.width = width;
}

public String getHeight() {
return height;
}

public void setHeight(String height) {
this.height = height;
}

public String getLink() {
return link;
}

public void setLink(String link) {
this.link = link;
}

public String getUrl() {
return url;
}

public void setUrl(String url) {
this.url = url;
}

}