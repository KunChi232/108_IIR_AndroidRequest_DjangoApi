package com.example.kkbox;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button requset_like, request_unlike;
    RetrofitRequst retrofitRequst ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chageToFragment();
        /*requset_like = (Button) findViewById(R.id.like);
        request_unlike = (Button) findViewById(R.id.unlike);
        retrofitRequst = RetrofitRequst.getInstance();

        requset_like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirstFragment firstFragment = FirstFragment.newInstance();
                FragmentManager fm = getSupportFragmentManager();
                fm.beginTransaction().replace(R.id.main, firstFragment)
                        .addToBackStack(firstFragment.getClass().getName()).commit();
            }
        });
        request_unlike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getSupportFragmentManager();
                FirstFragment firstFragment = FirstFragment.newInstance();
                fm.beginTransaction().replace(R.id.main, FirstFragment.newInstance())
                        .addToBackStack(firstFragment.getClass().getName()).commit();
            }
        });*/
    }

    void chageToFragment()
    {
        FragmentManager fm = getSupportFragmentManager();
        FirstFragment firstFragment = FirstFragment.newInstance();
        fm.beginTransaction().replace(R.id.main, firstFragment)
                .addToBackStack(firstFragment.getClass().getName()).commit();
    }

    @Override
    public void onBackPressed() {
        int count = getFragmentManager().getBackStackEntryCount();

        if (count == 0) {
            super.onBackPressed();
        } else {
            getFragmentManager().popBackStack();
        }
    }
}
