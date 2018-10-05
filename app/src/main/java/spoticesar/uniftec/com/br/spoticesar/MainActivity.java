package spoticesar.uniftec.com.br.spoticesar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.List;

import spoticesar.uniftec.com.br.spoticesar.activity.AgendaTelefonicaActivity;
import spoticesar.uniftec.com.br.spoticesar.activity.CadastroTelefoneActivity;
import spoticesar.uniftec.com.br.spoticesar.activity.ImageActivity;
import spoticesar.uniftec.com.br.spoticesar.models.Telefone;

public class MainActivity extends AppCompatActivity {

    private List<Telefone> telefones;

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

            case R.id.menu_listagem_telefone:
                startActivity(new Intent(this,
                        AgendaTelefonicaActivity.class));
                break;

            case R.id.menu_cadastro_telefone:
                startActivity(new Intent(this,
                        CadastroTelefoneActivity.class));
                break;

//            case R.id.menu_imagem:
//                startActivity(new Intent(this,
//                        ImageActivity.class));
//                break;
        }

        return super.onOptionsItemSelected(item);

    }

}
