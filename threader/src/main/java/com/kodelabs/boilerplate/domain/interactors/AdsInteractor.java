package com.kodelabs.boilerplate.domain.interactors;

import com.kodelabs.boilerplate.domain.interactors.base.Interactor;

public interface AdsInteractor extends Interactor {

    //Отстку в главный тред
    interface Callback {
        void onMessageRetrieved(String message);

        void onRetrievalFailed(String error);
    }


    void notifyError();
    void postMessage(final String msg);

    //run <--base
    void extractById(int id);
}
