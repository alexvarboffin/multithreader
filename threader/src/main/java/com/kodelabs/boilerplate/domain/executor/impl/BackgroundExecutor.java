package com.kodelabs.boilerplate.domain.executor.impl;

import android.util.Log;

import com.kodelabs.boilerplate.domain.executor.Executor;
import com.kodelabs.boilerplate.domain.interactors.base.AbstractInteractor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class BackgroundExecutor implements Executor {

    private static volatile BackgroundExecutor INSTANCE;

    public static BackgroundExecutor getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new BackgroundExecutor();
        }
        return INSTANCE;
    }

    private static int CORE_POOL_SIZE = Runtime.getRuntime().availableProcessors();

    private static final String TAG = "@@@";
    private ExecutorService mExecutorService;

    private BackgroundExecutor() {
        this.mExecutorService = Executors.newFixedThreadPool(CORE_POOL_SIZE);
        Log.i(TAG, "MyThreadExecutor: pool-zize -> " + CORE_POOL_SIZE + " -> "
                + mExecutorService.hashCode());
    }

    @Override
    public void execute(final AbstractInteractor interactor) {
//        mExecutorService.submit(new Runnable() {
//            @Override
//            public void run() {
//                // run the main logic
//                interactor.run();
//
//                // mark it as finished
//                interactor.onFinished();
//            }
//        });


        try {
            Future<Boolean> booleanFuture = mExecutorService.submit(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    // run the main logic
                    interactor.run();

                    // mark it as finished
                    interactor.onFinished();
                    return null;
                }
            });
        } catch (Exception e) {
            Log.i(TAG, "execute: " + e.toString());
        }
    }


    @Override
    public <T> Future<T> submit(Callable<T> runnable) {
        return mExecutorService.submit(runnable);
    }
}
