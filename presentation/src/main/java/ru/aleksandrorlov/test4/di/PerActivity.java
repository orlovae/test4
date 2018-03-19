package ru.aleksandrorlov.test4.di;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by alex on 18.03.18.
 */

@Scope
@Retention(RUNTIME)
public @interface PerActivity {}
