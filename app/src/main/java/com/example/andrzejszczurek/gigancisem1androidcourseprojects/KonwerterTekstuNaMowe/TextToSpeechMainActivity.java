package com.example.andrzejszczurek.gigancisem1androidcourseprojects.KonwerterTekstuNaMowe;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.andrzejszczurek.gigancisem1androidcourseprojects.R;

import java.util.Locale;

public class TextToSpeechMainActivity extends AppCompatActivity {

    TextToSpeech textToSpeech;
    EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_to_speech_main);

        text = findViewById(R.id.et_text_to_speech_text);
        findViewById(R.id.btn_text_to_speech_convert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String t = text.getText().toString();
                textToSpeech.speak(t, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        // inicjalizujemy nowy textToSpeech - nie ma dostepnego języka polskiego więc ustawiamu UK
        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    textToSpeech.setLanguage(Locale.UK);
                }
            }
        });
    }

    @Override
    protected void onPause() {
        // potrzebne po to by przestało mówić jak wyłączymy aplikacje
        if(textToSpeech !=null){
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onPause();
    }
}
