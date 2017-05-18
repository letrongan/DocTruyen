package bustudio.doctruyen;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ogaclejapan.smarttablayout.SmartTabLayout;

import java.util.ArrayList;

import adapter.TabLayoutAdapter;
import animation.ReaderViewPagerTransformer;

/**
 * Created by TieuHoan on 08/04/2017.
 */

public class ViewPagerFragment extends Fragment implements ViewPager.OnPageChangeListener {
    private ArrayList<Fragment> fragments;
    private ArrayList<String> fragmentTitles;
    private TabLayoutAdapter tabLayoutAdapter;
    private ViewPager viewPager;
    private SmartTabLayout smartTabLayout;
    private Fragment kimDungFragment, favoriteFragment;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.viewpage_fragment, null, false);
        initTabLayout(view);
        return view;
    }

    public void initTabLayout(View view) {


        fragments = new ArrayList<>();
        fragmentTitles = new ArrayList<>();

        kimDungFragment = new KimDungFragment();
        favoriteFragment = new FavoriteFragment();
        addFragmentTabLayout(kimDungFragment, "Kim Dung");
        addFragmentTabLayout(favoriteFragment, "Yêu Thích");


        tabLayoutAdapter = new TabLayoutAdapter(getChildFragmentManager(), fragments, fragmentTitles);
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        viewPager.setAdapter(tabLayoutAdapter);
        viewPager.setPageTransformer(true, new ReaderViewPagerTransformer(ReaderViewPagerTransformer.TransformType.ZOOM));
        viewPager.setOffscreenPageLimit(0);

        smartTabLayout = (SmartTabLayout) view.findViewById(R.id.tabLayout);
        smartTabLayout.setOnPageChangeListener(this);
        smartTabLayout.setViewPager(viewPager);

        // set màu cho tab đầu tiên
        ((TextView) smartTabLayout.getTabAt(0)).setTextColor(Color.BLACK);
    }

    public void addFragmentTabLayout(Fragment fragmentTab, String nameTab) {
        fragments.add(fragmentTab);
        fragmentTitles.add(nameTab);
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        setColorTab(position);
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    public void setColorTab(int position) {
        for (int i = 0; i < fragments.size(); i++) {
            TextView view = (TextView) smartTabLayout.getTabAt(i);
            view.setTextColor(Color.WHITE);
        }

        TextView view1 = (TextView) smartTabLayout.getTabAt(position);
        view1.setTextColor(Color.BLACK);
    }

    public ArrayList<Fragment> getFragments() {
        return fragments;
    }

    public void setFragments(ArrayList<Fragment> fragments) {
        this.fragments = fragments;
    }


}
