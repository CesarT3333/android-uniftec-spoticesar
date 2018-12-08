package spoticesar.uniftec.com.br.spoticesar.task;

import android.os.AsyncTask;

import retrofit2.Call;
import retrofit2.Response;
import spoticesar.uniftec.com.br.spoticesar.models.Musica;
import spoticesar.uniftec.com.br.spoticesar.service.SearchService;
import spoticesar.uniftec.com.br.spoticesar.utils.RetrofitUtil;

public class SearchMusicaByIdTask
        extends AsyncTask<String, Void, Musica> {

    private final SearchMusicaByIdTaskDelegate delegate;

    public SearchMusicaByIdTask(SearchMusicaByIdTaskDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    protected Musica doInBackground(String... strings) {

        SearchService service = RetrofitUtil.getInstance().createSearchService();

        Call<Musica> call = service.searchMusicaById(strings[0]);

        try {

            Response<Musica> response = call.execute();

            if (response.isSuccessful()) {
                return response.body();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    @Override
    protected void onPostExecute(Musica artistaResponse) {
        if (artistaResponse != null) {
            delegate.onSearchMusicaByIdSuccess(artistaResponse);
        } else {
            delegate.onSearchMusicaByIdError("Não foi possível realizar a busca.");
        }
    }

    public interface SearchMusicaByIdTaskDelegate {
        void onSearchMusicaByIdSuccess(Musica response);

        void onSearchMusicaByIdError(String error);
    }

}