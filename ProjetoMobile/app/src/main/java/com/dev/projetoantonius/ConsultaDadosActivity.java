package com.dev.projetoantonius;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ConsultaDadosActivity extends AppCompatActivity {
    TextView txtplaca, txtmarca, txtmodelo, txtano, txtstatus_registro;

    SQLiteDatabase db;

    ImageView imgprimeiro, imganterior, imgproximo, imgultimo;

    int indice;

    Cursor c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_consulta_dados);

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

        try {
            db = openOrCreateDatabase("antonius_db", Context.MODE_PRIVATE, null);

            c = db.query("carros", new String[]{
                    "placa", "marca", "modelo", "ano"
            }, null, null, null, null, null, null);
            if(c.getCount() > 0){
                c.moveToFirst();
                indice = 1;

                txtplaca.setText(c.getString(0));
                txtmarca.setText(c.getString(1));
                txtmodelo.setText(c.getString(2));
                txtano.setText(c.getString(3));

                txtstatus_registro.setText(indice + " / " + c.getCount());
            } else {
                txtstatus_registro.setText("Nenhum registro");
            }

            imgprimeiro.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(c.getCount() > 0){
                        c.moveToFirst();
                        indice = 1;

                        txtplaca.setText(c.getString(0));
                        txtmarca.setText(c.getString(1));
                        txtmodelo.setText(c.getString(2));
                        txtano.setText(c.getString(3));

                        txtstatus_registro.setText(indice + " / " + c.getCount());
                    } else {
                        txtstatus_registro.setText("Nenhum registro");
                    }
                }
            });

            imganterior.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(c.getCount() > 0) {
                        if (indice > 1) {
                            indice--;
                            c.moveToPrevious();

                            txtplaca.setText(c.getString(0));
                            txtmarca.setText(c.getString(1));
                            txtmodelo.setText(c.getString(2));
                            txtano.setText(c.getString(3));

                            txtstatus_registro.setText(indice + " / " + c.getCount());
                            c.getCount();
                        }
                    }
                }
            });

            imgproximo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(c.getCount() > 0) {
                        if (indice != c.getCount()) {
                            indice++;
                            c.moveToNext();

                            txtplaca.setText(c.getString(0));
                            txtmarca.setText(c.getString(1));
                            txtmodelo.setText(c.getString(2));
                            txtano.setText(c.getString(3));

                            txtstatus_registro.setText(indice + " / " + c.getCount());
                            c.getCount();
                        }
                    }
                }
            });

            imgultimo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(c.getCount() > 0) {
                            c.moveToLast();
                            indice = c.getCount();

                        txtplaca.setText(c.getString(0));
                        txtmarca.setText(c.getString(1));
                        txtmodelo.setText(c.getString(2));
                        txtano.setText(c.getString(3));

                            txtstatus_registro.setText(indice + " / " + c.getCount());
                            c.getCount();
                        }
                }
            });
        } catch (Exception e){
            MostrarMensagem("Erro : " + e.toString());
        }
    }
    public void MostrarMensagem(String str){
        AlertDialog.Builder dialogo = new AlertDialog.Builder(ConsultaDadosActivity.this);
        dialogo.setTitle("Aviso");
        dialogo.setMessage(str);
        dialogo.setNeutralButton("OK", null);
        dialogo.show();
    }
}