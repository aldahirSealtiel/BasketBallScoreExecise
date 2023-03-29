package com.example.basketballscore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.basketballscore.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    Integer localScore = 0;
    Integer visitorScore =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.LocalScoreText.setText(localScore.toString());
        binding.VisitanteScoreText.setText(visitorScore.toString());
        binding.substractLocalScoreBtn.setOnClickListener(v -> {
            restarLocalScore();
        });
        binding.addOneLocalScoreBtn.setOnClickListener(v->{
            sumarMarcadorLocalScore(1);
        });
    }

    private void sumarMarcadorLocalScore(int valorASumar)
    {
        if(valorASumar == 1)
        {
            localScore ++;
            binding.LocalScoreText.setText(localScore.toString());
        }
    }
    private void restarLocalScore()
    {
        if(localScore - 1 >= 0)
        {
            localScore --;
            binding.LocalScoreText.setText(localScore.toString());
        }
    }
}