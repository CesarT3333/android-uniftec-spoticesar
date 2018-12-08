package spoticesar.uniftec.com.br.spoticesar.service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import spoticesar.uniftec.com.br.spoticesar.models.Album;
import spoticesar.uniftec.com.br.spoticesar.models.AlbumListResponse;
import spoticesar.uniftec.com.br.spoticesar.models.Artista;
import spoticesar.uniftec.com.br.spoticesar.models.ArtistaResponse;
import spoticesar.uniftec.com.br.spoticesar.models.MusicaResponse;

public interface SearchService {

    @GET("/search/track")
    Call<MusicaResponse> searchMusica(@Query("q") String query);

    @GET("/search/artist")
    Call<ArtistaResponse> searchArtist(@Query("q") String query);

    @GET("/search/album")
    Call<AlbumListResponse> searchAlbum(@Query("q") String filtro);

    // ================

    @GET("/album/{idAlbum}")
    Call<Album> searchAlbumById(@Path("idAlbum") String idAlbum);

    @GET("/artist/{idArtista}/albums")
    Call<AlbumListResponse> searchAlbunsDoArtista(@Path("idArtista") String idArtista);

}
