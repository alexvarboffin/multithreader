package com.walhalla.boilerplate.threading

import android.os.Handler
import android.os.Looper
import com.walhalla.boilerplate.domain.executor.MainThread

class MainThreadImpl : MainThread {

    private val mHandler: Handler = Handler(Looper.getMainLooper())

    override fun post(runnable: Runnable) {
        mHandler.post(runnable)
    }

    companion object {
        private var sThread: MainThread? = null

        @JvmStatic
        val instance: MainThread
            get() {
                if (sThread == null) {
                    sThread = MainThreadImpl()
                }
                return sThread!!
            }
    }
}
