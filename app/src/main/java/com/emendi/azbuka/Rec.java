package com.emendi.azbuka;

import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;


// Created by Nikola  15.7.2016.

class Rec {

    private String rec;
    private Drawable slikaReci;
    private MediaPlayer zvuk;


    Rec(String rec, Drawable slikaReci, MediaPlayer zvuk) {
        this.rec = rec;
        this.slikaReci = slikaReci;
        this.zvuk = zvuk;
    }

    String getRec() {
        return rec;
    }

    public void setRec(String rec) {
        this.rec = rec;
    }

    Drawable getSlikaReci() {
        return slikaReci;
    }

    public void setSlikaReci(Drawable slikaReci) {
        this.slikaReci = slikaReci;
    }

    MediaPlayer getZvuk() {
        return zvuk;
    }

    public void setZvuk(MediaPlayer zvuk) {
        this.zvuk = zvuk;
    }

    @Override
    public String toString() {
        return getRec() + ", zvuk: " + getZvuk().toString();
    }
}
