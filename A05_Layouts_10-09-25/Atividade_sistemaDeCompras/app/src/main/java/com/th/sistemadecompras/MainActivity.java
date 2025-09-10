package com.th.sistemadecompras;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.os.Bundle;
import android.app.Activity;
import android.widget.*;
import android.view.*;
import android.app.*;

public class MainActivity extends AppCompatActivity {

    CheckBox chkarroz, chkleite, chkfeijao, chkcarne;
    Button bttotal;
    Intent iTela2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        chkarroz = (CheckBox) findViewById(R.id.checkBox6);
        chkleite = (CheckBox) findViewById(R.id.checkBox7);
        chkcarne = (CheckBox) findViewById(R.id.checkBox8);
        chkfeijao = (CheckBox) findViewById(R.id.checkBox9);

        bttotal = (Button) findViewById(R.id.button2);

        bttotal.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                double total = 0;
                if (chkarroz.isChecked()){
                    total += 12.89;
                }
                if (chkleite.isChecked()){
                    total += 5.49 ;
                }
                if (chkcarne.isChecked()){
                    total += 23.90;
                }
                if (chkfeijao.isChecked()){
                    total += 8.60;
                }
                // String totalFormatado = String.format("%2.f", total); Verificar formatação

                AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
                dialogo.setTitle("Aviso");
                dialogo.setMessage("Valor total da compra: R$"+ total);
                dialogo.setNeutralButton("Ok", null);
                dialogo.show();

                iTela2 = new Intent(MainActivity.this, tela2.class);
                startActivity(iTela2);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}