package h.mentalhealth;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SignUP extends AppCompatActivity {
    TextView textView1, textView2, textView3, textView4, textView5, textView6, textView7;
    EditText editText1, editText2, editText3, editText4, editText5;
    Button button1;

    private ViewGroup mainLayout;
    private ImageView image01, image02;

    private int xDelta;
    private int yDelta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        textView1 = findViewById(R.id.TV01);
        textView2 = findViewById(R.id.TV02);
        textView3 = findViewById(R.id.TV03);
        textView4 = findViewById(R.id.TV04);
        textView5 = findViewById(R.id.TV05);
        textView6 = findViewById(R.id.TV06);
        textView7 = findViewById(R.id.TV07);

        editText1 = findViewById(R.id.ET01);
        editText2 = findViewById(R.id.ET02);
        editText3 = findViewById(R.id.ET03);
        editText4 = findViewById(R.id.ET04);
        editText5 = findViewById(R.id.ET05);

        button1 = findViewById(R.id.B01);


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
                        Toast.makeText(SignUP.this,
                                        "Everything's going to work out!", Toast.LENGTH_SHORT)
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


    public boolean Register(View view) {

        String name1 = editText1.getText().toString();
        String name2 = editText2.getText().toString();
        String name3 = editText3.getText().toString();
        String name4 = editText4.getText().toString();
        String name5 = editText5.getText().toString();


        if (name1.isEmpty()) {
            return false;
        } else if (name2.isEmpty()) {
            return false;
        } else if (name3.isEmpty()) {
            return false;
        } else if (name4.isEmpty()) {
            return false;
        } else if (name5.isEmpty()) {
            return false;
        }

        Intent i = new Intent(SignUP.this, Symptoms.class);
        startActivity(i);
        return true;
    }
}