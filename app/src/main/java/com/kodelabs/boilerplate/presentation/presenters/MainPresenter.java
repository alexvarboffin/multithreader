package com.kodelabs.boilerplate.presentation.presenters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.kodelabs.boilerplate.presentation.presenters.base.BasePresenter;
import com.kodelabs.boilerplate.presentation.ui.BaseView;


public interface MainPresenter extends BasePresenter {

    interface MainView extends BaseView {
        void displayWelcomeMessage(String message);

        void displayViewMessage(View message);
    }

    void attachView(ViewGroup frameLayout);

    // TODO: Add your presenter methods
    void runWork();
}
