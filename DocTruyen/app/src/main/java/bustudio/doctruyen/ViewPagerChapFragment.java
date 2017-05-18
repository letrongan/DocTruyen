package bustudio.doctruyen;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ogaclejapan.smarttablayout.SmartTabLayout;

import java.util.ArrayList;

import adapter.TabLayoutAdapter;
import animation.ReaderViewPagerTransformer;
import model.Chap;
import rule.SpellCheck;

import static bustudio.doctruyen.R.id.tabLayout;

/**
 * Created by TieuHoan on 30/04/2017.
 */

public class ViewPagerChapFragment extends Fragment implements ViewPager.OnPageChangeListener, MenuItem.OnMenuItemClickListener, View.OnClickListener {

    public static ArrayList<Chap> chaps;
    private ReadChapFragment readChapFragment;
    public static ArrayList<Fragment> fragments;
    private ArrayList<String> fragmentTitles;
    private SmartTabLayout smartTabLayout;
    private ViewPager viewPager;
    private int position;
    private static String textChap;
    private EditText edtKiemTra;
    private Button btnKiemTra;
    private TextView tvKiemTra;
    private TextView tvCheck;
    public static float scroll;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            chaps = (ArrayList<Chap>) bundle.getSerializable("READ_CHAPS");
            position = bundle.getInt("POSITION");
            scroll = bundle.getFloat("SCROLL");
            currentPosition = position;
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
            j = i;
            j++;
            readChapFragment = new ReadChapFragment(chaps.get(i));
            fragments.add(readChapFragment);
            fragmentTitles.add("Chương " + j);
        }



        TabLayoutAdapter tabLayoutAdapter = new TabLayoutAdapter(getChildFragmentManager(), fragments, fragmentTitles);
        viewPager.setAdapter(tabLayoutAdapter);
        viewPager.setCurrentItem(position);
        viewPager.setPageTransformer(true, new ReaderViewPagerTransformer(ReaderViewPagerTransformer.TransformType.ZOOM));
        viewPager.setOffscreenPageLimit(0);

        smartTabLayout.setOnPageChangeListener(this);
        smartTabLayout.setViewPager(viewPager);
        smartTabLayout.setSelectedIndicatorColors(position);


        MenuItem menuItem = MainActivity.micro;
        menuItem.setVisible(true);
        menuItem.setOnMenuItemClickListener(this);

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


    @Override
    public void onPageSelected(int position) {

        currentPosition = position;

    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {

        if (item.getItemId() == R.id.menu) {

            textChap = ((ReadChapFragment) fragments.get(currentPosition)).getTextChap();
            createDialog();

        }
        return true;
    }


    @Override
    public void onPageScrollStateChanged(int state) {

    }


    private void eventBtnKiemTra() {
        String submitText = edtKiemTra.getText().toString();

        tvKiemTra.setText(getTuSaiChinhTa(submitText));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnKiemTra: {
                eventBtnKiemTra();
                break;
            }

        }
    }

    public void createDialog() {
        Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.dialog);
        dialog.setTitle("Kiểm tra chính tả");

        edtKiemTra = (EditText) dialog.findViewById(R.id.edtKiemTra);
        btnKiemTra = (Button) dialog.findViewById(R.id.btnKiemTra);
        tvKiemTra = (TextView) dialog.findViewById(R.id.tvKiemTra);
        tvCheck = (TextView) dialog.findViewById(R.id.tvCheck);
        tvCheck.setText("");
        btnKiemTra.setOnClickListener(this);
        tvCheck.setText(getTuSaiChinhTa(textChap));
        dialog.show();
    }

    public String getTuSaiChinhTa(String textChap) {
        String[] words = textChap.split(" ");
        String result = "";
        for (int i = 0; i < words.length; i++) {
            if (SpellCheck.check(words[i])) {
                result += words[i] + " ";
            }
        }
        return result;
    }

    public void setColorTab(int position) {
        for (int i = 0; i < fragments.size(); i++) {
            TextView view = (TextView) smartTabLayout.getTabAt(i);
            view.setTextColor(Color.WHITE);
        }

        TextView view1 = (TextView) smartTabLayout.getTabAt(position);
        view1.setTextColor(Color.BLACK);
    }

    public ArrayList<Chap> getChaps() {
        return chaps;
    }

    public void setChaps(ArrayList<Chap> chaps) {
        this.chaps = chaps;
    }
}
