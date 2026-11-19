package com.example.listaprodukty2;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editTextText, editTextNumber;
    Spinner spinner;
    ListView listView;
    Button button;
    CheckBox checkBox;
    SeekBar seekBar;
    ArrayAdapter<Produkt> arrayAdapter;
    ArrayList<Produkt> arrayList;
    Double cena;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editTextText = findViewById(R.id.editTextText);
        editTextNumber = findViewById(R.id.editTextNumber);
        spinner = findViewById(R.id.spinner);
        listView = findViewById(R.id.listView);
        button = findViewById(R.id.button);
        checkBox = findViewById(R.id.checkBox);
        seekBar = findViewById(R.id.seekBar);
        textView = findViewById(R.id.textView);
        arrayList = new ArrayList<Produkt>();
        arrayAdapter = new ArrayAdapter<Produkt>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                arrayList

        );
        listView.setAdapter(arrayAdapter);


        checkBox.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(@NonNull CompoundButton compoundButton, boolean b) {
                            if(!checkBox.isChecked()){
                                seekBar.setVisibility(INVISIBLE);
                                textView.setVisibility(INVISIBLE);
                            }else{
                                seekBar.setVisibility(VISIBLE);
                                textView.setVisibility(VISIBLE);
                            }
                    }
                }
        );
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String nazwa = editTextText.getText().toString();
                        cena = Double.parseDouble(editTextNumber.getText().toString());
                        String kategoria = spinner.getSelectedItem().toString();
                        if (checkBox.isChecked()){
                            cena = cena*(100-seekBar.getProgress())/100;

                        }
                        arrayList.add(new Produkt(kategoria, nazwa +" " , cena));
                        arrayAdapter.notifyDataSetChanged();





                    }
                }
        );
        seekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        textView.setText(i+"");
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );

    }
}