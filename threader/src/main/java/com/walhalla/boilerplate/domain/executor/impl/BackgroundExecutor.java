package com.walhalla.boilerplate.domain.executor.impl;

import android.util.Log;

import com.walhalla.boilerplate.domain.executor.Executor;
import com.walhalla.boilerplate.domain.interactors.base.AbstractInteractor;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class BackgroundExecutor
        implements Executor {

    private static final String TAG = "@@@";

    //android 4.4 not work !!!!!!!!!

    private static volatile BackgroundExecutor INSTANCE;

    public static BackgroundExecutor getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new BackgroundExecutor();
        }
        return INSTANCE;
    }

    private static int CORE_POOL_SIZE = Runtime.getRuntime().availableProcessors();

    private ExecutorService var0;

    private BackgroundExecutor() {
        this.var0 = Executors.newFixedThreadPool(CORE_POOL_SIZE);
        Log.d(TAG,  "MyThreadExecutor: pool-zize -> " + CORE_POOL_SIZE + " -> "
                + var0.hashCode());
    }

    @Override
    public void execute(final AbstractInteractor interactor) {
        var0.submit(() -> {
            // run the main logic
            interactor.run();
            interactor.onFinished();
            Log.d(TAG, "[execute]: mark it as finished");
        });


//        try {
//            Future<Boolean> booleanFuture = var0.submit(new Callable<Boolean>() {
//                @Override
//                public Boolean call() throws Exception {
//                    // run the main logic
////                        interactor.run();
//
//                    // mark it as finished
//                    interactor.onFinished();
//                    return null;
//                }
//            });
//        } catch (Exception e) {
//            Log.i(TAG, "execute: " + e.toString());
//        }
    }

    @Override
    public void terminate() {
        var0.shutdownNow();
        Log.d(TAG,  "terminate: ");
    }


    @Override
    public <T> Future<T> submit(Callable<T> runnable) {
        return var0.submit(runnable);
    }

    @Override
    public Future<?> execute(Runnable runnable) {
        return null;
    }

    @Override
    public void submit(Runnable runnable) {
        var0.submit(runnable);
    }


}