package com.example.turismocolombia3.ui.granada;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GranadaViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public GranadaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is granada fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}