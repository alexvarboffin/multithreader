package com.walhalla.boilerplate.domain.model;

public class UserModel {

    private int mValue;

    public UserModel(int value) {
        mValue = value;
    }

    public int getValue() {
        return mValue;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "mValue=" + mValue +
                '}';
    }
}
