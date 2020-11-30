package com.walhalla.boilerplate.domain.executor.impl;

import com.walhalla.boilerplate.domain.executor.Executor;
import com.walhalla.boilerplate.domain.interactors.base.AbstractInteractor;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class RawThreadExecuter implements Executor {
    @Override
    public void execute(AbstractInteractor interactor) {

    }

    @Override
    public void terminate() {
     //       var0.shutdownNow();
    }

    @Override
    public <T> Future<T> submit(Callable<T> runnable) {
        return null;
    }

    @Override
    public Future<?> execute(Runnable runnable) {
        return null;
    }

    @Override
    public void submit(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
