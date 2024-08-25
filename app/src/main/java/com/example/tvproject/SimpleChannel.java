package com.example.tvproject;

import android.text.Spanned;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.egeniq.androidtvprogramguide.entity.ProgramGuideChannel;

public class SimpleChannel implements ProgramGuideChannel {
    private String id;
    private Spanned name;
    private String imageUrl;

    public SimpleChannel(String id, Spanned name, String imageUrl) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
    }

    @Override
    public String getId() {
        return id;
    }


    @Override
    public String getImageUrl() {
        return imageUrl;
    }

    @Override
    public Spanned getName() {
        return name;
    }
}
