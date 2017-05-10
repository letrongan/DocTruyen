package bustudio.doctruyen;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import ulti.FragmentControl;

public class MainActivity extends AppCompatActivity implements MenuItem.OnMenuItemClickListener {


    private Toolbar toolbar;
    private MenuItem search, micro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragment();

    }

    public void initFragment() {
        // set toolbar
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        toolbar.setTitle("Đọc truyện");
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().getDisplayOptions();


        FragmentControl fragmentControl = new FragmentControl();
        fragmentControl.goToFragmentNoAddBackStack(R.id.frameLayout, new ViewPagerFragment(), MainActivity.this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.tool_bar, menu);

        //find view by id
        search = menu.findItem(R.id.searchView);
        micro = menu.findItem(R.id.menu);

        //event
        search.setOnMenuItemClickListener(this);
        micro.setOnMenuItemClickListener(this);


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu: {
                //Todo everything

                Toast.makeText(MainActivity.this, "Click Micro", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.searchView: {
                //Todo everything

                Toast.makeText(MainActivity.this, "Click SearchView", Toast.LENGTH_SHORT).show();
                break;
            }
        }


        return true;
    }

    @Override
    public void onBackPressed() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.frameLayout);
        if (fragment instanceof ViewPagerChapFragment) {

//            Log.e("tieuhoan", String.valueOf(ViewPagerChapFragment.currentPosition));
//            int idchap = ViewPagerChapFragment.chaps.get(ViewPagerChapFragment.currentPosition).getId();
//            Log.e("tieuhoan", "idchap" + idchap);

        }
        super.onBackPressed();

    }
}
