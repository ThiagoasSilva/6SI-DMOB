package com.dev.projetoantonius;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AlterarDadosActivity extends AppCompatActivity {

    EditText txtplaca, txtmarca, txtmodelo, txtano;
    TextView txtstatus_registro;

    SQLiteDatabase db;

    ImageView imgprimeiro, imganterior, imgproximo, imgultimo;

    Button btalterardados;

    int indice;

    int numreg;

    Cursor c;

    DialogInterface.OnClickListener diAlteraInformacoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_alterar_dados);

        txtplaca = findViewById(R.id.txtplaca);
        txtmarca = findViewById(R.id.txtmarca);
        txtmodelo = findViewById(R.id.txtmodelo);
        txtano = findViewById(R.id.txtano);
        txtstatus_registro = findViewById(R.id.txtstatus_registro);

        txtplaca.setText("");
        txtmarca.setText("");
        txtmodelo.setText("");
        txtano.setText("");

        imgprimeiro = findViewById(R.id.imgprimeiro);
        imganterior = findViewById(R.id.imganterior);
        imgproximo = findViewById(R.id.imgproximo);
        imgultimo = findViewById(R.id.imgultimo);

        btalterardados = findViewById(R.id.btalterardados);

        try {
            db = openOrCreateDatabase("antonius_db", Context.MODE_PRIVATE, null);

            c = db.query("carros", new String[]{
                    "numreg", "placa", "marca", "modelo", "ano"
            }, null, null, null, null, null, null);
            if (c.getCount() > 0) {
                c.moveToFirst();

                indice = 1;
                numreg = c.getInt(0);
                txtplaca.setText(c.getString(1));
                txtmarca.setText(c.getString(2));
                txtmodelo.setText(c.getString(3));
                txtano.setText(c.getString(4));

                txtstatus_registro.setText(indice + " / " + c.getCount());
            } else {
                txtstatus_registro.setText("Nenhum registro");
            }
        } catch (Exception e) {

        }
        imgprimeiro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (c.getCount() > 0) {
                    c.moveToFirst();
                    indice = 1;

                    numreg = c.getInt(0);
                    txtplaca.setText(c.getString(1));
                    txtmarca.setText(c.getString(2));
                    txtmodelo.setText(c.getString(3));
                    txtano.setText(c.getString(4));

                    txtstatus_registro.setText(indice + " / " + c.getCount());
                }
            }
        });
        imganterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (c.getCount() > 0) {
                    if (indice > 1) {
                        indice--;
                        c.moveToPrevious();

                        numreg = c.getInt(0);
                        txtplaca.setText(c.getString(1));
                        txtmarca.setText(c.getString(2));
                        txtmodelo.setText(c.getString(3));
                        txtano.setText(c.getString(4));

                        txtstatus_registro.setText(indice + " / " + c.getCount());
                        c.getCount();
                    }
                }
            }
        });
        imgproximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (c.getCount() > 0) {
                    if (indice != c.getCount()) {
                        indice++;
                        c.moveToNext();

                        numreg = c.getInt(0);
                        txtplaca.setText(c.getString(1));
                        txtmarca.setText(c.getString(2));
                        txtmodelo.setText(c.getString(3));
                        txtano.setText(c.getString(4));

                        txtstatus_registro.setText(indice + " / " + c.getCount());
                        c.getCount();
                    }
                }
            }
        });
        imgultimo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (c.getCount() > 0) {
                    c.moveToLast();
                    indice = c.getCount();

                    numreg = c.getInt(0);
                    txtplaca.setText(c.getString(1));
                    txtmarca.setText(c.getString(2));
                    txtmodelo.setText(c.getString(3));
                    txtano.setText(c.getString(4));

                    txtstatus_registro.setText(indice + " / " + c.getCount());
                    c.getCount();
                }
            }
        });
        diAlteraInformacoes = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String placa = txtplaca.getText().toString();
                String marca = txtmarca.getText().toString();
                String modelo = txtmodelo.getText().toString();
                String ano = txtano.getText().toString();

                try {
                    db.execSQL("update carros set placa = '" + placa + "', "
                            + "marca = '" + marca + "', modelo = '" + modelo +
                            " ano = '" + ano + "' where numreg = " + numreg);

                    MostrarMensagem("Dados alterados com sucesso!");
                } catch (Exception e) {
                    MostrarMensagem("Erro: " + e.toString());
                }
            }
        };
    }
    public void MostrarMensagem(String str){
        AlertDialog.Builder dialogo = new AlertDialog.Builder(AlterarDadosActivity.this);
        dialogo.setTitle("Aviso");
        dialogo.setMessage(str);
        dialogo.setNeutralButton("OK", null);
        dialogo.show();
    }
}