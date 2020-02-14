package com.example.turismocolombia3.ui.mosquera;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MosqueraViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MosqueraViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is mosquera fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}