package aliahmed.info.yahooweatherapi;

import android.app.Application;
import android.content.ContextWrapper;

import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;

public class AppController extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Picasso.Builder builder = new Picasso.Builder(this);
        builder.downloader(new OkHttpDownloader(this, Integer.MAX_VALUE));
        Picasso built = builder.build();
        built.setIndicatorsEnabled(false);
        built.setLoggingEnabled(true);
        Picasso.setSingletonInstance(built);


    }


}
