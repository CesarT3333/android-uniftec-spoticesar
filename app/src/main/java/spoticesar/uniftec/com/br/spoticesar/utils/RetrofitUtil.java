package spoticesar.uniftec.com.br.spoticesar.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import spoticesar.uniftec.com.br.spoticesar.service.SearchService;

public class RetrofitUtil {

    public static final String API_KEY = "8cc65cc237509b082427cce84df4fe28";

    private static RetrofitUtil instance;
    private Retrofit retrofit;

    private RetrofitUtil(){

        ObjectMapper jackasonMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

//        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
//                .connectTimeout(60, TimeUnit.SECONDS)
//                .readTimeout(60, TimeUnit.SECONDS)
//                .writeTimeout(60, TimeUnit.SECONDS)
//                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.deezer.com")
                .addConverterFactory(JacksonConverterFactory.create(jackasonMapper))
                .build();

    }

    public static RetrofitUtil getInstance(){

        if(instance == null){
            instance = new RetrofitUtil();
        }

        return instance;

    }

    public SearchService createSearchService(){
        return retrofit.create(SearchService.class);
    }

}
