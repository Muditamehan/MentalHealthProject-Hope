package h.mentalhealth;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Meditationn extends AppCompatActivity {

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
        setContentView(R.layout.activity_meditationn);


        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        // initializing views

        play = findViewById(R.id.playy);
        prev = findViewById(R.id.prevv);
        next = findViewById(R.id.nextt);
        songTitle = findViewById(R.id.songTitlee);
        imageView = findViewById(R.id.imageVieww);
        mSeekBarTime = findViewById(R.id.seekBarTimee);
        mSeekBarVol = findViewById(R.id.seekBarVoll);

        // creating an ArrayList to store our songs

        final ArrayList<Integer> songs = new ArrayList<>();

        songs.add(0, R.raw.meditation);
        songs.add(1, R.raw.calmandpeaceful);
        songs.add(2, R.raw.cozyplacechillbackgroundmusic);
        songs.add(3, R.raw.eveningimprovisationwithethera);
        songs.add(4, R.raw.peritunematerialsakuya);
        songs.add(5, R.raw.sunsetlandscape);


        // intializing mediaplayer

        mMediaPlayer = MediaPlayer.create(getApplicationContext(), songs.get(currentIndex));



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
            songTitle.setText("Meditation");
            imageView.setImageResource(R.drawable.med);
        }
        if (currentIndex == 1) {
            songTitle.setText("Calm And Peaceful");
            imageView.setImageResource(R.drawable.calmandpeaceful);
        }
        if (currentIndex == 2) {
            songTitle.setText("Cozy And Chill");
            imageView.setImageResource(R.drawable.chill);
        }
        if (currentIndex == 3) {
            songTitle.setText("Evening Improvisation With Ethera");
            imageView.setImageResource(R.drawable.improvisation);
        }
        if (currentIndex == 4) {
            songTitle.setText("Peritune Material Sakuya");
            imageView.setImageResource(R.drawable.peritune);
        }
        if (currentIndex == 5) {
            songTitle.setText("Sunset Landscape");
            imageView.setImageResource(R.drawable.sunset);
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
                        Toast.makeText(Meditationn.this,
                                        "You've been through enough, relax a little", Toast.LENGTH_SHORT)
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


    @SuppressLint("Handler Leak")
    Handler handler = new Handler() {
        @Override
        public void handleMessage  (Message msg) {
            mSeekBarTime.setProgress(msg.what);
        }
    };
}