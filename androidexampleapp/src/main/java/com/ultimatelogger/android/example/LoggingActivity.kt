package com.ultimatelogger.android.example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ultimatelogger.android.output.ALog
import com.ultimatelogger.android.output.ALogInitializer
import com.ultimatelogger.multiplatform.tag.TagSettings
import com.ultimatelogger.multiplatform.tw

internal class LoggingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ALogInitializer.init(true, TagSettings(
                shouldLogThreadName = true,
                shouldLogFileNameAndLineNum = true,
                shouldLogClassName = true,
                shouldLogMethodName = true))

        ALog.e("12345")
        ALog.e(Exception())

        Thread({ ALog.v("JvmLog.v") }, "THREAD NAMED").start()

        (null as String?).tw { }
    }
}