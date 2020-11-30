package com.walhalla.boilerplate.domain.interactors.impl;

import com.walhalla.boilerplate.domain.executor.Executor;
import com.walhalla.boilerplate.domain.executor.MainThread;
import com.walhalla.boilerplate.domain.interactors.MessageInteractor;
import com.walhalla.boilerplate.domain.interactors.base.AbstractInteractor;
import com.walhalla.boilerplate.domain.repository.MessageRepository;

/**
 * AbstractInteractor
 * запустит все в фоновом потоке...
 */

public class MessageInteractorImpl extends AbstractInteractor implements MessageInteractor {

    private final Callback mCallback;
    private final MessageRepository mMessageRepository;

    public MessageInteractorImpl(Executor threadExecutor, MainThread mainThread,
                                 MessageInteractor.Callback callback, MessageRepository repository) {
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
    private void notifyError() {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onRetrievalFailed("Nothing to welcome you with :(");
            }
        });
    }

    private void postMessage(final String msg) {
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
        mThreadExecutor.execute(() -> {
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

            postMessage(message);
        });
    }
}
