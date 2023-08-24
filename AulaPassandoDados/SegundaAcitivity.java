package com.example.passandodadosentreactivitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SegundaAcitivity extends AppCompatActivity {

    private TextView textNome;
    private TextView textIdade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_acitivity);

        textNome = findViewById(R.id.textNome);
        textIdade = findViewById(R.id.textIdade);

        //recuperando dados

        Bundle dados = getIntent().getExtras();
        String nome = dados.getString("nome");
        int idade = dados.getInt("idade");


        Usuario usario = (Usuario) dados.getSerializable("objeto");


        textNome.setText(usario.getEmail());
        textIdade.setText(String.valueOf(idade));
    }
}
