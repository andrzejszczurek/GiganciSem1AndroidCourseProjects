package com.example.andrzejszczurek.gigancisem1androidcourseprojects.MailSender;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.andrzejszczurek.gigancisem1androidcourseprojects.R;

public class MailSenderMainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail_sender_main);

        final EditText adres = findViewById(R.id.et_mail_sender_mail);
        final EditText temat = findViewById(R.id.et_mail_sender_temat);
        final EditText tresc = findViewById(R.id.et_mail_sender_tresc);

        // łapiemy przycisk i od razu przypisujemy listenera
        findViewById(R.id.btn_mail_sender_send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // tworzymy intent odpowiedzialny za wysyłkę maila
                Intent sendIntent = new Intent(Intent.ACTION_SEND);

                sendIntent.setType("message/rfc822");
                sendIntent.putExtra(Intent.EXTRA_EMAIL, adres.getText().toString());
                sendIntent.putExtra(Intent.EXTRA_SUBJECT, temat.getText().toString());
                sendIntent.putExtra(Intent.EXTRA_TEXT, tresc.getText().toString());

                // wywołujemy choosera który pozwoli wybrać aplikacją za pomocą której chcemy wysłać mail
                startActivity(Intent.createChooser(sendIntent, "Send mail..."));
            }
        });
    }
}
