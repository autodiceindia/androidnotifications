package in.autodice.notifications;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyService extends FirebaseMessagingService {
    public static String TAG="FirebaseMessage";
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.d(TAG, "From: " + remoteMessage.getFrom());
        if(remoteMessage.getData().size()>0){
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());
        }
        if(remoteMessage.getNotification()!=null){
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
        }
    }

    @Override
    public void onNewToken(String s) {
        Log.d(TAG, "Refreshed token: " + s);
    }
}
