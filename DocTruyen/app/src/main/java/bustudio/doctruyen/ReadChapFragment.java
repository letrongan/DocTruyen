package bustudio.doctruyen;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;

import model.Chap;

/**
 * Created by TieuHoan on 30/04/2017.
 */

public class ReadChapFragment extends Fragment{

    private Chap chap;
    private TextView textView;
    private TextView tenChap;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public ReadChapFragment(Chap chap) {
        this.chap = chap;


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.read_chap_fragment, null, false);
        bindView(view);

        textView.setText(Html.fromHtml(chap.getContent()));
        tenChap.setText(chap.getNameChap());
        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        tenChap.setTextColor(color);

        final NestedScrollView anout = (NestedScrollView) view.findViewById(R.id.scroll);

//        anout.post(new Runnable() {
//                       public void run() {
//                           if ((float) ViewPagerChapFragment.scroll < 1) {
//                               anout.smoothScrollTo(0, (int) ViewPagerChapFragment.scroll * anout.getChildAt(0).getBottom());
//                           }
//                           else {
//                               anout.smoothScrollTo(0, (int) ViewPagerChapFragment.scroll);
//                           }
//                       }
//                   }
//        );
        anout.scrollTo(0, (int) ViewPagerChapFragment.scroll + 1000);


        return view;
    }

    public void bindView(View view) {

        textView = (TextView) view.findViewById(R.id.textViewReadChap);
        tenChap = (TextView) view.findViewById(R.id.chap);
    }



    public String getTextChap() {
        return textView.getText().toString();
    }
}
