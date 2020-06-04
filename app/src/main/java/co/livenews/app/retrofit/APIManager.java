package co.livenews.app.retrofit;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.concurrent.TimeUnit;

import co.livenews.app.bp.MyApplication;
import co.livenews.app.models.TradingModel;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class APIManager {
    public static final String BASE_URL = "https://live-news.co/webservices/";

    private final APIInterface api;
    private Context _context;

    public APIManager(){

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .connectTimeout(5*60, TimeUnit.SECONDS)
                .readTimeout(2*60, TimeUnit.SECONDS)
                .writeTimeout(20*60, TimeUnit.SECONDS)
                .build();

        _context = MyApplication.getContext();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        api = retrofit.create(APIInterface.class);
    }

    public void getArticleList(String ctgID,String sortOrder, RequestListener<TradingModel> listener) {
        api.getArticleList(ctgID,sortOrder).enqueue(new APICallback<TradingModel>(_context,listener));
    }

}
