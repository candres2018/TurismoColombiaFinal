package com.example.turismocolombia3.ui.quipama;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class QuipamaViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public QuipamaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is quipama fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}