package com.walhalla.boilerplate.domain.executor.impl;

import android.util.Log;

import com.walhalla.boilerplate.domain.executor.Executor;
import com.walhalla.boilerplate.domain.interactors.base.AbstractInteractor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SingleThreadExecutor implements Executor {

    private static final String TAG = "@@@@";
    private static final ExecutorService mExecutorService = Executors.newSingleThreadExecutor();

    private static volatile SingleThreadExecutor INSTANCE;

    public static SingleThreadExecutor getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SingleThreadExecutor();
        }
        return INSTANCE;
    }

    @Override
    public void execute(AbstractInteractor interactor) {
       // mExecutorService.execute(interactor);
    }

    @Override
    public void terminate() {
        mExecutorService.shutdownNow();
    }

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        return mExecutorService.submit(task);
    }

    @Override
    public Future<?> execute(Runnable runnable) {
        return mExecutorService.submit(runnable);
    }

    @Override
    public void submit(Runnable runnable) {
        try {
            mExecutorService.submit(runnable);
        } catch (Exception e) {
            Log.d(TAG, "submit: " + e);
        }
    }
}
