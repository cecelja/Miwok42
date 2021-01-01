package com.example.miwok4;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
    /** Handles playback of all the sound files */
    private MediaPlayer mMediaPlayer;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        ArrayList<Word> numbersE = new ArrayList<Word>();

        //Adding our new class to the array
        numbersE.add(new Word("one", "lutti", R.drawable.number_one, R.raw.number_one));
        numbersE.add(new Word("two", "otiiko", R.drawable.number_two, R.raw.number_two));
        numbersE.add(new Word("three", "tolookosu", R.drawable.number_three, R.raw.number_three));
        numbersE.add(new Word("four", "oyyisa", R.drawable.number_four, R.raw.number_four));
        numbersE.add(new Word("five", "massokka", R.drawable.number_five,R.raw.number_five));
        numbersE.add(new Word("six", "temmokka", R.drawable.number_six, R.raw.number_six));
        numbersE.add(new Word("seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven));
        numbersE.add(new Word("eight", "kawinta", R.drawable.number_eight, R.raw.number_eight));
        numbersE.add(new Word("nine", "wo'e", R.drawable.number_nine, R.raw.number_nine));
        numbersE.add(new Word("ten", "na'aacha", R.drawable.number_ten, R.raw.number_ten));

        WordAdapter itemsAdapter = new WordAdapter(this, numbersE, R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //It cleans up the resources for other purposes in the app
                releaseMediaPlayer();
                // Get the {@link Word} object at the given position the user clicked on
                Word word = numbersE.get(position);

                // Create and setup the {@link MediaPlayer} for the audio resource associated
                // with the current word
                mMediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getAudioResourceId());

                // Start the audio file
                mMediaPlayer.start();

                mMediaPlayer.setOnCompletionListener(mCompletionListener);

            }
        });
        
    }

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

}
