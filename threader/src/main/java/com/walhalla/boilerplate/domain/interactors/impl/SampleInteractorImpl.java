package com.walhalla.boilerplate.domain.interactors.impl;

import com.walhalla.boilerplate.domain.executor.Executor;
import com.walhalla.boilerplate.domain.executor.MainThread;
import com.walhalla.boilerplate.domain.interactors.SampleInteractor;
import com.walhalla.boilerplate.domain.interactors.base.AbstractInteractor;
import com.walhalla.boilerplate.domain.repository.base.Repository;

/**
 * This is an interactor boilerplate with a reference to a model repository.
 * <p/>
 */
public class SampleInteractorImpl extends AbstractInteractor implements SampleInteractor {

    public SampleInteractorImpl(Executor threadExecutor,
                                MainThread mainThread,
                                Callback callback, Repository repository) {
        super(threadExecutor, mainThread);
    }

    @Override
    public void run() {
        // TODO: Implement this with your business logic
    }
}
