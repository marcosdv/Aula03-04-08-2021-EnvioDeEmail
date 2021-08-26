package com.example.aula03_04_08_2021_enviodeemail;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ContatoActivity extends AppCompatActivity {

    EditText edtNome, edtEmail, edtMesangem;
    Button btnEnviar, btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //vinculando o arquivo XML (tela) com o JAVA
        setContentView(R.layout.activity_contato);

        //vinculando os objetos do JAVA com os da tela (XML)
        edtNome = findViewById(R.id.edtNome);
        edtEmail = findViewById(R.id.edtEmail);
        edtMesangem = findViewById(R.id.edtMensagem);
        btnEnviar = findViewById(R.id.btnEnviar);
        btnVoltar = findViewById(R.id.btnVoltar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviarEmail();
            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                voltar();
            }
        });
    }

    private void enviarEmail() {
        String emailPara = "marcosdiasvendramini@yahoo.com.br";
        String assunto = "Mensagem do App - Aula 03";
        String texto =
                "Nome: " + edtNome.getText() + "<br />" +
                "E-mail: " + edtEmail.getText() + "<br />" +
                "Mensagem: " + edtMesangem.getText();

        String[] destinatarios = new String[] {emailPara, "email@email.com"};

        Intent telaEmail = new Intent(Intent.ACTION_SEND);
        telaEmail.setType("text/html");
        telaEmail.putExtra(Intent.EXTRA_SUBJECT, assunto);
        telaEmail.putExtra(Intent.EXTRA_TEXT, Html.fromHtml(texto));
        telaEmail.putExtra(Intent.EXTRA_EMAIL, destinatarios);

        startActivity(Intent.createChooser(telaEmail, "Escolha o e-mail:"));

        voltar();
    }

    private void voltar() {
       //comando para fechar a tela atual e voltar para a anterior
        onBackPressed();
    }
}
