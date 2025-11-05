package com.dev.projetoantonius;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GravaRegistros2Activity extends AppCompatActivity {

    Button btcadastrar;
    EditText ednome;
    EditText edtelefone;
    EditText edemail;
    SQLiteDatabase db;

    GravaRegistrosActivity gra = new GravaRegistrosActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_grava_registros2);

        btcadastrar = (Button) findViewById(R.id.btcadastrar);

        ednome = (EditText) findViewById(R.id.ednome);
        ednome = (EditText) findViewById(R.id.ednome);
        ednome = (EditText) findViewById(R.id.ednome);

        try {
            db = openOrCreateDatabase("banco_dados",
                    Context.MODE_PRIVATE, null);
        } catch (Exception e){
            gra.MostrarMensagem("Erro: " + e.toString());
        }
        btcadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = ednome.getText().toString();
                String telefone = edtelefone.getText().toString();
                String email = edemail.getText().toString();

                ContentValues valor = new ContentValues();

                valor.put("nome", nome);
                valor.put("telefone", telefone);
                valor.put("email",email);

                try {
                    db.insert("usuarios", null, valor);
                    gra.MostrarMensagem("Dados cadastrados com sucesso!");
                } catch (Exception e) {
                    gra.MostrarMensagem("Erro : " + e.toString());
                }

            }
        });
    }
}