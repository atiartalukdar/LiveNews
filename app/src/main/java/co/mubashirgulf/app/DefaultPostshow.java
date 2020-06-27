package co.mubashirgulf.app;

import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.github.appintro.AppIntro;
import com.kaopiz.kprogresshud.KProgressHUD;

import org.jetbrains.annotations.Nullable;

import co.mubashirgulf.app.models.DefaultPostModel;
import co.mubashirgulf.app.retrofit.APIManager;
import co.mubashirgulf.app.retrofit.RequestListener;

public class DefaultPostshow extends AppIntro {
    private final String TAG = getClass().getName() + " Atiar - ";
    APIManager _apiManager;
    WebView _articleWebview;
    String defaultPostLink  = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default_postshow);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1){
            getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        }
        //addSlide(AppIntroCustomLayoutFragment.newInstance(R.layout.activity_default_postshow));
        _apiManager = new APIManager();
        loadData();



    }


    public void backButton(View view) {
        //onBackPressed();
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("start", "0");
        intent.putExtra("link", "");
        startActivity(intent);
        finish();
    }

    public void startTrading(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("start", "2");
        intent.putExtra("link", "DefaultPost: "+ defaultPostLink);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void loadData() {
        final KProgressHUD kProgressHUD = KProgressHUD.create(this)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setLabel(getResources().getString(R.string.please_wait_ar))
                .setDetailsLabel(getResources().getString(R.string.downloadin_ar))
                .setCancellable(false)
                .setAnimationSpeed(2)
                .setDimAmount(0.5f)
                .show();

        _apiManager.getDefaultPost(new RequestListener<DefaultPostModel>() {

            @Override
            public void onSuccess(DefaultPostModel response) {
                if (response !=null && response.getStatus().equals("ok")){
                    showData(response.getPost());
                }
                kProgressHUD.dismiss();
            }

            @Override
            public void onError(Throwable t) {
                kProgressHUD.dismiss();

            }
        });

    }

    @SuppressLint("JavascriptInterface")
    private void showData(DefaultPostModel.Post post) {
        defaultPostLink = post.getPostLink();
        _articleWebview = findViewById(R.id.articleWebView);
        //_articleWebview.getSettings().getJavaScriptEnabled();
        _articleWebview.setWebChromeClient(new WebChromeClient());
        _articleWebview.setWebViewClient(new WebViewClient());
        _articleWebview.getSettings().setJavaScriptEnabled(true);
        _articleWebview.getSettings().setBuiltInZoomControls(true);
        _articleWebview.getSettings().setLoadWithOverviewMode(true);
        _articleWebview.addJavascriptInterface(new ArticleActivity(),"jsinterface");
        String article = post.getPostContent();
        article = article.replaceAll("\\r\\n\\r\\n", "<br><br>").replaceAll("\\[/caption\\]","");

        String[] parts = article.split("1500\"]");
        String part1,part2;
        if (parts.length>1){
            part1 = parts[0]; // 004
            part2 = parts[1]; // 034556
        }else {
            part2 = article;
        }

        Log.e(TAG,part2);

        Log.e(TAG,"\n\n" + part2);

        _articleWebview.loadDataWithBaseURL(null, "<style>img{display: inline;height: auto;max-width: 100%;}</style>" + "<body dir=\"rtl\">"+ part2 + "</body>", "text/html", "utf-8", null);


    }

    @Override
    protected void onSkipPressed(@Nullable Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }

    @Override
    protected void onDonePressed(@Nullable Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        startActivity(new Intent(this,MainActivity.class));
        finish();

    }
}
