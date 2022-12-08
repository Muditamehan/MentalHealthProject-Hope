package h.mentalhealth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Canva4 extends AppCompatActivity {
    TextView textView1, textView2, textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canva4);

        textView1 = findViewById(R.id.tv1slider4);
        textView2 = findViewById(R.id.tv2slider4);
        textView3 = findViewById(R.id.tv3slider4);
    }
}