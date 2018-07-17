package com.kodelabs.boilerplate.domain.interactors.impl;

import com.kodelabs.boilerplate.domain.executor.Executor;
import com.kodelabs.boilerplate.domain.executor.MainThread;
import com.kodelabs.boilerplate.domain.interactors.AdsInteractor;
import com.kodelabs.boilerplate.domain.interactors.base.AbstractInteractor;

import com.kodelabs.boilerplate.domain.repository.MessageRepository;
import com.kodelabs.boilerplate.domain.repository.Repository;

/**
 * AbstractInteractor
 * запустит все в фоновом потоке...
 */

public class AdsInteractorImpl extends AbstractInteractor implements AdsInteractor{

    private final Callback mCallback;
    private final MessageRepository mMessageRepository;

    public AdsInteractorImpl(Executor threadExecutor, MainThread mainThread,
                             AdsInteractor.Callback callback, MessageRepository repository) {
        super(threadExecutor, mainThread);
        this.mCallback = callback;
        this.mMessageRepository = repository;
    }

    @Override
    public void run() {
        /**
         * В фоновом потоке тянем из репозитория
         *
         */
        // получение сообщения
        final String message = mMessageRepository.getWelcomeMessage();
        // проверяем, получили ли мы сообщение
        if (message == null || message.length() == 0) {
            // уведомляем об ошибке основной поток
            notifyError();
            return;
        }
        // мы получили наше сообщение, уведомляем об этом UI в основном потоке
        postMessage(message);
    }




    //Отдаем результат
    @Override
    public void notifyError() {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onRetrievalFailed("Nothing to welcome you with :(");
            }
        });
    }

    @Override
    public void postMessage(final String msg) {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onMessageRetrieved(msg);
            }
        });
    }

    @Override
    public void extractById(int id) {
//        //Как будем отличать таски?
//        public int getTag() {
//            return tag;
//        }
//
//        public void setTag(int tag) {
//            this.tag = tag;
//        }
//
//        int tag;
    }
}
