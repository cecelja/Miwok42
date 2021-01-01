package com.example.miwok4;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import org.w3c.dom.Text;

import java.util.ArrayList;



public class WordAdapter extends ArrayAdapter<Word> {
    private int mResourceCol;


    public WordAdapter(Activity context,  ArrayList<Word> words, int colorResource){
        super(context, 0, words);
        mResourceCol = colorResource;
    }

    public int getColor(){
        return mResourceCol;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate
                    (R.layout.list_view_layout, parent, false);
        }

        //Find the Word object on the current position
        Word words = getItem(position);

        //Find the the linearlayout where the 2 textViews are
        LinearLayout textBox = (LinearLayout) listItemView.findViewById(R.id.text_container);
        //Find the correct color to map on the background
        int color = ContextCompat.getColor(getContext(), mResourceCol);
        //Set the textBox to the correct color
        textBox.setBackgroundColor(color);

        //Find the view id of the TextView for miwok words
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        //Now set the text in the TextView with the given words. We have used
        //our custom class method to do this
        miwokTextView.setText(words.getMiwokTranslation());

        //Find the view id of the default text view for english words
        TextView defaultTextView = listItemView.findViewById(R.id.default_text_view);
        //Now lets get the default english word
        defaultTextView.setText(words.getDefaultTranslation());

        //Find the view id of the default image view for the images
        ImageView iconImageView = listItemView.findViewById(R.id.image_view_icon);
        // Check if an image is provided for this word or not
        if (words.hasImage()) {
            iconImageView.setBackgroundColor(Color.parseColor("#FFF7DA"));
            // If an image is available, display the provided image based on the resource ID
            iconImageView.setImageResource(words.getResourceId());
            // Make sure the view is visible
            iconImageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            iconImageView.setVisibility(View.GONE);
        }


        return listItemView;
    }
}
/**
 //Find the the linearlayout where the audio player is
 LinearLayout audioBox = (LinearLayout) listItemView.findViewById(R.id.media_container);
 //Find the correct color to map on the background
 int colorMedia = ContextCompat.getColor(getContext(), mResourceCol);
 //Set the textBox to the correct color
 audioBox.setBackgroundColor(colorMedia);

 //We need to set a listener on the textView
 listItemView.setOnClickListener((new View.OnClickListener() {
 // The code in this method will be executed when the numbers category is clicked on.
 @Override
 public void onClick(View view) {
 //OnClick we need to create a media file
 MediaPlayer mediaPlayer = MediaPlayer.create(WordAdapter.super.getContext(), words.getAudioResourceId());
 mediaPlayer.start();
 }
 }));*/


/**        //Playing the audio resource with a button
 Button playBtn = (Button) listItemView.findViewById(R.id.play_button);
 //Setting the color of the button
 int colorBtn = ContextCompat.getColor(getContext(), mResourceCol);
 //Set the textBox to the correct color
 playBtn.setBackgroundColor(colorBtn);

 playBtn.setOnClickListener((new View.OnClickListener() {
 // The code in this method will be executed when the numbers category is clicked on.
 @Override
 public void onClick(View view) {
 //OnClick we need to create a media file
 MediaPlayer mediaPlayer = MediaPlayer.create(WordAdapter.super.getContext(), words.getAudioResourceId());
 mediaPlayer.start();
 }
 }));*/