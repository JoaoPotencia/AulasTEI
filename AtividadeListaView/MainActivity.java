package com.example.materias;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private ListView ListMaterias;
    View view;
    private String[] itens = {
          "Sociologia", "Filosofia", "Geografia",
            "Física", "História", "Química",
            "Matemática", "Biologia", "Programação Internet",
            "Programação Orientada a Objetos", "Inglês",
            "Tópicos Especiais de Informática", "Língua Portuguesa",
            "Redes de Computadores", "TCC"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListMaterias = findViewById(R.id.ListMaterias);

        //Criar um adptador para a lista

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                itens

        );
        // adicionar adapter para a lista;
        ListMaterias.setAdapter(adaptador);

        ListMaterias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String valorSelecionado = ListMaterias.getItemAtPosition(position).toString();
                dialog1(view);
            }
        });
    }

        public void dialog1(View view){

            AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);

            //configurar titulo e mensagem
            dialog.setTitle("Matrícula");
            dialog.setMessage("DESEJA SE MATRICULAR NESSA MATÉRIA?");

            //configurar cancelamento do alert dialog
            dialog.setCancelable(false);

            //configurar icone
            dialog.setIcon(android.R.drawable.ic_menu_agenda);


            //configurar açoes para sim e nâo
            dialog.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getApplicationContext(), "Inscrição realizada com sucesso!", Toast.LENGTH_SHORT).show();

                }
            });

            dialog.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getApplicationContext(), "Inscrição não foi realizada", Toast.LENGTH_SHORT).show();

                }
            });
            dialog.create();
            dialog.show();
        }




    }

