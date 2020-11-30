package com.kodelabs.boilerplate;

import org.junit.Test;

import static org.junit.Assert.*;


public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }


    @Test
    public void testWelcomeMessageFound() throws Exception {

        //Example
//        ThreadExecutor mExecutor = new ThreadExecutor();
//        MainThread mMainThread = new MainThreadImpl();
//        AdsRepository mMessageRepository = new GoogleAdsRepository();
//
//        String msg = "Welcome, friend!";
//        when(mMessageRepository.getWelcomeMessage())
//                .thenReturn(msg);
//
//        MessageInteractor interactor = new MessageInteractorImpl(
//                mExecutor,
//                mMainThread,
//                mMockedCallback,
//                mMessageRepository
//        );
//        interactor.run();
//        Mockito.verify(mMessageRepository).getWelcomeMessage();
//        Mockito.verifyNoMoreInteractions(mMessageRepository);
//        Mockito.verify(mMockedCallback).onMessageRetrieved(msg);
    }
}