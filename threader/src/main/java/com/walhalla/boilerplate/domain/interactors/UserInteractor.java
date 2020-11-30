package com.walhalla.boilerplate.domain.interactors;

import com.walhalla.boilerplate.domain.interactors.base.Interactor;
import com.walhalla.boilerplate.domain.model.UserModel;

public interface UserInteractor extends Interactor {




    interface Callback<T> {
        // TODO: Add interactor callback methods here
        void onMessageRetrieved(T message);

        void onRetrievalFailed(String error);
    }

    //run <--base
    void getUserById(long id, Callback<UserModel> callback);



}


