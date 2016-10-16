package com.example.nikola.slova;

import android.content.res.TypedArray;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SlovaActivity extends AppCompatActivity {

    TypedArray slike, slikeUBoji, slikeSlova, zvuciSlova;
    List<Slovo> slova;
    List<MediaPlayer> zvuciSlovaLista;
    ImageView prikaz;
    TextView prikazTxt;
    LinearLayout prikazLayout;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slova);

        prikazLayout = (LinearLayout) findViewById(R.id.prikazL);
        prikaz = (ImageView) findViewById(R.id.prikaz_slova);
        prikazTxt = (TextView) findViewById(R.id.prikaz_txt);

        String []slovaStr = {"A","Б","В","Г","Д","Ђ","Е","Ж","З","И","Ј","К","Л","Љ","М","Н",
                "Њ","О","П","Р","С","Т","Ћ","У","Ф","Х","Ц","Ч","Џ","Ш"};
        String []slikeStr = {"Aвион","Балон","Ветар","Грожђе","Дрво","Ђак","Ексер","Жаба","Зец",
                "Игла","Јабука","Кућа","Лист","Љуљашка","Мачка","Наочаре","Њива","Оловка","Паприка",
                "Риба","Сунце","Телевизор","Ћурка","Удица","Филм","Хлеб","Ципела","Чаша","Џак","Шатор"};

        slike = getResources().obtainTypedArray(R.array.slike);
        slikeSlova = getResources().obtainTypedArray(R.array.slike_slova);
        slikeUBoji = getResources().obtainTypedArray(R.array.slike_u_boji);
        zvuciSlova = getResources().obtainTypedArray(R.array.zvuci_slova);

        slova = new ArrayList<>();
        zvuciSlovaLista = new ArrayList<>();

        for(int i=0; i < 30;i++)
            slova.add(new Slovo(slovaStr[i],
                    slikeStr[i],
                    slike.getDrawable(i),
                    slikeUBoji.getDrawable(i),
                    slikeSlova.getDrawable(i)
                    , Objekti.zvuciSlova.get(i)));


        int i = 0;
        for(Slovo s: slova) {
            ImageView imageView = (ImageView) findViewById(getResources().getIdentifier("slovo"+(1+i), "id",
                    SlovaActivity.this.getPackageName()));
            imageView.setSoundEffectsEnabled(false);
            imageView.setOnClickListener(new ClickListener(s));
            i++;
        }


    }

    public class ClickListener implements View.OnClickListener {
        private Slovo s;
        public ClickListener(Slovo s) {
            this.s = s;
        }

        @Override public void onClick(final View v) {
          ((ImageView) v).setImageDrawable(s.getChangeSlika());
            prikaz.setImageDrawable(s.getSlikaSlova());
            prikazTxt.setText(s.getImeSlike());
            prikazLayout.setVisibility(View.VISIBLE );
            s.getZvuk().start();

        }

    }

//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        slike.recycle();
//        slikeSlova.recycle();
//        slikeUBoji.recycle();
//        zvuciSlova.recycle();
//
//    }
}
