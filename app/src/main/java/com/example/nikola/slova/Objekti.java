package com.example.nikola.slova;

import android.content.Context;
import android.content.res.TypedArray;
import android.media.MediaPlayer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikola on 24.7.2016
 */
public class Objekti {
    public static boolean slovaUcitana = false, reciucitane = false;
    public static List<MediaPlayer> zvuciSlova = new ArrayList<>();
    public static List<MediaPlayer> zvuciReci = new ArrayList<>();
    public static List<Rec> reci = new ArrayList<>();
    public static List<Slovo> slova = new ArrayList<>();

     static String []slovaStr = {"A","Б","В","Г","Д","Ђ","Е","Ж","З","И","Ј","К","Л","Љ","М","Н",
            "Њ","О","П","Р","С","Т","Ћ","У","Ф","Х","Ц","Ч","Џ","Ш"};
    final static String []tekstSlike = {"Aвион","Балон","Ветар","Грожђе","Дрво","Ђак","Ексер","Жаба","Зуб",
            "Игла","Јабука","Кућа","Лист","Љуљашка","Мачка","Наочаре","Њива","Оловка","Паприка",
            "Риба","Сунце","Телевизор","Ћурка","Удица","Филм","Хлеб","Ципела","Чаша","Џак","Шатор",
            "Лопта", "Ауто", "Птица", "Вода", "Облак", "Пуж", "Лав", "Књига", "Капа", "Столица", "Миш", "Телефон",
            "Шешир", "Кључ", "Острво", "Ватра", "Мува", "Шума", "Ливада", "Цвет", "Дугме", "Чамац", "Пас",
            "Мердевине", "Чекић", "Беба", "Јагода", "Воз", "Месец", "Пут", "Застава", "Кишобран",
            "Зуб", "Змај", "Бомбона","Њушка","Коњ", "Семафор", "Јастук", "Рак", "Фен", "Мост","Клупа",
            "Жбун","Снег","Киша","Муња","Замак","Двоглед"};

    public static void ucitajSlova(TypedArray zvukovi, Context c){

        for(int i = 0; i < 30; i++ )
            zvuciSlova.add(MediaPlayer.create(c, zvukovi.getResourceId(i, 0)));

//        for(int i=0; i < 30;i++) {
//            slova.add(new Slovo(slovaStr[i],
//                    tekstSlike[i],
////                    slike.getDrawable(i),
////                    slikeUBoji.getDrawable(i),
////                    slikeSlova.getDrawable(i)
////                    , Objekti.zvuciSlova.get(i)));
//        }


        zvukovi.recycle();
        slovaUcitana = true;
    }

    public static void ucitajReci(TypedArray zvukovi, Context c){
        for(int i=0; i < 79;i++)
            zvuciReci.add(MediaPlayer.create(c, zvukovi.getResourceId(i, i)));
        zvukovi.recycle();
        reciucitane = true;
    }

}
