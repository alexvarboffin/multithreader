package com.kodelabs.boilerplate.domain.repository.impl;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.kodelabs.boilerplate.domain.repository.ViewRepository;

public class ViewAdmobRepository implements ViewRepository {

    //private final Context mContext;
    private long startTime = System.currentTimeMillis();

    private static ViewAdmobRepository INSTANCE;

    public static ViewAdmobRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ViewAdmobRepository();
        }
        return INSTANCE;
    }


//    public ViewAdmobRepository(Context context) {
//        this.mContext = context;
//    }

    private ViewAdmobRepository() {
    }


    @Override
    public View getView(ViewGroup viewGroup) {
        long seconds = ((System.currentTimeMillis() - startTime)) / 1000;
        String msg = "update success: " + seconds; // let's be friendly
        Button view = new Button(viewGroup.getContext());
        view.setText(msg);
//        // давайте симулируем некоторые сетевые/БД лаги
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return view;
    }


}

