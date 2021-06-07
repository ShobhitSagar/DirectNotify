package com.example.shobhitsagar.directnotify;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.RemoteInput;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RemoteViews;

public class MainActivity extends AppCompatActivity {

    private Button notificatinbtn;
    private static String REMOTE_INPUT_KEY = "remote_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notificatinbtn = (Button) findViewById(R.id.notificatinbtn);
    }

private void sendNotification() {
    RemoteInput remoteInput = new RemoteInput.Builder(REMOTE_INPUT_KEY)
            .setLabel("Reply")
            .build();

    Intent intent = new Intent(this, MainActivity.class);
    PendingIntent pendingIntent = PendingIntent.getActivities(this, 0, new Intent[]{intent}, PendingIntent.FLAG_UPDATE_CURRENT);
    Notification.Action actionNotification = new Notification.Action.Builder(
            R.drawable.download,
            "Reply", pendingIntent)
            .addRemoteInput(remoteInput)
            .build();
}

}
