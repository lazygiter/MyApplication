package com.example.a13635.myapplication.model;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;



/**
 * Created by lazyeraser on 2018/8/6.
 */

public class User extends BaseObservable{
    public final ObservableField<String> firstName = new ObservableField<>();
    public final ObservableField<String> lastName = new ObservableField<>();


    /*
    private String firstName;
    private String lastName;
    public User(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }


    @Bindable
    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
        notifyPropertyChanged(BR.lastName);
    }

    @Bindable
    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
        notifyPropertyChanged(BR.firstName);
    }

    public String toString(){
        return firstName+lastName;
    }
    */
}
