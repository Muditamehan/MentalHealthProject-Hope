package h.mentalhealth;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Music extends AppCompatActivity {
    TextView textView1, textView2, textView3;
    Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button10;

    private ViewGroup mainLayout;
    private ImageView image01, image02;

    private int xDelta;
    private int yDelta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        textView1 = findViewById(R.id.mt1);
        textView2 = findViewById(R.id.mt2);
        textView3 = findViewById(R.id.mt3);

        button1 = findViewById(R.id.b1);
        button2 = findViewById(R.id.b2);
        button3 = findViewById(R.id.b3);
        button4 = findViewById(R.id.b4);
        button5 = findViewById(R.id.b5);
        button6 = findViewById(R.id.b6);
        button7 = findViewById(R.id.b7);
        button8 = findViewById(R.id.b8);
        button9 = findViewById(R.id.b9);
        button10 = findViewById(R.id.b10);

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
                        Toast.makeText(Music.this,
                                        "You have a beautiful soul!", Toast.LENGTH_SHORT)
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

    public void adelesomeonelikeyou(View view) {
        //String pos0 = getIntent().getExtras().getString("key0");
        Intent i = new Intent(Music.this, MusicPlayerr.class);
        i.putExtra("key0", "0");
        startActivity(i);
    }

    public void airstreamelectra(View view) {
        Intent i = new Intent(Music.this, MusicPlayerr.class);
        i.putExtra("key0", "1");
        startActivity(i);
    }

    public void allsaintspureshores(View view) {
        Intent i = new Intent(Music.this, MusicPlayerr.class);
        i.putExtra("key0", "2");
        startActivity(i);
    }

    public void barcelonapleasedontgo(View view) {
        Intent i = new Intent(Music.this, MusicPlayerr.class);
        i.putExtra("key0", "3");
        startActivity(i);
    }

    public void coldplaystrawberryswing(View view) {
        Intent i = new Intent(Music.this, MusicPlayerr.class);
        i.putExtra("key0", "4");
        startActivity(i);
    }

    public void djshahmellomaniac(View view) {
        Intent i = new Intent(Music.this, MusicPlayerr.class);
        i.putExtra("key0", "5");
        startActivity(i);
    }

    public void enyawatermark(View view) {
        Intent i = new Intent(Music.this, MusicPlayerr.class);
        i.putExtra("key0", "6");
        startActivity(i);
    }

    public void mozartthemarriageoffigaro(View view) {
        Intent i = new Intent(Music.this, MusicPlayerr.class);
        i.putExtra("key0", "7");
        startActivity(i);
    }

    public void ruedusoleilwecanfly(View view) {
        Intent i = new Intent(Music.this, MusicPlayerr.class);
        i.putExtra("key0", "8");
        startActivity(i);
    }

    public void weightlessmarconiunion(View view) {
        Intent i = new Intent(Music.this, MusicPlayerr.class);
        i.putExtra("key0", "9");
        startActivity(i);
    }
}