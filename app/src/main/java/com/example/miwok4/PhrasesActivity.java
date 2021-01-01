package com.example.miwok4;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);
        ArrayList<Word> numbersE = new ArrayList<Word>();

        //Adding our new class to the array
        numbersE.add(new Word("Where are you going?", "minto wuksus", R.raw.phrase_where_are_you_going));
        numbersE.add(new Word("What is your name?", "tinnә oyaase'nә",R.raw.phrase_what_is_your_name ));
        numbersE.add(new Word("My name is...", "oyaaset...", R.raw.phrase_my_name_is));
        numbersE.add(new Word("How are you feeling?", "michәksәs?", R.raw.phrase_how_are_you_feeling));
        numbersE.add(new Word("I’m feeling good.", "kuchi achit", R.raw.phrase_im_feeling_good));
        numbersE.add(new Word("Are you coming", "әәnәs'aa?", R.raw.phrase_are_you_coming));
        numbersE.add(new Word("Yes, I’m coming.", "hәә’ әәnәm", R.raw.phrase_yes_im_coming));
        numbersE.add(new Word("I’m coming.", "әәnәm", R.raw.phrase_im_coming));
        numbersE.add(new Word("Let’s go.", "yoowutis", R.raw.phrase_lets_go));
        numbersE.add(new Word("Come here.", "әnni'nem", R.raw.phrase_come_here));

        WordAdapter itemsAdapter = new WordAdapter(this, numbersE, R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.list_phrases);

        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                releaseMediaPlayer();
                // Get the {@link Word} object at the given position the user clicked on
                Word word = numbersE.get(position);

                // Create and setup the {@link MediaPlayer} for the audio resource associated
                // with the current word
                mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, word.getAudioResourceId());

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

}
