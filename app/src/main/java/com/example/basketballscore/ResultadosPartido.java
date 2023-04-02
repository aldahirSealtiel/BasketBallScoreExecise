package com.example.basketballscore;



import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import com.example.basketballscore.databinding.ActivityResultadosPartidoBinding;

public class ResultadosPartido extends AppCompatActivity {

    ActivityResultadosPartidoBinding binding;
    ResultadosViewModel resultadosViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResultadosPartidoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        resultadosViewModel = new  ViewModelProvider(this).get(ResultadosViewModel.class);
        resultadosViewModel.getLocalScore().observe(this, integer -> {
            binding.localScore.setText(resultadosViewModel.getLocalScore().getValue().toString());
        });
        resultadosViewModel.getVisitorScore().observe(this, integer -> {
            binding.VisitorScore.setText(resultadosViewModel.getVisitorScore().getValue().toString());
        });
        Intent datosDeMainActivity = getIntent();
        Bundle extras = datosDeMainActivity.getExtras();
        Integer localScore = extras.getInt(MainActivity.LOCAL_SCORE_KEY);
        Integer visitorScore = extras.getInt(MainActivity.VISITOR_SCORE_KEY);
        resultadosViewModel.colocarValorLocalScore(localScore);
        resultadosViewModel.colocarValorVisitorScore(visitorScore);

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