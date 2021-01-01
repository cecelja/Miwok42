package com.example.miwok4;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        ArrayList<Word> numbersE = new ArrayList<Word>();

        //Adding our new class to the array
        numbersE.add(new Word("red", "wetetti", R.drawable.color_red, R.raw.color_red));
        numbersE.add(new Word("green", "chokokki", R.drawable.color_green, R.raw.color_green));
        numbersE.add(new Word("brown", "takaakki", R.drawable.color_brown, R.raw.color_brown));
        numbersE.add(new Word("gray", "topoppi", R.drawable.color_gray, R.raw.color_gray));
        numbersE.add(new Word("black", "kululli", R.drawable.color_black, R.raw.color_black));
        numbersE.add(new Word("white", "kelelli", R.drawable.color_white, R.raw.color_white));
        numbersE.add(new Word("dusty yellow", "topiisa", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        numbersE.add(new Word("mustard yellow", "chiwiita", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));

        WordAdapter itemsAdapter = new WordAdapter(this, numbersE, R.color.category_colors);

        ListView listView = (ListView) findViewById(R.id.list_colors);

        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                releaseMediaPlayer();
                // Get the {@link Word} object at the given position the user clicked on
                Word word = numbersE.get(position);

                // Create and setup the {@link MediaPlayer} for the audio resource associated
                // with the current word
                mMediaPlayer = MediaPlayer.create(ColorsActivity.this, word.getAudioResourceId());

                // Start the audio file
                mMediaPlayer.start();
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
