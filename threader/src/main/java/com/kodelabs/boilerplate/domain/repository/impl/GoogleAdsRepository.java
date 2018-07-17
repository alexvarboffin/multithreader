package com.kodelabs.boilerplate.domain.repository.impl;

import com.kodelabs.boilerplate.domain.repository.AdsRepository;

public class GoogleAdsRepository
        implements AdsRepository {

    /*
     *
     * Класс вытягивает данные из сети\бд\итд
     *
     * */


    @Override
    public String getWelcomeMessageById(int id) {
        String msg = "Welcome, friend! -> " + id; // let's be friendly

        // давайте симулируем некоторые сетевые/БД лаги
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return msg;
    }

    @Override
    public String getWelcomeMessage() {
        String msg = "Welcome, friend!"; // let's be friendly

        // давайте симулируем некоторые сетевые/БД лаги
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return msg;
    }
}
