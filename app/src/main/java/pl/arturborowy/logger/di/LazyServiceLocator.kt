package pl.arturborowy.logger.di

import org.koin.core.KoinComponent
import org.koin.core.inject
import pl.arturborowy.logger.di.util.named
import pl.arturborowy.logger.di.util.toKoinParameters

object LazyServiceLocator : KoinComponent {

    inline fun <reified DependencyT> getDependency(qualifierString: String?) =
            getDependency<DependencyT>(qualifierString, {})

    inline fun <reified DependencyT> getDependency(vararg parametersGetter: () -> Any?) =
            getDependency<DependencyT>(qualifierString = null, parametersGetter = *parametersGetter)

    inline fun <reified DependencyT> getDependency(qualifierString: String? = null,
                                                   vararg parametersGetter: () -> Any? = arrayOf()) =
            inject<DependencyT>(named(qualifierString)) { parametersGetter.toKoinParameters() }
}