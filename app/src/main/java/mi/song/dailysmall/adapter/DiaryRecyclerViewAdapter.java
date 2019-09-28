package mi.song.dailysmall.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import mi.song.dailysmall.R;
import mi.song.dailysmall.activity.DiaryDetailActivity;
import mi.song.dailysmall.model.DailyDiary;

public class DiaryRecyclerViewAdapter extends RecyclerView.Adapter<DiaryRecyclerViewAdapter.ViewHolder> {
    ArrayList<DailyDiary> list; //daily diary 정보를 담는 리스트
    Context context;

    public DiaryRecyclerViewAdapter(Context context, ArrayList<DailyDiary> list){
        this.context = context;
        this.list = list;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtDate, txtTitle;
        int id;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtDate = (TextView) itemView.findViewById(R.id.card_date);
            txtTitle = (TextView) itemView.findViewById(R.id.card_title);

            //Recyclerview item 클릭 이벤트 처리
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(context, DiaryDetailActivity.class);
                    i.putExtra("id", id);
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    context.startActivity(i);
                }
            });
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        ViewHolder vh = new ViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtDate.setText(list.get(position).getDate());
        holder.txtTitle.setText(list.get(position).getTitle());
        holder.id = list.get(position).getId();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
