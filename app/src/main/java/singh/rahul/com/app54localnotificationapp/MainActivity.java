package singh.rahul.com.app54localnotificationapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText edtContentTitle;
    EditText edtContentText;
    Button btnNotify;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

edtContentTitle = (EditText) findViewById(R.id.edtContentTitle);
edtContentText = (EditText) findViewById(R.id.edtContentText);
btnNotify = (Button) findViewById(R.id.btnNotify);

btnNotify.setOnClickListener(MainActivity.this);

    }

    @Override
    public void onClick(View v) {

        if(edtContentTitle.getText().toString().matches("")||edtContentText.getText().toString().matches(""))
        {
            return;
        }
ShowNotification();
    }
private void ShowNotification()
{
    Notification.Builder builder = new Notification.Builder(MainActivity.this);
    builder.setSmallIcon(R.drawable.image);
    builder.setContentText(edtContentText.getText().toString());
    builder.setContentTitle(edtContentTitle.getText().toString());


    Intent intent = new Intent(MainActivity.this,MainActivity.class);
    PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this,0,intent,
            PendingIntent.FLAG_UPDATE_CURRENT);
    builder.setContentIntent(pendingIntent);
    NotificationManager notificationManager =(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    notificationManager.notify("Mynotify",123,builder.build());
}

}
