package h.mentalhealth;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Gratitude extends AppCompatActivity {

    private ViewGroup mainLayout;
    private ImageView image01, image02;

    private int xDelta;
    private int yDelta;

    TextView textView1, textView2, textView3, textView4, textView5, textView6;
    EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7, editText8, editText9, editText10, editText11, editText12, editText13, editText14;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gratitude);

        textView1 = findViewById(R.id.t001);
        textView2 = findViewById(R.id.t002);
        textView3 = findViewById(R.id.t003);
        textView4 = findViewById(R.id.t004);
        textView5 = findViewById(R.id.t005);
        textView6 = findViewById(R.id.tv3slider1);

        editText1 = findViewById(R.id.e001);
        editText2 = findViewById(R.id.e002);
        editText3 = findViewById(R.id.e003);
        editText4 = findViewById(R.id.e004);
        editText5 = findViewById(R.id.e005);
        editText6 = findViewById(R.id.e006);
        editText7 = findViewById(R.id.e007);
        editText8 = findViewById(R.id.e008);
        editText9 = findViewById(R.id.e009);
        editText10 = findViewById(R.id.e0010);
        editText11 = findViewById(R.id.e0011);
        editText12 = findViewById(R.id.e0012);
        editText13 = findViewById(R.id.e0013);
        editText14 = findViewById(R.id.e0014);

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
                        Toast.makeText(Gratitude.this,
                                        "You are so much more than they know!", Toast.LENGTH_SHORT)
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
    }
