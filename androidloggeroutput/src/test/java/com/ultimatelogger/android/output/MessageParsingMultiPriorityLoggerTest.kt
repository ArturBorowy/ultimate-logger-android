package com.ultimatelogger.android.output

import org.mockito.kotlin.given
import org.mockito.kotlin.mock
import com.ultimatelogger.multiplatform.output.MultiPriorityLogger
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

internal class MessageParsingMultiPriorityLoggerTest {

    private val mockMultiPriorityLogger: MultiPriorityLogger = mock()
    private val mockMessageForThrowableLogParser: MessageForThrowableLogParser = mock()

    private val messageParsingMultiPriorityLogger =
            MessageParsingMultiPriorityLogger(mockMultiPriorityLogger,
                    mockMessageForThrowableLogParser)

    private val givenMsg = "f[p[]"
    private val givenThrowable = Exception()
    private val expectedMsg = "f[p[fsdfsdsdf]"

    @Before
    fun setUp() {
        given(mockMessageForThrowableLogParser.getMsg(givenMsg, givenThrowable))
                .willReturn(expectedMsg)
    }

    @Test
    fun `v() calls multiPriorityLogger v() with same tag, throwable and msg from messageForThrowableLogParser`() {
        val givenTag = "][;]"

        messageParsingMultiPriorityLogger.v(givenTag, givenMsg, givenThrowable)

        Mockito.verify(mockMultiPriorityLogger, Mockito.times(1))
                .v(givenTag, expectedMsg, givenThrowable)
    }

    @Test
    fun `d() calls multiPriorityLogger d() with same tag, throwable and msg from messageForThrowableLogParser`() {
        val givenTag = "][;]"

        messageParsingMultiPriorityLogger.d(givenTag, givenMsg, givenThrowable)

        Mockito.verify(mockMultiPriorityLogger, Mockito.times(1))
                .d(givenTag, expectedMsg, givenThrowable)
    }

    @Test
    fun `i() calls multiPriorityLogger i() with same tag, throwable and msg from messageForThrowableLogParser`() {
        val givenTag = "][;]"

        messageParsingMultiPriorityLogger.i(givenTag, givenMsg, givenThrowable)

        Mockito.verify(mockMultiPriorityLogger, Mockito.times(1))
                .i(givenTag, expectedMsg, givenThrowable)
    }

    @Test
    fun `w() calls multiPriorityLogger w() with same tag, throwable and msg from messageForThrowableLogParser`() {
        val givenTag = "][;]"

        messageParsingMultiPriorityLogger.w(givenTag, givenMsg, givenThrowable)

        Mockito.verify(mockMultiPriorityLogger, Mockito.times(1))
                .w(givenTag, expectedMsg, givenThrowable)
    }

    @Test
    fun `e() calls multiPriorityLogger e() with same tag, throwable and msg from messageForThrowableLogParser`() {
        val givenTag = "][;]"

        messageParsingMultiPriorityLogger.e(givenTag, givenMsg, givenThrowable)

        Mockito.verify(mockMultiPriorityLogger, Mockito.times(1))
                .e(givenTag, expectedMsg, givenThrowable)
    }

    @Test
    fun `wtf() calls multiPriorityLogger wtf() with same tag, throwable and msg from messageForThrowableLogParser`() {
        val givenTag = "][;]"

        messageParsingMultiPriorityLogger.wtf(givenTag, givenMsg, givenThrowable)

        Mockito.verify(mockMultiPriorityLogger, Mockito.times(1))
                .wtf(givenTag, expectedMsg, givenThrowable)
    }

    @Test
    fun `println() calls multiPriorityLogger println() with same priority, throwable and msg from messageForThrowableLogParser`() {
        val givenPriority = 1
        val givenTag = "][;]"

        messageParsingMultiPriorityLogger.println(givenPriority, givenTag, givenMsg)

        Mockito.verify(mockMultiPriorityLogger, Mockito.times(1))
                .println(givenPriority, givenTag, givenMsg)
    }
}