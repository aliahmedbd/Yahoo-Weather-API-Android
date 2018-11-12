package aliahmed.info.yahooweatherapi;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import aliahmed.info.yahooweatherapi.weather.WeatherModel;
import io.nlopez.smartlocation.OnLocationUpdatedListener;
import io.nlopez.smartlocation.SmartLocation;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView txtCityName;
    TextView txtDateTime;
    TextView txtTemperature;
    TextView txtWeatherCondition;
    TextView txtWelcomeMessage;
    String locationName = "";
    String mPermission = Manifest.permission.ACCESS_FINE_LOCATION;
    ImageView imgWeatherCondition;
    private static final int PERMISSION_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setInitialization();
        getLocation();
    }

    public void setInitialization(){
        txtCityName = (TextView) findViewById(R.id.txtCityName);
        txtTemperature = (TextView) findViewById(R.id.txtTemperature);
        txtDateTime = (TextView) findViewById(R.id.txtDateTime);
        txtWeatherCondition = (TextView) findViewById(R.id.txtWeatherCondition);
        imgWeatherCondition = (ImageView) findViewById(R.id.imgWeatherCondition);
    }

    /**
     * This function will call the yahoo weather api and fetch the current condition of dhaka's weather and set these in text views
     */
    protected void callWeatherApi() {

        String query = "select*from weather.forecast where woeid in (select woeid from geo.places(1) where text=\"(" + (locationName.equals("") ? "23.777176,90.399452" : locationName) + ")\")";
        String format = "json";
        WeatherApiProvider.getApiClient().getWeatherQuery(query, format).enqueue(new Callback<WeatherModel>() {
            @Override
            public void onResponse(Call<WeatherModel> call, Response<WeatherModel> response) {
                locationName = "";
                try {
                    txtCityName.setText(response.body().getQuery().getResults().getChannel().getLocation().getCity().trim().toUpperCase());
                    txtTemperature.setText((Integer.parseInt(response.body().getQuery().getResults().getChannel().getItem().getCondition().getTemp()) - 32) * 5 / 9 + "");
                    txtWeatherCondition.setText(response.body().getQuery().getResults().getChannel().getItem().getCondition().getText() + "\nWind: " + response.body().getQuery().getResults().getChannel().getWind().getSpeed() + " mph\nHumidity: " + response.body().getQuery().getResults().getChannel().getAtmosphere().getHumidity() + "%");
                    Picasso.with(MainActivity.this).load("http://l.yimg.com/a/i/us/we/52/" + response.body().getQuery().getResults().getChannel().getItem().getCondition().getCode() + ".gif").into(imgWeatherCondition);
                } catch (NullPointerException e) {

                }
            }

            @Override
            public void onFailure(Call<WeatherModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Check permission of Location if yes then call "getLocationData()" otherwise open a dialogue to enable the Location permission.
     */
    public void getLocation() {
        if (checkPermission()) {
            getLocationData();
        } else {
            if (ActivityCompat.checkSelfPermission(this, mPermission) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{mPermission}, PERMISSION_REQUEST_CODE);
            }
        }
    }

    /**
     * @return true or false base on Location permission.
     */
    private boolean checkPermission() {
        int result = ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION);
        if (result == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }


    public void getLocationData() {
        LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            callWeatherApi();
        } else {
            SmartLocation.with(this).location()
                    .oneFix()
                    .start(new OnLocationUpdatedListener() {
                        @Override
                        public void onLocationUpdated(Location location) {
                            try {
                                locationName = location.getLatitude() + "," + location.getLongitude();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            callWeatherApi();
                        }
                    });
        }

    }

    /**
     * @param requestCode  the code of a Request
     * @param permissions  the available permissions.
     * @param grantResults The granted permissions results.
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Log.e("Req Code", "" + requestCode);
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    getLocationData();
                } else {
                    callWeatherApi();
                }
                break;
        }
    }

}
