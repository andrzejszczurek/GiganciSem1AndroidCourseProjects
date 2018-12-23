package com.example.andrzejszczurek.gigancisem1androidcourseprojects;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.andrzejszczurek.gigancisem1androidcourseprojects.Calculator.CalculatorMainActivity;
import com.example.andrzejszczurek.gigancisem1androidcourseprojects.DataPicker.DataPickerMainActivity;
import com.example.andrzejszczurek.gigancisem1androidcourseprojects.Dyktafon.DyktafonMainActivity;
import com.example.andrzejszczurek.gigancisem1androidcourseprojects.GoogleMaps.GoogleMapsMainActivity;
import com.example.andrzejszczurek.gigancisem1androidcourseprojects.KonwerterTekstuNaMowe.TextToSpeechMainActivity;
import com.example.andrzejszczurek.gigancisem1androidcourseprojects.ListaWithSharedPreferences.ListWithShMainActivity;
import com.example.andrzejszczurek.gigancisem1androidcourseprojects.MailSender.MailSenderMainActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_main_navigate_calculator).setOnClickListener(this);
        findViewById(R.id.btn_main_navigate_dyktafon).setOnClickListener(this);
        findViewById(R.id.btn_main_navigate_google_maps).setOnClickListener(this);
        findViewById(R.id.btn_main_navigate_konwerter_tekstu_na_mowe).setOnClickListener(this);
        findViewById(R.id.btn_main_navigate_data_picker).setOnClickListener(this);
        findViewById(R.id.btn_main_navigate_list_with_sh).setOnClickListener(this);
        findViewById(R.id.btn_main_navigate_mail_sender).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.btn_main_navigate_calculator:
            {
                NavigateToActivity(CalculatorMainActivity.class);
                break;
            }
            case R.id.btn_main_navigate_dyktafon:
            {
                NavigateToActivity(DyktafonMainActivity.class);
                break;
            }
            case R.id.btn_main_navigate_google_maps:
            {
                NavigateToActivity(GoogleMapsMainActivity.class);
                break;
            }
            case R.id.btn_main_navigate_konwerter_tekstu_na_mowe:
            {
                NavigateToActivity(TextToSpeechMainActivity.class);
                break;
            }
            case R.id.btn_main_navigate_data_picker:
            {
                NavigateToActivity(DataPickerMainActivity.class);
                break;
            }
            case R.id.btn_main_navigate_list_with_sh:
            {
                NavigateToActivity(ListWithShMainActivity.class);
                break;
            }
            case R.id.btn_main_navigate_mail_sender:
            {
                NavigateToActivity(MailSenderMainActivity.class);
                break;
            }
        }
    }

    private void NavigateToActivity(Class activity)
    {
        if (activity == null)
            return;
        startActivity(new Intent(getApplicationContext(), activity));
    }

}
