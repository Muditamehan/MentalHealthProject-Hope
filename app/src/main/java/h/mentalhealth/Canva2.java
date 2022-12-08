package h.mentalhealth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Canva2 extends AppCompatActivity {
    TextView textView1, textView2, textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canva2);

        textView1 = findViewById(R.id.tv1slider2);
        textView2 = findViewById(R.id.tv2slider2);
        textView3 = findViewById(R.id.tv3slider2);
    }
}