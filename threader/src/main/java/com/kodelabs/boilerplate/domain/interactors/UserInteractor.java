package com.kodelabs.boilerplate.domain.interactors;

import com.kodelabs.boilerplate.domain.interactors.base.Interactor;
import com.kodelabs.boilerplate.domain.model.UserModel;

public interface UserInteractor extends Interactor {




    interface Callback<T> {
        // TODO: Add interactor callback methods here
        void onMessageRetrieved(T message);

        void onRetrievalFailed(String error);
    }

    // TODO: Add interactor methods here
    void notifyError();

    void postMessage(final String msg);

    //run <--base
    void getUserById(long id, Callback<UserModel> callback);



}


