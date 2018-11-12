package aliahmed.info.yahooweatherapi;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Name : Ali Ahmed
 * Email: aliahmedaiub@gmail.com
 * on 2/23/2017.
 */

public class WeatherApiProvider {
    private static WeatherService apiInterface;
    private static String BASE_URL = "https://query.yahooapis.com";

    /**
     * Initializes the Weather API service where service is used RETROFIT LIBRARY.
     *
     * @return WeatherService
     */
    public static WeatherService getApiClient() {
        if (apiInterface == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(60, TimeUnit.SECONDS)
                    .build();

            Retrofit retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            apiInterface = retrofit.create(WeatherService.class);
        }
        return apiInterface;
    }
}
