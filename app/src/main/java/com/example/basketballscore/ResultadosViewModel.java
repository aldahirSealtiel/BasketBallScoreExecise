package com.example.basketballscore;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ResultadosViewModel extends ViewModel {
    private final MutableLiveData<Integer> localScore = new MutableLiveData<>();
    private final MutableLiveData<Integer> visitorScore = new MutableLiveData<>();

    public ResultadosViewModel()
    {
        this.localScore.setValue(0);
        this.visitorScore.setValue(0);
    }
    public LiveData<Integer> getLocalScore()
    {
        return localScore;
    }
    public LiveData<Integer> getVisitorScore()
    {
        return visitorScore;
    }
    public void colocarValorLocalScore(Integer value)
    {
        this.localScore.setValue(value);
    }
    public void colocarValorVisitorScore(Integer value)
    {
        this.visitorScore.setValue(value);
    }
}
