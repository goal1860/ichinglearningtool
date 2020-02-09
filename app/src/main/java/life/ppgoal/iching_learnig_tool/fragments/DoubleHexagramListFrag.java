package life.ppgoal.iching_learnig_tool.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

import life.ppgoal.iching_learnig_tool.R;
import life.ppgoal.iching_learnig_tool.adapter.DoubleHexagramAdapter;
import life.ppgoal.iching_learnig_tool.entity.DoubleHexagram;
import life.ppgoal.iching_learnig_tool.entity.DoubleHexagramContainer;

public class DoubleHexagramListFrag extends Fragment {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    List<DoubleHexagram> doubleHexagramList;
    View view;

    public DoubleHexagramListFrag() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView = view.findViewById(R.id.rvDoubleGrams);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        Gson gson = new GsonBuilder().create();
        doubleHexagramList = gson.fromJson(readJson(), DoubleHexagramContainer.class).getList();

        adapter = new DoubleHexagramAdapter(getActivity(), doubleHexagramList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_double_hexagram_list, container, false);

        // Inflate the layout for this fragment
        return view;
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
