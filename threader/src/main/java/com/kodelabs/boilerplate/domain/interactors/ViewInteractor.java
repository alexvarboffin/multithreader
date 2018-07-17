package com.kodelabs.boilerplate.domain.interactors;

import android.view.View;
import android.view.ViewGroup;

import com.kodelabs.boilerplate.domain.interactors.base.Interactor;
import com.kodelabs.boilerplate.domain.model.UserModel;

public interface ViewInteractor extends Interactor {




    interface Callback<T> {
        // TODO: Add interactor callback methods here
        void onMessageRetrieved(T message);

        void onRetrievalFailed(String error);
    }

    // TODO: Add interactor methods here
    void notifyError();

    void postMessage(final String msg);

    //run <--base
    void selectView(ViewGroup id, Callback<View> callback);



}


