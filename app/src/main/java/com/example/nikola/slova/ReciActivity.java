package com.example.nikola.slova;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ReciActivity extends AppCompatActivity {

    TextView textReci;
    ImageView slikaReci;
    Button nextBtn, playBtn;
    TypedArray slike;
    List<Rec> reci;
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


        String []slikeStr = {"Aвион","Балон","Ветар","Грожђе","Дрво","Ђак","Ексер","Жаба","Зуб",
                "Игла","Јабука","Кућа","Лист","Љуљашка","Мачка","Наочаре","Њива","Оловка","Паприка",
                "Риба","Сунце","Телевизор","Ћурка","Удица","Филм","Хлеб","Ципела","Чаша","Џак","Шатор",
        "Лопта", "Ауто", "Птица", "Вода", "Облак", "Пуж", "Лав", "Књига", "Капа", "Столица", "Миш", "Телефон",
        "Шешир", "Кључ", "Острво", "Ватра", "Мува", "Шума", "Ливада", "Цвет", "Дугме", "Чамац", "Пас",
                "Мердевине", "Чекић", "Беба", "Јагода", "Воз", "Месец", "Пут", "Застава", "Кишобран",
                "Зуб", "Змај", "Бомбона","Њушка","Коњ", "Семафор", "Јастук", "Рак", "Фен", "Мост","Клупа",
        "Жбун","Снег","Киша","Муња","Замак","Двоглед"};


        for(int i=0; i < 79;i++)
            reci.add(new Rec(slikeStr[i], slike.getDrawable(i), Objekti.zvuciReci.get(i) ));


        textReci.setText(reci.get(0).getRec());
        slikaReci.setImageDrawable(reci.get(0).getSlikaReci());
        ir = 0;

        nextBtn.setSoundEffectsEnabled(false);
        playBtn.setSoundEffectsEnabled(false);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r = new Random();
                ir = r.nextInt(79);
                textReci.setText(reci.get(ir).getRec());
                slikaReci.setImageDrawable(reci.get(ir).getSlikaReci());
            }
        });

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reci.get(ir).getZvuk().start();

            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // zvukReci.recycle();


    }
}
