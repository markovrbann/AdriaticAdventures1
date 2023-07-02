package com.example.adriaticadventures.ui.item;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RabViewModel extends ViewModel {
    // TODO: Implement the ViewModel

    private final MutableLiveData<String> mText;

    public RabViewModel() {
        mText = new MutableLiveData<>();
        // mText.setValue("This is Rab fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
