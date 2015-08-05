package in.novopay.mymusicplayer;

import android.media.Image;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mPlayButton;
    private Button mPauseButton;
    private Button mfastforward;
    private Button mrewind;
    private SeekBar mSeekbar;
    private ImageView image;
    private MediaPlayer mediaPlayer;


    MusicHandler musicHandler = new MusicHandler();


    private static final String TAG = "MusicActivity";


    public static int MESSAGE_WAKE_UP_AND_SEEK = 10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPlayButton = (Button) findViewById(R.id.activity_main_play);
        mPauseButton = (Button) findViewById(R.id.activity_main_pause);
        mediaPlayer = MediaPlayer.create(this, R.raw.song);
        mfastforward = (Button) findViewById(R.id.activity_main_fastforward);
        mrewind = (Button) findViewById(R.id.activity_main_rewind);
        mSeekbar = (SeekBar) findViewById(R.id.activity_main_seekbar);
        image = (ImageView) findViewById(R.id.album_cover);

        mSeekbar.setMax(mediaPlayer.getDuration());

        mPlayButton.setBackgroundResource(R.drawable.p);
        mfastforward.setBackgroundResource(R.drawable.ff);
        mrewind.setBackgroundResource(R.drawable.rewind);

        mPlayButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Play is clicked", Toast.LENGTH_SHORT).show();
                if (mPlayButton != null && mediaPlayer.isPlaying() == true) {
                    mediaPlayer.pause();
                    mPlayButton.setBackgroundResource(R.drawable.p);
                }
                else {
                    mediaPlayer.start();
                    mPlayButton.setBackgroundResource(R.drawable.pause);
                }


                musicHandler.sendEmptyMessage(MESSAGE_WAKE_UP_AND_SEEK);
            }


        });


        mfastforward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.seekTo(mediaPlayer.getCurrentPosition() + 10000);


            }
        });

        mrewind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.seekTo(mediaPlayer.getCurrentPosition() - 10000);

            }
        });

        mSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser)
                    mediaPlayer.seekTo(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    class MusicHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == MESSAGE_WAKE_UP_AND_SEEK) {

                if (mediaPlayer != null) {
                    if (mediaPlayer.isPlaying()) {
                        mSeekbar.setProgress(mediaPlayer.getCurrentPosition());
                        sendEmptyMessageDelayed(MESSAGE_WAKE_UP_AND_SEEK, 200);
                    }
                }
            }

            super.handleMessage(msg);
        }
    }
}

