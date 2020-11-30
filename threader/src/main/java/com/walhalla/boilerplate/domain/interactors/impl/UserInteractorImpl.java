package com.walhalla.boilerplate.domain.interactors.impl;

import com.walhalla.boilerplate.domain.executor.Executor;
import com.walhalla.boilerplate.domain.executor.MainThread;
import com.walhalla.boilerplate.domain.interactors.UserInteractor;
import com.walhalla.boilerplate.domain.interactors.base.AbstractInteractor;
import com.walhalla.boilerplate.domain.model.UserModel;
import com.walhalla.boilerplate.domain.repository.impl.UserRepository;

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

//    @Override
//    public void run() {
//        // TODO: Implement this with your business logic
//        /**
//         * В фоновом потоке тянем из репозитория
//         *
//         */
//        // получение сообщения
//        final UserModel message = mRepository.get(99);
//        // проверяем, получили ли мы сообщение
//        if (message == null || message.getValue() == 0) {
//            // уведомляем об ошибке основной поток
//            notifyError();
//            return;
//        }
//        // мы получили наше сообщение, уведомляем об этом UI в основном потоке
//        postMessage(message.toString());
//    }


    //Отдаем результат
    private void notifyError() {
        mMainThread.post(() -> {
            //mCallback.onRetrievalFailed("Nothing to welcome you with :(");
        });
    }

    private void postMessage(final String msg) {
        mMainThread.post(() -> {
            //mCallback.onMessageRetrieved(msg);
        });
    }

    @Override
    public void getUserById(long id, final Callback<UserModel> callback) {
        mThreadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                final UserModel userModel = mRepository.get(id);

                mMainThread.post(() -> {
                    callback.onMessageRetrieved(userModel);
                });
            }
        });
    }

    @Override
    public void run() {

    }
}

