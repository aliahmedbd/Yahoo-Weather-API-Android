package aliahmed.info.yahooweatherapi;



import aliahmed.info.yahooweatherapi.weather.WeatherModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Endpoints of Weather service API.
 */
public interface WeatherService {
    @Headers("Content-Type: application/json")
    @GET("/v1/public/yql?q=select * from weather.forecast where woeid in (select woeid from geo.places(1) where text=\"pabna, ati\")&format=json")
    Call<WeatherModel> getWeather(@Query("q") String q);


    @Headers("Content-Type: application/json")
    @GET("/v1/public/yql")
    Call<WeatherModel> getWeatherQuery(@Query("q") String q, @Query("format") String format);

}