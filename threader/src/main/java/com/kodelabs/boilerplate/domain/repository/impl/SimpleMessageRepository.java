package com.kodelabs.boilerplate.domain.repository.impl;

import com.kodelabs.boilerplate.domain.repository.AdsRepository;

public class SimpleMessageRepository
        implements AdsRepository {


    private static SimpleMessageRepository INSTANCE;

    private SimpleMessageRepository() {}

    public static SimpleMessageRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SimpleMessageRepository();
        }
        return INSTANCE;
    }


    private long startTime = System.currentTimeMillis();
    /*
     *
     * Класс вытягивает данные из сети\бд\итд
     *
     * */


    @Override
    public String getWelcomeMessageById(int id) {
        String msg = "Welcome, friend! -> " + id; // let's be friendly

        // давайте симулируем некоторые сетевые/БД лаги

//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        return msg;
    }

    @Override
    public String getWelcomeMessage() {
        long seconds = ((System.currentTimeMillis() - startTime)) / 1000;
        String msg = "Welcome, friend: " + seconds; // let's be friendly

        // давайте симулируем некоторые сетевые/БД лаги
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        return msg;
    }
}
