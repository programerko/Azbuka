package com.example.nikola.slova;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TypedArray zvuk = getResources().obtainTypedArray(R.array.zvuci_slova);
        final TypedArray zvukrec = getResources().obtainTypedArray(R.array.zvuci_reci);

        ImageView slovaBtn = (ImageView) findViewById(R.id.slova_btn);
        ImageView reciBtn = (ImageView) findViewById(R.id.reci_btn);

        if(!Objekti.reciucitane)
            Objekti.ucitajReci(zvukrec, MainActivity.this);

        slovaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Objekti.slovaUcitana)
                    Objekti.ucitajSlova(zvuk, MainActivity.this);
                Intent i = new Intent(MainActivity.this, SlovaActivity.class);
                i.setFlags(i.getFlags() | Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(i);
            }
        });

        reciBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ReciActivity.class);
                i.setFlags(i.getFlags() | Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(i);
            }
        });
    }
}
