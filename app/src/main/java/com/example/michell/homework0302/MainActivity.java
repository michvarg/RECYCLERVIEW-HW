package com.example.michell.homework0302;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final int NOTIFICATION_ID = 0;


    private static final String TAG = "MainActivity";

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started.");

        initImageBitmap();

        createNotificationChannel();
    }

    private void initImageBitmap(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageUrls.add("https://c1.staticflickr.com/5/4636/25316407448_de5f183d_o.jpf");
        mNames.add("Havasu falls");

        mImageUrls.add("https://i.redd.it/tpsnoz5bzo501.jpg");
        mNames.add("Trondheim");

        mImageUrls.add("https://i.redd.it/qn7f9oqu7o501.jpg");
        mNames.add("Portugal");

        mImageUrls.add("https://i.redd.it/j6myfglup501.jpg");
        mNames.add("Rocky Mountain National Park");

        mImageUrls.add("https://i.redd.it/k98uz168eh501.jpg");
        mNames.add("Frozen Lake");

        mImageUrls.add("https://i.redd.it/glin0nwndo501.jpg");
        mNames.add("White Sands Desert");

        mImageUrls.add("https://i.redd.it/obx4zydshg601.jpg");
        mNames.add("Austrailia");

        mImageUrls.add("https://i.redd.it/ZcLLrkY.jpg");
        mNames.add("Washington");

        initRecyclerView();
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: inti recyclerview.");
        recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter recyclerViewAdapter= new RecyclerViewAdapter(mNames, mImageUrls,this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private Button button_notify;

    public void setNotificationId(){}




    public void setButton_notify(Button button_notify) {
        this.button_notify = button_notify;
    }

    private static final String PRIMARTY_CHANNEL_ID = "primary_notification_channel";

    private NotificationManager mNotifyManger;

    public NotificationCompat.Builder createNotificationChannel(){

        mNotifyManger = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);               // create a notificationchannel
          if (Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {

              NotificationChannel notificationChannel = new NotificationChannel(PRIMARTY_CHANNEL_ID, "Vacation Notification", NotificationManager.IMPORTANCE_HIGH );

          }

         NotificationCompat.Builder getNotificationBuilder; {
            NotificationCompat.Builder notifyBuilder = new NotificationCompat.Builder(this, PRIMARTY_CHANNEL_ID)
                    .setContentTitle("you've been notified")
                    .setContentText("This is your notification text.")
                    .setSmallIcon(R.drawable.ic_android);
            return notifyBuilder;



        }




    }



}
