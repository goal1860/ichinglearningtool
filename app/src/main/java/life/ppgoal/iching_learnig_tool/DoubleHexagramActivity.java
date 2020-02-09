package life.ppgoal.iching_learnig_tool;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

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
    ImageView ivDetailLine0, ivDetailLine1, ivDetailLine2, ivDetailLine3, ivDetailLine4, ivDetailLine5;
    TextView tvDetailName, tvDetailPinyin, tvDetailAlias, tvDetailGramText, tvDetailTuanText, tvDetailXiangText, tvDetailLine0, tvDetailLine1, tvDetailLine2, tvDetailLine3, tvDetailLine4, tvDetailLine5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_double_hexagram);
        ivDetailLine0 = findViewById(R.id.ivDetailLine0);
        ivDetailLine1 = findViewById(R.id.ivDetailLine1);
        ivDetailLine2 = findViewById(R.id.ivDetailLine2);
        ivDetailLine3 = findViewById(R.id.ivDetailLine3);
        ivDetailLine4 = findViewById(R.id.ivDetailLine4);
        ivDetailLine5 = findViewById(R.id.ivDetailLine5);
        tvDetailLine0 = findViewById(R.id.tvDetailLineText0);
        tvDetailLine1 = findViewById(R.id.tvDetailLineText1);
        tvDetailLine2 = findViewById(R.id.tvDetailLineText2);
        tvDetailLine3 = findViewById(R.id.tvDetailLineText3);
        tvDetailLine4 = findViewById(R.id.tvDetailLineText4);
        tvDetailLine5 = findViewById(R.id.tvDetailLineText5);
        tvDetailName = findViewById(R.id.tvDetailName);
        tvDetailPinyin = findViewById(R.id.tvDetailPinyin);
        tvDetailAlias = findViewById(R.id.tvDetailAlias);
        tvDetailGramText = findViewById(R.id.tvDetailGramText);
        tvDetailTuanText = findViewById(R.id.tvDetailTuanText);
        tvDetailXiangText = findViewById(R.id.tvDetailXiangText);
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .hide(fragmentManager.findFragmentById(R.id.doubleHexagramDetailFrag))
                .commit();
    }

    @Override
    public void onItemClicked(DoubleHexagram h) {
        tvDetailName.setText(h.getName());
        ivDetailLine0.setImageResource(getLineResourceId(0, h));
        ivDetailLine1.setImageResource(getLineResourceId(1, h));
        ivDetailLine2.setImageResource(getLineResourceId(2, h));
        ivDetailLine3.setImageResource(getLineResourceId(3, h));
        ivDetailLine4.setImageResource(getLineResourceId(4, h));
        ivDetailLine5.setImageResource(getLineResourceId(5, h));
        tvDetailLine0.setText(h.getLineList().get(0).getLineText());
        tvDetailLine1.setText(h.getLineList().get(1).getLineText());
        tvDetailLine2.setText(h.getLineList().get(2).getLineText());
        tvDetailLine3.setText(h.getLineList().get(3).getLineText());
        tvDetailLine4.setText(h.getLineList().get(4).getLineText());
        tvDetailLine5.setText(h.getLineList().get(5).getLineText());
        tvDetailPinyin.setText(h.getPinyin());
        tvDetailAlias.setText(h.getAlias());
        tvDetailGramText.setText(h.getGramText());
        tvDetailTuanText.setText(h.getTuanText());
        tvDetailXiangText.setText(h.getXiangText());
        fragmentManager.beginTransaction()
                .show(fragmentManager.findFragmentById(R.id.doubleHexagramDetailFrag))
                .hide(fragmentManager.findFragmentById(R.id.doubleHexagramListFrag))
                .addToBackStack(null)
                .commit();
    }
    private int getLineResourceId(int index, DoubleHexagram h) {
        if (h.getLineList() == null){
            return R.drawable.yin;
        }
        return h.getLineList().get(index).isPositive()?R.drawable.yang:R.drawable.yin;
    }
}
