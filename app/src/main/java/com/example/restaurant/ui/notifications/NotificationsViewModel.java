package com.example.restaurant.ui.notifications;

import android.content.Intent;
import android.view.View;

import com.example.restaurant.Main2Activity;
import com.example.restaurant.Settings;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NotificationsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public NotificationsViewModel() {
        mText = new MutableLiveData<>();

    }


    public LiveData<String> getText() {
        return mText;
    }
}
