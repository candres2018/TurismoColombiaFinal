package com.example.turismocolombia3.ui.acerca;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AcercaViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AcercaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is acerca fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}