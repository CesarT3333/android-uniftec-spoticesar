package spoticesar.uniftec.com.br.spoticesar.task;

import android.os.AsyncTask;

import retrofit2.Call;
import retrofit2.Response;
import spoticesar.uniftec.com.br.spoticesar.models.MusicaResponse;
import spoticesar.uniftec.com.br.spoticesar.service.SearchService;
import spoticesar.uniftec.com.br.spoticesar.utils.RetrofitUtil;

public class SearchMusicTask
        extends AsyncTask<String, Void, MusicaResponse> {

    private final SearchMusicTask.SearchMusicTaskDelegate delegate;


    public SearchMusicTask(SearchMusicTaskDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    protected MusicaResponse doInBackground(String... strings) {
        SearchService service = RetrofitUtil.getInstance().createSearchService();

        Call<MusicaResponse> call = service.searchMusica(strings[0]);

        try {

            Response<MusicaResponse> response = call.execute();

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
    protected void onPostExecute(MusicaResponse searchResponse) {
        if (searchResponse != null) {
            delegate.onSearchMovieSuccess(searchResponse);
        } else {
            delegate.onSearchMovieError("Não foi possível realizar a busca.");
        }
    }

    public interface SearchMusicTaskDelegate {
        void onSearchMovieSuccess(MusicaResponse response);

        void onSearchMovieError(String error);
    }

}
