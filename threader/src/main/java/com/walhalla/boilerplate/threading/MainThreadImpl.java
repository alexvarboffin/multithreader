package com.walhalla.boilerplate.threading;

import android.os.Handler;
import android.os.Looper;

import com.walhalla.boilerplate.domain.executor.MainThread;

public class MainThreadImpl implements MainThread {

    private static MainThread sThread;

    private Handler mHandler;

    public MainThreadImpl() {
        mHandler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void post(Runnable runnable) {
        mHandler.post(runnable);
    }

    public static MainThread getInstance() {
        if (sThread == null) {
            sThread = new MainThreadImpl();
        }

        return sThread;
    }
}
