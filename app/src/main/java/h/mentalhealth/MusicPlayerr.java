package h.mentalhealth;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MusicPlayerr extends AppCompatActivity {

    ImageView play, prev, next, imageView;
    TextView songTitle;
    SeekBar mSeekBarTime, mSeekBarVol;
    static MediaPlayer mMediaPlayer;
    private Runnable runnable;
    private AudioManager mAudioManager;
    int currentIndex = 0;

    private ViewGroup mainLayout;
    private ImageView image01, image02;

    private int xDelta;
    private int yDelta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_playerr);

        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        // initializing views

        play = findViewById(R.id.play);
        prev = findViewById(R.id.prev);
        next = findViewById(R.id.next);
        songTitle = findViewById(R.id.songTitle);
        imageView = findViewById(R.id.imageView);
        mSeekBarTime = findViewById(R.id.seekBarTime);
        mSeekBarVol = findViewById(R.id.seekBarVol);

        // creating an ArrayList to store our songs

        final ArrayList<Integer> songs = new ArrayList<>();

        songs.add(0, R.raw.adelesomeonelikeyou);
        songs.add(1, R.raw.airstreamelectra);
        songs.add(2, R.raw.allsaintspureshores);
        songs.add(3, R.raw.barcelonapleasedontgo);
        songs.add(4, R.raw.coldplaystrawberryswing);
        songs.add(5, R.raw.djshahmellomaniac);
        songs.add(6, R.raw.enyawatermark);
        songs.add(7, R.raw.mozartthemarriageoffigaro);
        songs.add(8, R.raw.ruedusoleilwecanfly);
        songs.add(9, R.raw.weightlessmarconiunion);


        // intializing mediaplayer

        mMediaPlayer = MediaPlayer.create(getApplicationContext(), songs.get(currentIndex));


        String s = getIntent().getExtras().getString("key0");
        Log.d("s" ,  s);

        String s1 = getIntent().getExtras().getString("key0");
        Log.d("s" ,  s1);

        String s2 = getIntent().getExtras().getString("key0");
        Log.d("s" ,  s2);

        if(s.equals("0")){
            MediaPlayer music1 = MediaPlayer.create(MusicPlayerr.this, R.raw.adelesomeonelikeyou);
            music1.start();
        }
        if(s1.equals("1")){
            MediaPlayer music2 = MediaPlayer.create(MusicPlayerr.this, R.raw.airstreamelectra);
            music2.start();
        }
        if(s2.equals(2)){
            MediaPlayer music3 = MediaPlayer.create(MusicPlayerr.this, R.raw.allsaintspureshores);
            music3.start();
        }
        else if(s.equals(3)){
            MediaPlayer music4 = MediaPlayer.create(MusicPlayerr.this, R.raw.barcelonapleasedontgo);
            music4.start();
        }
        else if(s.equals(4)){
            MediaPlayer music5 = MediaPlayer.create(MusicPlayerr.this, R.raw.coldplaystrawberryswing);
            music5.start();
        }
        else if(s.equals(5)){
            MediaPlayer music6 = MediaPlayer.create(MusicPlayerr.this, R.raw.djshahmellomaniac);
            music6.start();
        }
        else if(s.equals(6)){
            MediaPlayer music7 = MediaPlayer.create(MusicPlayerr.this, R.raw.enyawatermark);
            music7.start();
        }
        else if(s.equals(7)){
            MediaPlayer music8 = MediaPlayer.create(MusicPlayerr.this, R.raw.mozartthemarriageoffigaro);
            music8.start();
        }
        else if(s.equals(8)){
            MediaPlayer music9 = MediaPlayer.create(MusicPlayerr.this, R.raw.ruedusoleilwecanfly);
            music9.start();
        }
        else {
            MediaPlayer music10 = MediaPlayer.create(MusicPlayerr.this, R.raw.weightlessmarconiunion);
            music10.start();
        }



        // seekbar volume

        int maxV = mAudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int curV = mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        mSeekBarVol.setMax(maxV);
        mSeekBarVol.setProgress(curV);

        mSeekBarVol.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        //above seekbar volume
        //

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSeekBarTime.setMax(mMediaPlayer.getDuration());
                if (mMediaPlayer != null && mMediaPlayer.isPlaying()) {
                    mMediaPlayer.pause();
                    play.setImageResource(R.drawable.ic_baseline_play_arrow_24);
                } else {
                    mMediaPlayer.start();
                    play.setImageResource(R.drawable.ic_baseline_play_circle_outline_24);
                }

                songNames();

            }
        });


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mMediaPlayer != null) {
                    play.setImageResource(R.drawable.ic_baseline_play_arrow_24);
                }

                if (currentIndex < songs.size() - 1) {
                    currentIndex++;
                } else {
                    currentIndex = 0;
                }

                if (mMediaPlayer.isPlaying()) {
                    mMediaPlayer.stop();
                }

                mMediaPlayer = MediaPlayer.create(getApplicationContext(), songs.get(currentIndex));

                mMediaPlayer.start();
                songNames();

            }
        });


        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mMediaPlayer != null) {
                    play.setImageResource(R.drawable.ic_baseline_play_arrow_24);
                }

                if (currentIndex > 0) {
                    currentIndex--;
                } else {
                    currentIndex = songs.size() - 1;
                }
                if (mMediaPlayer.isPlaying()) {
                    mMediaPlayer.stop();
                }

                mMediaPlayer = MediaPlayer.create(getApplicationContext(), songs.get(currentIndex));
                mMediaPlayer.start();
                songNames();

            }
        });

    }

    private void songNames() {
        if (currentIndex == 0) {
            songTitle.setText("Someone Like You");
            imageView.setImageResource(R.drawable.adelesomeonelikeyou);
        }
        if (currentIndex == 1) {
            songTitle.setText("Air Stream");
            imageView.setImageResource(R.drawable.airstreamelectra);
        }
        if (currentIndex == 2) {
            songTitle.setText("All Saints");
            imageView.setImageResource(R.drawable.allsaintspureshoress);
        }
        if (currentIndex == 3) {
            songTitle.setText("Please Don't Go");
            imageView.setImageResource(R.drawable.barcelonapleasedontgo);
        }
        if (currentIndex == 4) {
            songTitle.setText("Strawberry Swing");
            imageView.setImageResource(R.drawable.coldplaystrawberryswing);
        }
        if (currentIndex == 5) {
            songTitle.setText("Marshmellow Maniac");
            imageView.setImageResource(R.drawable.djshahmellomaniac);
        }
        if (currentIndex == 6) {
            songTitle.setText("Watermark");
            imageView.setImageResource(R.drawable.enyawatermark);
        }
        if (currentIndex == 7) {
            songTitle.setText("Mozart");
            imageView.setImageResource(R.drawable.themarriageoffigaro);
        }
        if (currentIndex == 8) {
            songTitle.setText("We Can Fly");
            imageView.setImageResource(R.drawable.ruedusoleilwecanfly);
        }
        if (currentIndex == 9) {
            songTitle.setText("Weightless");
            imageView.setImageResource(R.drawable.weightlessmarconiunion);
        }


        // seekbar duration
        mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mSeekBarTime.setMax(mMediaPlayer.getDuration());
                mMediaPlayer.start();
            }
        });

        mSeekBarTime.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    mMediaPlayer.seekTo(progress);
                    mSeekBarTime.setProgress(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mMediaPlayer != null) {
                    try {
                        if (mMediaPlayer.isPlaying()) {
                            Message message = new Message();
                            message.what = mMediaPlayer.getCurrentPosition();
                            handler.sendMessage(message);
                            Thread.sleep(1000);
                        }
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
                        Toast.makeText(MusicPlayerr.this,
                                        "We're so happy to see you here!", Toast.LENGTH_SHORT)
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


    @SuppressLint("Handler Leak") Handler handler = new Handler() {
        @Override
        public void handleMessage  (Message msg) {
            mSeekBarTime.setProgress(msg.what);
        }
    };
}