package co.mubashirgulf.app.bp;

import android.app.Application;
import android.content.Context;

import com.onesignal.OneSignal;

public class MyApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();

        // OneSignal Initialization
        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(false)
                .init();
    }

    public static Context getContext (){return context; }

}