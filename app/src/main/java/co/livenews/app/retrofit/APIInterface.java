package co.livenews.app.retrofit;


import java.util.List;

import co.livenews.app.models.TradingModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface APIInterface {

/*
    @GET("get_article/{id}")
    Call<List<TradingModel>> getArticleList(@Path("id") String id);
*/

    @GET("get_category_item?category_id={id}&order={sortOrder}}")
    Call<TradingModel> getArticleList(@Path("id") String id,@Path("sortOrder") String sortOrder);

}
