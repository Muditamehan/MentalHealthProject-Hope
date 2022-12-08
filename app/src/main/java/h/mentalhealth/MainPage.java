package h.mentalhealth;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainPage extends AppCompatActivity {
    TextView textView1, textView2, textView3, textView4;
    Button button1, button2, button3, button4;

    private ViewGroup mainLayout;
    private ImageView image01, image02;

    private int xDelta;
    private int yDelta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        textView1 = findViewById(R.id.mptext1);
        textView2 = findViewById(R.id.mptext2);
        textView3 = findViewById(R.id.mptext3);
        textView4 = findViewById(R.id.tv3slider1);
        button1 = findViewById(R.id.b1);
        button2 = findViewById(R.id.b2);
        button3 = findViewById(R.id.b3);
        button4 = findViewById(R.id.b4);

        TextView textView=findViewById(R.id.date);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
        //Date date = new Date();
        String currentDateandTime = sdf.format(new Date());
        textView.setText(currentDateandTime);


        mainLayout = (RelativeLayout) findViewById(R.id.main);
        image01 = (ImageView) findViewById(R.id.image01);
        image02 = (ImageView) findViewById(R.id.image02);

        image01.setOnTouchListener(onTouchListener());
        image02.setOnTouchListener(onTouchListener());
    }

    private View.OnTouchListener onTouchListener() {
        return new View.OnTouchListener() {

            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View view, MotionEvent event) {

                final int x = (int) event.getRawX();
                final int y = (int) event.getRawY();

                switch (event.getAction() & MotionEvent.ACTION_MASK) {

                    case MotionEvent.ACTION_DOWN:
                        RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams)
                                view.getLayoutParams();

                        xDelta = x - lParams.leftMargin;
                        yDelta = y - lParams.topMargin;
                        break;

                    case MotionEvent.ACTION_UP:
                        Toast.makeText(MainPage.this,
                                        "We love you!", Toast.LENGTH_SHORT)
                                .show();
                        break;

                    case MotionEvent.ACTION_MOVE:
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view
                                .getLayoutParams();
                        layoutParams.leftMargin = x - xDelta;
                        layoutParams.topMargin = y - yDelta;
                        layoutParams.rightMargin = 0;
                        layoutParams.bottomMargin = 0;
                        view.setLayoutParams(layoutParams);
                        break;
                }

                mainLayout.invalidate();
                return true;
            }
        };
    }


    public void gratitude(View view) {
        Intent i = new Intent(MainPage.this, Gratitude.class);
        startActivity(i);
    }

    public void meditation(View view) {
        Intent i = new Intent(MainPage.this, Meditationn.class);
        startActivity(i);
    }

    public void musicplayer(View view) {
        Intent i = new Intent(MainPage.this, Music.class);
        startActivity(i);
    }

    public void rantcard(View view) {
        Intent i = new Intent(MainPage.this, RantCard.class);
        startActivity(i);
    }
}