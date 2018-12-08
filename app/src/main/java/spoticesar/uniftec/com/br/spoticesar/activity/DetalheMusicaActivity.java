package spoticesar.uniftec.com.br.spoticesar.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.deezer.sdk.model.Permissions;
import com.deezer.sdk.network.connect.DeezerConnect;
import com.deezer.sdk.network.connect.SessionStore;
import com.deezer.sdk.network.connect.event.DialogListener;
import com.deezer.sdk.network.request.event.DeezerError;
import com.deezer.sdk.player.TrackPlayer;
import com.deezer.sdk.player.exception.TooManyPlayersExceptions;
import com.deezer.sdk.player.networkcheck.WifiAndMobileNetworkStateChecker;
import com.squareup.picasso.Picasso;

import spoticesar.uniftec.com.br.spoticesar.R;
import spoticesar.uniftec.com.br.spoticesar.constants.DeezerConstants;
import spoticesar.uniftec.com.br.spoticesar.models.Musica;
import spoticesar.uniftec.com.br.spoticesar.task.SearchMusicaByIdTask;

public class DetalheMusicaActivity
        extends AppCompatActivity
        implements View.OnClickListener, DialogListener, SearchMusicaByIdTask.SearchMusicaByIdTaskDelegate {

    // ==========================

    public static final String MUSICA_PARAM = "MUSICA_PARAM";

    private boolean playTrack = false;

    private Musica musica;

    // ==========================

    private DeezerConnect deezerConnect;
    private SessionStore sessionStore;

    // ==========================

    private TextView txtvDataLancamento;
    private TextView txtvNomeArtista;
    private TextView txtvDuracao;
    private TextView txtvNome;

    private ImageView imgvCapaAlbumMusica;

    private Button playButton;

    private TrackPlayer trackPlayer;

    // ==========================

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_musica);

        Intent intent = getIntent();

        Musica musica = (Musica)
                intent.getSerializableExtra(MUSICA_PARAM);

        this.atribuiElementosDeTela();
        this.populaMusicaEmTela(musica);

        this.playButton = this.findViewById(R.id.btn_play);
        this.playButton.setOnClickListener(this);

        SearchMusicaByIdTask searchMusicaByIdTask =
                new SearchMusicaByIdTask(this);

        searchMusicaByIdTask.execute(musica.getId().toString());

        this.configuraDeezer();

    }

    private void configuraDeezer() {

        deezerConnect = new DeezerConnect(this, DeezerConstants.APP_ID);
        this.sessionStore = new SessionStore();

        if (!sessionStore.restore(deezerConnect, this)) {

            String[] permissoes = new String[]{
                    Permissions.BASIC_ACCESS,
                    Permissions.MANAGE_LIBRARY,
                    Permissions.LISTENING_HISTORY
            };

            deezerConnect.authorize(this, permissoes, this);

        } else {
            this.createTrackPlayer();
        }

    }

    private void populaMusicaEmTela(Musica musica) {
        this.musica = musica;
        this.txtvDuracao.setText("" + musica.getDuracao() + " Seg.");
        this.txtvNome.setText("" + musica.getNome());
        this.txtvNomeArtista.setText("" + musica.getArtista().getNome());
        this.txtvDataLancamento.setText("" + musica.getDataLancamento());

        Picasso.with(this)
                .load(musica.getImageUrl())
                .into(this.imgvCapaAlbumMusica);
    }

    private String ajustaDataLancamento(String dataLancamento) {
        String[] arrayString = new String[3];
        arrayString = dataLancamento.split("-");
        return "" + arrayString[2] + "/" + arrayString[1] + "/" + arrayString[0];
    }

    private void atribuiElementosDeTela() {
        this.txtvDuracao = findViewById(R.id.txtv_musica_duracao_imp);
        this.txtvNome = findViewById(R.id.txtv_musica_nome_musica_imp);
        this.txtvNomeArtista = findViewById(R.id.txtv_musica_nome_artista_imp);
        this.txtvDataLancamento = findViewById(R.id.txtv_musica_data_lancamento_imp);
        this.imgvCapaAlbumMusica = findViewById(R.id.musica_image_src);
    }

    @Override
    public void onClick(View v) {

        if (v == this.playButton) {

            if (!playTrack) {

                this.playMusic();
                playTrack = true;

            } else {

                this.pauseMusic();
                playTrack = false;

            }

        }

    }

    private void pauseMusic() {

        this.playButton
                .setCompoundDrawablesWithIntrinsicBounds(0, 0,
                        android.R.drawable.ic_media_play, 0);

        trackPlayer.pause();
    }

    private void playMusic() {

        this.playButton
                .setCompoundDrawablesWithIntrinsicBounds(0, 0,
                        android.R.drawable.ic_media_pause, 0);

        trackPlayer.playTrack(this.musica.getId());

        if (trackPlayer == null) {
            Toast.makeText(this, "erro", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onComplete(Bundle bundle) {
        this.sessionStore.save(this.deezerConnect, this);
        createTrackPlayer();
    }

    private void createTrackPlayer() {

        try {

            trackPlayer = new TrackPlayer(
                    getApplication(),
                    this.deezerConnect,
                    new WifiAndMobileNetworkStateChecker()
            );

        } catch (TooManyPlayersExceptions tooManyPlayersExceptions) {


        } catch (DeezerError deezerError) {
            deezerError.printStackTrace();
        }

    }

    @Override
    public void onCancel() {

    }

    @Override
    public void onException(Exception e) {

    }

    @Override
    public void onSearchMusicaByIdSuccess(Musica response) {
        populaMusicaEmTela(response);
    }

    @Override
    public void onSearchMusicaByIdError(String error) {

    }
}
