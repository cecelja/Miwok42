package com.example.miwok4;

import android.graphics.drawable.Drawable;

public class Word {

    // Default translation of the word
    private String mDefaultTranslation;

    //Miwok translation of the word
    private String mMiwokTranslation;


    /** Image resource ID for the word */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /** Constant value that represents no image was provided for this word */
    private static final int NO_IMAGE_PROVIDED = -1;

    private int mAudioResourceId;

    /**Now we need to set up our construtor
     *
     * @param defaultTranslation is the word in a language the user is familiar with.
     *
     * @param miwokTranslation is the word translated into Miwok language.
     * **/
    public Word(String defaultTranslation, String miwokTranslation, int image, int audio){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = image;
        mAudioResourceId = audio;
    }
    public Word(String defaultTranslation, String miwokTranslation){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
    }

    public Word(String defaultTranslation2, String miwokTranslation2, int audio){
        mDefaultTranslation = defaultTranslation2;
        mMiwokTranslation = miwokTranslation2;
        mAudioResourceId = audio;
    }

    /**
     * Get the Miwok translation of the word.
     * */
    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }

    /**
     * Get the default translation of the word.
     * */
    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }

    /**
     * Get the image for the assigned word.
     * */
    public int getResourceId(){ return mImageResourceId; }

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    /**
     * Get the resource for the media file.
     * */
    public int getAudioResourceId(){
        return mAudioResourceId;
    }


}
