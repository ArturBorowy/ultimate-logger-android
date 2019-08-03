package pl.arturborowy.logger.tag.builder

import pl.arturborowy.logger.data.TagSettingsRepository
import pl.arturborowy.logger.tag.dataprovider.TagData

class TagDataTagBuilderWithDefaultSettings(
        private val defaultTagSettingsRepository: TagSettingsRepository) : TagDataTagBuilder {

    companion object {
        private const val PACKAGE_SEPARATOR = '.'
    }

    private val defaultTagSettings = defaultTagSettingsRepository.defaultTagSettings

    override fun build(tagData: TagData?,
                       withFileNameAndLineNum: Boolean?,
                       withClassName: Boolean?,
                       withMethodName: Boolean?): String {
        return if (tagData == null) {
            ""
        } else {
            build(tagData,
                    withFileNameAndLineNum ?: defaultTagSettings.shouldLogFileNameAndLineNum,
                    withClassName ?: defaultTagSettings.shouldLogClassName,
                    withMethodName ?: defaultTagSettings.shouldLogMethodName)
        }
    }

    private fun build(tagData: TagData,
                      withFileNameAndLineNum: Boolean,
                      withClassName: Boolean,
                      withMethodName: Boolean): String {
        val fileNameWithLineNum = getTagElement(withFileNameAndLineNum,
                "(${tagData.fileName}:${tagData.lineNumber})")

        val className = getTagElement(withClassName,
                removePackageFromClassName(tagData.className))

        val methodName = getTagElement(withMethodName,
                ".${tagData.methodName}()")

        val output = "$fileNameWithLineNum $className$methodName"

        return if (output == " ") {
            " "
        } else {
            output.removePrefix(" ").removeSuffix(" ")
        }
    }

    private fun removePackageFromClassName(classWithPackage: String) =
            classWithPackage.substring(classWithPackage.indexOfLast { it == PACKAGE_SEPARATOR } + 1)

    private fun getTagElement(isElementIncluded: Boolean, element: String) =
            if (isElementIncluded) {
                element
            } else {
                ""
            }
}