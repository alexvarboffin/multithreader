package com.kodelabs.boilerplate.presentation.ui.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.kodelabs.boilerplate.R;
import com.kodelabs.boilerplate.domain.executor.impl.BackgroundExecutor;
import com.kodelabs.boilerplate.domain.repository.impl.SimpleMessageRepository;
import com.kodelabs.boilerplate.domain.repository.impl.ViewAdmobRepository;
import com.kodelabs.boilerplate.presentation.presenters.MainPresenter;
import com.kodelabs.boilerplate.presentation.presenters.impl.MainPresenterImpl;
import com.kodelabs.boilerplate.threading.MainThreadImpl;

public class MainActivity
        extends AppCompatActivity implements MainPresenter.MainView {


    private static final String TAG = "@@@";
    private MainPresenter mMainPresenter;
    private TextView mWelcomeTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "onCreate: " + this.hashCode());

        //Background
        //Example
        //Var#1
        //Executor - класс который запустит извлечение данных из репозитория в новом пооке...
        mMainPresenter = new MainPresenterImpl(

                //ThreadExecutor.getInstance(),
                BackgroundExecutor.getInstance(),

                MainThreadImpl.getInstance(),
                this,
                SimpleMessageRepository.getInstance(),
                ViewAdmobRepository.getInstance()
        );


        mWelcomeTextView = findViewById(android.R.id.text1);
        findViewById(R.id.btn1).setOnClickListener(v -> mMainPresenter.runWork());



        FrameLayout frameLayout = findViewById(R.id.banner_container);
        Button message=new Button(this);
        message.setText("000000000000000000000000000000000");
        frameLayout.addView(message);


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
        } catch (Exception e) {
            Log.i(TAG, "displayWelcomeMessage: >>" + this.hashCode());
        }
    }

    @Override
    public void displayViewMessage(@NonNull View message) {
        FrameLayout frameLayout = findViewById(R.id.banner_container);
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

    }
}
