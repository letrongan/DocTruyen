package customview;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;

/**
 * Created by TieuHoan on 09/05/2017.
 */

public class WebViewCus  extends WebView{

    private OnScrollChangedCallback mOnScrollChangedCallback;


    public WebViewCus(Context context) {
        super(context);
    }


    public WebViewCus(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public WebViewCus(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
    }

    public OnScrollChangedCallback getOnScrollChangedCallback()
    {
        return mOnScrollChangedCallback;
    }

    public void setOnScrollChangedCallback(final OnScrollChangedCallback onScrollChangedCallback)
    {
        mOnScrollChangedCallback = onScrollChangedCallback;
    }


    public static interface OnScrollChangedCallback
    {
        public void onScroll(int l, int t);
    }
}


