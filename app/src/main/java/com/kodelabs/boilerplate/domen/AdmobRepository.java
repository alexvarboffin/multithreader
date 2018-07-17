package com.kodelabs.boilerplate.domen;

import com.kodelabs.boilerplate.domain.repository.AdsRepository;

public class AdmobRepository
        implements AdsRepository {


    private static AdmobRepository INSTANCE;

    private AdmobRepository() {}

    public static AdmobRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AdmobRepository();
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
