package life.ppgoal.iching_learnig_tool;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
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

public class DoubleHexagramActivity extends AppCompatActivity implements DoubleHexagramAdapter.DoubleHexagramItemClickable{

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_double_hexagram);

        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .hide(fragmentManager.findFragmentById(R.id.doubleHexagramDetailFrag))
                .commit();
    }

    @Override
    public void onItemClicked(DoubleHexagram item) {
        fragmentManager.beginTransaction()
                .show(fragmentManager.findFragmentById(R.id.doubleHexagramDetailFrag))
                .hide(fragmentManager.findFragmentById(R.id.doubleHexagramListFrag))
                .addToBackStack(null)
                .commit();
    }
}
