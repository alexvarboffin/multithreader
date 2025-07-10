package com.walhalla.boilerplate.domain.interactors.base

import com.walhalla.boilerplate.domain.executor.Executor
import com.walhalla.boilerplate.domain.executor.MainThread

/**
 * Created by dmilicic on 8/4/15.
 *
 *
 * This abstract class implements some common methods for all interactors. Cancelling an interactor, check if its running
 * and finishing an interactor has mostly the same code throughout so that is why this class was created. Field methods
 * are declared volatile as we might use these methods from different threads (mainly from UI).
 *
 *
 * For pcleaner, when an activity is getting destroyed then we should probably cancel an interactor
 * but the request will come from the UI thread unless the request was specifically assigned to a background thread.
 */
abstract class AbstractInteractor
    (@JvmField protected var mThreadExecutor: Executor, @JvmField protected var mMainThread: MainThread) :
    Interactor {
    @Volatile
    protected var mIsCanceled: Boolean = false

    @Volatile
    var isRunning: Boolean = false
        protected set

    /**
     * This method contains the actual business logic of the interactor. It SHOULD NOT BE USED DIRECTLY but, instead, a
     * developer should call the execute() method of an interactor to make sure the operation is done on a background thread.
     *
     *
     * This method should only be called directly while doing unit/integration tests. That is the only reason it is declared
     * public as to help with easier testing.
     */
    abstract fun run()

    fun cancel() {
        mIsCanceled = true
        this.isRunning = false
    }

    fun onFinished() {
        this.isRunning = false
        mIsCanceled = false
    }
    //    @Override
    //    private void execute() {
    //        Log.i(TAG, "[execute]: mark this interactor as running");
    //        this.mIsRunning = true;
    //
    //        // start running this interactor in a background thread
    //        mThreadExecutor.execute(this);
    //    }
}
