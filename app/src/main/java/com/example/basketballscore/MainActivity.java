package com.example.basketballscore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.basketballscore.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    Integer localScore = 0;
    Integer visitorScore =0;

    public static final String LOCAL_SCORE_KEY = "SCORE_LOCAL_PLAYER";
    public static final String VISITOR_SCORE_KEY = "SCORE_VISITOR_PLAYER";
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
            sumarLocalScore(1);
        });
        binding.addTwoLocalScoreBtn.setOnClickListener( v->{
            sumarLocalScore(2);
        });
        binding.addOneVisitorScoreBtn.setOnClickListener(v->{
            sumarVisitorScore(1);
        });
        binding.addTwoVisitorScoreBtn.setOnClickListener(v->{
            sumarVisitorScore(2);
        });
        binding.substractVisitorScoreBtn.setOnClickListener(v->{
            restarVisitorScore();
        });
        binding.resetScoreBtn.setOnClickListener(v->{
            resetScores();
        });
        binding.detallesBtn.setOnClickListener(v->{
            abrirPantallaDetallesPartido();
        });

    }

    private void abrirPantallaDetallesPartido()
    {
        Intent intent = new Intent(this, ResultadosPartido.class);
        intent.putExtra(LOCAL_SCORE_KEY, localScore);
        intent.putExtra(VISITOR_SCORE_KEY, visitorScore);
        startActivity(intent);
    }
    private void resetScores()
    {
        visitorScore = 0;
        localScore = 0;
        binding.VisitanteScoreText.setText(visitorScore.toString());
        binding.LocalScoreText.setText(localScore.toString());
    }
    private void restarVisitorScore()
    {
        if(visitorScore - 1 >= 0)
        {
            visitorScore --;
            binding.VisitanteScoreText.setText(visitorScore.toString());
        }
    }

    private void sumarVisitorScore(int valorASumar)
    {
        if(valorASumar == 1)
        {
            visitorScore ++;
            binding.VisitanteScoreText.setText(visitorScore.toString());
        }
        if(valorASumar == 2)
        {
            visitorScore +=2;
            binding.VisitanteScoreText.setText(visitorScore.toString());
        }
    }

    private void sumarLocalScore(int valorASumar)
    {
        if(valorASumar == 1)
        {
            localScore ++;
            binding.LocalScoreText.setText(localScore.toString());
        }
        if(valorASumar == 2)
        {
            localScore +=2;
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