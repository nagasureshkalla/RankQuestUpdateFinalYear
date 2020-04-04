package com.example.admin.data.Homepage;

        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.widget.ImageView;

        import com.example.admin.data.R;
        import com.google.android.gms.ads.MobileAds;
        import com.google.android.gms.ads.initialization.InitializationStatus;
        import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class SplashScreen extends Activity {
    ImageView img;
    Thread splas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        img=findViewById(R.id.splash);

        MobileAds.initialize(getApplicationContext(),"ca-app-pub-7470227253711247~4089135355");

        splas = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                    Intent i = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(i);
                    finish();
                } catch (Exception e) {

                }
            }
        };

        splas.start();
    }
}
