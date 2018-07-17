package com.kodelabs.boilerplate.domain.interactors.impl;

import com.kodelabs.boilerplate.domain.executor.Executor;
import com.kodelabs.boilerplate.domain.executor.MainThread;
import com.kodelabs.boilerplate.domain.interactors.UserInteractor;
import com.kodelabs.boilerplate.domain.interactors.base.AbstractInteractor;
import com.kodelabs.boilerplate.domain.model.UserModel;
import com.kodelabs.boilerplate.domain.repository.impl.UserRepository;

/**
 * This is an interactor boilerplate with a reference to a model repository.
 * <p/>
 */
public class UserInteractorImpl extends AbstractInteractor
        implements UserInteractor {

    private UserRepository mRepository;

//    public UserInteractorImpl(Executor threadExecutor,
//                              MainThread mainThread,
//                              Callback callback, UserRepository repository) {
//        super(threadExecutor, mainThread);
//        mCallback = callback;
//        mRepository = repository;
//    }

    public UserInteractorImpl(Executor threadExecutor,
                              MainThread mainThread,
                              UserRepository repository) {
        super(threadExecutor, mainThread);
        mRepository = repository;
    }

    @Override
    public void run() {
        // TODO: Implement this with your business logic
        /**
         * В фоновом потоке тянем из репозитория
         *
         */
        // получение сообщения
        final UserModel message = mRepository.get(99);
        // проверяем, получили ли мы сообщение
        if (message == null || message.getValue() == 0) {
            // уведомляем об ошибке основной поток
            notifyError();
            return;
        }
        // мы получили наше сообщение, уведомляем об этом UI в основном потоке
        postMessage(message.toString());
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
    public void getUserById(long id, final Callback<UserModel> callback) {


        final UserModel userModel = mRepository.get(id);

        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                callback.onMessageRetrieved(userModel);
            }
        });
    }

}

