package mi.song.dailysmall.base;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import mi.song.dailysmall.R;
import mi.song.dailysmall.adapter.DiaryRecyclerViewAdapter;
import mi.song.dailysmall.model.DailyDiary;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    @Override
    protected void init(){

        //set fab button
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.main_fab);
        fab.setOnClickListener(fabClick);

        //set recycler view
        RecyclerView rv = (RecyclerView) findViewById(R.id.main_recycler_view);
        ArrayList<DailyDiary> diaryList = new ArrayList<>();
        DiaryRecyclerViewAdapter drAdapter = new DiaryRecyclerViewAdapter(getApplicationContext(), diaryList);
        rv.setAdapter(drAdapter);

        for(int i = 0; i < 5; i++){
            DailyDiary temp = new DailyDiary(i, "test " + i, Integer.toString(i));
            diaryList.add(temp);
        }

    }

    View.OnClickListener fabClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(), "fab click event", Toast.LENGTH_SHORT).show();
        }
    };
}
