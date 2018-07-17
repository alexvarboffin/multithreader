package com.kodelabs.boilerplate.presentation.ui.activities;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.kodelabs.boilerplate.R;
import com.kodelabs.boilerplate.domain.executor.Executor;
import com.kodelabs.boilerplate.domain.executor.MainThread;
import com.kodelabs.boilerplate.domain.executor.impl.ThreadExecutor;
import com.kodelabs.boilerplate.domain.interactors.AdsInteractor;
import com.kodelabs.boilerplate.domain.interactors.impl.AdsInteractorImpl;
import com.kodelabs.boilerplate.domain.repository.AdsRepository;
import com.kodelabs.boilerplate.domain.repository.impl.GoogleAdsRepository;
import com.kodelabs.boilerplate.presentation.presenters.MainPresenter.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View {

    private static final String TAG = "@@@";


    //@BindView(android.R.id.text1)
    TextView mTextView;

    //@OnClick(R.id.btn1)
    public void runWork() {
        //Example
        //Var#1
        //Executor - класс который запустит извлечение данных из репозитория в новом пооке...
        Executor mExecutor
                = ThreadExecutor.getInstance();
        //= MyThreadExecutor.getInstance();

        MainThread mMainThread = new Muuuu(); //new MainThreadImpl();
        AdsRepository adsRepository = new GoogleAdsRepository();

        AdsInteractor interactor = new AdsInteractorImpl(
                mExecutor,
                mMainThread,
                new AdsInteractor.Callback() {
                    @Override
                    public void onMessageRetrieved(String message) {


                        //!!!! Ошибка !!! при повороте mTextView не занулится,
                        //его не будет на активити... -> висит в памяти 8\

                        //Log.i(TAG, "onMessageRetrieved: " + message+mTextView.hashCode());
                        //mTextView.setText(">>" + new Random().nextInt());
                        Log.i(TAG, "onMessageRetrieved: " + this.hashCode());

                        try {
                            ((TextView) findViewById(android.R.id.text1)).setText(">>" + new Random().nextInt());
                        } catch (Exception e) {
                            Log.i(TAG, "onMessageRetrieved: " + e.getMessage());
                        }
                    }

                    @Override
                    public void onRetrievalFailed(String error) {
                        Log.i(TAG, "onRetrievalFailed: " + error);
                    }
                },
                adsRepository
        );    // запускаем interactor


//        for (int i = 0; i < 100; i++) {
//            interactor.execute();
//        }

//        interactor.execute();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ButterKnife.bind(this);
        mTextView = findViewById(android.R.id.text1);
        findViewById(R.id.btn1).setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                runWork();
            }
        });


        Log.i(TAG, "onCreate: " + "Текущая активность: " + this.hashCode());
        //runWork();
    }

    @Override
    public void showProgress() {
        Log.i(TAG, "showProgress: ");
    }

    @Override
    public void hideProgress() {
        Log.i(TAG, "hideProgress: ");
    }

    @Override
    public void showError(String message) {
        Log.i(TAG, "showError: ");
    }

    private class Muuuu implements MainThread {

        @Override
        public void post(Runnable runnable) {
            //new Handler(Looper.getMainLooper()).post(runnable);
            new Handler(getApplication().getMainLooper()).post(runnable);
        }
    }
}
