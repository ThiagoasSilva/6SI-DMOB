package com.th.sistemadeavaliacao;

import android.media.Rating;
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

    TextView txtstatus;
    RatingBar rtbvotacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        rtbvotacao = (RatingBar) findViewById(R.id.ratingBar);
        txtstatus = (TextView) findViewById(R.id.textView2);

        txtstatus.setText("Status: Ruim");
        rtbvotacao.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v /* OU rating */, boolean b /*OU fromUser*/) {
                if (v == 1){
                    txtstatus.setText("Status: Regular");
                } else if (v == 2){
                    txtstatus.setText("Status: Bom");
                } else if (v == 3) {
                    txtstatus.setText("Status: Ótimo");
                } else if (v == 4) {
                    txtstatus.setText("Status: Excelente");
                } else if (v == 5){
                    txtstatus.setText("Status: Espetacular");
                }
            AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
            alerta.setTitle("Avaliação:");
            alerta.setMessage(txtstatus.getText());
            alerta.setNeutralButton("Ok", null);
            alerta.show();
            }
        });




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}