package bustudio.doctruyen;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

import model.Chap;
import model.Truyen;
import search.Search;
import search.SearchResult;
import ulti.FragmentControl;

import static bustudio.doctruyen.R.id.searchView;
import static bustudio.doctruyen.ViewPagerChapFragment.chaps;

public class MainActivity extends AppCompatActivity implements MenuItem.OnMenuItemClickListener, SearchView.OnQueryTextListener {


    private Toolbar toolbar;
    public static MenuItem search, micro;

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
        search = menu.findItem(searchView);
        micro = menu.findItem(R.id.menu);
        micro.setVisible(false);

        //event
        search.setOnMenuItemClickListener(this);


        return super.onCreateOptionsMenu(menu);
    }


    private ArrayList<SearchResult> searchContentChap(ArrayList<Chap> chaps, String query) {

//        Dialog dialog = new Dialog(this);
//        dialog.setContentView(R.layout.dialog_search);
//        dialog.setTitle("Tìm kiếm");
//        RecyclerView recyclerView = (RecyclerView) dialog.findViewById(R.id.recycleResult);
//        ResultAdapter resultAdapter = new ResultAdapter(MainActivity.this, Search.search(chaps, query));
//        recyclerView.setAdapter(resultAdapter);
//        resultAdapter.setOnClickItemRecycleView(new ChapAdapter.OnClickItemRecycleView() {
//            @Override
//            public void OnClick(View view, int position) {
//                Toast.makeText(MainActivity.this, "Fuck", Toast.LENGTH_SHORT).show();
//
//            }
//        });
//        dialog.show();
//        for (SearchResult searchResult : Search.search(chaps, query)) {
//            Log.e("tieuhoan", searchResult.getSsearchContent());
//        }

        return Search.search(chaps, query);

    }

    private void searchTenChap(ArrayList<Chap> chaps, String query) {
    }

    private void searchTenTruyen(ArrayList<Truyen> truyens, String query) {

    }

    @Override
    public void onBackPressed() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.frameLayout);
        if (fragment instanceof ViewPagerChapFragment) {
            micro.setVisible(false);
        }
        super.onBackPressed();

    }

    @Override
    public boolean onQueryTextSubmit(String query) {

        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.frameLayout);
        if (fragment instanceof ViewPagerFragment) {
            ViewPagerFragment viewPagerFragment = (ViewPagerFragment) fragment;
            KimDungFragment kimDungFragment = (KimDungFragment) viewPagerFragment.getFragments().get(0);
            ArrayList<Truyen> truyens = kimDungFragment.getTruyens();

            searchTenTruyen(truyens, query);

        } else if (fragment instanceof ChapFragment) {

            ChapFragment chapFragment = (ChapFragment) fragment;
            ArrayList<Chap> chaps = chapFragment.getChaps();

            searchTenChap(chaps, query);


        } else
//            if(fragment instanceof ViewPagerChapFragment)

        {
//            ViewPagerChapFragment viewPagerChapFragment = (ViewPagerChapFragment) fragment;
//            ArrayList<Chap> chaps = viewPagerChapFragment.getChaps();

            SearchFragment searchFragment = new SearchFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("SEARCH_RESULT", searchContentChap(chaps , query));
            searchFragment.setArguments(bundle);

            FragmentControl.goToFragmentAddBackStack(R.id.frameLayout, searchFragment, MainActivity.this, getClass().getName());


        }
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case searchView: {
                eventSearchView();
                break;
            }
        }


        return true;
    }

    private void eventSearchView() {
        SearchView searchView = (SearchView) search.getActionView();
        searchView.setOnQueryTextListener(this);
    }
}
