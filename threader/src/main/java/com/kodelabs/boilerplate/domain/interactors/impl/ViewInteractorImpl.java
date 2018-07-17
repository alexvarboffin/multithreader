package com.kodelabs.boilerplate.domain.interactors.impl;

import android.view.View;
import android.view.ViewGroup;

import com.kodelabs.boilerplate.domain.executor.Executor;
import com.kodelabs.boilerplate.domain.executor.MainThread;
import com.kodelabs.boilerplate.domain.interactors.ViewInteractor;
import com.kodelabs.boilerplate.domain.interactors.base.AbstractInteractor;
import com.kodelabs.boilerplate.domain.repository.ViewRepository;

public class ViewInteractorImpl extends AbstractInteractor
        implements ViewInteractor {


    private ViewRepository mViewRepository;

    public ViewInteractorImpl(Executor threadExecutor, MainThread mainThread,
                              ViewRepository repository) {
        super(threadExecutor, mainThread);
        mViewRepository = repository;
    }

    //Отдаем результат
    @Override
    public void notifyError() {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                //mCallback.onRetrievalFailed("Nothing to welcome you with :(");
            }
        });
    }

    @Override
    public void postMessage(final String msg) {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                //mCallback.onMessageRetrieved(msg);
            }
        });
    }

    @Override
    public void selectView(ViewGroup viewGroup, final Callback<View> callback) {
        final View repositoryView = mViewRepository.getView(viewGroup);
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                callback.onMessageRetrieved(repositoryView);
            }
        });
    }

    @Override
    public void run() {

    }
}
