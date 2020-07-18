package com.ultimatelogger.android.output

import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.mock
import com.ultimatelogger.android.output.tag.TagCutter
import com.ultimatelogger.multiplatform.output.MultiPriorityLogger
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

internal class TagLimitMultiPriorityLoggerTest {

    private val mockMultiPriorityLogger: MultiPriorityLogger = mock()
    private val mockAndroidTagCutter: TagCutter = mock()

    private val tagLimitMultiPriorityLogger = TagLimitMultiPriorityLogger(mockMultiPriorityLogger,
            mockAndroidTagCutter)

    private val givenTag = "f[p[]"
    private val givenThrowable = Exception()
    private val expectedTag = "f[p[fsdfsdsdf]"

    @Before
    fun setUp() {
        given(mockAndroidTagCutter.toLimit(givenTag)).willReturn(expectedTag)
    }

    @Test
    fun `v() calls multiPriorityLogger v() with same msg, throwable and tag from tagCutter`() {
        val givenMsg = "][;]"

        tagLimitMultiPriorityLogger.v(givenTag, givenMsg, givenThrowable)

        Mockito.verify(mockMultiPriorityLogger, Mockito.times(1))
                .v(expectedTag, givenMsg, givenThrowable)
    }

    @Test
    fun `d() calls multiPriorityLogger d() with same msg, throwable and tag from tagCutter`() {
        val givenMsg = "][;]"

        tagLimitMultiPriorityLogger.d(givenTag, givenMsg, givenThrowable)

        Mockito.verify(mockMultiPriorityLogger, Mockito.times(1))
                .d(expectedTag, givenMsg, givenThrowable)
    }

    @Test
    fun `i() calls multiPriorityLogger i() with same msg, throwable and tag from tagCutter`() {
        val givenMsg = "][;]"

        tagLimitMultiPriorityLogger.i(givenTag, givenMsg, givenThrowable)

        Mockito.verify(mockMultiPriorityLogger, Mockito.times(1))
                .i(expectedTag, givenMsg, givenThrowable)
    }

    @Test
    fun `w() calls multiPriorityLogger w() with same msg, throwable and tag from tagCutter`() {
        val givenMsg = "][;]"

        tagLimitMultiPriorityLogger.w(givenTag, givenMsg, givenThrowable)

        Mockito.verify(mockMultiPriorityLogger, Mockito.times(1))
                .w(expectedTag, givenMsg, givenThrowable)
    }

    @Test
    fun `e() calls multiPriorityLogger e() with same msg, throwable and tag from tagCutter`() {
        val givenMsg = "][;]"

        tagLimitMultiPriorityLogger.e(givenTag, givenMsg, givenThrowable)

        Mockito.verify(mockMultiPriorityLogger, Mockito.times(1))
                .e(expectedTag, givenMsg, givenThrowable)
    }

    @Test
    fun `wtf() calls multiPriorityLogger wtf() with same msg, throwable and tag from tagCutter`() {
        val givenMsg = "][;]"

        tagLimitMultiPriorityLogger.wtf(givenTag, givenMsg, givenThrowable)

        Mockito.verify(mockMultiPriorityLogger, Mockito.times(1))
                .wtf(expectedTag, givenMsg, givenThrowable)
    }

    @Test
    fun `println() calls multiPriorityLogger println() with same priority, msg and tag from tagCutter`() {
        val givenPriority = 1
        val givenMsg = "][;]"

        tagLimitMultiPriorityLogger.println(givenPriority, givenTag, givenMsg)

        Mockito.verify(mockMultiPriorityLogger, Mockito.times(1))
                .println(givenPriority, expectedTag, givenMsg)
    }
}