package spoticesar.uniftec.com.br.spoticesar.task;

import android.os.AsyncTask;

import retrofit2.Call;
import retrofit2.Response;
import spoticesar.uniftec.com.br.spoticesar.models.AlbumListResponse;
import spoticesar.uniftec.com.br.spoticesar.service.SearchService;
import spoticesar.uniftec.com.br.spoticesar.utils.RetrofitUtil;

public class SearchAlbunsDoArtistaTask
            extends AsyncTask<String, Void, AlbumListResponse> {

    private final SearchArtistaByIdTaskDelegate delegate;

    public SearchAlbunsDoArtistaTask(SearchArtistaByIdTaskDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    protected AlbumListResponse doInBackground(String... strings) {

        SearchService service = RetrofitUtil.getInstance().createSearchService();

        Call<AlbumListResponse> call = service.searchAlbunsDoArtista(strings[0]);

        try {

            Response<AlbumListResponse> response = call.execute();

            if (response.isSuccessful()) {
                return response.body();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    @Override
    protected void onPostExecute(AlbumListResponse artistaResponse) {
        if (artistaResponse != null) {
            delegate.onSearchAlbunsDoArtistaSuccess(artistaResponse);
        } else {
            delegate.onSearchAlbunsDoArtistaError("Não foi possível realizar a busca.");
        }
    }

    public interface SearchArtistaByIdTaskDelegate {
        void onSearchAlbunsDoArtistaSuccess(AlbumListResponse response);
        void onSearchAlbunsDoArtistaError(String error);
    }

}