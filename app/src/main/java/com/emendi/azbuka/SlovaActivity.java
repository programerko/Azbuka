package com.emendi.azbuka;

import android.content.res.TypedArray;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SlovaActivity extends AppCompatActivity {

    private TypedArray zvuciSlova;
    private ImageView prikaz;
    private TextView prikazTxt;
    private LinearLayout prikazLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slova);

        prikazLayout = (LinearLayout) findViewById(R.id.prikazL);
        prikaz = (ImageView) findViewById(R.id.prikaz_slova);
        prikazTxt = (TextView) findViewById(R.id.prikaz_txt);
        zvuciSlova = getResources().obtainTypedArray(R.array.zvuci_slova);

        new LoadImageTask().execute("");

    }

    public class ClickListener implements View.OnClickListener {
        private Slovo s;
        private int in;
        MediaPlayer tmpM;
        ClickListener(Slovo s, int in) {
            this.s = s;this.in = in;
        }

        @Override public void onClick(final View v) {
            try{
            tmpM.release();
            }catch (Exception e){}

            tmpM = MediaPlayer.create(SlovaActivity.this, zvuciSlova.getResourceId(in, 0));
          ((ImageView) v).setImageDrawable(s.getChangeSlika());
            prikaz.setImageDrawable(s.getSlikaSlova());
            prikazTxt.setText(s.getImeSlike());
            prikazLayout.setVisibility(View.VISIBLE );
            tmpM.start();

        }

    }
    private class LoadImageTask extends AsyncTask<String, Void, String> {
        List<Slovo> slova = new ArrayList<>();
        TypedArray slike = getResources().obtainTypedArray(R.array.slike);
        TypedArray slikeSlova = getResources().obtainTypedArray(R.array.slike_slova);
        TypedArray slikeUBoji = getResources().obtainTypedArray(R.array.slike_u_boji);
        String []slikeStr = {"Aвион","Балон","Ветар","Грожђе","Дрво","Ђак","Ексер","Жаба","Зец",
                "Игла","Јабука","Кућа","Лист","Љуљашка","Мачка","Наочаре","Њива","Оловка","Паприка",
                "Риба","Сунце","Телевизор","Ћурка","Удица","Филм","Хлеб","Ципела","Чаша","Џак","Шатор"};
        protected String doInBackground(String... urls) {
            for(int i=0; i < 30;i++)
                slova.add(new Slovo(
                        slikeStr[i],
                        slike.getDrawable(i),
                        slikeUBoji.getDrawable(i),
                        slikeSlova.getDrawable(i)));
            slike.recycle();
            slikeSlova.recycle();
            slikeUBoji.recycle();
            return "";
        }

        /** The system calls this to perform work in the UI thread and delivers
         * the result from doInBackground() */
        protected void onPostExecute(String result) {
            int i = 0;
            for(Slovo s: slova) {
                ImageView imageView = (ImageView) findViewById(getResources().getIdentifier("slovo"+(1+i), "id",
                        SlovaActivity.this.getPackageName()));
                imageView.setSoundEffectsEnabled(false);
                imageView.setOnClickListener(new ClickListener(s,i));
                i++;
        }
    }

}}
