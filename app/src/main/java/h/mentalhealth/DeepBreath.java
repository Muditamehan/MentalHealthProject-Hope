package h.mentalhealth;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class DeepBreath extends AppCompatActivity {

    TableRow tableRow1, tableRow2;
    TextView textView1, textView2, textView3, textView4;
    Button button1, button2;

    private ViewGroup mainLayout;
    private ImageView image01, image02;

    private int xDelta;
    private int yDelta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deep_breath);

        tableRow1 = findViewById(R.id.tableRow1);
        tableRow2 = findViewById(R.id.tableRow2);

        textView1 = findViewById(R.id.tv1);
        textView2 = findViewById(R.id.tv2);
        textView3 = findViewById(R.id.tv3);
        textView4 = findViewById(R.id.tv3slider1);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

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
                        Toast.makeText(DeepBreath.this,
                                        "You're amazing!", Toast.LENGTH_SHORT)
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


    static int TIMEOUT_MILLIS = 3000;
    public void activity(View view) {
        String name1 = textView1.getText().toString();
        textView1.setText("Let's take");

        String name2 = textView2.getText().toString();
        textView2.setText("3");

        String name3 = textView3.getText().toString();
        textView3.setText("breaths together.");


        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                Intent i = new Intent(DeepBreath.this, BreatheInHoldOut.class);
                startActivity(i);

                // close this activity
                finish();
            }
        }, TIMEOUT_MILLIS);
    }


    public void nope(View view) {
        Intent i = new Intent(DeepBreath.this, MainPage.class);
        startActivity(i);
    }

        }