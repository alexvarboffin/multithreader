package com.walhalla.boilerplate.domain.repository.impl;

import com.walhalla.boilerplate.domain.model.UserModel;
import com.walhalla.boilerplate.domain.repository.CrudRepository;

import java.util.List;

public class UserRepository implements CrudRepository<UserModel>{

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
    public UserModel get(long id) {
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

    @Override
    public List<UserModel> query() {
        return null;
    }
}
