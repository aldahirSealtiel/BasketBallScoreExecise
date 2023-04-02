package com.example.basketballscore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

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
        //se asigna el liveData a la activity
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        //se agregan los observables para que se en cada cambio de los valores localScore y
        //VisitorScore
        mainViewModel.getLocalScore().observe(this, integer -> {
            binding.LocalScoreText.setText(mainViewModel.getLocalScore().getValue().toString());
        });
        mainViewModel.getVisitorScore().observe(this, integer -> {
            binding.VisitanteScoreText.setText(mainViewModel.getVisitorScore().getValue().toString());
        });
        setListeners();


    }

    private void setListeners()
    {
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
        intent.putExtra(LOCAL_SCORE_KEY, mainViewModel.getLocalScore().getValue());
        intent.putExtra(VISITOR_SCORE_KEY, mainViewModel.getVisitorScore().getValue());
        startActivity(intent);
    }
    private void resetScores()
    {
        mainViewModel.resetScores();
    }
    private void restarVisitorScore()
    {
        mainViewModel.restarVisitorScore();
    }

    private void sumarVisitorScore(int valorASumar)
    {
        mainViewModel.sumarVisitorScore(valorASumar);
    }

    private void sumarLocalScore(int valorASumar)
    {
        mainViewModel.sumarLocalScore(valorASumar);
    }
    private void restarLocalScore()
    {
        mainViewModel.restarLocalScore();
    }
}