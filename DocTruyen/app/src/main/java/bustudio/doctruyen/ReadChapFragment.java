package bustudio.doctruyen;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;

import customview.WebViewCus;
import model.Chap;

/**
 * Created by TieuHoan on 30/04/2017.
 */

public class ReadChapFragment extends Fragment {

    private Chap chap;
    private WebViewCus webViewCus;
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
        View view = inflater.inflate(R.layout.read_chap_fragment, null, false);
        bindView(view);

        webViewCus.loadData(chap.getContent(), "text/html; charset=utf-8", "utf-8");

//        webView.setBackgroundResource(R.drawable.read);
//        webView.setBackgroundColor(0x00000000);
        tenChap.setText(chap.getNameChap());
        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        tenChap.setTextColor(color);

        return view;
    }

    public void bindView(View view) {

        webViewCus = (WebViewCus) view.findViewById(R.id.webViewReadChap);
        tenChap = (TextView) view.findViewById(R.id.chap);
    }


    public WebViewCus getWebViewCus() {
        return webViewCus;
    }

    public void setWebViewCus(WebViewCus webViewCus) {
        this.webViewCus = webViewCus;
    }
}
