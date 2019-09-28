package mi.song.dailysmall.activity;

import android.os.Bundle;
import android.widget.TextView;

import mi.song.dailysmall.R;
import mi.song.dailysmall.base.BaseActivity;

public class DiaryDetailActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_detail);


        init();
    }

    @Override
    protected void init() {
        TextView temp = (TextView) findViewById(R.id.temp_id);

        Bundle b = getIntent().getExtras();
        int id = b.getInt("id");

        temp.setText(String.format("Hello %s", id));
    }
}
