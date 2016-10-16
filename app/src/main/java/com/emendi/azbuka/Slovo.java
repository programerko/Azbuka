package com.emendi.azbuka;

import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;

/**
 * Created by Nikola on 10.7.2016
 */
class Slovo {

    private String imeSlike ;
    private Drawable slika;
    private Drawable slikaBoja;
    private Drawable slikaSlova;
    private boolean change = false;


    Slovo(String imeSlike, Drawable slikaSlova, Drawable slikaBoja, Drawable slika) {

        this.slikaSlova = slika;
        this.slikaBoja = slikaBoja;
        this.slika = slikaSlova;
        this.imeSlike = imeSlike;
    }

    Drawable getChangeSlika(){
        change = !change;
        if(change)
            return slikaBoja;
        else
            return slika;
    }

    Drawable getSlikaSlova() {
        return slikaSlova;
    }


    String getImeSlike() {
        return imeSlike;
    }

}
