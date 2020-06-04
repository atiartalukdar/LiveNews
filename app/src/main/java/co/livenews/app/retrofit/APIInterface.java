package co.livenews.app.retrofit;


import java.util.List;

import co.livenews.app.models.SubmitData;
import co.livenews.app.models.TradingModel;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface APIInterface {

/*
    @GET("get_article/{id}")
    Call<List<TradingModel>> getArticleList(@Path("id") String id);
*/

    @GET("get_category_item?")
    Call<TradingModel> getArticleList(@Query("category_id") String id,@Query("order") String sort);

    @FormUrlEncoded
    @POST("submit_data")
    Call<SubmitData> sendLead(@Field("name") String name,
                              @Field("phone") String phone,
                              @Field("country") String country);
}
