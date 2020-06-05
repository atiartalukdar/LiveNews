package co.livenews.app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.w3c.dom.Text;

public class ArticleActivity extends AppCompatActivity {
    final String tag = getClass().getSimpleName() + "Atiar - ";
    WebView _articleWebview;
    TextView _tv;
    @SuppressLint("JavascriptInterface")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1){
            getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        }
        _articleWebview = findViewById(R.id.articleWebView);
        _tv = findViewById(R.id.tview);
        //_articleWebview.getSettings().getJavaScriptEnabled();
        _articleWebview.setWebChromeClient(new WebChromeClient());
        _articleWebview.setWebViewClient(new WebViewClient());
        _articleWebview.getSettings().setJavaScriptEnabled(true);
        _articleWebview.getSettings().setBuiltInZoomControls(true);
        _articleWebview.getSettings().setLoadWithOverviewMode(true);
        _articleWebview.addJavascriptInterface(new ArticleActivity(),"jsinterface");
        Intent intent = getIntent();
        String image = intent.getStringExtra("img");
        String article = intent.getStringExtra("art");
        article = article.replaceAll("\\r\\n\\r\\n", "<br><br>").replaceAll("\\[/caption\\]","");

        String[] parts = article.split("1500\"]");
        String part1,part2;
        if (parts.length>1){
            part1 = parts[0]; // 004
            part2 = parts[1]; // 034556
        }else {
            part2 = article;
        }

        Log.e(tag,part2);

        Log.e(tag,"\n\n" + part2);

        _articleWebview.loadDataWithBaseURL(null, "<style>img{display: inline;height: auto;max-width: 100%;}</style>" + "<body dir=\"rtl\">"+ part2 + "</body>", "text/html", "utf-8", null);

    }

    public static String html2text(String html) {
        return Jsoup.parse(html).text();
    }
}
