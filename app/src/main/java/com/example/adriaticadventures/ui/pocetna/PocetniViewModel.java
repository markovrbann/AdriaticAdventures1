package com.example.adriaticadventures.ui.pocetna;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PocetniViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public PocetniViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}