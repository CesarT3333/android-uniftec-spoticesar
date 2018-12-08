package spoticesar.uniftec.com.br.spoticesar.task;

import android.os.AsyncTask;

import retrofit2.Call;
import retrofit2.Response;
import spoticesar.uniftec.com.br.spoticesar.models.ArtistaResponse;
import spoticesar.uniftec.com.br.spoticesar.service.SearchService;
import spoticesar.uniftec.com.br.spoticesar.utils.RetrofitUtil;

public class SearchArtistTask
        extends AsyncTask<String, Void, ArtistaResponse> {

    private final SearchArtistTask.SearchArtistTaskDelegate delegate;

    public SearchArtistTask(SearchArtistTaskDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    protected ArtistaResponse doInBackground(String... strings) {

        SearchService service = RetrofitUtil.getInstance().createSearchService();

        Call<ArtistaResponse> call = service.searchArtist(strings[0]);

        try {

            Response<ArtistaResponse> response = call.execute();

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
    protected void onPostExecute(ArtistaResponse searchResponse) {
        if (searchResponse != null) {
            delegate.onSearchMovieSuccess(searchResponse);
        } else {
            delegate.onSearchMovieError("Não foi possível realizar a busca.");
        }
    }

    public interface SearchArtistTaskDelegate {
        public void onSearchMovieSuccess(ArtistaResponse response);

        public void onSearchMovieError(String error);
    }
}
