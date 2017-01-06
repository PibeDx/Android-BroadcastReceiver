package com.josecuentas.android_broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by jcuentas on 5/01/17.
 */

public abstract class NotificationViewReceiver extends BroadcastReceiver{

    public static final String ACTION_SHOW_MESSAGE = "com.josecuentas.android_broadcastreceiver.show_message";
    public static final String BUNDLE_MESSAGE = "com.josecuentas.android_broadcastreceiver.message";


    @Override public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        switch (action) {
            case ACTION_SHOW_MESSAGE:
                String message = intent.getStringExtra(BUNDLE_MESSAGE);
                showMessage(message);
                break;
        }


    }

    protected abstract void showMessage(String message);
}
