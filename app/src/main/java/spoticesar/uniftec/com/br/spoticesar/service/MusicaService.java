package spoticesar.uniftec.com.br.spoticesar.service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import spoticesar.uniftec.com.br.spoticesar.models.MusicaResponse;

public interface MusicaService {

    @GET("/3/search/movie?language=pt-BR")
    public Call<MusicaResponse> searchMovie(@Query("query") String query);

}
