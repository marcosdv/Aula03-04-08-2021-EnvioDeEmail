package com.example.aula03_04_08_2021_enviodeemail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnContato, btnSobre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //vinculando o arquivo XML (tela) com o JAVA
        setContentView(R.layout.activity_main);

        //vincula os campos da tela (XML) com o criado no JAVA
        btnContato = findViewById(R.id.btnContato);
        btnSobre = findViewById(R.id.btnSobre);

        //ouvinte do clique, ao clicar no botao, dispara este metodo
        btnContato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirTelaContato();
            }
        });

        btnSobre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirTelaSobre();
            }
        });
    }

    private void abrirTelaContato() {
        abrirTela(ContatoActivity.class);
    }

    private void abrirTelaSobre() {
        abrirTela(SobreActivity.class);
    }

    private void abrirTela(Class<?> cls) {
        /*
        //criando o caminho (rota) para abrir a tela
        Intent caminhoTela = new Intent(MainActivity.this, cls);

        //abrindo a tela
        startActivity(caminhoTela);
        */

        //criando o caminho (rota) para abrir a tela e ja abre a tela
        startActivity(new Intent(MainActivity.this, cls));
    }
}