package com.example.basketballscore;

import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    //Esta clase no debe acceder a nada del front, se concentra en realizar procesos
    //internos y arrojar resultados a mostrar en el front
    private Integer localScore;
    private Integer visitorScore;

    public MainViewModel()
    {
        this.localScore = 0;
        this.visitorScore = 0;
    }

    public Integer getLocalScore()
    {
        return this.localScore;
    }
    public Integer getVisitorScore()
    {
        return this.visitorScore;
    }

    public void resetScores()
    {
        this.visitorScore = 0;
        this.localScore = 0;
    }
    public void restarVisitorScore()
    {
        if(this.visitorScore - 1 >= 0)
        {
            this.visitorScore --;
        }
    }

    public void sumarVisitorScore(int valorASumar)
    {
        if(valorASumar == 1)
        {
            this.visitorScore ++;
        }
        if(valorASumar == 2)
        {
            this.visitorScore +=2;
        }
    }

    public void sumarLocalScore(int valorASumar)
    {
        if(valorASumar == 1)
        {
            this.localScore ++;
        }
        if(valorASumar == 2)
        {
            this.localScore +=2;
        }
    }
    public void restarLocalScore()
    {
        if(this.localScore - 1 >= 0)
        {
            this.localScore --;
        }
    }
}
