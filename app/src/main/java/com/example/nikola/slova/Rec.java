package com.example.nikola.slova;

import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;

/**
 * Created by Nikola  15.7.2016.
 */
public class Rec {

    private String rec;
    private Drawable slikaReci;
    private MediaPlayer zvuk;


    public Rec(String rec, Drawable slikaReci, MediaPlayer zvuk) {
        this.rec = rec;
        this.slikaReci = slikaReci;
        this.zvuk = zvuk;
    }

    public String getRec() {
        return rec;
    }

    public void setRec(String rec) {
        this.rec = rec;
    }

    public Drawable getSlikaReci() {
        return slikaReci;
    }

    public void setSlikaReci(Drawable slikaReci) {
        this.slikaReci = slikaReci;
    }

    public MediaPlayer getZvuk() {
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
