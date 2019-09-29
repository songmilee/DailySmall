package mi.song.dailysmall.markdown;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MarkDownView extends WebView {

    public MarkDownView(Context context) {
        super(context);
        initView(context);
    }

    public MarkDownView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public MarkDownView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public MarkDownView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
    }

    public void initView(final Context context){

        this.getSettings().setJavaScriptEnabled(true);
        this.getSettings().setUseWideViewPort(true);
        this.getSettings().setLoadWithOverviewMode(true);
        this.getSettings().setDomStorageEnabled(true);

        this.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                Toast.makeText(context, "Page finished", Toast.LENGTH_SHORT).show();
            }
        });
        this.setWebChromeClient(new WebChromeClient());
    }


}
