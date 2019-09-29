package mi.song.dailysmall.activity;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

import mi.song.dailysmall.R;
import mi.song.dailysmall.base.BaseActivity;
import mi.song.dailysmall.markdown.MarkDownView;

public class DiaryDetailActivity extends BaseActivity {
    MarkDownView mdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_detail);


        init();
    }

    @Override
    protected void init() {
        mdView = (MarkDownView) findViewById(R.id.detail_mdview);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mdView.loadUrl("https://www.google.com");
    }
}
