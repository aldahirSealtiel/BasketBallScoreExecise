package com.example.basketballscore;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.basketballscore.databinding.ActivityResultadosPartidoBinding;

public class ResultadosPartido extends AppCompatActivity {

    ActivityResultadosPartidoBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResultadosPartidoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent datosDeMainActivity = getIntent();
        Bundle extras = datosDeMainActivity.getExtras();
        Integer localScore = extras.getInt(MainActivity.LOCAL_SCORE_KEY);
        Integer visitorScore = extras.getInt(MainActivity.VISITOR_SCORE_KEY);
        binding.localScore.setText(localScore.toString());
        binding.VisitorScore.setText(visitorScore.toString());
        String res = validateResult(localScore, visitorScore);
        binding.resultadoPartido.setText(res);
    }

    public String validateResult(Integer local, Integer visitor){
        String ans = "";
        if(local == visitor)
        {
            ans = getString(R.string.empate);
        }
        else if (local > visitor)
        {
            ans = getString(R.string.localWon);
        }
        else
        {
            ans = getString(R.string.visitanteWon);
        }
        return ans;

    }
}