package com.kodelabs.boilerplate.presentation.ui.activities;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.kodelabs.boilerplate.R;
import com.kodelabs.boilerplate.domain.executor.impl.BackgroundExecutor;
import com.kodelabs.boilerplate.domain.executor.impl.ThreadExecutor;
import com.kodelabs.boilerplate.domain.repository.impl.SimpleMessageRepository;
import com.kodelabs.boilerplate.domain.repository.impl.UserRepository;
import com.kodelabs.boilerplate.presentation.presenters.MainPresenter;
import com.kodelabs.boilerplate.presentation.presenters.impl.MainPresenterImpl;
import com.kodelabs.boilerplate.threading.MainThreadImpl;

import nl.walhalla.domain.repository.from_internet.AdvertAdmobRepository;
import nl.walhalla.domain.repository.from_internet.AdvertConfig;

public class MainActivity
        extends AppCompatActivity implements MainPresenter.MainView {

    private MainPresenter mMainPresenter;
    private TextView mWelcomeTextView;
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DLog.i(TAG, "onCreate: " + this.hashCode());

        //Background
        //Example
        //Var#1
        //Executor - класс который запустит извлечение данных из репозитория в новом пооке...
        mMainPresenter = new MainPresenterImpl(

                //ThreadExecutor.getInstance(),
                BackgroundExecutor.getInstance(),
                MainThreadImpl.getInstance(),
                this,


                //All repository
                SimpleMessageRepository.getInstance(),
                AdvertAdmobRepository.getInstance(new AdvertConfig() {
                    @Override
                    public String application_id() {
                        return null;
                    }

                    @Override
                    public String[] banner_ad_unit_id() {
                        return new String[]{"ca-app-pub-3940256099942544/6300978111"};
                    }

                    @Override
                    public String interstitial_ad_unit_id() {
                        return null;
                    }
                }), new UserRepository()
        );


        mWelcomeTextView = findViewById(android.R.id.text1);
        findViewById(R.id.btn1).setOnClickListener(v ->
                {
                    mMainPresenter.runWork();
                    mMainPresenter.attachView(frameLayout);
                }
        );


        frameLayout = findViewById(R.id.banner_container);
//        Button message = new Button(this);
//        message.setText("000000000000000000000000000000000");
//        frameLayout.addView(message);


        mMainPresenter.attachView(frameLayout);
    }

    //RotateScreen
    @Override
    protected void onPause() {
        super.onPause();

        Log.i(TAG, "onPause: " + this.hashCode());
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.i(TAG, "onStop: " + this.hashCode());
    }

    @Override
    protected void onDestroy() {
        /**
         * Detach from all 
         */
        mMainPresenter.destroy();//<phantom view
        mMainPresenter = null;//<phantom view
        super.onDestroy();
        Log.i(TAG, "onDestroy: " + this.hashCode());
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.i(TAG, "onStart: " + this.hashCode());
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMainPresenter.runWork();
        Log.i(TAG, "onResume: " + this.hashCode());
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.i(TAG, "onRestart: " + this.hashCode());
    }


    /*
     * Presenter
     * */
    @Override
    public void displayWelcomeMessage(String message) {
        Log.i(TAG, "###########: " + message + " " + this.hashCode());
        try {
            mWelcomeTextView.setText(message);
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Log.i(TAG, "displayWelcomeMessage: >>" + this.hashCode());
        }
    }


    @Override
    public void displayAdvertBanner(@NonNull View message) {

        Toast.makeText(this, message.toString(), Toast.LENGTH_SHORT).show();



        FrameLayout frameLayout = findViewById(R.id.banner_container);
        frameLayout.removeView(message);
        if (message.getParent() != null) {
            ((ViewGroup) message.getParent()).removeView(message);
        }
        frameLayout.addView(message);
    }


    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
