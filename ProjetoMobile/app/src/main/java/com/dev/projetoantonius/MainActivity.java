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
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btcriarbanco;
    Button btcadastrados;
    Button btcadastrados2;
    Button btconsultardados;
    Button btalterardados;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btcriarbanco = findViewById(R.id.btcriarbanco);
        btcadastrados = findViewById(R.id.btcadastrardados);
        btcadastrados2 = findViewById(R.id.btcadastrardados2);
        btconsultardados = findViewById(R.id.btconsultardados);
        btalterardados = findViewById(R.id.btalterardados);

        btcadastrados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gravaRegistroActivity = new Intent(MainActivity.this,
                        GravaRegistrosActivity.class);
                MainActivity.this.startActivity(gravaRegistroActivity);
            }
        });

        btcadastrados2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gravaRegistroActivity2 = new Intent(MainActivity.this,
                        GravaRegistrosActivity.class);
                MainActivity.this.startActivity(gravaRegistroActivity2);
            }
        });

        btconsultardados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent consultaDadosActivity = new Intent(MainActivity.this,
                        ConsultaDadosActivity.class);
                MainActivity.this.startActivity(consultaDadosActivity);
            }
        });

        btalterardados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent alterarDadosActivity = new Intent(MainActivity.this,
                        AlterarDadosActivity.class);
                MainActivity.this.startActivity(alterarDadosActivity);
            }
        });

        btcriarbanco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    db = openOrCreateDatabase("antonius_bd",
                            Context.MODE_PRIVATE, null);
                    db.execSQL("create table if not exists " +
                            " carros(numreg integer primary key " +
                            " autoincrement, placa text not null, marca text not null, modelo text " +
                            " not null, " + " ano text not null) ");
                    AlertDialog.Builder dialogo = new
                            AlertDialog.Builder(MainActivity.this);
                    dialogo.setTitle("Aviso")
                            .setMessage("Banco de dados criado com sucesso!")
                            .setNeutralButton("OK", null)
                            .show();
                } catch (Exception e) {
                    MostrarMensagem("Erro : " + e);
                }
            }

            public void MostrarMensagem(String str) {
                AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
                dialogo.setTitle("Aviso");
                dialogo.setMessage(str);
                dialogo.setNeutralButton("OK", null);
                dialogo.show();
            }
        });
    }
}