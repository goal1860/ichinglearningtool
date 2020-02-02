package life.ppgoal.iching_learnig_tool;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import life.ppgoal.iching_learnig_tool.adapter.DoubleHexagramAdapter;
import life.ppgoal.iching_learnig_tool.entity.DoubleHexagram;

public class DoubleHexagramActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    List<DoubleHexagram> doubleHexagramList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_double_hexagram);

        recyclerView = findViewById(R.id.rvDoubleGrams);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        doubleHexagramList = new ArrayList<>();
        doubleHexagramList.add(new DoubleHexagram(1, 1, "乾", "乾为天", "元亨利贞"));

        adapter = new DoubleHexagramAdapter(this, doubleHexagramList);
        recyclerView.setAdapter(adapter);
    }


}
