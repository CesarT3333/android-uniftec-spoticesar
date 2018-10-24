package spoticesar.uniftec.com.br.spoticesar;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;

import spoticesar.uniftec.com.br.spoticesar.activity.BuscarAlbumActivity;
import spoticesar.uniftec.com.br.spoticesar.activity.BuscarArtistaActivity;
import spoticesar.uniftec.com.br.spoticesar.activity.BuscarMusicaActivity;
import spoticesar.uniftec.com.br.spoticesar.fragment.BlankFragment;
import spoticesar.uniftec.com.br.spoticesar.fragment.BuscaAlbumFragment;

public class MainActivity
        extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private FrameLayout frameLayout;
    private NavigationView navigationView;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.frameLayout = this.findViewById(R.id.main_activity_container_frame_layout);
        this.drawerLayout = this.findViewById(R.id.main_activity_menu_drawer_layout);

        Toolbar toolbar = this.findViewById(R.id.action_toolbar);
        setSupportActionBar(toolbar);
        this.actionBar = getSupportActionBar();
        this.actionBar.setDisplayHomeAsUpEnabled(true);
        this.actionBar.setHomeAsUpIndicator(R.drawable.baseline_android_black_24);

        this.navigationView = findViewById(R.id.nav_item);
        this.navigationView.setNavigationItemSelectedListener(this);

    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.menu_buscar_album:
                this.changeFragment(BuscaAlbumFragment.newInstance());
                break;

            case R.id.menu_buscar_artista:
                startActivity(new Intent(this,
                        BuscarArtistaActivity.class));
                break;

            case R.id.menu_buscar_musica:
                startActivity(new Intent(this,
                        BuscarMusicaActivity.class));
                break;

            case R.id.menu_fragment:
                this.changeFragment(BlankFragment.newInstance());
                break;

        }

        return false;

    }

    private void changeFragment(Fragment f) {

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_activity_container_frame_layout, f)
                .commit();

    }

}
