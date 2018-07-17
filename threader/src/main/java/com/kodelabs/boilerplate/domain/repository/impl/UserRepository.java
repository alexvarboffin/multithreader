package com.kodelabs.boilerplate.domain.repository.impl;

import com.kodelabs.boilerplate.domain.model.UserModel;
import com.kodelabs.boilerplate.domain.repository.Repository;

public class UserRepository implements Repository{

    private long startTime = System.currentTimeMillis();

    @Override
    public boolean insert(UserModel model) {
        long seconds = ((System.currentTimeMillis() - startTime)) / 1000;
        String msg = "Insert success: " + seconds; // let's be friendly

        // давайте симулируем некоторые сетевые/БД лаги
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean update(UserModel model) {
        long seconds = ((System.currentTimeMillis() - startTime)) / 1000;
        String msg = "update success: " + seconds; // let's be friendly

        // давайте симулируем некоторые сетевые/БД лаги
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public UserModel get(Object id) {
        return new UserModel(99);
    }

    @Override
    public boolean delete(UserModel model) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }
}
