package com.example.basketballscore;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    //Esta clase no debe acceder a nada del front, se concentra en realizar procesos
    //internos y arrojar resultados a mostrar en el front
    //private Integer localScore;
    //private Integer visitorScore;

    //Se agregara LiveData para que la información de la aplicación persista
    //para ello se puede usar liveData(no se puede editar) o MutableLiveData (se puede editar)
    private final MutableLiveData <Integer> localScore = new MutableLiveData<>();
    private final MutableLiveData <Integer>visitorScore = new MutableLiveData<>();
    public MainViewModel()
    {
        this.localScore.setValue(0);
        this.visitorScore.setValue(0);
    }
    //para que quede correctamente encapsulado se debe cambiar de mutable a liveData para que no
    //se pueda editar
    public LiveData<Integer> getLocalScore()
    {
        return this.localScore;
    }

    public LiveData <Integer> getVisitorScore()
    {
        return this.visitorScore;
    }

    public void resetScores()
    {
        this.visitorScore.setValue(0);
        this.localScore.setValue(0);
    }
    public void restarVisitorScore()
    {
        if(this.visitorScore.getValue() - 1 >= 0)
        {
            this.visitorScore.setValue(this.visitorScore.getValue() - 1 );
        }
    }

    public void sumarVisitorScore(int valorASumar)
    {
        if(valorASumar == 1)
        {
            this.visitorScore.setValue(this.visitorScore.getValue() + 1);
        }
        if(valorASumar == 2)
        {
            this.visitorScore.setValue(this.visitorScore.getValue() + 2);
        }
    }

    public void sumarLocalScore(int valorASumar)
    {
        if(valorASumar == 1)
        {
            this.localScore.setValue(this.localScore.getValue() + 1);
        }
        if(valorASumar == 2)
        {
            this.localScore.setValue(this.localScore.getValue() + 2);
        }
    }
    public void restarLocalScore()
    {
        if(this.localScore.getValue() - 1 >= 0)
        {
            this.localScore.setValue(this.localScore.getValue() -1 );
        }
    }
}
