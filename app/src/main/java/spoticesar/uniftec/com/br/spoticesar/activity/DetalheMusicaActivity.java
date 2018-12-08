package spoticesar.uniftec.com.br.spoticesar.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

import spoticesar.uniftec.com.br.spoticesar.R;
import spoticesar.uniftec.com.br.spoticesar.constants.DeezerConstants;
import spoticesar.uniftec.com.br.spoticesar.models.Musica;

public class DetalheMusicaActivity
        extends AppCompatActivity
        implements View.OnClickListener, DialogListener {

    // ==========================

    public static final String MUSICA_PARAM = "MUSICA_PARAM";

    // ==========================

    private DeezerConnect deezerConnect;
    private SessionStore sessionStore;

    // ==========================

    private TextView txtvNomeArtista;
    private TextView txtvDuracao;
    private TextView txtvNome;

    private Button playButton;
    private TrackPlayer trackPlayer;

    // ==========================

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_musica);

        Intent intent = getIntent();
        getApplication();
        Musica musica = (Musica)
                intent.getSerializableExtra(MUSICA_PARAM);

        this.atribuiElementosDeTela();
        this.populaMusicaEmTela(musica);

        this.playButton = this.findViewById(R.id.btn_play);
        this.playButton.setOnClickListener(this);

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
        this.txtvDuracao.setText("04:12");
        this.txtvNome.setText(musica.getNome());
        this.txtvNomeArtista.setText(musica.getArtista().getNome());
    }

    private void atribuiElementosDeTela() {
        this.txtvDuracao = findViewById(R.id.txtv_musica_duracao_imp);
        this.txtvNome = findViewById(R.id.txtv_musica_nome_musica_imp);
        this.txtvNomeArtista = findViewById(R.id.txtv_musica_nome_artista_imp);
    }

    @Override
    public void onClick(View v) {

        if (v == this.playButton) {
            this.playMusic();
        }

    }

    private void playMusic() {

        String idMusicaStr = "92720046";

        long idMusica = 0;

        try {

            idMusica = Long.parseLong(idMusicaStr);

        } catch (NumberFormatException e) {
            e.printStackTrace();
            Toast.makeText(this, "erro", Toast.LENGTH_LONG).show();
        }

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

            trackPlayer.playTrack(92720046);

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
}
