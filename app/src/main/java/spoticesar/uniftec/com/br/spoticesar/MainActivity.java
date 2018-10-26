package spoticesar.uniftec.com.br.spoticesar;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;

import spoticesar.uniftec.com.br.spoticesar.fragment.BuscaAlbumFragment;
import spoticesar.uniftec.com.br.spoticesar.fragment.BuscaArtistaFragment;
import spoticesar.uniftec.com.br.spoticesar.fragment.BuscaMusicaFragment;

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
                this.changeFragment(BuscaArtistaFragment.newInstance());
                break;

            case R.id.menu_buscar_musica:
                this.changeFragment(BuscaMusicaFragment.newInstance());
                break;

        }

        return false;

    }

    private void changeFragment(Fragment f) {

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_activity_container_frame_layout, f)
                .commit();

        this.drawerLayout.closeDrawers();

    }

}
