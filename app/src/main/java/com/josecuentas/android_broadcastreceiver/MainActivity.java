package com.josecuentas.android_broadcastreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mTviMessage;
    private NotificationViewReceiver mNotificationViewReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTviMessage = (TextView) findViewById(R.id.tviMessage);



        mNotificationViewReceiver = new NotificationViewReceiver() {
            @Override protected void showMessage(String message) {
                mTviMessage.setText(message);
            }
        };


        //suscripcion
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(NotificationViewReceiver.ACTION_SHOW_MESSAGE);
        registerReceiver(mNotificationViewReceiver, intentFilter);


        findViewById(R.id.butMessage).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                Intent intent = new Intent(NotificationViewReceiver.ACTION_SHOW_MESSAGE);
                intent.putExtra(NotificationViewReceiver.BUNDLE_MESSAGE, "Este es un mensage");
                //envio notifiacion al broadcast
                sendBroadcast(intent);
            }
        });


    }

    @Override protected void onPause() {
        super.onPause();
        //des-suscripcion
        unregisterReceiver(mNotificationViewReceiver);
    }
}
