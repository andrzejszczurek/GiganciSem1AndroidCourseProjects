package com.example.andrzejszczurek.gigancisem1androidcourseprojects.ListaWithSharedPreferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.andrzejszczurek.gigancisem1androidcourseprojects.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class ListWithShMainActivity extends AppCompatActivity {

    ListView listView;
    Button saveBtn;
    Button addBtn;
    EditText nameEt;

    List<String> todoList;
    final Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_with_sh_main);

        listView = findViewById(R.id.lv_list_with_sh);
        addBtn = findViewById(R.id.btn_list_with_sh_dodaj);
        saveBtn = findViewById(R.id.btn_list_with_sh_zapisz);
        nameEt = findViewById(R.id.et_list_with_sh_nazwa);

        todoList = new ArrayList<>();

        SharedPreferences prefs = getBaseContext().getSharedPreferences("settings", Context.MODE_PRIVATE);
        String value = prefs.getString("list", null);

        GsonBuilder gsonb = new GsonBuilder();
        Gson gson2 = gsonb.create();
        List<String> valuesTemp = gson2.fromJson(value, ArrayList.class);

        if(valuesTemp != null)
        {
            for (int i =0; i<valuesTemp.size(); i++) {
                todoList.add(valuesTemp.get(i));
            }
        }

        // Tworzymy domyślny adapter na ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext()
                , R.layout.list_adapter_view
                , R.id.tv_list_adapter_value
                , todoList);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String msg = "Kliknięto element " + position++ + " o nazwie " + listView.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        });


        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEt.getText().toString();
                todoList.add(name);
                listView.invalidateViews();
                nameEt.setText("");
            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = gson.toJson(todoList);
                SharedPreferences prefs = getBaseContext().getSharedPreferences("settings", Context.MODE_PRIVATE);
                SharedPreferences.Editor e = prefs.edit();
                e.putString("list", value);
                e.apply();
                e.commit();
            }
        });

    }
}
