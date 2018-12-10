package com.example.a13635.myapplication.viewmodel;


import android.app.Activity;
import com.kelin.mvvmlight.messenger.Messenger;
import android.widget.Toast;

import rx.functions.Action0;
import rx.functions.Action1;


/**
 * Created by lazyeraser on 2018/8/24.
 */

public class TestViewModel{
    Activity mcontext;
    public static final String TOKEN_1 = "TestViewModel_token_1";
    public static final String TOKEN_2 = "TestViewModel_token_2";

    public TestViewModel(Activity context){
        this.mcontext = context;
        Messenger.getDefault().register(mcontext, TOKEN_1, new Action0()
        {
            @Override
            public void call()
            {
                Toast.makeText(mcontext, "Send No Msg Token", Toast.LENGTH_SHORT).show();
            }
        });

        Messenger.getDefault().register(mcontext, TOKEN_2, String.class, new Action1<String>()
        {
            @Override
            public void call(String s)
            {
                Toast.makeText(mcontext, s, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
