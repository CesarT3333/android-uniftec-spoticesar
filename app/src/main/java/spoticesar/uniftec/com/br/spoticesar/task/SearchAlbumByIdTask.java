package spoticesar.uniftec.com.br.spoticesar.task;

import android.os.AsyncTask;

import retrofit2.Call;
import retrofit2.Response;
import spoticesar.uniftec.com.br.spoticesar.models.Album;
import spoticesar.uniftec.com.br.spoticesar.service.SearchService;
import spoticesar.uniftec.com.br.spoticesar.utils.RetrofitUtil;

public class SearchAlbumByIdTask
        extends AsyncTask<String, Void, Album> {

    private final SearchAlbumByIdTaskDelegate delegate;

    public SearchAlbumByIdTask(SearchAlbumByIdTaskDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    protected Album doInBackground(String... strings) {

        SearchService service = RetrofitUtil.getInstance().createSearchService();

        Call<Album> call = service.searchAlbumById(strings[0]);

        try {

            Response<Album> response = call.execute();

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
    protected void onPostExecute(Album albumResponse) {
        if (albumResponse != null) {
            delegate.onSearchMovieSuccess(albumResponse);
        } else {
            delegate.onSearchMovieError("Não foi possível realizar a busca.");
        }
    }

    public interface SearchAlbumByIdTaskDelegate {
        void onSearchMovieSuccess(Album response);
        void onSearchMovieError(String error);
    }

}