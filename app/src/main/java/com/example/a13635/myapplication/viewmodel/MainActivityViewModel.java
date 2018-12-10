package com.example.a13635.myapplication.viewmodel;

import android.app.Activity;
import android.content.Intent;
import android.databinding.ObservableField;
import android.view.View;

import com.example.a13635.myapplication.view.ReviewActivity;
import com.kelin.mvvmlight.messenger.Messenger;

/**
 * Created by lazyeraser on 2018/8/7.
 */

public class MainActivityViewModel {
    public Activity context;
    public final ObservableField<String> firstName = new ObservableField<>();
    public final ObservableField<String> lastName = new ObservableField<>();

    public MainActivityViewModel(Activity context){
        this.context = context;
        firstName.set("tom");
        lastName.set("jerry");
        TestViewModel tvm = new TestViewModel(context);

    }

    public void buttonClick(View view){
        firstName.set("haha");
        Messenger.getDefault().sendNoMsg(TestViewModel.TOKEN_1);
        Messenger.getDefault().send("test",TestViewModel.TOKEN_2);
    }

    public void buttonClick2(View view){
        Intent intent = new Intent();
        intent.setClass(context, ReviewActivity.class);
        context.startActivity(intent);
    }

}
