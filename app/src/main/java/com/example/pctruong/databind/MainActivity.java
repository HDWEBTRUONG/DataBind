package com.example.pctruong.databind;

import android.app.ActivityManager;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.example.pctruong.databind.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterBind.IOnClick{
    AdapterBind adapterBind;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding mainBinding= DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);
        mainBinding.setMain(this);
        setData();
        mainBinding.rv.setLayoutManager(new LinearLayoutManager(this));
        mainBinding.rv.setAdapter(adapterBind);

    }

    private void setData() {
        List<User> list=new ArrayList<>();
        for(int i=0;i<20;i++){
            User user=new User("Firt" +i,"Last" +i);
            list.add(user);
        }
        adapterBind=new AdapterBind(list,this);
    }

    @Override
    public void itemOnClick(User user) {
        Toast.makeText(this, user.firt_name, Toast.LENGTH_SHORT).show();
    }
}
