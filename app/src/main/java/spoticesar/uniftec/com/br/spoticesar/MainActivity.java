package spoticesar.uniftec.com.br.spoticesar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import spoticesar.uniftec.com.br.spoticesar.activity.AgendaTelefonicaActivity;
import spoticesar.uniftec.com.br.spoticesar.activity.BuscarAlbumActivity;
import spoticesar.uniftec.com.br.spoticesar.activity.BuscarArtistaActivity;
import spoticesar.uniftec.com.br.spoticesar.activity.BuscarMusicaActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();

        menuInflater.inflate(R.menu.main_menu, menu);

        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

//            case R.id.menu_buscar_album:
//                startActivity(new Intent(this,
//                        BuscarAlbumActivity.class));
//                break;
//
//            case R.id.menu_buscar_artista:
//                startActivity(new Intent(this,
//                        BuscarArtistaActivity.class));
//                break;
//
//            case R.id.menu_buscar_musica:
//                startActivity(new Intent(this,
//                        BuscarMusicaActivity.class));
//                break;

            case R.id.menu_listagem_telefone:
                startActivity(new Intent(this,
                        AgendaTelefonicaActivity.class));
                break;
        }

        return super.onOptionsItemSelected(item);

    }

}
