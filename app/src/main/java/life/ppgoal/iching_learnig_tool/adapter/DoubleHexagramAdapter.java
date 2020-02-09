package life.ppgoal.iching_learnig_tool.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import life.ppgoal.iching_learnig_tool.R;
import life.ppgoal.iching_learnig_tool.entity.DoubleHexagram;
import life.ppgoal.iching_learnig_tool.entity.Hexagram;

public class DoubleHexagramAdapter extends RecyclerView.Adapter<DoubleHexagramAdapter.ViewHolder> {
    private List<DoubleHexagram> hexagramList;
    DoubleHexagramItemClickable activity;

    public DoubleHexagramAdapter(Context context, List<DoubleHexagram> hexagramList) {
        this.hexagramList = hexagramList;
        activity = (DoubleHexagramItemClickable) context;
    }

    public interface DoubleHexagramItemClickable {
        void onItemClicked(DoubleHexagram item);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivLine1, ivLine2, ivLine3, ivLine4, ivLine5, ivLine6;
        TextView tvName;
        TextView tvGramText;
        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            ivLine1 = itemView.findViewById(R.id.ivLine1);
            ivLine2 = itemView.findViewById(R.id.ivLine2);
            ivLine3 = itemView.findViewById(R.id.ivLine3);
            ivLine4 = itemView.findViewById(R.id.ivLine4);
            ivLine5 = itemView.findViewById(R.id.ivLine5);
            ivLine6 = itemView.findViewById(R.id.ivLine6);

            tvName = itemView.findViewById(R.id.tvName);
            tvGramText = itemView.findViewById(R.id.tvGramText);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.onItemClicked((DoubleHexagram)(itemView.getTag()));
                }
            });

        }
    }

    @NonNull
    @Override
    public DoubleHexagramAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.double_hexagram_items, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DoubleHexagram h = hexagramList.get(position);
        holder.itemView.setTag(h);
        holder.tvName.setText(h.getName());
        holder.tvGramText.setText(h.getGramText());
        holder.ivLine1.setImageResource(getLineResourceId(0, h));
        holder.ivLine2.setImageResource(getLineResourceId(1, h));
        holder.ivLine3.setImageResource(getLineResourceId(2, h));
        holder.ivLine4.setImageResource(getLineResourceId(3, h));
        holder.ivLine5.setImageResource(getLineResourceId(4, h));
        holder.ivLine6.setImageResource(getLineResourceId(5, h));
    }

    @Override
    public int getItemCount() {
        return hexagramList.size();
    }

    private int getLineResourceId(int index, DoubleHexagram h) {
        if (h.getLineList() == null){
            return R.drawable.yin;
        }
        return h.getLineList().get(index).isPositive()?R.drawable.yang:R.drawable.yin;
    }
}
