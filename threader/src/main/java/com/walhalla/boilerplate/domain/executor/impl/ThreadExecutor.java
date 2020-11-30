package com.walhalla.boilerplate.domain.executor.impl;

import com.walhalla.boilerplate.domain.executor.Executor;
import com.walhalla.boilerplate.domain.interactors.base.AbstractInteractor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * This singleton class will make sure that each interactor operation gets a background thread.
 * <p/>
 * <p>
 * android 4.4 not work !!!!!!!!!
 */
public class ThreadExecutor implements Executor {

    // This is a singleton
    private static volatile ThreadExecutor sThreadExecutor;

    private static final int CORE_POOL_SIZE = 3;
    private static final int MAX_POOL_SIZE = 5;
    private static final int KEEP_ALIVE_TIME = 120;
    private static final TimeUnit TIME_UNIT = TimeUnit.SECONDS;
    private static final BlockingQueue<Runnable> WORK_QUEUE = new LinkedBlockingQueue<>();

    private ThreadPoolExecutor var0;

    public ThreadExecutor() {

        var0 = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TIME_UNIT,
                WORK_QUEUE);
    }

    @Override
    public void execute(final AbstractInteractor interactor) {
        var0.submit(() -> {
            // run the main logic
            interactor.run();

            // mark it as finished
            interactor.onFinished();
        });
    }

    public Future<?> execute(Runnable runnable) {
        return var0.submit(runnable);
    }

    @Override
    public void submit(Runnable runnable) {
        var0.submit(runnable);
    }


    @Override
    public void terminate() {
        var0.shutdownNow();
    }

    @Override
    public <T> Future<T> submit(Callable<T> runnable) {
        return var0.submit(runnable);
    }

    /**
     * Returns a singleton instance of this executor. If the executor is not initialized then it initializes it and returns
     * the instance.
     */
    public static Executor getInstance() {
        if (sThreadExecutor == null) {
            sThreadExecutor = new ThreadExecutor();
        }
        return sThreadExecutor;
    }
}
