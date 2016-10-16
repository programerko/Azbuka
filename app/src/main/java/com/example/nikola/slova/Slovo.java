package com.example.nikola.slova;

import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.widget.ImageView;

/**
 * Created by Nikola on 10.7.2016
 */
public class Slovo {

    private String slovo,imeSlike ;
    private Drawable slika;
    private Drawable slikaBoja;
    private Drawable slikaSlova;
    private MediaPlayer zvuk;
    private boolean change = false;

    public Slovo(String slovo, Drawable img1, Drawable img2){
        this.slovo = slovo;
        this.slika = img1;
        this.slikaBoja = img2;
    }

    public Slovo(String slovo,String imeSlike, Drawable img1, Drawable img2, Drawable slikaSlova){
        this.slovo = slovo;
        this.slika = img1;
        this.slikaBoja = img2;
        this.slikaSlova = slikaSlova;
        this.imeSlike = imeSlike;
    }

    public Slovo(String slovo,Drawable img2){
        this.slovo = slovo;
        slikaBoja = img2;
    }

    public Slovo( String slovo, String imeSlike, Drawable slikaSlova, Drawable slikaBoja, Drawable slika, MediaPlayer zvuk) {
        this.zvuk = zvuk;
        this.slovo = slovo;
        this.slikaSlova = slika;
        this.slikaBoja = slikaBoja;
        this.slika = slikaSlova;
        this.imeSlike = imeSlike;
    }

    public Drawable getSlika() {
        return slika;
    }

    public void setSlika(Drawable slika) {
        this.slika = slika;
    }

    public String getSlovo() {
        return slovo;
    }

    public void setSlovo(String slovo) {
        this.slovo = slovo;
    }

    public Drawable getSlikaBoja() {
        return slikaBoja;
    }

    public void setSlikaBoja(Drawable slikaBoja) {
        this.slikaBoja = slikaBoja;
    }

    public Drawable getChangeSlika(){
        change = !change;
        if(change)
            return slikaBoja;
        else
            return slika;
    }

    public Drawable getSlikaSlova() {
        return slikaSlova;
    }

    public void setSlikaSlova(Drawable slikaSlova) {
        this.slikaSlova = slikaSlova;
    }

    public String getImeSlike() {
        return imeSlike;
    }

    public void setImeSlike(String imeSlike) {
        this.imeSlike = imeSlike;
    }

    public MediaPlayer getZvuk() {
        return zvuk;
    }

    public void setZvuk(MediaPlayer zvuk) {
        this.zvuk = zvuk;
    }
}
