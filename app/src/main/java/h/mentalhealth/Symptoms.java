package h.mentalhealth;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class Symptoms extends AppCompatActivity {

    TextView textView1, textView2, textView3;
    Button Button1, Button2, Button3, Button4, Button5, Button6, Button7,  Button8, Button9, Button10, Button11, Button12, Button13, Button14, Button15, Button16, Button17, Button18;
    Button button1;


    private ViewGroup mainLayout;
    private ImageView image01, image02;

    private int xDelta;
    private int yDelta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptoms);

        textView1 = findViewById(R.id.TV1);
        textView2 = findViewById(R.id.idTVDB2);
        textView3 = findViewById(R.id.yo);

        Button1 = findViewById(R.id.idRB1);
        Button2 = findViewById(R.id.idRB2);
        Button3 = findViewById(R.id.idRB3);
        Button4 = findViewById(R.id.idRB4);
        Button5 = findViewById(R.id.idRB5);
        Button6 = findViewById(R.id.idRB6);
        Button7 = findViewById(R.id.idRB7);
        Button8 = findViewById(R.id.idRB8);
        Button9 = findViewById(R.id.idRB9);
        Button10 = findViewById(R.id.idRB10);
        Button11 = findViewById(R.id.idRB11);
        Button12 = findViewById(R.id.idRB12);
        Button13 = findViewById(R.id.idRB13);
        Button14 = findViewById(R.id.idRB14);
        Button15 = findViewById(R.id.idRB15);
        Button16 = findViewById(R.id.idRB16);
        Button17 = findViewById(R.id.idRB17);
        Button18 = findViewById(R.id.idRB18);

        button1 = findViewById(R.id.idB);


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
                        Toast.makeText(Symptoms.this,
                                        "The first step is always the hardest!", Toast.LENGTH_SHORT)
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

    public void moreinfodepression(View view) {
        String name1 = textView2.getText().toString();
        textView2.setText("Depression is a mood disorder that causes a persistent feeling of sadness and loss of interest.");
    }

    public void moreinfoanxiety(View view) {
        String name2 = textView2.getText().toString();
        textView2.setText("Anxiety is the mind and body's reaction to stressful, dangerous, or unfamiliar situations. It's the sense of uneasiness, distress, or dread you feel before a significant event.");
    }

    public void moreinfotrauma(View view) {
        String name3 = textView2.getText().toString();
        textView2.setText("An emotional response to a terrible event like an accident, rape, or natural disaster.");
    }

    public void moreinfoangermanagement(View view) {
        String name4 = textView2.getText().toString();
        textView2.setText("The process of learning to recognize signs that you're becoming angry, and taking action to calm down and deal with the situation in a productive way.");
    }

    public void moreinfoselfesteem(View view) {
        String name5 = textView2.getText().toString();
        textView2.setText("How a person thinks and feels about their own qualities and characteristics, either high or low.");
    }

    public void moreinfostress(View view) {
        String name6 = textView2.getText().toString();
        textView2.setText("A state of mental or emotional strain or tension resulting from adverse or demanding circumstances.");
    }

    public void moreinfopersonalgrowth(View view) {
        String name7 = textView2.getText().toString();
        textView2.setText("Activities that develop a person's capabilities and potential, build human capital, facilitate employability, and enhance quality of life and the realization of dreams and aspirations.");
    }

    public void moreinfoaddiction(View view) {
        String name8 = textView2.getText().toString();
        textView2.setText("The inability to stop using a substance or engaging in a behavior even though it is causing psychological and physical harm.");
    }

    public void moreinfosleep(View view) {
        String name9 = textView2.getText().toString();
        textView2.setText("To rest with eyes closed in a temporary state of inactivity.");
    }

    public void moreinfogrief(View view) {
        String name10 = textView2.getText().toString();
        textView2.setText("An instance or cause of intense sorrow.");
    }

    public void moreinfoobsessivecompulsivedisorder(View view) {
        String name11 = textView2.getText().toString();
        textView2.setText("Experiencing persistent, intrusive thoughts that cause distress and performs repetitive physical or mental acts in order to prevent or counteract the thoughts and relieve the distress.");
    }

    public void moreinfoparenting(View view) {
        String name12 = textView2.getText().toString();
        textView2.setText("The intricacies of raising a child and not exclusively for a biological relationship.");
    }

    public void moreinfoadjustmenttransitions(View view) {
        String name13 = textView2.getText().toString();
        textView2.setText("The process or a period of changing from one state or condition to another.");
    }

    public void moreinfolgbtqi(View view) {
        String name14 = textView2.getText().toString();
        textView2.setText("Lesbian, gay, bisexual, transgender, queer and intersex (LGBTQI) persons facing specific obstacles when it comes to accessing many of their rights, including their right to social protection.");
    }

    public void moreinfocouple(View view) {
        String name15 = textView2.getText().toString();
        textView2.setText("Counseling for couples who are in a relationship, married or not.");
    }

    public void moreinfoconfidence(View view) {
        String name16 = textView2.getText().toString();
        textView2.setText("A feeling of self-assurance arising from an appreciation of one's own abilities or qualities.");
    }

    public void moreinfowork(View view) {
        String name17 = textView2.getText().toString();
        textView2.setText("To give assistance.");
    }

    public void moreinfolrelationships(View view) {
        String name18 = textView2.getText().toString();
        textView2.setText("Receiving assistance with working through relationship problems and resolving conflict.");
    }


    public void done(View view) {
        Intent i = new Intent(Symptoms.this, MainPage.class);
        startActivity(i);
    }
}