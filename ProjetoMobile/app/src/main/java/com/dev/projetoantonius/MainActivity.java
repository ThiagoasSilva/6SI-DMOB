package com.dev.projetoantonius;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btcriarbanco;
    Button btcadastrados;
    Button btcadastrados2;
    Button btconsultardados;
    SQLiteDatabase db;

    GravaRegistrosActivity gra = new GravaRegistrosActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btcriarbanco = findViewById(R.id.btcriarbanco);
        btcadastrados = findViewById(R.id.btcadastrardados);
        btcadastrados2 = findViewById(R.id.btcadastrardados2);
        btconsultardados = findViewById(R.id.btconsultardados);

        //CADASTRO
        btcadastrados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent gravaRegistroActivity = new Intent(MainActivity.this,
                       GravaRegistrosActivity.class);
                       MainActivity.this.startActivity(gravaRegistroActivity);
            }
        });

        //CADASTRO2
        btcadastrados2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gravaRegistroActivity2 = new Intent(MainActivity.this,
                        GravaRegistrosActivity.class);
                MainActivity.this.startActivity(gravaRegistroActivity2);
            }
        });

        //CONSULTA DE DADOS
        btconsultardados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent consultaDadosActivity = new Intent(MainActivity.this,
                        ConsultaDadosActivity.class);
                MainActivity.this.startActivity(consultaDadosActivity);
            }
        });

        //CRIAÇÃO DE DATABASE
        btcriarbanco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    db = openOrCreateDatabase("banco_dados",
                            Context.MODE_PRIVATE, null);
                    db.execSQL("create table if not exists "+
                            " usuarios(numreg integer primary key "+
                            " autoincrement, nome text not null, telefone text "+
                            " not null, " + " email text not null) ");
                    AlertDialog.Builder dialogo = new
                            AlertDialog.Builder(MainActivity.this);
                    dialogo.setTitle("Aviso")
                            .setMessage("Banco de dados criado com sucesso!")
                            .setNeutralButton("OK",  null)
                            .show();
                } catch (Exception e) {
                    gra.MostrarMensagem("Erro : "+ e);
                }
            }
        });
    }
}