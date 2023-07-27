package com.example.testelista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private ListView listLocais;
    private String[] itens = {
            "Angra dos Reis", "Caldas Novas",
            "Campos do Jordão", "Florianópolis",
            "São Paulo", "Rio de Janeiro", "Gramado",
            "Bonito", "Foz do Iguaçu", "Salvador", "Porto Seguro",
            "Belo Horizonte", "Porto Alegre", "Maceió"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listLocais = findViewById(R.id.listLocais);

        //Criar um adptador para a lista

        ArrayAdapter<String> adpatador = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1, //layout da lista
                android.R.id.text1, //id do layout
                itens // a lista a ser passada
        );

        // adicionar adapter para a lista;
        listLocais.setAdapter(adpatador);

        // adiciona clique na lista
        listLocais.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String valorSelecionado = listLocais.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),valorSelecionado, Toast.LENGTH_LONG).show();
            }
        });



    }
}