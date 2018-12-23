package com.example.andrzejszczurek.gigancisem1androidcourseprojects.Dyktafon;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.andrzejszczurek.gigancisem1androidcourseprojects.R;

import java.io.IOException;

import static android.Manifest.permission.RECORD_AUDIO;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class DyktafonMainActivity extends AppCompatActivity implements View.OnClickListener {

    Button play;
    Button record;
    Button stop;
    Button stopPlayingRecording;

    String audioSavePath = null;
    MediaRecorder mediaRecorder;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dyktafon_main);

        play = findViewById(R.id.btn_dyktafon_play);
        record = findViewById(R.id.btn_dyktafon_record);
        stopPlayingRecording = findViewById(R.id.btn_dyktafon_stop_playing_recording);
        stop = findViewById(R.id.btn_dyktafon_stop);

        play.setOnClickListener(this);
        record.setOnClickListener(this);
        stopPlayingRecording.setOnClickListener(this);
        play.setOnClickListener(this);

        stop.setEnabled(false);
        play.setEnabled(false);
        stopPlayingRecording.setEnabled(false);
    }

    private void Record() {
        audioSavePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + "myRecording.3gp";
        MediaRecorderReady();

        try {
            mediaRecorder.prepare();
            mediaRecorder.start();
        } catch (IOException e){
            e.printStackTrace();
        }

        record.setEnabled(false);
        stop.setEnabled(true);

        Toast.makeText(getApplicationContext(), "Nagrywanie rozpoczęte...", Toast.LENGTH_LONG).show();
    }

    private void StopRecording() {
        mediaRecorder.stop();

        stop.setEnabled(false);
        stopPlayingRecording.setEnabled(false);
        play.setEnabled(true);
        record.setEnabled(true);
        Toast.makeText(getApplicationContext(), "Nagrywanie zakończone...", Toast.LENGTH_LONG).show();
    }

    private void PlayLastRecord()
    {
        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(audioSavePath);
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }

        mediaPlayer.start();
        Toast.makeText(getApplicationContext(), "Odtwarzanie nagrania...", Toast.LENGTH_LONG).show();
    }

    private void StopPlayLastRecord() {
        if(mediaPlayer != null){
            mediaPlayer.stop();
            mediaPlayer.release();
            MediaRecorderReady();
        }

        play.setEnabled(false);
        record.setEnabled(false);
        stop.setEnabled(false);
        stopPlayingRecording.setEnabled(true);
    }

    public void MediaRecorderReady(){
        mediaRecorder = new MediaRecorder();
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mediaRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        mediaRecorder.setOutputFile(audioSavePath);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_dyktafon_play:
            {
                PlayLastRecord();
                break;
            }
            case R.id.btn_dyktafon_stop:
            {
                StopRecording();
                break;
            }
            case R.id.btn_dyktafon_record:
            {
                Record();
                break;
            }
            case R.id.btn_dyktafon_stop_playing_recording:
            {
                StopPlayLastRecord();
                break;
            }
        }
    }
}
