package co.mubashirgulf.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.onesignal.OneSignal;

import co.mubashirgulf.app.adapter.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager;
     static String postLink = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String a = getIntent().getStringExtra("start");
        postLink = getIntent().getStringExtra("link");
        ViewPagerAdapter adapter = createCardAdapter();

        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tabs);
        viewPager.setAdapter(adapter);

        if (a!= null && a.equals("2")){
            viewPager.setCurrentItem(2);
        }
        if (a!= null && a.equals("1")){
            viewPager.setCurrentItem(1);
        }
        if (a!= null && a.equals("0")){
            viewPager.setCurrentItem(0);
        }


        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1){
            getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        }

        new TabLayoutMediator(tabLayout, viewPager,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        switch (position){
                            case 0:
                                tab.setText(getResources().getString(R.string.learn_trading_ar));
                                break;
                            case 1:
                                //tab.setText("Success Stories");
                                tab.setText(getResources().getString(R.string.success_stories_ar));
                                break;
                            case 2:
                                //tab.setText("Start Trading");
                                tab.setText(getResources().getString(R.string.start_trading_ar));
                                break;
                        }
                    }
                }).attach();


        // OneSignal Initialization
        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(false)
                .init();
    }

    private ViewPagerAdapter createCardAdapter() {
        ViewPagerAdapter adapter;
        adapter = new ViewPagerAdapter(this);
        return adapter;
    }

    public static String getPostLink(){
        return postLink;
    }

    public static void setPostLink(String link){
         postLink = link;
    }
}
