package life.ppgoal.iching_learnig_tool;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    Button btnLearnZY;
    Button btnLearnDoubleHexagram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLearnZY = findViewById(R.id.btn_learn_zy);

        btnLearnZY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleContents(v);
            }
        });
        btnLearnDoubleHexagram = findViewById(R.id.btn_learn_double_hexagram);
        btnLearnDoubleHexagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DoubleHexagramActivity.class);
                startActivity(intent);
            }
        });



    }

    private void toggleContents(View v){

            LinearLayout layout = ((LinearLayout) v.getParent()).findViewById(R.id.group0);
            layout.setVisibility(layout.isShown()?View.GONE:View.VISIBLE);
    }
}
