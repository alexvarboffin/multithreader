package com.kodelabs.boilerplate.presentation.presenters.impl;

import android.util.Log;

import com.kodelabs.boilerplate.domain.executor.Executor;
import com.kodelabs.boilerplate.domain.executor.MainThread;
import com.kodelabs.boilerplate.domain.interactors.AdsInteractor;
import com.kodelabs.boilerplate.domain.interactors.UserInteractor;
import com.kodelabs.boilerplate.domain.interactors.impl.AdsInteractorImpl;
import com.kodelabs.boilerplate.domain.interactors.impl.UserInteractorImpl;
import com.kodelabs.boilerplate.domain.model.UserModel;
import com.kodelabs.boilerplate.domain.repository.MessageRepository;
import com.kodelabs.boilerplate.domain.repository.impl.UserRepository;
import com.kodelabs.boilerplate.presentation.presenters.MainPresenter;
import com.kodelabs.boilerplate.presentation.presenters.base.AbstractPresenter;

/**
 * Created by dmilicic on 12/13/15.
 */
public class MainPresenterImpl extends AbstractPresenter
        implements MainPresenter {


    private static final String TAG = "@@@";

    private AdsInteractor interactor;
    private UserInteractor mUserInteractor;

    private final MessageRepository mRepository;
    private long startTime = System.currentTimeMillis();
    private View mView;
    private Thread mThread;

    public MainPresenterImpl(Executor executor, MainThread mainThread,
                             View view, MessageRepository messageRepository) {
        super(executor, mainThread);
        mView = view;
        mRepository = messageRepository;
    }

    @Override
    public void runWork() {


        mUserInteractor = new UserInteractorImpl(
                mExecutor,
                mMainThread,
                new UserRepository()
        );

        mUserInteractor.getUserById((long) 77, new UserInteractor.Callback<UserModel>() {
            @Override
            public void onMessageRetrieved(UserModel message) {
                if (mView != null) {
                    mView.displayWelcomeMessage(message.toString());
                }
            }

            @Override
            public void onRetrievalFailed(String error) {

            }
        });

        //====================================================================

//        interactor = new AdsInteractorImpl(
//                mExecutor,
//                mMainThread,
//                new AdsInteractor.Callback() {
//                    @Override
//                    public void onMessageRetrieved(String message) {
//                        if (mView != null) {
//                            mView.displayWelcomeMessage(message);
//                        }
//                    }
//
//                    @Override
//                    public void onRetrievalFailed(String error) {
//                        Log.i(TAG, "onRetrievalFailed: " + error);
//                    }
//                },
//                mRepository
//        );
//
//        // запускаем interactor
//        interactor.execute();

        for (int i = 0; i < 100; i++) {

//            BackgroundExecutor.getInstance().submit(new Callable<Boolean>() {
//                @Override
//                public Boolean call() throws Exception {
//                    return null;
//                }
//            });
        }


//        Handler handler = new Handler(Looper.getMainLooper());
//
//        if (mThread == null) {
//            mThread = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        for (int i = 0; i < 100; i++) {
//                            Thread.sleep(1000);
//                            long seconds = ((System.currentTimeMillis() - startTime)) / 1000;
//                            handler.post(() -> mView.displayWelcomeMessage("@" + seconds));
//                        }
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
//            mThread.start();
//        }

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {
        if (mThread != null && mThread.isAlive()) {
            mThread.interrupt();
            mThread = null;
        }
        mView = null;
    }

    @Override
    public void onError(String message) {

    }


    /**
     * View
     *
     */

}
