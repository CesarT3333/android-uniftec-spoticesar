package spoticesar.uniftec.com.br.spoticesar.service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import spoticesar.uniftec.com.br.spoticesar.models.AlbumResponse;
import spoticesar.uniftec.com.br.spoticesar.models.MusicaResponse;

public interface SearchService {

    @GET("/3/search/movie?language=pt-BR")
    Call<MusicaResponse> searchMusica(@Query("query") String query);

    @GET("/3/search/movie?language=pt-BR")
    Call<ArtistaResponse> searchArtist(@Query("query") String query);

    @GET("/search/album")
    Call<AlbumResponse> searchAlbum(@Query("q") String filtro);

}
