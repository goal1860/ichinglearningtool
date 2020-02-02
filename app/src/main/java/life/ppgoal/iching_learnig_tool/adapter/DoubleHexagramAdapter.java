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

public class DoubleHexagramAdapter extends RecyclerView.Adapter<DoubleHexagramAdapter.ViewHolder> {
    private List<DoubleHexagram> hexagramList;

    public DoubleHexagramAdapter(Context context, List<DoubleHexagram> hexagramList) {
        this.hexagramList = hexagramList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivGram;
        TextView tvName;
        TextView tvGramText;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivGram = itemView.findViewById(R.id.ivGram);
            tvName = itemView.findViewById(R.id.tvName);
            tvGramText = itemView.findViewById(R.id.tvGramText);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

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
        holder.ivGram.setImageResource(R.drawable.lines);
    }

    @Override
    public int getItemCount() {
        return hexagramList.size();
    }
}
