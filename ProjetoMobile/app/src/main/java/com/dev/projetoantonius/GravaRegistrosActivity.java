package com.dev.projetoantonius;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GravaRegistrosActivity extends AppCompatActivity {
    Button btcadastrar;
    EditText ednome, edtelefone, edemail;
    EditText edplaca, edmarca, edmodelo, edano;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_grava_registros);

        btcadastrar = (Button) findViewById(R.id.btcadastrar);
        edplaca = (EditText) findViewById(R.id.edplaca);
        edmarca = (EditText) findViewById(R.id.edmarca);
        edmodelo = (EditText) findViewById(R.id.edmodelo);
        edano = (EditText) findViewById(R.id.edano);

        try {
            db = openOrCreateDatabase("antonius_bd",
                    Context.MODE_PRIVATE, null);
        } catch (Exception e) {
            MostrarMensagem("Erro : " + e.toString());
        }
        btcadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String placa = edplaca.getText().toString();
                String marca = edmarca.getText().toString();
                String modelo = edmodelo.getText().toString();
                String ano = edano.getText().toString();
                try {
                    db.execSQL("insert into carros(placa, marca," +
                            "modelo, ano) values('" + placa + "', '" + marca + "', '"
                            + modelo + "','" + ano + "')");
                    MostrarMensagem("Dados cadastrados com sucesso");
                } catch (Exception e) {
                    MostrarMensagem("Erro : " + e.toString());
                }
            }
        });
    }
    public void MostrarMensagem(String str){
        AlertDialog.Builder dialogo = new AlertDialog.Builder(GravaRegistrosActivity.this);
        dialogo.setTitle("Aviso");
        dialogo.setMessage(str);
        dialogo.setNeutralButton("OK", null);
        dialogo.show();
    }
}