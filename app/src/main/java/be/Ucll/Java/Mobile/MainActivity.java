package be.Ucll.Java.Mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MAIN activity";
    Long startTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void handleClickBtnStart(View view) {
        //String time = ((TextView) findViewById(R.id.txtTime)).getText().toString();

        TextView lblTime = findViewById(R.id.TextTime);
       //lblTime.setText(getString(R.string.lblTime_prefix));
        findViewById(R.id.BtnStart).setEnabled(false);
        findViewById(R.id.BtnEnd).setEnabled(true);
        startTime = SystemClock.elapsedRealtime();

        Log.i(TAG, "Start has been pressed and is active");
    }

    public void handleClickBtnStop(View view) {
        TextView lblTime = findViewById(R.id.TextTime);

        findViewById(R.id.BtnStart).setEnabled(true);
        findViewById(R.id.BtnEnd).setEnabled(false);

        long duration = SystemClock.elapsedRealtime() - startTime;
        long timeSeconds = duration / 1000;
        long timeMinutes = timeSeconds / 60;
        String time = String.format("%02d", timeMinutes) + ":" + String.format("%02d", timeSeconds);

        lblTime.setText(time);

        Log.i(TAG, "Stop has been pressed");
        Log.i(TAG, "Duration: " + time);
    }
}