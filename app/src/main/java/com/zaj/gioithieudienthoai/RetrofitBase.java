package com.zaj.gioithieudienthoai;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class RetrofitBase {
    private static Retrofit retrofit;
    private static String DOMAIN = "http://shipdoan.000webhostapp.com/zaj";
    private static String BASE_URL = DOMAIN+"/api/";
    public static String getDOMAIN(){
        return DOMAIN;
    }
    public static Retrofit getRetrofit(){
        if (retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
    public interface API{
        @GET("get.php?action=get")
        public Call<PhoneResponse> getListPhone(@Query("token") String token,@Query("idDM") int id);
    }
}
