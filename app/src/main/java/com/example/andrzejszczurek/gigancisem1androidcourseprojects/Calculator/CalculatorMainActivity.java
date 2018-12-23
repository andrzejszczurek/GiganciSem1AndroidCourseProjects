package com.example.andrzejszczurek.gigancisem1androidcourseprojects.Calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.andrzejszczurek.gigancisem1androidcourseprojects.R;

public class CalculatorMainActivity extends AppCompatActivity {

    Button dodaj;
    Button odejmij;
    Button podziel;
    Button pomnoz;
    EditText liczbaA;
    EditText liczbaB;
    TextView wynik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_main);

        // robimy uchwyty dla wszystkich kontrolek które zdefiniowaliśmy w pliku xml,
        // z których będziemy chcieli korzystać w kodzie
        dodaj = findViewById(R.id.btn_calculator_dodaj);
        odejmij = findViewById(R.id.btn_calculator_odejmij);
        podziel = findViewById(R.id.btn_calculator_podziel);
        pomnoz = findViewById(R.id.btn_calculator_pomnoz);
        liczbaA = findViewById(R.id.et_calculator_pierwsza_liczba);
        liczbaB = findViewById(R.id.et_calculator_druga_liczba);
        wynik = findViewById(R.id.tv_calculator_wynik);

        // do przycisków musimy dodać OnClickListenery, aby można było łapać kliknięcia

        dodaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // po kliknieciu pobieramy wartości z edidTextow i zamieniamy na liczbe całkowitą
                int a = Integer.parseInt(liczbaA.getText().toString());
                int b = Integer.parseInt(liczbaB.getText().toString());
                // obliczamy wynik wybranego działania
                int w = a + b;
                //zamieniamy wynik na tekst
                String wSTR = Integer.toString(w);
                // i ustawiamy wartość textView na obliczny wynik
                wynik.setText(wSTR);
            }
        });

        odejmij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // to samo co w przypadku dodawania tylko dla odejmowania i w nieco skróconej wersji
                int a = Integer.parseInt(liczbaA.getText().toString());
                int b = Integer.parseInt(liczbaB.getText().toString());
                String wSTR = Integer.toString(a-b);
                wynik.setText(wSTR);
            }
        });

        pomnoz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(liczbaA.getText().toString());
                int b = Integer.parseInt(liczbaB.getText().toString());
                wynik.setText(Integer.toString(a*b));
            }
        });

        podziel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int w = Integer.parseInt(liczbaA.getText().toString()) / Integer.parseInt(liczbaB.getText().toString());
                wynik.setText(Integer.toString(w));
            }
        });

    }



}
