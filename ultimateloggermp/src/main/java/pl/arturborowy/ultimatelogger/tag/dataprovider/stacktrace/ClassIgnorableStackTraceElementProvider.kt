package pl.arturborowy.ultimatelogger.tag.dataprovider.stacktrace

import pl.arturborowy.ultimatelogger.data.TagSettingsRepository

internal class ClassIgnorableStackTraceElementProvider(
        private val stackTraceProvider: StackTraceProvider,
        private val tagSettingsRepository: TagSettingsRepository) :
        StackTraceElementProvider {

    override fun getStackTraceElement(): StackTraceElement? {
        val stackTraceElements = stackTraceProvider.provide()

        stackTraceElements?.forEach { stackTraceElement ->
            if (shouldClassBeIgnored(stackTraceElement.className).not()) {
                return stackTraceElement
            }
        }

        return null
    }

    private fun shouldClassBeIgnored(className: String) =
            getNamesOfClassesToIgnore().any { isClassNameMatchingClassNameToIgnore(className, it) }

    private fun isClassNameMatchingClassNameToIgnore(classNameToCheck: String,
                                                     classNameToIgnore: String) =
            classNameToCheck.contains(classNameToIgnore)
                    || classNameToCheck.contains("$classNameToIgnore\$DefaultImpls")

    private fun getNamesOfClassesToIgnore(): Collection<String> {
        val namesOfClassesToIgnore = tagSettingsRepository
                .defaultTagSettings
                .classesToIgnore
                .mapNotNull { it.qualifiedName }
                .toMutableList()

        val defaultClassesToIgnore = listOf(
                "dalvik.system.VMStack",
                "pl.arturborowy.ultimatelogger",
                "java.lang.Thread"
        )

        namesOfClassesToIgnore.addAll(defaultClassesToIgnore)

        return namesOfClassesToIgnore
    }
}