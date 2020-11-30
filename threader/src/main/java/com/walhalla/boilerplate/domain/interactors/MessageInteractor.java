package com.walhalla.boilerplate.domain.interactors;

import com.walhalla.boilerplate.domain.interactors.base.Interactor;

public interface MessageInteractor extends Interactor {

    //Отстyk в главный тред
    interface Callback {
        void onMessageRetrieved(String message);

        void onRetrievalFailed(String error);
    }
    //run <--base
    void extractById(int id);
}
