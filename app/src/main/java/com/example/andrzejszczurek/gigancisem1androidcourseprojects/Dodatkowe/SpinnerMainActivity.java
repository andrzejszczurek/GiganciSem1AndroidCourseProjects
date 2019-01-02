package com.example.andrzejszczurek.gigancisem1androidcourseprojects.Dodatkowe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.andrzejszczurek.gigancisem1androidcourseprojects.R;

import java.util.ArrayList;

public class SpinnerMainActivity extends AppCompatActivity {

    Spinner spinner;
    EditText number1;
    EditText number2;
    EditText number3;
    EditText number4;
    EditText number5;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_main);

        spinner = findViewById(R.id.spinner_sample);
        number1 = findViewById(R.id.et_spinner_sample_number_1);
        number2 = findViewById(R.id.et_spinner_sample_number_2);
        number3 = findViewById(R.id.et_spinner_sample_number_3);
        number4 = findViewById(R.id.et_spinner_sample_number_4);
        number5 = findViewById(R.id.et_spinner_sample_number_5);
        result = findViewById(R.id.tv_spinner_sample_result);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String selectedValue = parent.getItemAtPosition(position).toString();

                if(selectedValue.equals("Wybierz operacje...")) {return;}

                ArrayList<Integer> arr = getNumbers();
                Toast.makeText(getApplicationContext(), selectedValue, Toast.LENGTH_SHORT).show();
                calculate(selectedValue, arr);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private ArrayList<Integer> getNumbers() {
        ArrayList<Integer> arr = new ArrayList<>();

        try {
            arr.add(Integer.parseInt(number1.getText().toString()));
            arr.add(Integer.parseInt(number2.getText().toString()));
            arr.add(Integer.parseInt(number3.getText().toString()));
            arr.add(Integer.parseInt(number4.getText().toString()));
            arr.add(Integer.parseInt(number5.getText().toString()));
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), "Nie wszystkie wartości są prawidłowe", Toast.LENGTH_SHORT).show();
            ex.printStackTrace();
        }
        return arr;
    }

    private void calculate(String operation, ArrayList<Integer> numbers){

        switch (operation){
            case "Minimalna":
            {
                int min = minimalna(numbers);
                if(min != Integer.MAX_VALUE){
                    result.setText("Wynik: " + min + ".");
                }
                break;
            }
            case "Maksymalna":
            {
                int max = maksymalna(numbers);
                if(max != Integer.MIN_VALUE) {
                    result.setText("Wynik: " + max + ".");
                }
                break;
            }
            default:
        }
    }

    private int minimalna(ArrayList<Integer> numbers){
        int min = Integer.MAX_VALUE;
        for (int num : numbers) {
            if(min > num) {
                min = num;
            }
        }
        return min;
    }

    private int maksymalna(ArrayList<Integer> numbers){
        int max = Integer.MIN_VALUE;
        for (int num : numbers) {
            if(max < num) {
                max = num;
            }
        }
        return max;
    }

}
