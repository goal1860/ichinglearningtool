package life.ppgoal.iching_learnig_tool;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import life.ppgoal.iching_learnig_tool.adapter.DoubleHexagramAdapter;
import life.ppgoal.iching_learnig_tool.entity.DoubleHexagram;
import life.ppgoal.iching_learnig_tool.entity.DoubleHexagramContainer;

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
        Gson gson = new GsonBuilder().create();
        doubleHexagramList = gson.fromJson(readJson(), DoubleHexagramContainer.class).getList();

//        doubleHexagramList = new ArrayList<>();
//        doubleHexagramList.add(new DoubleHexagram(1, 1, "乾", "乾为天", "元亨利贞"));


        adapter = new DoubleHexagramAdapter(this, doubleHexagramList);
        recyclerView.setAdapter(adapter);
    }

    private String readJson() {
        InputStream resourceReader = getResources().openRawResource(R.raw.doubhexagrams);
        Writer writer = new StringWriter();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(resourceReader, "UTF-8"));
            String line = reader.readLine();
            while (line != null) {
                writer.write(line);
                line = reader.readLine();
            }
        } catch (Exception e) {
            Log.d( "Unhandled exception", e.getMessage());
        } finally {
            try {
                resourceReader.close();
            } catch (Exception e) {
                Log.d( "Unhandled exception", e.getMessage());
            }
        }

        return writer.toString();
    }

}
