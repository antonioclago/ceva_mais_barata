package com.example.myapplication;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtNomeceva;
    EditText edtMlsceva;
    EditText edtValorCeva;
    Button btnAdd;
    Button btnComparar;
    Integer cont = 0;
    int cevaMaisBarata=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Cerveja[] cervejas = new Cerveja[10];
        edtMlsceva = findViewById(R.id.edtMl);
        edtNomeceva = findViewById(R.id.edtNomeceva);
        edtValorCeva = findViewById(R.id.edtValor);
        btnAdd = findViewById(R.id.btnAdd);
        btnComparar = findViewById(R.id.btnComparar);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!edtNomeceva.getText().toString().equals("") && !edtValorCeva.getText().toString().equals("") && !edtMlsceva.getText().toString().equals("")) {
                    Cerveja c = new Cerveja(edtNomeceva.getText().toString(),edtMlsceva.getText().toString(),edtValorCeva.getText().toString());

                    cervejas[cont]=c;
                    edtNomeceva.setText("");
                    edtMlsceva.setText("");
                    edtValorCeva.setText("");
                    System.out.println(cervejas[cont].valor.toString());
                } else {
                    System.out.println("mds!");
                }

                cont++;
            }

        });
        btnComparar.setOnClickListener(new View.OnClickListener() {
            Double[] media = new Double[cervejas.length];
            @Override
            public void onClick(View view) {
                for (int i = 0; i < cervejas.length; i++) {
                    if (cervejas[i] != null) {
                        media[i] = cervejas[i].valor / cervejas[i].mls;
                        if (i != 0) {
                            int aux = i - 1;
                            if (media[i] < media[aux]) {
                                cevaMaisBarata = i;
                            }
                        }
                    }
                }
                Toast.makeText(MainActivity.this, "Ceva mais barata é:" + cervejas[cevaMaisBarata].nomeceva, Toast.LENGTH_LONG).show();
            }
        });



                }


                }

