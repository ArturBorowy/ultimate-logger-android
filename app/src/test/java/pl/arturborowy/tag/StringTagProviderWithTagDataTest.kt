package pl.arturborowy.tag

import com.nhaarman.mockitokotlin2.anyOrNull
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.mock
import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito
import pl.arturborowy.logger.tag.builder.TagDataTagBuilder
import pl.arturborowy.logger.tag.dataprovider.TagDataProvider
import pl.arturborowy.logger.tag.provider.string.StringTagProviderWithTagData
import pl.arturborowy.util.TestData

class StringTagProviderWithTagDataTest {

    private val mockTagDataProvider: TagDataProvider = mock()
    private val mockTagDataTagBuilder: TagDataTagBuilder = mock()

    private val stringTagProviderWithTagData = StringTagProviderWithTagData(
            mockTagDataProvider, mockTagDataTagBuilder)

    @Test
    fun `build() calls tagDataTagBuilder build() with tagData from tagDataProvider`() {
        val givenTagData = TestData.getTagData()

        given(mockTagDataProvider.getTagData())
                .willReturn(givenTagData)

        stringTagProviderWithTagData.provide(null,
                null,
                null)

        Mockito.verify(mockTagDataTagBuilder, Mockito.times(1))
                .build(eq(givenTagData),
                        anyOrNull(),
                        anyOrNull(),
                        anyOrNull())
    }

    @Test
    fun `build() calls tagDataTagBuilder build() with same flags`() {
        val givenWithFileNameAndLineNum = true
        val givenWithClassName = true
        val givenWithMethodName = true

        stringTagProviderWithTagData.provide(givenWithFileNameAndLineNum,
                givenWithClassName,
                givenWithMethodName)

        Mockito.verify(mockTagDataTagBuilder, Mockito.times(1))
                .build(anyOrNull(),
                        eq(givenWithFileNameAndLineNum),
                        eq(givenWithClassName),
                        eq(givenWithMethodName))
    }

    @Test
    fun `build() returns tag from tagDataTagBuilder build()`() {
        val givenTag = "eeeeee"

        given(mockTagDataTagBuilder.build(anyOrNull(),
                anyOrNull(),
                anyOrNull(),
                anyOrNull()))
                .willReturn(givenTag)

        val actualTag = stringTagProviderWithTagData.provide(null,
                null,
                null)

        Assert.assertEquals(givenTag, actualTag)
    }
}