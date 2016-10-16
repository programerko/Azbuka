package com.emendi.azbuka;

import android.content.res.TypedArray;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ReciActivity extends AppCompatActivity {

    TextView textReci;
    ImageView slikaReci;
    Button nextBtn, playBtn;
    TypedArray slike;
    List<Rec> reci;
    Rec trenutnaRec;
    MediaPlayer trenutniZvuk;
    TypedArray zvukrec ;
    int ir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reci);

        textReci = (TextView) findViewById(R.id.rec_txt);
        slikaReci = (ImageView) findViewById(R.id.slika);
        nextBtn = (Button) findViewById(R.id.next);
        playBtn = (Button) findViewById(R.id.play);

        slike = getResources().obtainTypedArray(R.array.slike_slova);
        reci = new ArrayList<>();

        zvukrec = getResources().obtainTypedArray(R.array.zvuci_reci);
        final String []slikeStr = {"Aвион","Балон","Ветар","Грожђе","Дрво","Ђак","Ексер","Жаба","Зуб",
                "Игла","Јабука","Кућа","Лист","Љуљашка","Мачка","Наочаре","Њива","Оловка","Паприка",
                "Риба","Сунце","Телевизор","Ћурка","Удица","Филм","Хлеб","Ципела","Чаша","Џак","Шатор",
        "Лопта", "Ауто", "Птица", "Вода", "Облак", "Пуж", "Лав", "Књига", "Капа", "Столица", "Миш", "Телефон",
        "Шешир", "Кључ", "Острво", "Ватра", "Мува", "Шума", "Ливада", "Цвет", "Дугме", "Чамац", "Пас",
                "Мердевине", "Чекић", "Беба", "Јагода", "Воз", "Месец", "Пут", "Застава", "Кишобран",
                "Зуб", "Змај", "Бомбона","Њушка","Коњ", "Семафор", "Јастук", "Рак", "Фен", "Мост","Клупа",
        "Жбун","Снег","Киша","Муња","Замак","Двоглед"};

        trenutniZvuk = MediaPlayer.create(ReciActivity.this, zvukrec.getResourceId(ir, 0));
        trenutnaRec = new Rec(slikeStr[ir],slike.getDrawable(ir), trenutniZvuk);



        textReci.setText(trenutnaRec.getRec());
        slikaReci.setImageDrawable(trenutnaRec.getSlikaReci());



        nextBtn.setSoundEffectsEnabled(false);
        playBtn.setSoundEffectsEnabled(false);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                trenutniZvuk.release();
                ir++;
                if(ir>78) ir= 0;
                trenutniZvuk = MediaPlayer.create(ReciActivity.this, zvukrec.getResourceId(ir, 0));
                trenutnaRec = new Rec(slikeStr[ir],slike.getDrawable(ir), trenutniZvuk);

                textReci.setText(trenutnaRec.getRec());
                slikaReci.setImageDrawable(trenutnaRec.getSlikaReci());
            }
        });

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trenutnaRec.getZvuk().start();
                System.out.println("RB : "+ir);
            }
        });

    }

}
