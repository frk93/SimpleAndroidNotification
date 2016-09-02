package com.example.farrukh.simplenotifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText e;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e = (EditText) findViewById(R.id.editText);
        b = (Button) findViewById(R.id.button);



        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String name = e.getText().toString();
                showNotification(name);
            }
        });

    }


    public void showNotification(String mName) {

        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext());
        builder.setContentTitle("Hello " +mName);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentText("Hurrah! We made our first Notification");
        builder.setTicker("New Notification");
        builder.setAutoCancel(true);

        Notification m = builder.build();
        NotificationManager manager = (NotificationManager) this.getSystemService(NOTIFICATION_SERVICE);
        manager.notify(1234, m);
        Toast.makeText(getApplicationContext(),"Hello "+mName,Toast.LENGTH_SHORT).show();
    }
}
