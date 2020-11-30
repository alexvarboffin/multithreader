package com.walhalla.boilerplate.domain.executor;

import com.walhalla.boilerplate.domain.interactors.base.AbstractInteractor;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * This executor is responsible for running interactors on background threads.
 * <p/>
 */
public interface Executor {

    /**
     * This method should call the interactor's run method and thus start the interactor. This should be called
     * on a background thread as interactors might do lengthy operations.
     *
     * @param \\interactor The interactor to run.
     */

    void execute(final AbstractInteractor interactor);
    void terminate();

    //Execute runnable
    <T> Future<T> submit(Callable<T> runnable);
    Future<?> execute(Runnable runnable);

    void submit(Runnable runnable);
}
