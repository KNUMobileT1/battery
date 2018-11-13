package com.example.user.battery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView mStatus;
    Switch swc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swc = (Switch) findViewById(R.id.switch1);

        swc.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String str = String.valueOf(isChecked);
                // Toast.makeText(getApplicationContext(),"체크상태 = "+isChecked,Toast.LENGTH_SHORT);

                if (isChecked) {
                    Toast.makeText(getApplicationContext(), "on", Toast.LENGTH_SHORT).show();
                    Log.d("test", "on");
                    Intent intent = new Intent(
                            getApplicationContext(),//현재제어권자
                            BatteryService.class); // 이동할 컴포넌트
                    startService(intent); // 서비스 시작


                } else {
                    Toast.makeText(getApplicationContext(), "off", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(
                            getApplicationContext(),//현재제어권자
                            BatteryService.class); // 이동할 컴포넌트
                    stopService(intent); // 서비스 종료
                }
            }
        });

    }

}
