package com.walhalla.boilerplate.domain.executor.impl

import com.walhalla.boilerplate.domain.executor.Executor
import com.walhalla.boilerplate.domain.interactors.base.AbstractInteractor
import java.util.concurrent.BlockingQueue
import java.util.concurrent.Callable
import java.util.concurrent.Future
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

/**
 * This singleton class will make sure that each interactor operation gets a background thread.
 *
 *
 *
 *
 * android 4.4 not work !!!!!!!!!
 */
class ThreadExecutor : Executor {
    private val var0: ThreadPoolExecutor

    init {
        var0 = ThreadPoolExecutor(
            CORE_POOL_SIZE,
            MAX_POOL_SIZE,
            KEEP_ALIVE_TIME.toLong(),
            TIME_UNIT,
            WORK_QUEUE
        )
    }

    override fun execute(interactor: AbstractInteractor) {
        var0.submit(Runnable {
            // run the main logic
            interactor.run()

            // mark it as finished
            interactor.onFinished()
        })
    }

    override fun execute(runnable: Runnable?): Future<*>? {
        return var0.submit(runnable)
    }

    override fun submit(runnable: Runnable?) {
        var0.submit(runnable)
    }


    override fun terminate() {
        var0.shutdownNow()
    }

    override fun <T> submit(runnable: Callable<T?>?): Future<T?>? {
        return var0.submit<T?>(runnable)
    }

    companion object {
        // This is a singleton
        @Volatile
        private var sThreadExecutor: ThreadExecutor? = null

        private const val CORE_POOL_SIZE = 3
        private const val MAX_POOL_SIZE = 5
        private const val KEEP_ALIVE_TIME = 120
        private val TIME_UNIT = TimeUnit.SECONDS
        private val WORK_QUEUE: BlockingQueue<Runnable?> = LinkedBlockingQueue<Runnable?>()

        @JvmStatic
        val instance: Executor?
            /**
             * Returns a singleton instance of this executor. If the executor is not initialized then it initializes it and returns
             * the instance.
             */
            get() {
                if (sThreadExecutor == null) {
                    sThreadExecutor = ThreadExecutor()
                }
                return sThreadExecutor
            }
    }
}
