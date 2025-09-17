package com.th.sistemadeavaliacao;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    String resultado;
    TextView txtstatus;
    RatingBar rtbvotacao;
    Intent telaresultado;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        rtbvotacao = findViewById(R.id.ratingBar);
        txtstatus = findViewById(R.id.textView2);

        txtstatus.setText("Status: Ruim");
        rtbvotacao.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v /* OU rating */, boolean b /*OU fromUser*/) {
                if (v <= 1){
                    txtstatus.setText("Status: Regular");
                    resultado = "Regular";
                } else if (v <= 2){
                    txtstatus.setText("Status: Bom");
                    resultado = "Bom";
                } else if (v <= 3) {
                    txtstatus.setText("Status: Ótimo");
                    resultado = "Ótimo";
                } else if (v <= 4) {
                    txtstatus.setText("Status: Excelente");
                    resultado = "Excelente";
                } else if (v <= 5){
                    txtstatus.setText("Status: Espetacular");
                    resultado = "Espetacular";
                }
            AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
            alerta.setTitle("Avaliação:");
            alerta.setMessage(txtstatus.getText());
            alerta.setNeutralButton("Ok", null);
            alerta.show();

            /* TENTATIVA DE CHAMAR NA SEGUNDA TELA PORÉM O RESULTADO DA AVALIAÇÃO
            FICA NULO, POR ISSO MANTI O RESULTADO NA CAIXA DE DIÁLOGO | COMENTAR
            LINHA 62 PARA VERIFICAR A SEGUNDA TELA

            telaresultado = new Intent(MainActivity.this, MainActivity_avaliacao.class);
            startActivity(telaresultado);
  //          */
            }
        });




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}