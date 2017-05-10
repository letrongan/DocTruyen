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
import model.Chap;

import static bustudio.doctruyen.R.id.tabLayout;

/**
 * Created by TieuHoan on 30/04/2017.
 */

public class ViewPagerChapFragment extends Fragment implements ViewPager.OnPageChangeListener {

    private Chap chap;
    public static ArrayList<Chap> chaps;
    private ReadChapFragment readChapFragment;
    private ArrayList<Fragment> fragments;
    private ArrayList<String> fragmentTitles;
    private SmartTabLayout smartTabLayout;
    private ViewPager viewPager;
    private int position;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            chap = (Chap) bundle.getSerializable("READ_CHAP");
            chaps = (ArrayList<Chap>) bundle.getSerializable("READ_CHAPS");
            position = bundle.getInt("POSITION");
        }

        fragments = new ArrayList<>();
        fragmentTitles = new ArrayList<>();






    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.viewpage_fragment, null, false);
        bindView(view);

        int j;
        for (int i = 0; i < chaps.size(); i++) {
            j = i + 1;
            readChapFragment = new ReadChapFragment(chaps.get(i));
            fragments.add(readChapFragment);
            fragmentTitles.add("Chương " + j);

        }




        TabLayoutAdapter tabLayoutAdapter = new TabLayoutAdapter(getChildFragmentManager(), fragments, fragmentTitles);
        viewPager.setAdapter(tabLayoutAdapter);
        viewPager.setCurrentItem(position);
        viewPager.setPageTransformer(true, new ReaderViewPagerTransformer(ReaderViewPagerTransformer.TransformType.ZOOM));

        smartTabLayout.setOnPageChangeListener(this);
        smartTabLayout.setViewPager(viewPager);
        smartTabLayout.setSelectedIndicatorColors(position);

//        View view1 = smartTabLayout.getTabAt(position);


        return view;
    }

    public void bindView(View view) {
        smartTabLayout = (SmartTabLayout) view.findViewById(tabLayout);
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
    }

    public static int currentPosition;


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        setColorTab(position);
    }


    static ReadChapFragment readChap;

    @Override
    public void onPageSelected(int position) {

        currentPosition = position;
        readChap = (ReadChapFragment) fragments.get(position);


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
}
