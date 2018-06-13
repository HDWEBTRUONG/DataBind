package com.example.pctruong.databind;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

import com.android.databinding.library.baseAdapters.*;
import com.android.databinding.library.baseAdapters.BR;

/**
 * Created by PCTruong on 12/06/2018.
 */

public class User extends BaseObservable {

    public User(String firt_name, String last_name) {
        this.firt_name = firt_name;
        this.last_name = last_name;
    }

    public String firt_name, last_name;

    public String getFirt_name() {
        return firt_name;
    }

    public void setFirt_name(String firt_name) {
        this.firt_name = firt_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }



}
