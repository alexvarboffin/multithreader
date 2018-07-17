package com.kodelabs.boilerplate;

import com.kodelabs.boilerplate.domain.executor.MainThread;
import com.kodelabs.boilerplate.domain.executor.impl.ThreadExecutor;
import com.kodelabs.boilerplate.domain.interactors.AdsInteractor;
import com.kodelabs.boilerplate.domain.interactors.impl.AdsInteractorImpl;
import com.kodelabs.boilerplate.domain.repository.AdsRepository;
import com.kodelabs.boilerplate.domain.repository.impl.GoogleAdsRepository;
import com.kodelabs.boilerplate.threading.MainThreadImpl;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
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
//        AdsInteractor interactor = new AdsInteractorImpl(
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