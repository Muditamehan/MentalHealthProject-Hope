package h.mentalhealth;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class BreatheInHoldOut extends AppCompatActivity {

    ProgressBar Progressbar;
    TextView ShowText;
    int progressBarValue = 0;
    Handler handler = new Handler();
    TextView textView1, textView2, textView3, textView4, textView5;
    ImageView imageView1, imageView2;

    private ViewGroup mainLayout;
    private ImageView image01, image02;

    private int xDelta;
    private int yDelta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breathe_in_hold_out);

        textView1 = findViewById(R.id.textvi01);
        textView2 = findViewById(R.id.textvi02);
        textView3 = findViewById(R.id.aaaa);
        textView4 = findViewById(R.id.aaa);
        textView5 = findViewById(R.id.tv3slider1);

        imageView1 = findViewById(R.id.bb);
        imageView2 = findViewById(R.id.bbbbb);

        Progressbar = (ProgressBar) findViewById(R.id.seekBar);
        ShowText = (TextView) findViewById(R.id.textView1);




        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (progressBarValue < 100) {
                    progressBarValue++;

                    handler.post(new Runnable() {

                        @Override
                        public void run() {
                            if (progressBarValue <= 33.3) {
                                Progressbar.setProgress(progressBarValue);
                                ShowText.setText("Breathe in");
                            } else if (progressBarValue <= 66.6) {
                                Progressbar.setProgress(progressBarValue);
                                ShowText.setText("Hold");
                            }
                            else if (progressBarValue < 100) {
                                Progressbar.setProgress(progressBarValue);
                                ShowText.setText("Breathe out");
                            }
                            else {
                                Progressbar.setProgress(progressBarValue);
                                ShowText.setText("Click here");
                            }
                        }
                    });
                    try {
                        Thread.sleep(90);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();




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
                        Toast.makeText(BreatheInHoldOut.this,
                                        "We are here for you!", Toast.LENGTH_SHORT)
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

    public void breathe(View view) {
        ShowText.setText("Great job!!");
        Intent i = new Intent(BreatheInHoldOut.this, MainPage.class);
        startActivity(i);
    }
}