package com.cse110.lab6.service_test;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class DemoService extends IntentService {
    public DemoService() {
        super("worker");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null)
        {
            synchronized (this) {
                try
                {

                    wait(15000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                stopService(intent);
            }
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(DemoService.this, "Service started", Toast.LENGTH_SHORT).show();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Toast.makeText(DemoService.this, "Service stopped", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
}
