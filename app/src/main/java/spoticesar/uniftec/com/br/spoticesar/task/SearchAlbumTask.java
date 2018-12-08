package spoticesar.uniftec.com.br.spoticesar.task;

import android.os.AsyncTask;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import spoticesar.uniftec.com.br.spoticesar.models.AlbumListResponse;
import spoticesar.uniftec.com.br.spoticesar.service.SearchService;
import spoticesar.uniftec.com.br.spoticesar.utils.RetrofitUtil;

public class SearchAlbumTask
        extends AsyncTask<String, Void, AlbumListResponse> {

    private final SearchAlbumTaskDelegate delegate;

    public SearchAlbumTask(SearchAlbumTaskDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    protected AlbumListResponse doInBackground(String... strings) {

        SearchService service = RetrofitUtil.getInstance().createSearchService();

        Call<AlbumListResponse> call = service.searchAlbum(strings[0]);

        try {

            Response<AlbumListResponse> response = call.execute();

            if (response.isSuccessful()) {
                // response.raw().body().string() - response em formato string
                return response.body();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    @Override
    protected void onPostExecute(AlbumListResponse searchMovieResponse) {
        if (searchMovieResponse != null) {
            delegate.onSearchMovieSuccess(searchMovieResponse);
        } else {
            delegate.onSearchMovieError("Não foi possível realizar a busca.");
        }
    }

    public interface SearchAlbumTaskDelegate {
        void onSearchMovieSuccess(AlbumListResponse response);
        void onSearchMovieError(String error);
    }

}
