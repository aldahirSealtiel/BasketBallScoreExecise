package com.example.basketballscore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.basketballscore.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    MainViewModel mainViewModel;

    public static final String LOCAL_SCORE_KEY = "SCORE_LOCAL_PLAYER";
    public static final String VISITOR_SCORE_KEY = "SCORE_VISITOR_PLAYER";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mainViewModel = new MainViewModel();
        binding.LocalScoreText.setText(mainViewModel.getLocalScore().toString());
        binding.VisitanteScoreText.setText(mainViewModel.getVisitorScore().toString());
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
        intent.putExtra(LOCAL_SCORE_KEY, mainViewModel.getLocalScore());
        intent.putExtra(VISITOR_SCORE_KEY, mainViewModel.getVisitorScore());
        startActivity(intent);
    }
    private void resetScores()
    {
        mainViewModel.resetScores();
        binding.VisitanteScoreText.setText(mainViewModel.getVisitorScore().toString());
        binding.LocalScoreText.setText(mainViewModel.getLocalScore().toString());
    }
    private void restarVisitorScore()
    {
        mainViewModel.restarVisitorScore();
        binding.VisitanteScoreText.setText(mainViewModel.getLocalScore().toString());
    }

    private void sumarVisitorScore(int valorASumar)
    {
        mainViewModel.sumarVisitorScore(valorASumar);
        binding.VisitanteScoreText.setText(mainViewModel.getVisitorScore().toString());
    }

    private void sumarLocalScore(int valorASumar)
    {
        mainViewModel.sumarLocalScore(valorASumar);
        binding.LocalScoreText.setText(mainViewModel.getLocalScore().toString());

    }
    private void restarLocalScore()
    {
        mainViewModel.restarLocalScore();
        binding.LocalScoreText.setText(mainViewModel.getLocalScore().toString());

    }
}