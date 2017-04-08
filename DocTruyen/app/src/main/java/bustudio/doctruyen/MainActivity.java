package bustudio.doctruyen;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import ulti.FragmentControl;

public class MainActivity extends AppCompatActivity {
    public static KimDungFragment kimDungFragment;
    private Toolbar toolbar;
    private MenuItem search, micro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragment();

    }

    public void initFragment() {
        kimDungFragment = new KimDungFragment();

        FragmentControl fragmentControl = new FragmentControl();
        fragmentControl.goToFragmentNoAddBackStack(R.id.frameLayout, new ViewPagerFragment(), MainActivity.this);

        toolbar = (Toolbar) findViewById(R.id.toolBar);
        toolbar.setTitle("Đọc truyện");
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().getDisplayOptions();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.tool_bar, menu);

        //find view by id
        search = menu.findItem(R.id.searchView);
        micro = menu.findItem(R.id.menu);

        //event
        

        return super.onCreateOptionsMenu(menu);
    }
}
