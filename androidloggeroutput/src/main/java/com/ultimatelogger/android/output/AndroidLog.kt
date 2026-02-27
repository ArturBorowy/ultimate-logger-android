package com.ultimatelogger.android.output

import android.util.Log
import com.ultimatelogger.multiplatform.output.MultiPriorityLogger

internal class AndroidLog : MultiPriorityLogger {

    override fun v(tag: String?, msg: String?, throwable: Throwable?) {
        Log.v(tag, msg, throwable)
    }

    override fun d(tag: String?, msg: String?, throwable: Throwable?) {
        Log.d(tag, msg, throwable)
    }

    override fun i(tag: String?, msg: String?, throwable: Throwable?) {
        Log.i(tag, msg, throwable)
    }

    override fun w(tag: String?, msg: String?, throwable: Throwable?) {
        Log.w(tag, msg, throwable)
    }

    override fun e(tag: String?, msg: String?, throwable: Throwable?) {
        Log.e(tag, msg, throwable)
    }

    override fun wtf(tag: String?, msg: String?, throwable: Throwable?) {
        Log.wtf(tag, msg, throwable)
    }

    override fun println(priority: Int, tag: String?, msg: String?) {
        Log.println(priority, tag, msg.orEmpty())
    }
}