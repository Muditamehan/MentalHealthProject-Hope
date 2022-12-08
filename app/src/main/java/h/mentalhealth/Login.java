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

public class Login extends AppCompatActivity {

    TextView textView1, textView2, textView3, textView4, textView5, textView6;
    EditText editText1, editText2;
    Button button1, button2;

    private ViewGroup mainLayout;
    private ImageView image01, image02;

    private int xDelta;
    private int yDelta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textView1 = findViewById(R.id.texv1);
        textView2 = findViewById(R.id.texv2);
        textView3 = findViewById(R.id.texv3);
        textView4 = findViewById(R.id.texv4);
        textView5 = findViewById(R.id.texv5);
        textView6 = findViewById(R.id.tv3slider1);

        editText1 = findViewById(R.id.editt1);
        editText2 = findViewById(R.id.editt2);

        button1 = findViewById(R.id.but1);
        button2 = findViewById(R.id.but2);


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
                        Toast.makeText(Login.this,
                                        "Their life is better because of you!", Toast.LENGTH_SHORT)
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


    public boolean Login(View view) {
        String name1 = editText1.getText().toString();
        String name2 = editText2.getText().toString();

        String password_admin = "mudita";
        String username_admin = "mehan";
        if (name1.equals(username_admin) && name2.equals(password_admin)) {
            Intent i = new Intent(Login.this, DeepBreath.class);
            startActivity(i);
            return true;
        }
        else {
            return false;
        }
    }

    public void SignUp(View view) {
        Intent i = new Intent(Login.this, SignUP.class);
        startActivity(i);
    }
}

