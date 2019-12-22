package com.ultimatelogger.android.output

import com.ultimatelogger.multiplatform.tw
import org.junit.Test

class ALogTest {

    @Test
    fun `ALogConsumer do not throw exception when running on non-android JVM`() {
        ALogConsumer().useALog()
    }
}

class ALogConsumer {

    fun useALog() {
        ALog.e("Log message")
        (null as String?).tw { }
    }
}