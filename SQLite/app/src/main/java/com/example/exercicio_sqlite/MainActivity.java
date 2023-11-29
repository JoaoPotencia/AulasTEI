package com.example.exercicio_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText textName;
    private EditText textAltura;
    private EditText textPeso;

    private Button btnSalvar;
    SQLiteDatabase bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bd = openOrCreateDatabase("app", MODE_PRIVATE, null);
        bd.execSQL("CREATE TABLE IF NOT EXISTS DadosUsuario (nome VARCHAR,imc FLOAT)");

        textName = findViewById(R.id.textName);
        textAltura = findViewById(R.id.textAltura);
        textPeso= findViewById(R.id.textPeso);
        btnSalvar = findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(
                        getApplicationContext(),
                        "Salvo os dados",
                        Toast.LENGTH_LONG
                ).show();
                calcularIMC();
            }
        });
    }

    private String calcularIMC() {
        double peso = Double.parseDouble(textPeso.getText().toString());
        double altura = Double.parseDouble(textAltura.getText().toString());

        double textAltura = (double) altura / 100;

        double Imc = peso / (textAltura * textAltura);

        double imc = Math.round(Imc * 100.0)/100.0;

        if (imc < 18.5){
            return "Abaixo do peso";
        } else if (imc >= 18.5 && imc < 24.9){
            return "Na média";
        } else if (imc >= 25.0 && imc < 29.9){
            return "Acima do peso";
        } else if (imc >= 30 && imc < 34.9){
            return "Obesidade de Classe 1";
        } else if (imc >= 35.9 && imc < 39.9){
            return "Obesidade de Classe 2";
        } else {
            return "Obesidade de Classe 3";
        }

    }
}