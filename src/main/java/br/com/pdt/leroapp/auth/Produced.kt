package br.com.pdt.leroapp.auth

import javax.inject.Qualifier
import kotlin.annotation.AnnotationRetention.RUNTIME
import kotlin.annotation.AnnotationTarget.*

@Qualifier
@Retention(RUNTIME)
@Target(FIELD, TYPE, FUNCTION, VALUE_PARAMETER)
annotation class Produced