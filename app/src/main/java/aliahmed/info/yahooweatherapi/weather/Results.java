package aliahmed.info.yahooweatherapi.weather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Results {

@SerializedName("channel")
@Expose
private Channel channel;

public Channel getChannel() {
return channel;
}

public void setChannel(Channel channel) {
this.channel = channel;
}

}